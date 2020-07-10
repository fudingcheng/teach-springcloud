package com.itheima.controller;

import com.itheima.stream.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private MessageProducer producer;

    @RequestMapping("/send")
    public String send() {
        producer.send();
        return "send success";
    }

}
