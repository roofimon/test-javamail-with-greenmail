package service;

import javax.mail.Session;
import java.util.Properties;

/**
 * Created by roof on 11/19/15.
 */
public class GmailSession {
    private String from;
    private String pass;
    private String host;
    private int    port;
    private Session session;

    public GmailSession(String from, String pass, String host, int port) {
        this.host = host;
        this.from = from;
        this.pass = pass;
        this.port = port;
        invoke();
    }

    public String getFrom(){
        return this.from;
    }

    public String getPass() {
        return this.pass;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public Session getSession() {
        return session;
    }

    public void invoke() {
        Properties props = System.getProperties();
        host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        session = Session.getDefaultInstance(props);
    }
}
