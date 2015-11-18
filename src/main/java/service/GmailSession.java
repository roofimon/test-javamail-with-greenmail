package service;

import javax.mail.Session;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by roof on 11/18/15.
 */
public class GmailSession extends GenericSession {
    public GmailSession() {
        super();
        super.username = "roofimon@gmail.com";
        super.password = "N0mif00rA";
        super.host = "smtp.gmail.com";
    }
}
