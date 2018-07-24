package ru.java.courses.patterns.strategy.strategies;

public class CarStrategy implements TransportStrategy {

    @Override
    public void reserve(int courierId) {
        // 1. Резервируем машину
        // 2. Рассчитываем количество бензина
        // 3. Отправляем запрос в гараж
        // 4. Закрепляем машину за курьером
        // 5. Рассчитываем расходы на бензин
    }
}
