package service;

/**
 * Created by roofimon on 11/19/2015 AD.
 */
public class FakeMailSession extends GenericMailSession {
    public FakeMailSession() {
        super();
        super.host = "localhost";
        super.port = 3025;
    }
}
