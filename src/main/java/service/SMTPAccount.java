package service;

/**
 * Created by roofimon on 11/19/2015 AD.
 */
public class SMTPAccount {
    String username;
    String password;
    String host;
    int port;

    public SMTPAccount(String username, String password, String host, int port) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
    }
}
