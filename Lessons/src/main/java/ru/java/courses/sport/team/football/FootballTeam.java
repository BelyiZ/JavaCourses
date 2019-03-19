package ru.java.courses.sport.team.football;

public class FootballTeam {
    private String name;
    private Coach coach;
    private Player[] players = new Player[20];
    private int goals;

    public FootballTeam(String name, Coach coach, Player[] players) {
        this.name = name;
        this.coach = coach;
        this.players = players;
    }

    public void addPlayers(String name) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                players[i] = new Player(name);
                break;
            }
        }
    }

    public void deletePlayers(String name) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].getName() == name) {
                players[i] = null;
            }
        }
    }

    public int getPlayersCount() {
        return players.length;
    }

    public int getScore() {
        return 0;
    }
}
