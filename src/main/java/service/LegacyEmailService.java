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
    private Email email;

    public void setSession(GenericMailSession session, Email email) {
        this.session = session;
        this.email = email;
    }

    public void send(String[] to) {
        List<String> recipients = Arrays.asList(to);
        try {
            for( String recipient : recipients ) {
                MimeMessage message = session.createMimeMessage(recipient, email);
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
