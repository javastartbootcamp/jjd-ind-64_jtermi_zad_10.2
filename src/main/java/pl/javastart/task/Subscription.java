package pl.javastart.task;

public class Subscription extends Agreement {

    public Subscription(double monthlyPayment) {
        super();
        this.monthlyPayment = monthlyPayment;
    }

    private double monthlyPayment;

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public void sendSms() {
        setSmsCount(getSmsCount() + 1);
        System.out.println("SMS wysłany\n");
    }

    @Override
    public void sendMms() {
        setMmsCount(getMmsCount() + 1);
        System.out.println("MMS wysłany\n");
    }

    @Override
    public void makePhoneCall(int seconds) {
        setSecCount(getSecCount() + seconds);
        System.out.printf("Rozmowa trwała %d sekund\n\n", seconds);
    }

    @Override
    public void printAccountInformation() {
        System.out.println("=== STAN KONTA ===");
        System.out.printf("Wysłanych SMSów: %d\n", getSmsCount());
        System.out.printf("Wysłanych MMSów: %d\n", getMmsCount());
        System.out.printf("Liczba sekund rozmowy: %d\n", getSecCount());
        System.out.printf("Na koncie zostało: ABONAMENT BEZ LIMITU, mieięczna opłąta %.2f zł.\n\n", monthlyPayment);
    }

}
