package ru.java.courses.sport;

public interface ScoringPlayer {

    /**
     * Игрок зарабатывает очки
     */
    void score();

    /**
     * @return текущее количество заработанных очков
     */
    int getScore();
}
