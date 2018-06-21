package ru.java.courses.football;

import java.util.ArrayList;
import java.util.Arrays;

public class Team {

    private String name;

    private Coach coach;

    private ArrayList<Player> players =new ArrayList();

    public Team(String coachName, String name, long coachSalary){
        coach.setSalary(coachSalary);
        coach.setName(coachName);
        this.setName(name);

    }

    public Team(String name){
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name=="" || name.isEmpty()){
            throw new IllegalArgumentException("Ну кто так называет команду. Прояви фантазию, назови команду по-другому!");
        }
        else
        this.name = name;
    }

    public void addPlayers(Player... player){
        if (this.players.size()<20) {
            this.players.addAll(Arrays.asList(player));
        }
        else
            throw new IllegalArgumentException("Горошочек, не вари! В команде не может быть больше 20 игроков.");

    }

    public int getPlayersCount() {
        return this.players.size();
    }

    public int getScore() {
        int goals=0;
        for (Player player: players){
            goals+=player.getGoals();
        }
        return goals;
    }

    public void removePlayer(int index){
       this.players.remove(index);
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Coach getCoach() {
        return coach;
    }
}
