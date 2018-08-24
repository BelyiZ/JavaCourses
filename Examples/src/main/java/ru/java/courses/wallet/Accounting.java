package ru.java.courses.wallet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Accounting {

    private static Accounting instance = new Accounting();

    public static Accounting getInstance() {
        return instance;
    }

    private Accounting() {
    }

    private Wallet wallet = Wallet.getInstance();

    private double salary;

    private List<Operation> operations = new ArrayList<>();


    public void addOperation(Operation operation) {
        wallet.spendMoney(operation.getSum(), operation.getCategory());

        operations.add(operation);
    }

    public Map<Category, List<Operation>> getOperationsByCatgory() {
        return Collections.emptyMap();
    }

    public Map<Category, Double> getSumByCategory() {
        return Collections.emptyMap();
    }

    public List<Operation> findOperationsByDate(Date from, Date to) {
        return Collections.emptyList();
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
