package pl.javastart.task.internal;

public class Subscription extends Agreement {

    double monthlyPayment;

    public Subscription(double monthlyPayment) {
        super();
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public boolean sendSms() {
        smsCount++;
        return true;
    }

    @Override
    public boolean sendMms() {
        mmsCount++;
        return true;
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
