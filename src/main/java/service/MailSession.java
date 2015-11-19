package service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by roof on 11/19/15.
 */
public class MailSession {
    private SMTPAccount SMTPAccount;
    private Session session;

    public MailSession(SMTPAccount smtpAccount) {
        this.SMTPAccount = smtpAccount;
        invoke();
    }

    public Session getSession() {
        return session;
    }
    public void send(MimeMessage message) throws MessagingException {
        Transport transport = session.getTransport("smtp");
        transport.connect(this.SMTPAccount.host, SMTPAccount.port, SMTPAccount.from, SMTPAccount.pass);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public MimeMessage getMimeMessage(String[] to, String subject, String body) throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(SMTPAccount.from));
        getRecipientInternetAddress(to, message);
        message.setSubject(subject);
        message.setText(body);
        return message;
    }

    private void getRecipientInternetAddress(String[] to, MimeMessage message) throws MessagingException {
        for( int i = 0; i < to.length; i++ ) {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
        }
    }

    public void invoke() {
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTPAccount.host);
        props.put("mail.smtp.user", SMTPAccount.from);
        props.put("mail.smtp.password", SMTPAccount.pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        session = Session.getDefaultInstance(props);
    }
}
