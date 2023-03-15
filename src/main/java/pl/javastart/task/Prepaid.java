package pl.javastart.task;

public class Prepaid extends Agreement {

    private double smsPrice;
    private double mmsPrice;
    private double pricePerMin;

    public Prepaid(double accountState, double smsPrice, double mmsPrice, double pricePerMin) {
        super(accountState);
        this.smsPrice = smsPrice;
        this.mmsPrice = mmsPrice;
        this.pricePerMin = pricePerMin;
    }

    @Override
    public void sendSms() {
        if (this.getAccountState() >= smsPrice) {
            this.setSmsCount(this.getSmsCount() + 1);
            setAccountState(getAccountState() - smsPrice);
            System.out.println("SMS wysłany\n");
            return;
        }
        System.out.println("Nie udało się wysłać SMSa\n");
    }

    @Override
    public void sendMms() {
        if (this.getAccountState() > 0) {
            this.setMmsCount(this.getMmsCount() + 1);
            setAccountState(getAccountState() - mmsPrice);
            System.out.println("MMS wysłany\n");
            return;
        }
        System.out.println("Nie udało się wysłać MMSa\n");
    }

    @Override
    public void makePhoneCall(int callDuration) {

        double accountstate = this.getAccountState();
        double pricePerSec = pricePerMin / 60;
        if (accountstate < pricePerSec) {
            System.out.println("Niewystarczająca ilość środków na koncie\n");
            return;
        }

        double callPrice = pricePerSec * callDuration;
        if (accountstate < callPrice) {
            callDuration = (int) (accountstate / pricePerSec);
            callPrice = callDuration * pricePerSec;
        }

        setAccountState(accountstate - callPrice);
        setSecCount(getSecCount() + callDuration);
        System.out.printf("Rozmowa trwała %d sekund\n\n", callDuration);
    }

    @Override
    public void printAccountInformation() {
        System.out.println("=== STAN KONTA ===");
        System.out.printf("Wysłanych SMSów: %d\n", getSmsCount());
        System.out.printf("Wysłanych MMSów: %d\n", getMmsCount());
        System.out.printf("Liczba sekund rozmowy: %d\n", getSecCount());
        System.out.printf("Na koncie zostało: %.2f zł\n\n", getAccountState());
    }
}
