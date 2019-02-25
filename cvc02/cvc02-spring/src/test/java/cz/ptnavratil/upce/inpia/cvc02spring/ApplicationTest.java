package cz.ptnavratil.upce.inpia.cvc02spring;

import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicationTest {

    @Test(expected = IllegalArgumentException.class)
    public void processMessagesMsgEmptyTest() {
        Application app = new Application();
        app.sender = new EmailService();

            app.processMessages(null,"Petr");
    }

    @Test
    public void processMessagesMsgNonEmptyTest() {
        Application app = new Application();
        EmailServiceMock emailServiceMock = new EmailServiceMock();
        app.sender = emailServiceMock;

        app.processMessages("Petr","Petr");
        assertEquals("Expect 1 call to emailSender.sendMessage(msg,recipient)",1,emailServiceMock.callCount);
    }

    private class EmailServiceMock extends EmailService{

        public int callCount = 0;

        @Override
        public void sendMessage(String msg, String recipient) {
            super.sendMessage(msg, recipient);
            callCount++;
        }
    }

}