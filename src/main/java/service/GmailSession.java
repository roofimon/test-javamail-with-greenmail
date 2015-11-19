package service;

import javax.mail.Session;
import java.util.Properties;

/**
 * Created by roof on 11/19/15.
 */
public class GmailSession {
    private SMTPAccount SMTPAccount;
    private Session session;

    public GmailSession(SMTPAccount smtpAccount) {
        this.SMTPAccount = smtpAccount;
        invoke();
    }

    public String getFrom(){
        return this.SMTPAccount.from;
    }

    public String getPass() {
        return this.SMTPAccount.pass;
    }

    public String getHost() {
        return SMTPAccount.host;
    }

    public int getPort() {
        return SMTPAccount.port;
    }

    public Session getSession() {
        return session;
    }

    public void invoke() {
        Properties props = System.getProperties();
        SMTPAccount.host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTPAccount.host);
        props.put("mail.smtp.user", SMTPAccount.from);
        props.put("mail.smtp.password", SMTPAccount.pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        session = Session.getDefaultInstance(props);
    }
}
