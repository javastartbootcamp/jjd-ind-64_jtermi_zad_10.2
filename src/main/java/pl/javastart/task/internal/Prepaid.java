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
    public boolean sendSms() {
        if (accountState >= smsPrice) {
            smsCount++;
            accountState -= smsPrice;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean sendMms() {
        if (accountState > 0) {
            mmsCount++;
            accountState -= mmsPrice;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int makePhoneCall(int seconds) {
        int callDuration = useSecondsFromAccount(seconds);
        secCount += callDuration;
        return callDuration;
    }

    int useSecondsFromAccount(int seconds) {
        double pricePerSec = pricePerMin / 60;
        double callPrice = seconds * pricePerSec;
        int callDuration = seconds;
        if (accountState < callPrice) {
            callDuration = (int) (accountState / pricePerSec);
            callPrice = callDuration * pricePerSec;
        }
        accountState -= callPrice;
        return callDuration;
    }

    @Override
    public String getAccountInformation() {
        return "Na koncie zostało: " + accountState + "zł\n";
    }
}