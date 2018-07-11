package jms.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 主题模式-消息生产者
 *
 * @auther briarbear
 * @blog http://briarbear.github.io
 * @create 2018-07-11-8:54
 */
public class AppProducer {
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

        //5. 创建主题
        Destination topic = session.createTopic(topicName);

        //6. 创建一个消息生成者
        MessageProducer producer = session.createProducer(topic);

        for (int i = 0; i < 100; i++) {
            //7. 创建消息
            TextMessage message = session.createTextMessage("test" + i+1);

            //8. 发布消息
            producer.send(message);
            System.out.println("发送消息"+message.getText());
        }

        //9. 关闭连接
        connection.close();
    }
}
