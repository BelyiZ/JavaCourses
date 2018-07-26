package ru.java.courses.wallet;

public class StandartSpendingStrategy implements SpendingStrategy {

    private Wallet wallet = Wallet.getInstance();

    @Override
    public double getAvailableMoney() {
        return wallet.getSalary() * 0.5;
    }

    @Override
    public boolean canSpendMoney(double money, Category category) {
        if (money > getAvailableMoney()) {
            return false;
        }

        switch (category) {
            case FOOD:
            case DRUGS:
            case COFFEE_CLUB:
                return true;
            case ENTERTAINMENT:
                return money < getAvailableMoney() * 0.1;
            default:
                return false;
        }
    }
}
