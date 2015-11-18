import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import com.sun.tools.javac.jvm.Gen;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.*;

import javax.mail.MessagingException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;


/**
 * Created by roof on 11/18/15.
 */
public class MailServiceTest {
    private String[] RECIPIENT = {"roof@odd-e.co.th", "roofimon@gmail.com"};

    private static final int SMTP_TEST_PORT = 3025;
    public GreenMail greenMail;

    @Test
    public void testSendMailGreenMailSession() throws MessagingException {
        //Arrange
        greenMail = new GreenMail(new ServerSetup(SMTP_TEST_PORT, null, "smtp"));
        greenMail.start();
        GenericSession session = new GreenMailSession().invoke();
        MailService mailService = new MailService(session, new TransactionConfirmationEmail());

        //Act
        mailService.send(RECIPIENT);

        //Assert
        assertEquals("Your transaction is completed !!!", GreenMailUtil.getBody(greenMail.getReceivedMessages()[0]));
        greenMail.stop();
    }
}
