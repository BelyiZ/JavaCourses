package ru.java.courses.sport.team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ru.java.courses.sport.Athlete;
import ru.java.courses.sport.Coach;
import ru.java.courses.sport.ScoringPlayer;

public abstract class Team<T extends Athlete & ScoringPlayer> {

    private Coach coach;

    private List<T> players = new ArrayList<>();

    private String name;

    public Team(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("");
        }
        this.name = name;
    }

    public <S> String getString(S string) {
        return string.toString();
    }

    /**
     * @return максимально допустимое количество игроков в команде
     */
    public abstract int getMaxPlayersCount();

    /**
     * Добавляем игрока в команду
     *
     * @param player добавляемый игрок
     *
     * @throws IllegalStateException если достигнут лимит по количеству игроков
     */
    public void addPlayers(T... newPlayers) {
        if (players.size() + newPlayers.length > getMaxPlayersCount()) {
            throw new IllegalStateException("Превышен максимальный лимит игроков. " +
                    "Сейчас он составляет " + getMaxPlayersCount() + "человек");
        }

        players.addAll(Arrays.asList(newPlayers));
    }

    /**
     * Добавляем игрока в команду
     *
     * @param player добавляемый игрок
     *
     * @throws IllegalStateException если достигнут лимит по количеству игроков
     */
    public void addPlayer(T player) {
        if (players.size() + 1 > getMaxPlayersCount()) {
            throw new IllegalStateException("Превышен максимальный лимит игроков. " +
                    "Сейчас он составляет " + getMaxPlayersCount() + "человек");
        }

        players.add(player);
    }

    /**
     * Удаляет игрока из команды
     *
     * @param player удаляемый игрок
     *
     * @throws IndexOutOfBoundsException если переданный порядковый номер меньше нуля или больше количества игроков в команде
     */
    public void removePlayer(T player) {
        players.remove(player);
    }


    /**
     * @return количество игроков в команде
     */
    public int getPlayersCount() {
        return players.size();
    }

    /**
     * @return количество очков заработанное командой
     */
    public int getScore() {
        int score = 0;
        for (T player: players) {
            score += player.getScore();
        }
        return score;
    }

    @Override
    public String toString() {
        StringBuilder report = new StringBuilder()
                .append("Команда \"").append(name).append("\"\n")

                .append("---------------------\n")
                .append("Тренер: ").append(coach.getName()).append("\n")
                .append("Игроки:\n");

        for (T player: players) {
            report.append(player.getName());
            if (player.isActive()) {
                report.append(" всего забил - ")
                        .append(player.getScore());
            } else {
                report.append(" - запасной");
            }
            report.append("\n");
        }

        return report.toString();
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("");
        }
        this.name = name;
    }

    public List<T> getPlayers() {
        return new ArrayList<>(players);
    }

    public void setPlayers(List<T> players) {
        this.players = players;
    }
}
