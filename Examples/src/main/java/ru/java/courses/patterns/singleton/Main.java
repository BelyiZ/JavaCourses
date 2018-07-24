package ru.java.courses.patterns.singleton;

public class Main {


    public static void main(String[] args) {

        Wallet wallet = Wallet.getInstance();

        wallet.addBablishko(123);

        wallet.theTranzhirit(12);

    }

    private static void salary() {
        Wallet.getInstance().addBablishko(1234);
    }
}
