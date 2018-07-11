package spring.topic.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消费者-消息监听器
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-11-19:38
 */
@Component
public class ComsumerMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;

        try {
            System.out.println("接受消息"+textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
