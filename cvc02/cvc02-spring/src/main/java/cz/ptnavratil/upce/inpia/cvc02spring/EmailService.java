package cz.ptnavratil.upce.inpia.cvc02spring;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageSender {

    @Override
    public void sendMessage(String msg, String recipient) {
        System.out.println("Sending message via Email: \nMessage: " + msg + " \nRecipient: " + recipient);
    }
}
