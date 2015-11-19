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
    public void sendEmailViaGoogleSMTP() {
        SMTPAccount smtpAccount = new SMTPAccount("massive.mail3r@gmail.com", "N0mif00rA", "smtp.gmail.com", 587);
        GmailSession gmailSession = new GmailSession(smtpAccount);
        LegcyEmailService mailService = new LegcyEmailService();
        mailService.setGmailSession(gmailSession);
        mailService.send(RECIPIENT);
    }
}
