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
    public boolean sendSms() {
        if (smsLimit > 0) {
            smsLimit--;
            smsCount++;
        } else {
            return super.sendSms();
        }
        return true;
    }

    @Override
    public boolean sendMms() {
        if (mmsLimit > 0) {
            mmsLimit--;
            mmsCount++;
        } else {
            return super.sendMms();
        }
        return true;
    }

    @Override
    public int makePhoneCall(int seconds) {
        int remainingSeconds = seconds - useSecondsFromLimit(seconds);
        if (remainingSeconds > 0) {
            remainingSeconds -= super.useSecondsFromAccount(remainingSeconds);
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
