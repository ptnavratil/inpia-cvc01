package cz.ptnavratil.upce.inpia.cvc02spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Application {

    @Autowired
    private EmailService emailService;

    public MessageSender sender;

    @Autowired
    List<MessageSender> services;

    @PostConstruct
    public void myMethod() {
        System.out.println("Done!");
    }

    public void processMessages(String msg, String recipient) {
        if(msg == null) throw new IllegalArgumentException();

        sender.sendMessage(msg,recipient);
        /*
        for (MessageSender service : services) {
            service.sendMessage(msg, recipient);
        }
        */
    }

    public static void main(String[] args) {
        System.out.println(AnnotationConfigApplicationContext.class);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cz.ptnavratil.upce.inpia.cvc02spring");

        Application ap = (Application) context.getBean(Application.class);

        ap.processMessages("Test Spring", "Petr");

    }
}
