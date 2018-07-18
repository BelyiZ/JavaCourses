package ru.java.courses.sport.games;

import java.util.ArrayList;
import java.util.List;
import ru.java.courses.sport.Athlete;
import ru.java.courses.sport.Coach;
import ru.java.courses.sport.Scorable;

public class Team<T extends Player & Scorable> implements Scorable {

    public static final int MAX_PLAYERS_COUNT = 20;
    private List<T> players = new ArrayList<>();
    public Coach coach;

    public Team(List<T> players, Coach coach) {
        this.players = players;
        this.coach = coach;
    }

    public Team() {
    }

    /**
     * Add players into team
     *
     * @param athlete player
     *
     * @return {@code true} if OK
     */
    public boolean addPlayer(T athlete) {
        if (athlete == null) {
            throw new IllegalArgumentException("Player mustn't be null");
        }

        if (players.size() < MAX_PLAYERS_COUNT) {
            players.add(athlete);
        }

        return true;
    }

    @Override
    public void makeScore() {
        throw new UnsupportedOperationException("Team cann't makeScore");
    }

    @Override
    public int getScore() {
        int scoreSum = 0;
        for (Scorable player : players)
            scoreSum = scoreSum + player.getScore();
        return scoreSum;
    }


    public List<T> getPlayers() {
        return players;
    }

    public void setPlayers(List<T> players) {
        this.players = players;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
