import service.GenericSession;

import javax.mail.Session;
import java.util.Properties;

/**
 * Created by roof on 11/18/15.
 */
public class GreenMailSession extends GenericSession{

    public GreenMailSession() {
        super.username = "massive.mail3r@gmail.com";
        super.password = "N0mif00rA";
        super.port = 3025;
        super.host = "localhost";
    }


    public GreenMailSession invoke() {
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", this.username);
        props.put("mail.smtp.password", this.password);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(props);
        return this;
    }

}
