package ru.java.courses.sport.team.football;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FootballTeam extends FootballPlayer
{
    private String name;
    private Coach coach;
    private List<FootballPlayer> players = new ArrayList<>();
    private int playersNumber;

    public FootballTeam(String name){
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The team should have name");
        }else
        this.name = name;
       }

    public String getName(){return name;}

    public void setName(String name){
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("The team's name cannot be empty");
        }
        this.name = name;
    }

    public Coach getCoach(){return coach;}

    public void setCoach(Coach coach){this.coach = coach;}

    public int getPlayersNumber(){return playersNumber;}

    public void setPlayersNumber(int playersNumber){
         this.playersNumber = playersNumber;
    }

    public void addPlayer(FootballPlayer footballPlayer){
        if (players.size() +1 >= 20){
            throw new IllegalArgumentException("There shouldn't be more then 20 players in Team");
        } players.add(footballPlayer);
    }

    public void removePlayer(FootballPlayer footballPlayer){
        players.remove(footballPlayer);
    }

    public int getPlayersCount(){return players.size();}

    public int getScore() {
        int score = 0;
        for (FootballPlayer player: players) {
            score += player.getScore();
        }
        return score;
    }

    public List<FootballPlayer> getPlayers() {
        return new ArrayList<>(players);
    }

    public void setPlayers(List<FootballPlayer> players) {
        this.players = players;
    }

}

