import org.junit.Test;
import service.*;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created by roof on 11/18/15.
 */
public class MailServiceIntegrationTest {
    private String[] RECIPIENT = {"roof@odd-e.co.th", "roofimon@gmail.com"};

    @Test
    public void testSendMailViaHotmailSMTP() throws MessagingException {
        GenericSession session = new HotmailSession().invoke();
        MailService mailService = new MailService(session, new TransactionConfirmationEmail());
        mailService.send(RECIPIENT);
    }
    @Test
    public void testSendMailViaGmailSMTP() throws IOException, MessagingException {
        GenericSession session = new GmailSession().invoke();
        MailService mailService = new MailService(session, new TransactionConfirmationEmail());
        mailService.send(RECIPIENT);
    }
}
