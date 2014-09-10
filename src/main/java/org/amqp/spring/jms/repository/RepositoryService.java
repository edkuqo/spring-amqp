package org.amqp.spring.jms.repository;

import org.amqp.spring.jms.bo.Notification;

import java.util.List;

public interface RepositoryService {

    void addMessage(Notification notification);

    List<Notification> getMessages();

    Notification getMessage(String id);

    Notification deleteMessage(String id);

    List<Notification> deleteMessages();
}
