package org.amqp.spring.jms.repository;

import org.amqp.spring.jms.bo.Notification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
   Simulate a persistence mechanism
   to store the data received from the queue.
 */

@Service
public class RepositoryServiceImpl implements RepositoryService {

    private List<Notification> messages = new ArrayList<Notification>();

    public void addMessage(Notification notification){
        messages.add(notification);
    }

    public Notification deleteMessage(String id){

        for(Notification notification : messages){
            if(notification.getId().equals(id)){
                messages.remove(notification);
                return notification;
            }
        }
        return null;
    }

    public Notification getMessage(String id){

        // if found return object, otherwise return null
        for(Notification notification : messages){
            if(notification.getId().equals(id)){
                messages.remove(notification);
                return notification;
            }
        }
        return null;
    }

    // re-initialize the list
    public List<Notification> deleteMessages(){
        messages = new ArrayList<Notification>();
        return messages;
    }

    @Override
    public List<Notification> getMessages() {
        return messages;
    }

}
