import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.Ignore;
import org.junit.Test;
import service.*;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by roof on 11/18/15.
 */
public class MailServiceIntegrationTest {
    private static final int SMTP_TEST_PORT = 3025;
    public GreenMail greenMail;

    private String[] RECIPIENT = {"roof@odd-e.co.th", "roofimon@gmail.com"};
    @Ignore
    @Test
    public void sendEmailViaGoogleSMTP() {
        SMTPAccount smtpAccount = new SMTPAccount("massive.mail3r@gmail.com", "ukJjCqqDcepg98L", "smtp.gmail.com", 587);
        MailSession gmailSession = new MailSession(smtpAccount);
        LegcyEmailService mailService = new LegcyEmailService();
        mailService.setGmailSession(gmailSession);
        mailService.send(RECIPIENT);
    }
    @Test
    public void sendEmailViaGreenMailSMTP() {
        //Arrange
        greenMail = new GreenMail(new ServerSetup(SMTP_TEST_PORT, null, "smtp"));
        greenMail.start();
        SMTPAccount smtpAccount = new SMTPAccount("fake@greenmail.com", "*******", "localhost", 3025);
        MailSession fakeSession = new MailSession(smtpAccount);
        LegcyEmailService mailService = new LegcyEmailService();
        mailService.setGmailSession(fakeSession);

        //Act
        mailService.send(RECIPIENT);

        //Assert
        assertEquals("Your transaction is completed !!!", GreenMailUtil.getBody(greenMail.getReceivedMessages()[0]));
        greenMail.stop();
    }

}
