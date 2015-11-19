package service;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by roof on 11/18/15.
 */
public class LegacyEmailService {
    private GenericMailSession session;

    public void setSession(GenericMailSession session) {
        this.session = session;
    }

    public void send(String[] to) {
        List<String> recipients = Arrays.asList(to);
        String subject = "Java send mail example";
        String body = "Your transaction is completed !!!";
        try {
            for( String recipient : recipients ) {
                MimeMessage message = session.createMimeMessage(recipient, subject, body);
                session.send(message);
            }
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }

}
