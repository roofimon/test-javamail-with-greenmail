package service;
import javax.mail.*;
import javax.mail.internet.*;
/**
 * Created by roof on 11/18/15.
 */
public class LegcyEmailService {
    private MailSession gmailSession;

    public void setGmailSession(MailSession session) {
        this.gmailSession = session;
    }


    public void send(String[] args) {
        String[] to = args; // list of recipient email addresses
        String subject = "Java send mail example";
        String body = "Your transaction is completed !!!";


        try {
            MimeMessage message = gmailSession.getMimeMessage(to, subject, body);

            gmailSession.send(message);
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }

}
