package test.batis;

import javax.annotation.Resource;

import com.cn.tju.IDao.MessageDelegateListenerImpl;
import com.cn.tju.IDao.RedisDao;
import org.apache.log4j.Logger;
import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
import org.apache.log4j.Logger;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.cn.tju.pojo.User;
import com.cn.tju.service.UserService;
import com.cn.tju.service.impl.UserServiceImpl;

import java.util.Date;

public class TestMyBatis {

    ClassPathXmlApplicationContext ctx =  new ClassPathXmlApplicationContext("redis-consumer.xml");;
    MessageDelegateListenerImpl messageDelegateListener = (MessageDelegateListenerImpl) ctx.getBean("messageDelegateListener");
    public static void main(String[] args) {
        while (true) { //这里是一个死循环,目的就是让进程不退出,用于接收发布的消息
            try {
                System.out.println("current time: " + new Date());

                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testPublishMessage() throws Exception {
        RedisDao redisDAO = (RedisDao) ctx.getBean("redisDAO");
        String msg = "Hello, Redis!";
        redisDAO.sendMessage("java", msg); //发布字符串消息


        RedisTestBean bean = new RedisTestBean();
        bean.setName("Redis");
        bean.setSeliry((short)40);
        bean.setManbers(new String[]{"234567", "3456789"});
        redisDAO.sendMessage("java", bean); //发布一个普通的javabean消息


        Integer[] values = new Integer[]{21341,123123,12323};
        redisDAO.sendMessage("java", values);  //发布一个数组消息
    }

}
