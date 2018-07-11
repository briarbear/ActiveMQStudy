package spring.queue.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 消费者启动类
 *
 * @auther briarbear
 * @blog http://briarbear.github.io
 * @create 2018-07-11-12:52
 */
public class AppComsumer {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("comsumer.xml");

    }
}
