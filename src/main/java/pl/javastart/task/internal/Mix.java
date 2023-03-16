package pl.javastart.task.internal;

public class Mix extends Prepaid {

    int smsLimit;
    int mmsLimit;
    int secLimit;

    public Mix(double accountState, int smsLimit, int mmsLimit, int secLimit, double smsPrice, double mmsPrice, double perMinPrice) {
        super(accountState, smsPrice, mmsPrice, perMinPrice);
        this.smsLimit = smsLimit;
        this.mmsLimit = mmsLimit;
        this.secLimit = secLimit;
    }

    @Override
    public void sendSms() {
        if (smsLimit > 0) {
            System.out.println("SMS wysłany\n");
            smsLimit--;
            smsCount++;
        } else {
            super.sendSms();
        }
    }

    @Override
    public void sendMms() {
        if (mmsLimit > 0) {
            System.out.println("MMS wysłany\n");
            mmsLimit--;
            mmsCount++;
        } else {
            super.sendMms();
        }
    }

    @Override
    public void makePhoneCall(int seconds) {

        if (secLimit <= 0 && accountState < (pricePerMin / 60)) {
            System.out.println("Brak środków na koncie\n");
            return;
        }
        int secondsFromLimit = 0;
        if (secLimit > 0) {
            secondsFromLimit = useSecondsFromLimit(seconds);
        }
        int secondsFromAccount = 0;
        if (accountState > 0 && secondsFromLimit < seconds) {
            secondsFromAccount = super.useSecondsFromAccount(seconds - secondsFromLimit);
        }
        int callDuration = secondsFromAccount + secondsFromLimit;
        secCount += callDuration;
        System.out.printf("Rozmowa trwała %d sekund\n\n", callDuration);
    }

    private int useSecondsFromLimit(int seconds) {
        if (secLimit < seconds) {
            seconds = secLimit;
        }
        secLimit -= seconds;
        return seconds;
    }

    @Override
    public void printAccountInformation() {
        super.printAccountInformation();
        System.out.println("Pozostało do wykorzystania:");
        System.out.printf("SMSów: %d, MMSów: %d, Darmowych sekund: %d\n\n", smsLimit, mmsLimit, secLimit);
    }
}
