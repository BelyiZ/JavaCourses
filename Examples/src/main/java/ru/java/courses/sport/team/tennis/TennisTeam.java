package ru.java.courses.sport.team.tennis;

import ru.java.courses.sport.team.Team;

public class TennisTeam extends Team<TennisPlayer> {

    public static final int MAX_PLAYERS_COUNT = 2;

    public TennisTeam(String name) {
        super(name);
    }

    @Override
    public int getMaxPlayersCount() {
        return MAX_PLAYERS_COUNT;
    }
}
