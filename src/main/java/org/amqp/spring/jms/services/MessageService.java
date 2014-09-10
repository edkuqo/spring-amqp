package org.amqp.spring.jms.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class MessageService {

    @Autowired
    @Qualifier("jmsTemplate")
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("jmsTopicTemplate")
    private JmsTemplate jmsTopicTemplate;

    private static final Logger log = Logger.getLogger(MessageService.class);

    public void convertAndSendToQueue(Object payload) {
        log.info("***** Pushing Message to Queue:" + payload.toString());
        jmsTemplate.convertAndSend(payload);
    }

    public void convertAndSendToQueue(String destination, Object payload) {
        jmsTemplate.convertAndSend(destination, payload);
    }

    public void convertAndSendToTopic(Object payload) {
        log.info("***** Pushing Message to Topic:" + payload.toString());
        jmsTopicTemplate.convertAndSend("test.topic", payload);
    }
}