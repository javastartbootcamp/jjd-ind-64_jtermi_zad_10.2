package pl.javastart.task;

public class Main {

    public static void main(String[] args) {

        Phone phone = new Phone(new Prepaid(2, 0.1, .2, .5));
        Phone phone1 = new Phone(new Subscription(25));
        Phone phone2 = new Phone(new Mix(23, 1, 2, 250, .1, .2, .5));

        phone2.printAccountState();
        phone2.sendMms();
        phone1.sendMms();
        phone.sendSms();
        phone2.call(600);
        phone2.call(15);
        phone2.sendSms();
        phone2.sendMms();
        phone2.printAccountState();
    }
}
