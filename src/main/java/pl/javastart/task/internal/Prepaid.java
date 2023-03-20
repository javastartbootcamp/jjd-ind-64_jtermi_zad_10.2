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
        } else {
            System.out.println("Nie udało się wysłać SMSa\n");
        }
    }

    @Override
    public void sendMms() {
        if (accountState > 0) {
            mmsCount++;
            accountState -= mmsPrice;
            System.out.println("MMS wysłany\n");
        } else {
            System.out.println("Nie udało się wysłać MMSa\n");
        }
    }

    @Override
    public int makePhoneCall(int seconds) {
        int callDuration = 0;
        if (accountState <= 0) {
            System.out.println("Niewystarczająca ilość środków na koncie\n");
        } else {
            callDuration = useSecondsFromAccount(seconds);
            secCount += callDuration;
        }
        return callDuration;
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
    public String getAccountInformation() {
        return "Na koncie zostało: " + accountState + "zł\n";
    }
}