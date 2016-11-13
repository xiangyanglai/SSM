package test.batis;

/**
 * Created by search on 2016/11/12.
 */
import com.cn.tju.IDao.RedisDaoImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRedisProduce {
    private RedisDaoImpl redisDAO=null;

    @Before
    public void setUp() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("redis-producer.xml");
        redisDAO = (RedisDaoImpl) applicationContext.getBean("redisDAO");
    }


    @Test
    public void testPublishMessage() throws Exception {
        String msg = "Hello, Redis!";
        redisDAO.sendMessage("java", msg); //发布字符串消息


        Integer[] values = new Integer[]{21341,123123,12323};
        redisDAO.sendMessage("java", values);  //发布一个数组消息
    }
}
