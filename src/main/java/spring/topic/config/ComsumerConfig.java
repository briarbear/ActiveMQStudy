package spring.topic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import spring.topic.consumer.ComsumerMessageListener;

import javax.jms.Destination;

/**
 * 消费者配置
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-11-19:34
 */
@Configuration
@Import(CommonConfig.class)
public class ComsumerConfig {


    @Autowired
    public ComsumerMessageListener comsumerMessageListener;
    @Autowired
    public SingleConnectionFactory connectionFactory;

    @Autowired
    @Qualifier("topicDestination")
    public Destination topicDestination;

    /**
     * 配置消息监听容器
     */
    @Bean
    public DefaultMessageListenerContainer jmsContainer(){
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setDestination(topicDestination);
        container.setMessageListener(comsumerMessageListener);

        return container;
    }
}
