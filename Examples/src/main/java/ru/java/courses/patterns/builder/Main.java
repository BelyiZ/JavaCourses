package ru.java.courses.patterns.builder;

public class Main {

    public static void main(String[] args) {
        BookBuilder bb = new BookBuilder()
                .author("Ваня Рубанок")
                .name("Как я покупал кефир")
                .isbn("213ОDNRKR334-FDDE")
                .pagesCount(100500);

        // calculate

                bb.coverColor("Желтый")
                .annotation("Нету")
                .price(123.45)
                .quantity(100)
                .discount(12.5)
                .year(2018)
                .build();
    }

}
