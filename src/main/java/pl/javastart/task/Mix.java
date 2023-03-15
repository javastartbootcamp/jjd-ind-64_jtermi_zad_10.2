package pl.javastart.task;

public class Mix extends Agreement {

    private int smsLimit;
    private int mmsLimit;
    private int secLimit;
    private double smsPrice;
    private double mmsPrice;
    private double perMinPrice;

    public Mix(double accountState, int smsLimit, int mmsLimit, int secLimit, double smsPrice, double mmsPrice, double perMinPrice) {
        super(accountState);
        this.smsLimit = smsLimit;
        this.mmsLimit = mmsLimit;
        this.secLimit = secLimit;
        this.smsPrice = smsPrice;
        this.mmsPrice = mmsPrice;
        this.perMinPrice = perMinPrice;
    }

    @Override
    public void sendSms() {

        int smsCount = getSmsCount();
        if (smsLimit > 0) {
            System.out.println("SMS wysłany\n");
            smsLimit--;
            setSmsCount(smsCount + 1);
            return;
        }
        double accountState = getAccountState();
        if (accountState > smsPrice) {
            System.out.println("SMS wysłany\n");
            setSmsCount(smsCount + 1);
            setAccountState(accountState - smsPrice);
            return;
        }
        System.out.println("Brak środków na koncie\n");
    }

    @Override
    public void sendMms() {
        int mmsCount = getMmsCount();
        if (mmsLimit > 0) {
            System.out.println("MMS wysłany\n");
            mmsLimit--;
            setMmsCount(mmsCount + 1);
            return;
        }

        double accountState = getAccountState();
        if (accountState > mmsPrice) {
            System.out.println("MMS wysłany\n");
            setSmsCount(mmsCount + 1);
            setAccountState(accountState - mmsPrice);
            return;
        }
        System.out.println("Brak środków na koncie\n");
    }

    @Override
    public void makePhoneCall(int seconds) {

        double accountstate = getAccountState();

        if (secLimit <= 0 && accountstate < (perMinPrice / 60)) {
            System.out.println("Brak środków na koncie\n");
            return;
        }

        int secondsFromLimit = 0;
        if (secLimit > 0) {
            secondsFromLimit = useSecondsFromLimit(seconds);
        }

        int secondsFromAccount = 0;
        if (accountstate > 0 && secondsFromLimit < seconds) {
            secondsFromAccount = useSecondsFromAccount(seconds - secondsFromLimit);
        }

        int callDuration = secondsFromAccount + secondsFromLimit;
        setSecCount(getSecCount() + callDuration);

        System.out.printf("Rozmowa trwała %d sekund\n\n", callDuration);

    }

    private int useSecondsFromLimit(int seconds) {
        if (secLimit < seconds) {
            seconds = secLimit;
        }
        secLimit -= seconds;
        return seconds;

    }

    private int useSecondsFromAccount(int seconds) {
        double accountState = getAccountState();
        double pricePerSec = perMinPrice / 60;
        double callPrice = seconds * pricePerSec;

        if (accountState < callPrice) {
            seconds = (int) (accountState / pricePerSec);
            callPrice = seconds * pricePerSec;
        }
        setAccountState(accountState - callPrice);
        return seconds;
    }

    @Override
    public void printAccountInformation() {
        System.out.println("=== STAN KONTA ===");
        System.out.printf("Wysłanych SMSów: %d\n", getSmsCount());
        System.out.printf("Wysłanych MMSów: %d\n", getMmsCount());
        System.out.printf("Liczba sekund rozmowy: %d\n", getSecCount());
        System.out.println("Pozostało do wykorzystania:");
        System.out.printf("SMSów: %d, MMSów: %d, Darmowych sekund: %d\n", smsLimit, mmsLimit, secLimit);
        System.out.printf("Na koncie zostało: %.2f zł.\n\n", getAccountState());
    }

}
