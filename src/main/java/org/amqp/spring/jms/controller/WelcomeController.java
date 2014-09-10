package org.amqp.spring.jms.controller;

import org.amqp.spring.jms.bo.Notification;
import org.amqp.spring.jms.repository.RepositoryService;
import org.amqp.spring.jms.services.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/sample")
public class WelcomeController {

    private static final Logger log = Logger.getLogger(WelcomeController.class);

    @Autowired
    private MessageService messageService;

    @Autowired
    RepositoryService repositoryService;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    protected ModelAndView welcome(HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("index");
        model.addObject("notification", new Notification());
        return model;
    }

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    protected ModelAndView push(HttpServletRequest request,
                                HttpServletResponse response,
                                @ModelAttribute Notification notification) throws Exception {
        // simply to be used for the delete call
        notification.setId(UUID.randomUUID().toString());
        log.info("***** Publishing message with id : " + notification.getId() + " to the topic.");

        messageService.convertAndSendToTopic(notification);
        return new ModelAndView("results");
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    protected
    @ResponseBody
    List<Notification> getMessages(HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        log.info("***** Retrieving messages published to queue.");
        return repositoryService.getMessages();
    }

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    protected
    @ResponseBody
    ModelAndView resetList(HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
        log.info("***** Clearing all messages from list.");

        repositoryService.deleteMessages();
        ModelAndView model = new ModelAndView("results");
        model.addObject("message", "List Reset");
        return model;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    protected ModelAndView remove(HttpServletRequest request,
                                  HttpServletResponse response,
                                  @RequestParam String id) throws Exception {
        log.info("***** Removing message with id :" + id);
        ModelAndView model = new ModelAndView("results");
        model.addObject("notification", repositoryService.deleteMessage(id));
        return model;
    }

}