import service.GenericSession;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * Created by roof on 11/18/15.
 */
public class GreenMailSession extends GenericSession{

    public GreenMailSession() {
        super();
        super.username = "massive.mail3r@gmail.com";
        super.password = "N0mif00rA";
        super.port = 3025;
        super.host = "localhost";
    }



}
