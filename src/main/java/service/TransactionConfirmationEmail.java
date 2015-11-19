package service;

/**
 * Created by roofimon on 11/19/2015 AD.
 */
public class TransactionConfirmationEmail extends Email {
    public TransactionConfirmationEmail() {
        subject = "Java send mail example";
        body = "Your transaction is completed !!!";
    }

}
