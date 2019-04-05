package ru.java.courses.sport.team.football;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FootballTeam extends AppearanceBuilder
{
    private String name;
    private Coach coach;
    private List<FootballPlayer> players = new ArrayList<>();

    public String toString() {     // возвращает данные объекта в строке
        return "name is " + this.name + "coach is" + this.coach + "team is" + this.players + this.appearanceBuilder;
    }


    public FootballTeam(String name){

        setName(name);
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

    public void addPlayer(FootballPlayer footballPlayer){
        if (players.size() >= 20){
            throw new IllegalArgumentException("There shouldn't be more then 20 players in Team");
        }else if (footballPlayer == null){
            throw new IllegalArgumentException("You haven't chosen anyone");
        }else
        players.add(footballPlayer);
    }

    public void removePlayer(FootballPlayer footballPlayer){
        if(footballPlayer == null){
            throw new IllegalArgumentException("You haven't chosen anyone");
        } else
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballTeam team = (FootballTeam) o;
        return Objects.equals(name, team.name) &&
                Objects.equals(coach, team.coach) &&
                Objects.equals(players, team.players) &&
                Objects.equals(appearanceBuilder, team.appearanceBuilder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coach, players, appearanceBuilder);
    }

    @Override
    public void buildUniform_color() {appearence.setUniform_color("Red");

    }

    @Override
    public void buildFlag() {appearence.setFlag("Blue");

    }

    @Override
    public void buildLogo() {appearence.setLogo("Cross");

    }

    private AppearanceBuilder appearanceBuilder;

    public void setAppearanceBuilder(AppearanceBuilder ab) {this.appearanceBuilder = ab; }
    public Appearance getAppearance() { return appearanceBuilder.getAppearance(); }

    public void constructAppearance() {
        appearanceBuilder.createNewTeamAppearance();
        appearanceBuilder.buildUniform_color();
        appearanceBuilder.buildFlag();
        appearanceBuilder.buildLogo();
    }
}

