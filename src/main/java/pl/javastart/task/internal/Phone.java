package pl.javastart.task.internal;

public class Phone {

    private Agreement agreement;

    public Phone(Agreement agreement) {
        this.agreement = agreement;
    }

    public void sendSms() {
        if (agreement.sendSms()) {
            System.out.println("---> SMS został wysłany");
        } else {
            System.out.println("---> Nie udało się wysłać SMS: brak śodków na koncie!");
        }
    }

    public void sendMms() {
        if (agreement.sendMms()) {
            System.out.println("---> MMS został wysłany");
        } else {
            System.out.println("---> Nie udało się wysłać MMS: brak śodków na koncie!");
        }
    }

    public void call(int seconds) {
        int callDuration = agreement.makePhoneCall(seconds);
        if (callDuration > 0) {
            System.out.println("---> Rozmowa trwała: " + callDuration);
        } else {
            System.out.println("---> Nie udało się nawiązać połączenia: brak środków na koncie.");
        }
    }

    public void printAccountState() {
        System.out.println("=== STAN KONTA ===\nWysłanych SMSów: " + agreement.smsCount
                + "\nWysłanych MMSów: " + agreement.mmsCount
                + "\nLiczba sekund rozmowy: " +  agreement.secCount);
        System.out.println(agreement.getAccountInformation() + "\n");
    }
}
