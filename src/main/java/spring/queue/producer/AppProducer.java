package spring.queue.producer;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动生产者
 *
 * @auther briarbear
 * @blog http://briarbear.github.io
 * @create 2018-07-11-11:44
 */
public class AppProducer {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");

        ProducerService service = context.getBean(ProducerService.class);

        for (int i = 0; i <100; i++) {
            service.sendMessage("test"+(i+1));
        }

        ((ClassPathXmlApplicationContext) context).close();
    }
}
