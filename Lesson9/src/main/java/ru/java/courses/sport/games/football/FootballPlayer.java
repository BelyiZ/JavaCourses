package ru.java.courses.sport.games.football;

import ru.java.courses.sport.SportTitle;
import ru.java.courses.sport.games.Player;
import ru.java.courses.sport.Scorable;

public class FootballPlayer extends Player implements Scorable {


    private FootballPlayerType playerType;

    public FootballPlayer(String name, int age, FootballPlayerType playerType) {
        super(name, age);
        this.setPlayerType(playerType);
    }

    public FootballPlayer(String name, int age) {
        super(name, age);
    }

    public FootballPlayer(String name, int age, SportTitle title, double salary) {
        super(name, age, title, salary);
    }

    public FootballPlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(FootballPlayerType playerType) {
        if (playerType == null) {
            throw new UnsupportedOperationException("playerType cann't be null");
        }
        this.playerType = playerType;
    }

    @Override
    public void makeScore() {
        addPoints(1);
    }

    @Override
    public int getScore() {
        return 0;
    }

}
