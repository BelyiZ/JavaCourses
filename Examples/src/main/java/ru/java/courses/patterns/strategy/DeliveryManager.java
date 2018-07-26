package ru.java.courses.patterns.strategy;

import ru.java.courses.patterns.strategy.strategies.BikeStrategy;
import ru.java.courses.patterns.strategy.strategies.CarStrategy;
import ru.java.courses.patterns.strategy.strategies.ScooterStategy;
import ru.java.courses.patterns.strategy.strategies.TransportStrategy;
import ru.java.courses.patterns.strategy.transport.Transport;

public class DeliveryManager {

    public enum Status {
        CREATED, STARTED, FINISHED
    }

    private Courier courier;

    private Transport transport;

    private Status status;

    public DeliveryManager() {
        status = Status.CREATED;
    }

    public void startDelivery() {
        Courier courier = chooseCourier();

        TransportStrategy strategy = chooseStrategy();
//        strategy.reserve(courier.getId());

        status = Status.STARTED;
    }

    private Courier chooseCourier() {
        // Ищем свободного курьера
        return new Courier();
    }

    private TransportStrategy chooseStrategy() {
        TransportStrategy strategy = null;

//        if (courier.isHasLicense()) { // Проверяем наличие водительских прав у курьера
//            strategy = new BikeStrategy();
//        } else if (distance.isLong()) { // Проверяем расстояние
//            strategy = new CarStrategy();
//        } else if (trafficJam.getLevel() < 5) { // Проверяем загруженность на дорогах
//            strategy = new ScooterStategy();
//        } else if () {
//            strategy = new BikeStrategy();
//        } else if() {
//            strategy = new SamokatStrategy();
//        }
//
//        strategy = new WalkStrategy();

        return strategy;
    }

}
