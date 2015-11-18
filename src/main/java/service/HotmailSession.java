package service;

import javax.mail.Session;
import java.util.Properties;

/**
 * Created by roof on 11/18/15.
 */
public class HotmailSession extends GenericSession{
    public HotmailSession() {
        super.username = "roofimon@live.com";
        super.password = "N0mif00rA";
        super.host = "smtp.live.com";
    }

    public HotmailSession invoke() {
        initProperties();
        session = Session.getDefaultInstance(props);
        return this;
    }
}
