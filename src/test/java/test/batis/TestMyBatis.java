package test.batis;

import com.alibaba.fastjson.JSON;
import com.cn.tju.IDao.*;
import com.cn.tju.pojo.*;
import com.cn.tju.util.*;
import com.google.common.collect.Maps;
import com.google.common.collect.ObjectArrays;
import org.apache.velocity.runtime.directive.Foreach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.MapsId;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/test/resources/spring-test.xml"
})
public class TestMyBatis {

    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-test.xml");
    /*
    @Resource
    private UserDao userDao;
    @Test
    public void getUserInfo(String[] args) {
        System.out.println(userDao.selectLogin("admin").toString());
    }*/

    @Test
    public void test_SelectUser() {
        UserDao myDao = (UserDao) ctx.getBean("userDao");
        List<User> users = myDao.selectAllUser();
        for (User user: users)
        {
            System.out.println(user.toString());
        }
    }

    @Test
    public void test_InsertUser() {
        UserDao myDao = (UserDao) ctx.getBean("userDao");
        User newUser = new User();
        newUser.setUserName("testUser");
        newUser.setUserPhone("111111");
        newUser.setUserFlag(1);
        newUser.setDatetime(new Date());
        int result = myDao.insertSelective(newUser);
        System.out.println(result);
    }


    @Test
    public void test_SelectAllRole() {
        RoleDao myDao = (RoleDao) ctx.getBean("roleDao");
        //System.out.println(myDao.selectAllRoles().toString());
    }

    @Test
    public void test_SelectAllPerson() {
        PersonDao myDao = (PersonDao) ctx.getBean("personDao");
        DataTablePageUtil util = new DataTablePageUtil();
        util.setDraw(4);
        Map<String,String> myMapList = Maps.newHashMap();
        myMapList.put("address","1");
        myMapList.put("sex","男");
        util.setCondition(myMapList);
        List<Person> users = myDao.selectPersonByPage(util);
        for (Person person: users)
        {
            System.out.println(person.toString());
        }
    }

    @Test
    public void test()
    {
        String test ="hello,world,s,,b";
        System.out.println(test.split(",").length);
    }


    @Test
    public void test_SelectAllAmmeterSetting() {
        AmmeterSettingMapper myDao = (AmmeterSettingMapper) ctx.getBean("ammeterSettingMapper");
        AmmeterSettingExample queryExample = new AmmeterSettingExample();
        AmmeterSettingExample.Criteria queryCriteria = queryExample.createCriteria();
        queryCriteria.andAmmeterSlaveGreaterThan(1);
        queryExample.or(queryCriteria);
        List<AmmeterSetting> ammeterSettings = myDao.selectByExample(queryExample);
        for (int i = 0; i < ammeterSettings.size(); i++) {
            System.out.println(ammeterSettings.get(i).toString());
        }
    }


    @Test
    public void test_InsertAmmeterSetting() {
        AmmeterSettingMapper myDao = (AmmeterSettingMapper) ctx.getBean("ammeterSettingMapper");
        AmmeterSetting mySetting = new AmmeterSetting();
        mySetting.setAmmeterId("test001");
        mySetting.setAmmeterName("hello");
        myDao.insert(mySetting);
        System.out.println(myDao.selectByPrimaryKey("test001"));
    }

    @Test
    public void test_selectWeatherLogByDatetiem()
    {
        WeatherLogMapper myDao = (WeatherLogMapper) ctx.getBean("weatherLogMapper");
        HashMap<String,Object> queryFilter = new HashMap<String, Object>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        queryFilter.put("startTime","2016-11-27 00:00:00" );
        queryFilter.put("endTime",sdf.format(new Date()) );
        List<WeatherLog> weatherLogs = myDao.selectByTime(queryFilter);
        ResultDO<List<WeatherLog>> resultDO = new ResultDO<List<WeatherLog>>();
        resultDO.setModule(weatherLogs);
        resultDO.setSuccess(true);
        System.out.println(JSON.toJSONString(resultDO));
    }

    /*测试获取所有设备*/
    @Test
    public void test_selectAllAmmeterSetting() {
        AmmeterSettingMapper myDao = (AmmeterSettingMapper) ctx.getBean("ammeterSettingMapper");
        List<AmmeterSetting> ammeterSettings = myDao.selectAllAMmeterSettings();
        for (AmmeterSetting ammeterSetting: ammeterSettings)
        {
            System.out.println(ammeterSetting.toString());
        }
    }


    @Test
    public void test_resultDO_JSON()
    {
        ResultDO<List<WeatherLog>> resultDO = new ResultDO<List<WeatherLog>>();
        System.out.println(JSON.toJSONString(resultDO));
    }

