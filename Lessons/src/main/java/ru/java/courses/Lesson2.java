package ru.java.courses;

public class Lesson2 {

    /**
     * Нужно реализовать формулу y = √(13x + 13/x)
     * Подсказка: квадратный корень вычисляется функцией Math.sqrt()
     *
     * @param x на текущем этапе входное значение будет больше нуля
     * @return возвращаем только целую часть от полученного результата,
     * хвост отбрасываем без откругления
     */
   static int formula(int x) {
       //x = 1;
       int y = (int) Math.sqrt(13*x +13/x);

        return y;
   }

    /**
     * Нужно привести строку с полным именем к инициалам.
     * Например, "Иванов Петр Александрович" → "И.П.А."
     * Подсказка:
     * разделение строки на части: .split(" ");
     * получение символа на определенной позиции: .charAt();
     * приведение к верхнему регистру: .toUpperCase();
     *
     * @param fullName на текущем этапе имена будут состоять из имени, фамили и отчества, разделяться пробелами.
     *                 Регистр букв во входном параметре может быть любым.
     * @return возвращаем инициалы в верхнем регистре разделенные точкой, как в примере выше
     */
    static String initials(String fullName) {
        String[] splitName = fullName.split(" ");
       char firstInitial = splitName[0].charAt(0);
        char secondInitial = splitName[1].charAt(0);
        char thirdInitial = splitName[2].charAt(0);
        String result1 = Character.toString(firstInitial).toUpperCase();
        String result2 = Character.toString(secondInitial).toUpperCase();
        String result3 = Character.toString(thirdInitial).toUpperCase();

        return new String(result1 + "." + result2 + "." + result3 + ".");
    }

}
