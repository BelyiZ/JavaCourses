package ru.java.courses.wallet;

public class BurjuiSpendingStrategy implements SpendingStrategy {

    private Wallet wallet = Wallet.getInstance();

    @Override
    public double getAvailableMoney() {
        return wallet.getMoney();
    }

    @Override
    public boolean canSpendMoney(double money, Category category) {
        return true;
    }
}
