package com.company.app.com.company.app.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: mf
 * Date: 05.09.14
 * Time: 15:40
 */
@Component
public class MessagePrinter {
    //@Autowired
    private MessageService messageService;

/*    @Autowired
    public MessagePrinter(MessageService service) {
        this.messageService = service;
    }*/

    public void printMessage(){
        System.out.print(messageService.getMessage());
    }
    @Autowired
    public void setMessageService(MessageService service){
        System.err.println("--->> Message service setter invocation. Before: " + messageService );
        messageService = service;
    }
}
