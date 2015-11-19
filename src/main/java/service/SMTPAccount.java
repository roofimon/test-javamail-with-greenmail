package service;

public class SMTPAccount {
    String from;
    String pass;
    String host;
    int port;

    public SMTPAccount(String from, String pass, String host, int port) {
        this.from = from;
        this.pass = pass;
        this.host = host;
        this.port = port;
    }
}