package service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;

/**
 * Created by roof on 11/18/15.
 */

public class MailService {
    private TransactionConfirmationEmail transactionConfirmationEmail;
    private GenericSession session;

    public MailService(GenericSession session, TransactionConfirmationEmail email) {
        this.session = session;
        this.transactionConfirmationEmail = email;
    }

    public void send(String[] to) {
        try {
            MimeMessage message = session.getMimeMessage(to, transactionConfirmationEmail.subject, transactionConfirmationEmail.body);
            session.send(message);
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }



}

