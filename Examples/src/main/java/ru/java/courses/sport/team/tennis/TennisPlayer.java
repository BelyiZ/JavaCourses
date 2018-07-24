package ru.java.courses.sport.team.tennis;

import ru.java.courses.sport.Athlete;
import ru.java.courses.sport.ScoringPlayer;

/**
 * Теннисист
 */
public final class TennisPlayer extends Athlete implements ScoringPlayer {

    /**
     * Количество полученных очков
     */
    private int points;

    public TennisPlayer(String name) {
        super(name);
    }

    @Override
    public void score() {
        points += 15; // Ну или какая там логика...
    }

    @Override
    public int getScore() {
        return points;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void setActive(boolean active) {
        throw new UnsupportedOperationException("В нашем теннисе нет запасных игроков!");
    }
}
