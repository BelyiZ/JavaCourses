package ru.java.courses.sport.team.football;

import ru.java.courses.sport.team.Team;

public class FootballTeam extends Team<FootballPlayer> {

    public static final int MAX_PLAYERS_COUNT = 20;

    public FootballTeam(String name) {
        super(name);
    }

    @Override
    public int getMaxPlayersCount() {
        return MAX_PLAYERS_COUNT;
    }
}