package org.amqp.spring.jms.listener;

import org.amqp.spring.jms.bo.Notification;
import org.amqp.spring.jms.repository.RepositoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueMessageReceiverTwo {

    private static final Logger log = Logger.getLogger(QueueMessageReceiverTwo.class);

    @Autowired
    private RepositoryService repositoryService;

    public void receive(Object message) {

        if (message instanceof Notification) {
            log.info("***** This is the message from the queue receiver two :" + message.toString());

            try {
                Notification notification = (Notification) message;
                repositoryService.addMessage(notification);
                // Sleep() is used to simulate a busy listener so if there are multiple
                // messages sent to the queue, you can see that each listener receives a message
                // and will not receive another one until has finished processing the first message.
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                log.error("***** " + e.getMessage());
            }
        }

    }
}