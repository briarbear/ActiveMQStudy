package jms.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 主题模式-消费者
 *
 * @auther briarbear
 * @blog http://briarbear.github.io
 * @create 2018-07-11-8:58
 */
public class AppConsumer {
    private static final String url = "tcp://192.168.24.128:61616";
    private static final String topicName = "topic-test";


    public static void main(String[] args) throws JMSException {
        //1. 创建ConnectionFactory连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        //2. 创建Connection连接
        Connection connection = connectionFactory.createConnection();

        //3. 启动连接
        connection.start();

        //4. 创建回话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//不启用事务 启动自动应答

        //5. 创建目标或目的地
        Destination topic = session.createTopic(topicName);

        //6. 创建一个消息消费者
        MessageConsumer consumer = session.createConsumer(topic);

        //7. 创建一个监听器
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("接受消息："+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });



        //8. 关闭连接
//        connection.close();
    }
}
