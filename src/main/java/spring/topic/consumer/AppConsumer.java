package spring.topic.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.topic.config.CommonConfig;
import spring.topic.config.ComsumerConfig;
import spring.topic.config.ProducerConfig;

/**
 * 消费者-消息订阅者
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-11-19:51
 */
public class AppConsumer {

    public static void main(String[] args) {
        //加载基于Java配置,或者注解的上下文
        ApplicationContext context = new AnnotationConfigApplicationContext(CommonConfig.class,ComsumerConfig.class,ProducerConfig.class);
    }
}
