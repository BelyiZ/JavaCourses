package ru.java.courses.wallet.strategies;

import ru.java.courses.wallet.Category;

public interface SpendingStrategy {

    double getAvailableMoney();

    boolean canSpendMoney(double money, Category category);

}
