package spring.topic.producer;

/**
 * 生产者
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-11-19:00
 */
public interface ProducerService {
    void sendMessage(String message);
}
