package service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by roof on 11/18/15.
 */
public class GenericSession {
    protected String username;
    protected String password;
    protected String host;
    protected Session session;
    protected int port = 587;

    public void send(MimeMessage message) throws MessagingException {
        Transport transport = session.getTransport("smtp");
        transport.connect(host, port, username, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public MimeMessage getMimeMessage(String[] to, String subject, String body) throws MessagingException {
        MimeMessage message = new MimeMessage(this.session);
        message.setFrom(new InternetAddress(this.username));
        messageSetTos(to, message);
        message.setSubject(subject);
        message.setText(body);
        return message;
    }

    private void messageSetTos(String[] to, MimeMessage message) throws MessagingException {
        InternetAddress[] toAddress = createRecipientInternetAddress(to);

        for( int i = 0; i < toAddress.length; i++) {
            message.addRecipient(Message.RecipientType.TO, toAddress[i]);
        }
    }

    private InternetAddress[] createRecipientInternetAddress(String[] to) throws AddressException {
        InternetAddress[] toAddress = new InternetAddress[to.length];

        for( int i = 0; i < to.length; i++ ) {
            toAddress[i] = new InternetAddress(to[i]);
        }
        return toAddress;
    }

}
