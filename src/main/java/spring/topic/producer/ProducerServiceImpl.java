package spring.topic.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;


/**
 * 生产者实现类
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-11-19:02
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    JmsTemplate jmsTemplate;


    //这连个注解组合起来,等同于@Resource
    @Qualifier("topicDestination")
    @Autowired
    Destination destination;

    @Override
    public void sendMessage(String message) {
        //使用JmsTemplate发送消息
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                return textMessage;
            }
        });

        System.out.println("发送消息"+ message);
    }
}
