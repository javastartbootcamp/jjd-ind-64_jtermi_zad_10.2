package pl.javastart.task.internal;

public class Subscription extends Agreement {

    double monthlyPayment;

    public Subscription(double monthlyPayment) {
        super();
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public void sendSms() {
        smsCount++;
        System.out.println("SMS wysłany\n");
    }

    @Override
    public void sendMms() {
        mmsCount++;
        System.out.println("MMS wysłany\n");
    }

    @Override
    public int makePhoneCall(int seconds) {
        secCount += seconds;
        return seconds;
    }

    @Override
    public String getAccountInformation() {
        return "Na koncie zostało: ABONAMENT BEZ LIMITU, mieięczna opłąta " + monthlyPayment + "zł.\n\n";
    }
}
