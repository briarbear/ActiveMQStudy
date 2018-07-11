package spring.topic.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.topic.config.CommonConfig;
import spring.topic.config.ComsumerConfig;
import spring.topic.config.ProducerConfig;

/**
 * 生产者-消息的发布者
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-11-20:08
 */
public class AppProducer {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(CommonConfig.class,ComsumerConfig.class,ProducerConfig.class);
//        context.getBean(ProducerServiceImpl.class);


        ProducerService service = context.getBean(ProducerServiceImpl.class);

        for (int i = 0; i <100; i++) {
            service.sendMessage("test"+(i+1));
        }

        ((AnnotationConfigApplicationContext) context).close();

    }
}
