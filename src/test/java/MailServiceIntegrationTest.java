import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.Test;
import service.*;

import javax.mail.MessagingException;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by roof on 11/18/15.
 */
public class MailServiceIntegrationTest {
    private String[] RECIPIENT = {"roof@odd-e.co.th", "roofimon@gmail.com"};
    private static final int SMTP_TEST_PORT = 3025;
    public GreenMail greenMail;
    Email email = new TransactionConfirmationEmail();
    public void testSendMailViaLegacy() throws MessagingException {
        GenericMailSession session = new GmailMailSession();
        LegacyEmailService mailService = new LegacyEmailService();
        mailService.setSession(session, email);
        mailService.send(RECIPIENT);
    }

    @Test
    public void testSendMailViaFakeSMTP() throws MessagingException {
        greenMail = new GreenMail(new ServerSetup(SMTP_TEST_PORT, null, "smtp"));
        greenMail.start();
        GenericMailSession session = new FakeMailSession();
        LegacyEmailService mailService = new LegacyEmailService();
        mailService.setSession(session, email);

        mailService.send(RECIPIENT);

        assertEquals("Your transaction is completed !!!", GreenMailUtil.getBody(greenMail.getReceivedMessages()[0]));
        greenMail.stop();
    }
}
