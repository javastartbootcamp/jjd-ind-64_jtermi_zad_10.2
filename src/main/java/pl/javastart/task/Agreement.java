package pl.javastart.task;

abstract class Agreement {

    private int smsCount = 0;
    private int mmsCount = 0;
    private int secCount = 0;
    private double accountState = 0;

    public Agreement() {
    }

    public Agreement(double accountState) {
        this.accountState = accountState;
    }

    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

    public void setMmsCount(int mmsCount) {
        this.mmsCount = mmsCount;
    }

    public void setSecCount(int secCount) {
        this.secCount = secCount;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public int getMmsCount() {
        return mmsCount;
    }

    public int getSecCount() {
        return secCount;
    }

    public double getAccountState() {
        return accountState;
    }

    public void setAccountState(double accountState) {
        this.accountState = accountState;
    }

    public void sendSms() {
    }

    public void sendMms() {
    }

    public void makePhoneCall(int seconds) {
    }

    public void printAccountInformation() {
    }
}
