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
        super.username = "*****@gmail.com";
        super.password = "*****";
        super.host = "smtp.gmail.com";
    }

    public GmailSession invoke() throws IOException {
        initProperties();
        session = Session.getDefaultInstance(props);
        return this;
    }

}
