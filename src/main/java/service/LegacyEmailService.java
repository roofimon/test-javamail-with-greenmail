package service;
import javax.mail.*;
import javax.mail.internet.*;
/**
 * Created by roof on 11/18/15.
 */
public class LegacyEmailService {
    private GenericMailSession session;

    public void setSession(GenericMailSession session) {
        this.session = session;
    }

    public void send(String[] to) {
        String subject = "Java send mail example";
        String body = "Your transaction is completed !!!";
        try {
            for( int i = 0; i < to.length; i++ ) {
                MimeMessage message = session.createMimeMessage(to[i], subject, body);
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
