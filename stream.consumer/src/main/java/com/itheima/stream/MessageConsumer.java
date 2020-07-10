package com.itheima.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@EnableBinding({Sink.class})
@Component
public class MessageConsumer {

    @StreamListener(Sink.INPUT)
    public void receive(Message message){
        System.out.println(message);
        System.out.println(message.getPayload());
    }

}
