package spring.topic.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;

/**
 * 共同的配置
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-11-17:21
 */
@Configuration
@ComponentScan(basePackages = "spring.topic.*")
public class CommonConfig {

    private static final String URL = "tcp://192.168.159.132:61616";  //实验室电脑的docker activemq的ip
    private static final String TOPIC_NAME = "spring-jms-topic";

    @Bean(name = "targetConnectionFactory")
    public ActiveMQConnectionFactory targetConnectionFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(URL);
        return activeMQConnectionFactory;
    }

    //默认bean的名字就是方法名
    @Bean
    public SingleConnectionFactory connectionFactory(){
        SingleConnectionFactory connectionFactory = new SingleConnectionFactory();
        connectionFactory.setTargetConnectionFactory(targetConnectionFactory());

        return connectionFactory;
    }

    /**
     * 配置主题模式的目的地
     * 发布订阅模式
     * @return
     */
    @Bean(name = "topicDestination")
    public ActiveMQTopic topicDestination(){
        ActiveMQTopic activeMQTopic = new ActiveMQTopic(TOPIC_NAME);
        return activeMQTopic;
    }



}
