package ru.java.courses.wallet;

import java.util.Date;
import java.util.Objects;

public class Operation {

    private Category category;

    private Date date;

    private double sum;

    public Operation(Category category, double sum) {
        this.category = category;
        this.sum = sum;
        this.date = new Date();
    }

    public Operation(Category category, Date date, double sum) {
        this.category = category;
        this.date = date;
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Operation operation = (Operation) o;
        return Double.compare(operation.sum, sum) == 0 &&
                category == operation.category &&
                Objects.equals(date, operation.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, date, sum);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
