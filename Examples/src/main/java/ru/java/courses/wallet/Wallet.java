package ru.java.courses.wallet;

import ru.java.courses.wallet.strategies.SpendingStrategy;

public class Wallet {

    private static Wallet instance = new Wallet();

    public static Wallet getInstance() {
        return instance;
    }

    private Wallet() {
    }

    private double money;



    private SpendingStrategy strategy;

    private double availableInMonth;


    public void addMoney(double money) {
        this.money += money;
    }

    public void spendMoney(double money, Category category) {
        if (money > this.money) {
            // проверить что денег в кошелке достаточно
            throw new IllegalStateException("Not enough money!");
        }


        if (money > this.availableInMonth) {
            // проверить что в текущем месяце деньги есть
            throw new IllegalStateException("Not enough money in this month!");
        }


        if (!strategy.canSpendMoney(money, category)) {
            // проверить что стратегия позволяет потратить
            throw new IllegalStateException("Stategy is too strict!");
        }

        // тратим
        this.money -= money;
        this.availableInMonth -= money;
    }

    public double getMoney() {
        return money;
    }

    public SpendingStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(SpendingStrategy strategy) {
        this.strategy = strategy;
        this.availableInMonth = strategy.getAvailableMoney();
    }
}
