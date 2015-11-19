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
 * Created by roofimon on 11/19/2015 AD.
 */
public class GenericMailSession {
    private Session session;
    protected SMTPAccount smtpAccount;
    Properties props;

    public GenericMailSession() {
        props = System.getProperties();
    }

    public MimeMessage createMimeMessage(String to, String subject, String body) throws MessagingException {
        MimeMessage message = new MimeMessage(getSession());
        message.setFrom(new InternetAddress(smtpAccount.username));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)) ;
        message.setSubject(subject);
        message.setText(body);
        return message;
    }

    public void send(MimeMessage message) throws MessagingException {
        Transport transport = getSession().getTransport("smtp");
        transport.connect(smtpAccount.host, smtpAccount.port, smtpAccount.username, smtpAccount.password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    private Session getSession(){
        assignSMTPConfigurations();
        session = Session.getDefaultInstance(props);
        return session;
    }

    private void assignSMTPConfigurations() {
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtpAccount.host);
        props.put("mail.smtp.user", smtpAccount.username);
        props.put("mail.smtp.password", smtpAccount.password);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
    }
}
