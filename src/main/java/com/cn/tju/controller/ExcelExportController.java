package com.cn.tju.controller;

import com.cn.tju.pojo.Alarm;
import com.cn.tju.pojo.AlarmQueryParam;
import com.cn.tju.pojo.AlarmQueryType;
import com.cn.tju.service.AlarmService;
import com.cn.tju.util.Constants;
import com.cn.tju.util.ResultDO;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Search on 2016/12/4.
 */
@Slf4j
@Controller
@RequestMapping("/export")
public class ExcelExportController {

    @Resource
    AlarmService alarmServiceImpl;

    // 导出excel方法
    @RequestMapping("exportExcel")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) {
        String queryType = request.getParameter("queryType");
        String fileName = "导出结果";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        AlarmQueryParam myQueryParam = new AlarmQueryParam();
        Preconditions.checkArgument(AlarmQueryType.isContain(queryType), Constants.getErrCode(Constants.ERR_PARAMETER_ERROR, "查询参数为空"));
        myQueryParam.setQueryType(queryType);

        //转换日期格式
        if (queryType.equals("custom")) {
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            try {
                myQueryParam.setStartTime(sdf.parse(startTime));
                myQueryParam.setStartTime(sdf.parse(endTime));
            } catch (ParseException e) {
                log.error("日期格式转换出现错误，param：{}", new Object[]{startTime, endTime});
                throw new IllegalArgumentException(String.valueOf(e.toString()));
            }
        }

        //构造excel文件
        HttpSession session = request.getSession();
        session.setAttribute("state", null);
        // 生成提示信息，
        response.setContentType("application/vnd.ms-excel");
        String codedFileName = null;
        OutputStream fOut = null;
        try {
            // 进行转码，使其支持中文文件名
            codedFileName = java.net.URLEncoder.encode(fileName, "UTF-8");
            response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");
            // response.addHeader("Content-Disposition", "attachment;   filename=" + codedFileName + ".xls");
            // 产生工作簿对象
            HSSFWorkbook workbook = new HSSFWorkbook();
            //产生工作表对象
            HSSFSheet sheet = workbook.createSheet();
            ResultDO<List<Alarm>> listResultDO = alarmServiceImpl.selectAlarmsByTime(myQueryParam);
            if (listResultDO.isSuccess()) {
                createExcelByAlarmList(sheet, listResultDO);
            }

            fOut = response.getOutputStream();
            workbook.write(fOut);
        } catch (Exception e) {
            log.error("生成excel出现错误：{}",e.toString());
        } finally {
            try {
                fOut.flush();
                fOut.close();
            } catch (IOException e) {
                log.error("关闭excel输出流出现错误：{}",e.toString());
            }
            //session.setAttribute("state", "open");
        }
    }

    /**
     * 将查找结果写入excle sheet
     *
     * @param sheet
     * @param listResultDO
     */
    private void createExcelByAlarmList(HSSFSheet sheet, ResultDO<List<Alarm>> listResultDO) {
        int index = 0;
        for (Alarm alarm : listResultDO.getModule()) {
            HSSFRow row = sheet.createRow((int) index++);//创建一行
            HSSFCell idCell = row.createCell((int) 0);//创建一列
            HSSFCell sensorIdShell = row.createCell((int) 1);//创建一列
            HSSFCell noteCell = row.createCell((int) 2);//创建一列
            HSSFCell timeCell = row.createCell((int) 3);//创建一列
            idCell.setCellType(HSSFCell.CELL_TYPE_STRING);
            sensorIdShell.setCellType(HSSFCell.CELL_TYPE_STRING);
            noteCell.setCellType(HSSFCell.CELL_TYPE_STRING);
            timeCell.setCellType(HSSFCell.CELL_TYPE_STRING);
            idCell.setCellValue(alarm.getId());
            sensorIdShell.setCellValue(alarm.getSensorId());
            noteCell.setCellValue(alarm.getAlarmNote());
            timeCell.setCellValue(alarm.getAlarmTime());
        }
    }

    /**
     * 文件生成校验类，可用于需要后台实时推送生成进度的需求
     *
     * @param request
     * @param response
     */
    @RequestMapping("check")
    public void check(HttpServletRequest request, HttpServletResponse response) {
        try {
            if ("open".equals(request.getSession().getAttribute("state"))) {
                request.getSession().setAttribute("state", null);
                response.getWriter().write("true");
                response.getWriter().flush();
            } else {
                response.getWriter().write("false");
                response.getWriter().flush();
            }
        } catch (IOException e) {
        }
    }
}
