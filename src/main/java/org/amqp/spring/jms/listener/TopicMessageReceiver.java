package org.amqp.spring.jms.listener;

import org.amqp.spring.jms.bo.Notification;
import org.amqp.spring.jms.services.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("topicMessageReceiver")
public class TopicMessageReceiver {

    private static final Logger log = Logger.getLogger(TopicMessageReceiver.class);

    @Autowired
    private MessageService messageService;

    public void receive(Object message) {

        if (message instanceof Notification) {
            log.info("***** This is the message from the TopicMessageReceiver :" + message.toString());
            Notification notification = (Notification) message;
            messageService.convertAndSendToQueue(notification);
        }
    }
}