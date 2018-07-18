package ru.java.courses.patterns.builder;

public class Main {

    public static void main(String[] args) {
        Book book = new Book(
                "Ваня Рубанок", "Как я покупал кефир",
                "213ОDNRKR334-FDDE", 100500, "Желтый", "Нету",
                123.45, 100, 12.5, 2018
        );

//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//


        Book book1 = new BookBuilder()
                .author("Ваня Рубанок")
                .name("Как я покупал кефир")
                .isbn("213ОDNRKR334-FDDE")
                .pagesCount(100500)
                .coverColor("Желтый")
                .annotation("Нету")
                .price(123.45)
                .quantity(100)
                .discount(12.5)
                .year(2018)
                .build();
    }

}
