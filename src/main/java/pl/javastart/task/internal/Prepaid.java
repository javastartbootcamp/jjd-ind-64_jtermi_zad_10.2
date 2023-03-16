package pl.javastart.task.internal;

public class Prepaid extends Agreement {

    double smsPrice;
    double mmsPrice;
    double pricePerMin;
    double accountState;

    public Prepaid(double accountState, double smsPrice, double mmsPrice, double pricePerMin) {
        super();
        this.accountState = accountState;
        this.smsPrice = smsPrice;
        this.mmsPrice = mmsPrice;
        this.pricePerMin = pricePerMin;
    }

    @Override
    public void sendSms() {
        if (accountState >= smsPrice) {
            smsCount++;
            accountState -= smsPrice;
            System.out.println("SMS wysłany\n");
            return;
        }
        System.out.println("Nie udało się wysłać SMSa\n");
    }

    @Override
    public void sendMms() {
        if (accountState > 0) {
            mmsCount++;
            accountState -= mmsPrice;
            System.out.println("MMS wysłany\n");
            return;
        }
        System.out.println("Nie udało się wysłać MMSa\n");
    }

    @Override
    public void makePhoneCall(int seconds) {
        if (accountState <= 0) {
            System.out.println("Niewystarczająca ilość środków na koncie\n");
        } else {
            int callDuration = useSecondsFromAccount(seconds);
            secCount += callDuration;
            System.out.printf("Rozmowa trwała %d sekund\n\n", callDuration);
        }
    }

    int useSecondsFromAccount(int seconds) {
        double pricePerSec = pricePerMin / 60;
        double callPrice = seconds * pricePerSec;

        if (accountState < callPrice) {
            seconds = (int) (accountState / pricePerSec);
            callPrice = seconds * pricePerSec;
        }
        accountState -= callPrice;
        return seconds;
    }

    @Override
    public void printAccountInformation() {
        super.printAccountInformation();
        System.out.printf("Na koncie zostało: %.2f zł\n", accountState);
    }
}
