package ru.java.courses.patterns.builder;

public class Book {

    private String author;

    private String name;

    private String ISBN;

    private int pagesCount;

    private String coverColor;

    private String annotation;

    private double price;

    private int quantity;

    private double discount;

    private int year;

    private Book() {

    }

    private String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getISBN() {
        return ISBN;
    }

    private void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    private int getPagesCount() {
        return pagesCount;
    }

    private void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    private String getCoverColor() {
        return coverColor;
    }

    private void setCoverColor(String coverColor) {
        this.coverColor = coverColor;
    }

    private String getAnnotation() {
        return annotation;
    }

    private void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    private double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    private int getQuantity() {
        return quantity;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private double getDiscount() {
        return discount;
    }

    private void setDiscount(double discount) {
        this.discount = discount;
    }

    private int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }


    public static class BookBuilder {

        private Book book;

        public BookBuilder() {
            book = new Book();
        }


        public BookBuilder author(String author) {
            book.setAuthor(author);
            return this;
        }

        public BookBuilder name(String name) {
            book.setName(name);
            return this;
        }

        public BookBuilder isbn(String isbn) {
            book.setISBN(isbn);
            return this;
        }

        public BookBuilder pagesCount(int pagesCount) {
            book.setPagesCount(pagesCount);
            return this;
        }

        public BookBuilder coverColor(String coverColor) {
            book.setCoverColor(coverColor);
            return this;
        }

        public BookBuilder annotation(String annotation) {
            book.setAnnotation(annotation);
            return this;
        }

        public BookBuilder price(double price) {
            book.setPrice(price);
            return this;
        }

        public BookBuilder quantity(int quantity) {
            book.setQuantity(quantity);
            return this;
        }

        public BookBuilder discount(double discount) {
            book.setDiscount(discount);
            return this;
        }

        public BookBuilder year(int year) {
            book.setYear(year);
            return this;
        }

        public Book build() {
            return book;
        }
    }
}
