package pl.javastart.task.internal;

public abstract class Agreement {

    int smsCount = 0;
    int mmsCount = 0;
    int secCount = 0;

    public abstract void sendSms();

    public abstract void sendMms();

    public abstract int makePhoneCall(int seconds);

    public abstract String getAccountInformation();
}
