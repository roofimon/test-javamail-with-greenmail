package service;

/**
 * Created by roofimon on 11/19/2015 AD.
 */
public class GmailMailSession extends GenericMailSession{
    public GmailMailSession() {
        super();
        super.smtpAccount = new SMTPAccount("massive.mail3r@gmail.com", "N0mif00rA", "smtp.gmail.comt", 587);
    }
}
