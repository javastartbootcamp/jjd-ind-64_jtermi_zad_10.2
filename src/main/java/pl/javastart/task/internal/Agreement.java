package pl.javastart.task.internal;

public abstract class Agreement {

    int smsCount = 0;
    int mmsCount = 0;
    int secCount = 0;

    public Agreement() {
    }

    public void sendSms() {
    }

    public void sendMms() {
    }

    public void makePhoneCall(int seconds) {
    }

    public void printAccountInformation() {
        System.out.println("=== STAN KONTA ===");
        System.out.printf("Wysłanych SMSów: %d\n", smsCount);
        System.out.printf("Wysłanych MMSów: %d\n", mmsCount);
        System.out.printf("Liczba sekund rozmowy: %d\n", secCount);
    }
}
