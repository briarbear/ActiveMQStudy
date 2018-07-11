package spring.queue.producer;

/**
 * spring-jms 生产者接口
 */
public interface ProducerService {
    void sendMessage(String message);
}
