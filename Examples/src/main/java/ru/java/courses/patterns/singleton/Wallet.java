package ru.java.courses.patterns.singleton;

public class Wallet {

    private static Wallet instance;

    public static Wallet getInstance() {
        if (instance == null) {
            instance = new Wallet();
        }
        return instance;
    }

    private Wallet() {
    }


    private Double bablishko;

    void addBablishko(double skoka) {
        bablishko += skoka;
    }

    void theTranzhirit(double skoka) {
        bablishko -= skoka;
    }
}
