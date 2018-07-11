package spring.queue.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;


import javax.annotation.Resource;
import javax.jms.*;

/**
 * 生产者实现类
 *
 * @auther briarbear
 * @blog http://briarbear.github.io
 * @create 2018-07-11-11:30
 */
public class ProducerServiceImpl implements ProducerService {


    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource(name = "queueDestination")  //使用@Resource注解,因为存在多个Destination,使用name绑定
    private Destination destination;              //均使用jms的相关类


    public void sendMessage(final String message) {
        //使用JmsTemplate 发送消息
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);

            }
        });
        System.out.println("发送消息"+message);
    }
}
