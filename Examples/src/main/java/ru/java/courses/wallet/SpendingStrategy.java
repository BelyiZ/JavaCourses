package ru.java.courses.wallet;

public interface SpendingStrategy {

    double getAvailableMoney();

    boolean canSpendMoney(double money, Category category);

}
