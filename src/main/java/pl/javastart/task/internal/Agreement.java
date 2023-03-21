package pl.javastart.task.internal;

public abstract class Agreement {

    int smsCount = 0;
    int mmsCount = 0;
    int secCount = 0;

    public abstract boolean sendSms();

    public abstract boolean sendMms();

    public abstract int makePhoneCall(int seconds);

    public abstract String getAccountInformation();
}
