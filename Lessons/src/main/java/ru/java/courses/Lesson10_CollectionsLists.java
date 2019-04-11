package ru.java.courses;
import java.util.*;
import java.util.stream.Collectors;

public class Lesson10_CollectionsLists {
    /**
     * В этом методе необходимо реализовать:
     * 1. На вход получаем список чисел
     * 2. Удаляем все дубли
     * 3. Преобразуем числа в строки
     * 4. Возращаем полученный список строк отсортированный по возрастанию
     * <p>
     * Подсказки:
     * Collections.sort() - сортировка
     * Удалять элементы из итерируемого списка нельзя - выпадет исключение
     */
    public static List<String> task1(List<Integer> source) {

        Collections.sort(source);
        //List<String> strings = source.stream().distinct().map(Object::toString)
           //     .collect(Collectors.toList());

        return source.stream().distinct().map(Object::toString)
                .collect(Collectors.toList());
    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. Получаем на входе массив чисел
     * 2. Преобразовываем его к списку
     * 4. Все четные числа увеличиваем на единицу
     * 5. Возвращаем кусок списка с 3-го по 7-й элемент
     * <p>
     * Подсказка: на входе может быть любое количество чисел
     */
    public static List<Integer> task2(Integer... array) {
        List<Integer> test = Arrays.asList(array);
        for (Integer i : test) {
            if (i % 2 == 0) {
                test.set(test.indexOf(i), ++i);
            }
        }
        int i = test.size();
        if (i > 7) { return test.subList(3, 8);
        } else return test.subList(3,i);

    }
}