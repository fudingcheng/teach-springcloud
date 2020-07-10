package com.itheima.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class MessageProducer {

    @Autowired
    private MessageChannel output;

    public void send(){
        String message = "hello world stream";
        output.send(MessageBuilder.withPayload(message).build());
        System.out.println("消息发送成功~");
    }

}
