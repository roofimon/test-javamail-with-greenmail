import org.junit.Test;
import service.*;

import javax.mail.MessagingException;


/**
 * Created by roof on 11/18/15.
 */
public class MailServiceIntegrationTest {
    private String[] RECIPIENT = {"roof@odd-e.co.th", "roofimon@gmail.com"};

    @Test
    public void testSendMailViaLegacy() throws MessagingException {
        LegacyEmailService mailService = new LegacyEmailService();
        mailService.send(RECIPIENT);
    }

}
