package test.batis;

import com.cn.tju.IDao.MessageDelegateListenerImpl;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by search on 2016/11/12.
 */
public class TestRedisConsumer {
    private static MessageDelegateListenerImpl messageDelegateListener=null;

    public static void setUp() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("redis-consumer.xml");
        messageDelegateListener = (MessageDelegateListenerImpl) applicationContext.getBean("messageDelegateListener");
        System.out.println("ass");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("redis-consumer.xml");
        System.out.println("消费者1");
        while (true) { //这里是一个死循环,目的就是让进程不退出,用于接收发布的消息
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
