package pl.javastart.task;

public class Phone {

    private Agreement agreement;

    public Phone(Agreement agreement) {
        this.agreement = agreement;
    }

    public void sendSms() {
        agreement.sendSms();
    }

    public void call(int seconds) {
        agreement.makePhoneCall(seconds);
    }

    public void sendMms() {
        agreement.sendMms();
    }

    public void printAccountState() {
        agreement.printAccountInformation();
    }
}