    @Test
    public void testMd5() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar myCal = Calendar.getInstance();
        Date nowDate = new Date();
        //myCal.set(Calendar.DATE,myCal.get(Calendar.DATE)-7);
        System.out.println("当月："+ DateCalUtil.getStartMounth(myCal).getTime());
        System.out.println("当周："+ DateCalUtil.getMondayPlus());

        myCal.set(Calendar.MONTH, 0);
        myCal.set(Calendar.DAY_OF_MONTH, myCal.getActualMinimum(Calendar.DAY_OF_MONTH));
        System.out.println("当年："+myCal.getTime());
        // System.out.println(EncryptionUtil.getHash("admin","MD5"));
    }


    @Test
    public void test_SelectAllAlarms() {
        AlarmMapper myDao = (AlarmMapper) ctx.getBean("alarmMapper");
        List<Alarm> users = myDao.selectAllAlarms();
        for (Alarm user: users)
        {
            System.out.println(user.toString());
        }
    }

    @Test
    public void test_SelectFilterAlarms() {
        AlarmMapper myDao = (AlarmMapper) ctx.getBean("alarmMapper");
        String searchData = "";
        DataTablePageUtil pageUtil = new DataTablePageUtil();
        pageUtil.setSearchData(searchData);
        HashMap<String,String> queryConditions = new HashMap<>();
        queryConditions.put("sensor_id",searchData);
        queryConditions.put("alarm_note",searchData);
        List<String> myList = new ArrayList<>();
        myList.add("alarm_note");
        myList.add("sensor_id");
        pageUtil.setCondition(queryConditions);
        pageUtil.setConditionList(myList);
        List<Alarm> users = myDao.selectAlarmsByPageMap(pageUtil);
        for (Alarm user: users)
        {
            System.out.println(user.toString());
        }
    }


    @Test
    public void test_insertAlarm() {
        AlarmMapper myDao = (AlarmMapper) ctx.getBean("alarmMapper");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        for (int i = 0; i < 116; i++) {
           Alarm myAlarm = new Alarm();
           myAlarm.setSensorId(i+new Random().nextInt()+" ");
           myAlarm.setAlarmNote(i+new Random().nextInt()+" ");
            cal.add(Calendar.DATE, 1);
            myAlarm.setAlarmTime(cal.getTime());
            myDao.insert(myAlarm);
        }

    }

    @Test
    public void test_selectAlarmsByTime() {
        AlarmMapper myDao = (AlarmMapper) ctx.getBean("alarmMapper");
        HashMap<String, Object> queryFilter = new HashMap<String, Object>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        queryFilter.put("startTime", "2016-11-27");
        queryFilter.put("endTime", sdf.format(new Date()));
        List<Alarm> weatherLogs = myDao.selectAlarmsByTime(queryFilter);
        ResultDO<List<Alarm>> resultDO = new ResultDO<List<Alarm>>();
        resultDO.setModule(weatherLogs);
        resultDO.setSuccess(true);
        System.out.println(JSON.toJSONString(resultDO));

    }

    @Test
    public void test_SelectAmmeter()
    {
        AmmeterMapper myDao = (AmmeterMapper) ctx.getBean("ammeterMapper");
        AmmeterExample queryExample = new AmmeterExample();
        AmmeterExample.Criteria queryCriteria = queryExample.createCriteria();
        queryExample.setOrderByClause("sensor_id");
        String startTime = "2016-11-05";
        Date nowDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(nowDate);
        cal.set(Calendar.DATE,cal.get(Calendar.DATE)-60);
        queryCriteria.andDatetimeBetween(cal.getTime(),nowDate);
        queryCriteria.andSensorIdEqualTo("WV0001");
        queryExample.or(queryCriteria);
        List<Ammeter> ammeterSettings = myDao.selectByExample(queryExample);
        for (int i = 0; i < ammeterSettings.size(); i++) {
            String sensorId = ammeterSettings.get(i).getSensorId();
            System.out.println(ammeterSettings.toString());
        }
    }

    @Test
    public void test_SelectAmmeterBySensorId() throws ParseException {
        HotMapper myDao = (HotMapper) ctx.getBean("hotMapper");
        //System.out.println(myDao.queryHotTotalBySensorId("R0001"));

        HotExample hotExample = new HotExample();
        HotExample.Criteria criteria = hotExample.createCriteria();
        criteria.andSensorIdEqualTo("R0001");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse("2016-11-00");
        Date endDate = sdf.parse("2016-12-06");
        criteria.andDatetimeBetween(startDate,endDate);
        hotExample.or(criteria);
        System.out.println("总共热能量");
        List<Hot> hots = myDao.selectByExample(hotExample);
        for (Hot hot:hots)
        {
            System.out.println(hot.getDatetime()+":"+hot.getHotTotal());
        }

        System.out.println("建筑总能耗");
        AmmeterMapper myAmmeterDao = (AmmeterMapper) ctx.getBean("ammeterMapper");
        AmmeterExample queryExample = new AmmeterExample();
        AmmeterExample.Criteria queryCriteria = queryExample.createCriteria();
        queryCriteria.andDatetimeBetween(startDate, endDate);
        queryCriteria.andSensorIdEqualTo("WV0012");
        queryExample.or(queryCriteria);
        List<Ammeter> ammeters = myAmmeterDao.selectByExample(queryExample);
        for (Ammeter ammeter:ammeters)
        {
            System.out.println(ammeter.getDatetime()+":"+ammeter.getAmmeterTotal());
        }
        System.out.println();

        System.out.println("空调总能耗");
        AmmeterExample queryExample2 = new AmmeterExample();
        AmmeterExample.Criteria queryCriteria2 = queryExample.createCriteria();
        queryCriteria2.andDatetimeBetween(startDate, endDate);
        queryCriteria2.andSensorIdEqualTo("WV0011");
        queryExample2.or(queryCriteria2);
        List<Ammeter> ammeterList = myAmmeterDao.selectByExample(queryExample2);
        for (Ammeter ammeter:ammeterList)
        {
            System.out.println(ammeter.getDatetime()+":"+ammeter.getAmmeterTotal());
        }

        System.out.println("主机能耗");
        AmmeterExample queryExample3 = new AmmeterExample();
        AmmeterExample.Criteria queryCriteria3 = queryExample.createCriteria();
        queryCriteria3.andDatetimeBetween(startDate, endDate);
        queryCriteria3.andSensorIdEqualTo("W0017");
        queryExample3.or(queryCriteria3);
        List<Ammeter> ammeterZJ = myAmmeterDao.selectByExample(queryExample3);
        for (Ammeter ammeter:ammeterZJ)
        {
            System.out.println(ammeter.getDatetime()+":"+ammeter.getAmmeterTotal());
        }

    }

    @Test
    public void testAddHour() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(new Date().toString());
        System.out.println(sdf.format(new Date()));
    }

    @Test
    public void getEveryMonth() throws ParseException {
        String minDate ="2015-11-06";
        String maxDate ="2016-12-06";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            System.out.println(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
    }

    @Test
    public void selectAllAlarmsPerpage() throws ParseException {
        HotMapper hotMapper = (HotMapper) ctx.getBean("hotMapper");
        AmmeterMapper ammeterMapper = (AmmeterMapper) ctx.getBean("ammeterMapper");
        DataTablePageUtil dataTablePageUtil = new DataTablePageUtil();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf_new = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        dataTablePageUtil.setStartTime(sdf_new.parse("2016-10-31 00-00-00"));
        dataTablePageUtil.setEndTime(sdf_new.parse("2016-12-06 00-00-00"));
        dataTablePageUtil.setPeriodType("byDay");
        String periodType = dataTablePageUtil.getPeriodType();
        Calendar cal = Calendar.getInstance();

        //保存汇总结果
        List<EneryConsumer> eneryConsumersList = new ArrayList<>();

        List<String> everydayList = AccountDate.getEveryday(sdf.format(dataTablePageUtil.getStartTime()), sdf.format(dataTablePageUtil.getEndTime()));

        switch (periodType)
        {
            case "byHour":
                for (String oneDay: everydayList)
                {
                    try {
                        Date currentDate = sdf.parse(oneDay);
                        List<Date> everyHours = AccountDate.getEveryHour(currentDate);
                        for (Date oneHour: everyHours)
                        {
                            //TODO
                            EneryConsumer energyConsumer = getEnergyConsumer(ammeterMapper, hotMapper, oneHour, AccountDate.addOneHour(oneHour));
                            eneryConsumersList.add(energyConsumer);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case "byMonth":
                List<Date> everyMonths = AccountDate.getEveryMonth(dataTablePageUtil.getStartTime(), dataTablePageUtil.getEndTime());
                for (Date oneMonth : everyMonths)
                {
                    //TODO
                    EneryConsumer energyConsumer = getEnergyConsumer(ammeterMapper, hotMapper, oneMonth, AccountDate.subOneHour(AccountDate.addOneMonth(oneMonth)));
                    eneryConsumersList.add(energyConsumer);
                }

                break;
            case "byDay":
                for (String oneDay: everydayList)
                {
                    EneryConsumer tempEnergyConsumer = new EneryConsumer();
                    tempEnergyConsumer.setDateTime(oneDay);
                    try {
                        Date currentDate = sdf.parse(oneDay);
                        cal.setTime(currentDate);
                        cal.add(Calendar.DATE, -1);
                        Date startDate = DateCalUtil.getStartDate(cal).getTime();
                        EneryConsumer energyConsumer = getEnergyConsumer(ammeterMapper, hotMapper, startDate, AccountDate.subOneHour(currentDate));
                        eneryConsumersList.add(energyConsumer);

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                break;
        }
      /*  for (EneryConsumer eneryConsumer:eneryConsumersList)
        {
            System.out.println(eneryConsumer.toString());
        }*/
    }

    private EneryConsumer getEnergyConsumer(AmmeterMapper ammeterMapper, HotMapper hotMapper, Date startDate, Date currentDate) {
        System.out.println("时间段间隔");
        EneryConsumer tempEnergyConsumer = new EneryConsumer();
        //TODO
        tempEnergyConsumer.setDateTime(startDate.toString());
        //获取一天的总能耗
        float totalEnergyByDay = getTotalEnergyByDay(ammeterMapper, startDate, currentDate, "WV0012");

        //设置平均能耗
        tempEnergyConsumer.setDwmjEnergy(totalEnergyByDay/ Constants.CALC_AREA);


        //主机能耗
        //TODO
        float zjEnergyByDay = getTotalEnergyByDay(ammeterMapper, startDate, currentDate, "W0017");

        //获取总热量
        float hotEnergyByDay = getHotEnergyByDay(hotMapper, startDate, currentDate, "R0001");

        //坐主机能耗是否为空的判定，若为空值为零
        if(Math.abs(zjEnergyByDay-0)<1e-6)
        {
            tempEnergyConsumer.setKtxtEnergy(0);
        }else{
            //设置空调COP
            tempEnergyConsumer.setKtxtEnergy(hotEnergyByDay/zjEnergyByDay);
        }

        //获取空调总能耗
        float ktEnergyByDay = getTotalEnergyByDay(ammeterMapper, startDate, currentDate, "WV0011");


        //坐空调总能耗是否为空的判定，若为空值为零
        if(Math.abs(ktEnergyByDay-0)<1e-6)
        {
            tempEnergyConsumer.setKtzjEnergy(0);
        }else{
            //TODO
            //设置空调系统能效
            tempEnergyConsumer.setKtzjEnergy(hotEnergyByDay/ktEnergyByDay);
        }
        System.out.println(tempEnergyConsumer.toString());
        return tempEnergyConsumer;
    }

    private float getTotalEnergyByDay(AmmeterMapper ammeterMapper, Date startDate, Date currentDate,String sensorId) {
        float totalEnergy;
        List<Ammeter> ktnhAmmeters = ammeterMapper.selectByExample(getQueryExample(startDate,currentDate,sensorId));
        totalEnergy = 0;
        for (Ammeter ktAmmeter: ktnhAmmeters)
        {
            totalEnergy+=ktAmmeter.getAmmeterTotal();
        }
        return totalEnergy;
    }

    private float getHotEnergyByDay(HotMapper hotMapper, Date startDate, Date currentDate,String sensorId) {
        float totalEnergy;
        List<Hot> ktnhAmmeters = hotMapper.selectByExample(getHotExample(startDate,currentDate,sensorId));
        totalEnergy = 0;
        for (Hot ktAmmeter: ktnhAmmeters)
        {
            totalEnergy+=ktAmmeter.getHotTotal();
        }
        return totalEnergy;
    }


    public AmmeterExample getQueryExample(Date startDate, Date currentDate,String sensorId)
    {
        AmmeterExample queryExample = new AmmeterExample();
        AmmeterExample.Criteria queryCriteria = queryExample.createCriteria();
        queryCriteria.andDatetimeBetween(startDate, currentDate);
        queryCriteria.andSensorIdEqualTo(sensorId);
        queryExample.or(queryCriteria);
        return queryExample;
    }


    public HotExample getHotExample(Date startDate, Date currentDate, String sensorId)
    {
        HotExample queryExample = new HotExample();
        HotExample.Criteria queryCriteria = queryExample.createCriteria();
        queryCriteria.andDatetimeBetween(startDate, currentDate);
        queryCriteria.andSensorIdEqualTo(sensorId);
        queryExample.or(queryCriteria);
        return queryExample;
    }

}
