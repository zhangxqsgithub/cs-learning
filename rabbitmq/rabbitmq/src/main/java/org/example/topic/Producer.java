package org.example.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import org.example.util.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author will
 * @since 2024/5/14
 */
public class Producer {
    
    public static String EXCHANGE_NAME = "test";
    public static String QUEUE_NAME_1 = "q1";
    public static String QUEUE_NAME_2 = "q2";
    public static String QUEUE_NAME_3 = "q3";
    
    public static void main(String[] args) {
        try (Channel channel = RabbitMQUtils.getChannel()) {
            // 声明 exchange
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC, false, false, null);
            channel.queueDeclare(QUEUE_NAME_1, false, false, false, null);
            channel.queueDeclare(QUEUE_NAME_2, false, false, false, null);
            channel.queueDeclare(QUEUE_NAME_3, false, false, false, null);
            channel.queueBind(QUEUE_NAME_1, EXCHANGE_NAME, "*.test.*", null);
            channel.queueBind(QUEUE_NAME_2, EXCHANGE_NAME, "*.*.rabbit", null);
            channel.queueBind(QUEUE_NAME_3, EXCHANGE_NAME, "lazy.#", null);
            
            channel.basicPublish(EXCHANGE_NAME, "test.test.rabbit", null, "msg1".getBytes());
            channel.basicPublish(EXCHANGE_NAME, "lazy.test.rabbit", null, "msg1".getBytes());
            channel.basicPublish(EXCHANGE_NAME, "abc.hello.rabbit", null, "msg1".getBytes());
            channel.basicPublish(EXCHANGE_NAME, "lazy.test", null, "msg1".getBytes());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
