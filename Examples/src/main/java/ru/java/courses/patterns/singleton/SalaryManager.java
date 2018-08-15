package ru.java.courses.patterns.singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SalaryManager {

    private static SalaryManager instance = new SalaryManager();

    public static SalaryManager getInstance() {
        return instance;
    }

    private SalaryManager() {
    }


    private Map<Long, Double> salaries = new HashMap<>();

//    private List<Employee> stuff = new ArrayList<>();

    public void setSalary(long employeeId) {
        // Устанавливаем новую зарплату
    }


}
