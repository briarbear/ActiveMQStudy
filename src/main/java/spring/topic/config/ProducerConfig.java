package spring.topic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

/**
 * 生产者配置
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-11-18:51
 */
@Configuration
@Import(CommonConfig.class)
public class ProducerConfig {

    @Autowired
    SingleConnectionFactory connectionFactory;

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory);
        return jmsTemplate;
    }

}
