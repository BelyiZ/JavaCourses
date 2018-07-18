package ru.java.courses.patterns.builder;

public class BookBuilder {

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
