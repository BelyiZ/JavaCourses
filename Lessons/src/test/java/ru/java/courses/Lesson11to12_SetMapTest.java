package ru.java.courses;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.java.courses.Lesson11to12_SetMap.User;

public class Lesson11to12_SetMapTest {

    /**
     * В этом методе необходимо реализовать:
     * 1. На вход получаем коллекцию пользователей
     * 2. Удаляем все дубли (одинаковое имя и возраст)
     * 3. Сортируем по имени и возрасту
     */
    @Test
    public void task1() {
        List<User> users = Arrays.asList(new User("Ivan", 15), new User("Masha", 17), new User("Kolya", 23), new User("Denis", 7), new User("Vova", 45), new User("Marina", 15), new User("Kolya", 15), new User("Vova", 25), new User("Vlad", 26), new User("Ivan", 17));

        User result = Lesson11to12_SetMap.task1(users);
        Assertions.assertEquals("Vova", result.getName(), "В конце должен быть Vova, 45 лет");
        Assertions.assertEquals(45, result.getAge(), "В конце должен быть Vova, 25 лет");
    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем коллекцию пользователей
     * 2. Преобразовываем его в справочник [номер телефона -> пользователь]
     * 3. Один номер телефона на одного пользователя
     * 4. Вернуть количество записей в справочнике
     */
    @Test
    public void task2() {
        List<User> users = Arrays.asList(new User("1234"), new User("36736"), new User("1244"), new User("234324"), new User("234"), new User("234"), new User("234346"), new User("1234"), new User("23523"), new User("2342342"));

        int result = Lesson11to12_SetMap.task2(users);
        Assertions.assertEquals(8 ,result, "Должно быть 8 записей");
    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем список названий книг
     * 2. Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг
     * 3. Все книги должны быть отсортированы по алфавиту с первой до последней полки
     * 4. Количество полок константное - 5 штук
     * 5. Вернуть книги распределенные по полкам
     */
    @Test
    public void task3() {
        // свой код нужно писать тут
        // следующую строку можно удалять
        List<String> books = Arrays.asList("Тихий дон", "Вишневый сад", "Война и мир", "Мертвые души", "Преступление и наказание", "Аэлита",
                "Идиот", "Каменный цветок", "Мстители: Финал", "Игра престолов", "Тень воина", "Путь героя", "Ангелы и демоны",
                "Код да Винчи", "Гуси-лебеди", "Колобок", "Маша и медведь", "Снегурочка");

        Map<Integer, List<String>> result = Lesson11to12_SetMap.task3(books);

        Assertions.assertEquals("Гуси-лебеди", result.get(2).get(1), "Гуси-лебеди д.б. первой книгой на второй полке");
        Assertions.assertEquals("Код да Винчи", result.get(3).get(2), "Гуси-лебеди д.б. второй книгой на третьей полке");
        Assertions.assertEquals("Аэлита", result.get(1).get(1), "Гуси-лебеди д.б. первой книгой на первой полке");
    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем книги, распределенные по полкам
     * 5. Вернуть справочник [название книги -> номер полки]
     */
    @Test
    public void task4() {
        Map<Integer, String> map = new HashMap<>();
        map.put(4, "Ангелы и демоны");
        map.put(2, "Вишневый сад");
        map.put(3, "Тень воина");
        map.put(5, "Преступление и наказание");
        map.put(1, "Маша и медведь");

        Map result = Lesson11to12_SetMap.task4(map);

        Assertions.assertEquals(1, result.get("Маша и медведь"));
        Assertions.assertEquals(2, result.get("Вишневый сад"));
        Assertions.assertEquals(3, result.get("Тень воина"));
        Assertions.assertEquals(4, result.get("Ангелы и демоны"));
        Assertions.assertEquals(5, result.get("Преступление и наказание"));
    }
}
