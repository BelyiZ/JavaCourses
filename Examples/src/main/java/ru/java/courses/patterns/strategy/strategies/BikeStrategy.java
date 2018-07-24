package ru.java.courses.patterns.strategy.strategies;

public class BikeStrategy implements TransportStrategy {

    @Override
    public void reserve(int courierId) {
        // 1. Отправляем запрос на велосипед
        // 2. Закрепляем велосипед за курьером
    }
}
