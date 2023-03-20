package pl.javastart.task.internal;

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
        System.out.println("=== STAN KONTA ===\nWysłanych SMSów: " + agreement.smsCount
                + "\nWysłanych MMSów: " + agreement.mmsCount
                + "\nLiczba sekund rozmowy: " +  agreement.secCount + "\n");
        System.out.println(agreement.getAccountInformation());
    }
}
