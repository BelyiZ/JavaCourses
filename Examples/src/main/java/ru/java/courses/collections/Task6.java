package ru.java.courses.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Task6 {

    // Номер полки -> названия книг
    Map<Integer, List<String>> books = new HashMap<>();

    // Задача 1. Создать индекс: название книги -> номера полок
    Map<String, Set<Integer>> books2 = new HashMap<>();

    private void transform() {
        for (Entry<Integer, List<String>> entry : books.entrySet()) {
            Integer shelfNumber = entry.getKey();
            List<String> booksNames = entry.getValue();

            for (String bookName : booksNames) {
                Set<Integer> shelfsNumbers = books2.getOrDefault(bookName, new HashSet<>());
                shelfsNumbers.add(shelfNumber);

                books2.put(bookName, shelfsNumbers);
            }
        }
    }



    // Задача 2. Сбалансировать количество книг на полках, разложить по алфавиту
    public void balancing() {
        int allBooksCount = 0;
        for (List<String> booksNames : books.values()) {
            allBooksCount += booksNames.size();
        }

        int average = (int) Math.floor((double) allBooksCount / books.size());

        // получить все книги
        Set<String> allBooks = books2.keySet();
        // отсортировать по алфавиту
        List<String> sortedBooks = new ArrayList<>(allBooks);
        Collections.sort(sortedBooks);
        // раскидать по полкам
        Set<Integer> shelfs = books.keySet();
        TreeSet<Integer> sortedShelfs = new TreeSet<>(shelfs);

        books.clear();
        int startPosition = 0;
        for (Integer shelf : sortedShelfs) {
            int endPosition = Math.min(startPosition + average, sortedBooks.size());
            List<String> booksNames = sortedBooks.subList(startPosition, endPosition);
            books.put(shelf, booksNames);
            if (endPosition == sortedBooks.size()) {
                break;
            }
            startPosition = endPosition;
        }
        transform();
    }


    // Задача 3. Добавить признак "Книга на полке / Книга у читателя"


}
