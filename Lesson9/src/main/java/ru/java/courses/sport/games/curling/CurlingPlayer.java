package ru.java.courses.sport.games.curling;

import ru.java.courses.sport.SportTitle;
import ru.java.courses.sport.games.Player;
import ru.java.courses.sport.Scorable;

public class CurlingPlayer extends Player implements Scorable {

    public CurlingPlayer(String name, int age) {
        super(name, age);
    }

    public CurlingPlayer(String name, int age, SportTitle title, double salary) {
        super(name, age, title, salary);
    }

    @Override
    public void makeScore() {
        addPoints(10);
    }

}
