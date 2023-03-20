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
    public int makePhoneCall(int seconds) {

        if (secLimit <= 0 && accountState < (pricePerMin / 60)) {
            System.out.println("Brak środków na koncie\n");
            return 0;
        }

        int remainingSeconds = seconds - useSecondsFromLimit(seconds);

        if (remainingSeconds > 0) {
            remainingSeconds = super.useSecondsFromAccount(remainingSeconds);
        }

        int callDuration = seconds - remainingSeconds;
        secCount += callDuration;
        return callDuration;
    }

    private int useSecondsFromLimit(int seconds) {
        if (secLimit < seconds) {
            seconds = secLimit;
        }
        secLimit -= seconds;
        return seconds;
    }

    @Override
    public String getAccountInformation() {
        return super.getAccountInformation()
                + "Pozostało do wykorzystania: "
                + "SMSów: " + smsLimit + ", MMSów: " + mmsLimit + ", Darmowych sekund: " + secLimit;
    }
}
