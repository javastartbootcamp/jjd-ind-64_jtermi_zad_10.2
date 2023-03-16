package pl.javastart.task;

import pl.javastart.task.internal.Mix;
import pl.javastart.task.internal.Prepaid;
import pl.javastart.task.internal.Phone;
import pl.javastart.task.internal.Subscription;

public class Main {

    public static void main(String[] args) {

        Phone phone = new Phone(new Prepaid(2, 0.1, .2, .5));

        Phone phone1 = new Phone(new Subscription(25));
        Phone phone2 = new Phone(new Mix(23, 1, 2, 250, .1, .2, .5));

        Prepaid prepaid = new Prepaid(2, 0.1, .2, .5);

        phone2.printAccountState();
        phone2.sendMms();
        phone2.printAccountState();
        phone2.sendMms();
        phone2.printAccountState();
        phone2.sendSms();
        phone2.printAccountState();
        phone2.call(600);
        phone2.printAccountState();
        phone2.call(15);
        phone2.printAccountState();
        phone2.sendSms();
        phone2.printAccountState();
        phone2.sendMms();
        phone2.printAccountState();
    }
}
