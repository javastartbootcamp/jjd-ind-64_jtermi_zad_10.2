package pl.javastart.task.internal;

public class Subscription extends Agreement {

    public Subscription(double monthlyPayment) {
        super();
        this.monthlyPayment = monthlyPayment;
    }

    double monthlyPayment;

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
    public void makePhoneCall(int seconds) {
        secCount += seconds;
        System.out.printf("Rozmowa trwała %d sekund\n\n", seconds);
    }

    @Override
    public void printAccountInformation() {
        super.printAccountInformation();
        System.out.printf("Na koncie zostało: ABONAMENT BEZ LIMITU, mieięczna opłąta %.2f zł.\n\n", monthlyPayment);
    }

}
