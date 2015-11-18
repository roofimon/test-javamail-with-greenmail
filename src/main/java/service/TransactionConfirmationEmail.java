package service;

public class TransactionConfirmationEmail {
    public String subject;
    public String body;

    public TransactionConfirmationEmail() {
        subject = "Notice of transaction";
        body = "Your transaction is completed !!!";
    }
}