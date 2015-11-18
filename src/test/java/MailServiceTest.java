import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.GenericSession;
import service.GmailSession;
import service.MailService;
import service.TransactionConfirmationEmail;

import static org.junit.Assert.assertEquals;


/**
 * Created by roof on 11/18/15.
 */
public class MailServiceTest {
    private String[] RECIPIENT = {"roof@odd-e.co.th"};

    private static final int SMTP_TEST_PORT = 3025;
    public GreenMail greenMail;

    @Before
    public void setUp() throws Exception {
        greenMail = new GreenMail(new ServerSetup(SMTP_TEST_PORT, null, "smtp"));
        greenMail.start();
    }
    @After
    public void tearDown() throws Exception {
        greenMail.stop();
    }

    @Test
    public void testSendMailViaGmailSMTP() {
        GmailSession session = new GmailSession().invoke();
        MailService mailService = new MailService(session, new TransactionConfirmationEmail());
        mailService.send(RECIPIENT);
    }
    @Test
    public void testSendMailGreenMailSession() {
        GenericSession session = new GreenMailSession().invoke();
        MailService mailService = new MailService(session, new TransactionConfirmationEmail());
        mailService.send(RECIPIENT);
        assertEquals("Your transaction is completed !!!", GreenMailUtil.getBody(greenMail.getReceivedMessages()[0]));

    }
}
