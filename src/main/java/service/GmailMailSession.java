package service;

/**
 * Created by roofimon on 11/19/2015 AD.
 */
public class GmailMailSession extends GenericMailSession{
    public GmailMailSession() {
        super();
        super.host = "smtp.gmail.com";
        super.port = 587;
    }
}
