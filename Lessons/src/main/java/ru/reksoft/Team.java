package ru.reksoft;

import java.util.ArrayList;

public class Team {

    private String TeamName;

    Coach coach = new Coach();

    ArrayList<Player> Players=new ArrayList();

    public Team(String CoachName, String TeamName, long coach_salary){
        coach.setSalary(coach_salary);
        coach.setFullName(CoachName);
        this.setTeamName(TeamName);

    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public void AddPlayer(Player player){
        this.Players.add(player);
    }

    public void DelPlayer(Player player){
       this.Players.remove(player);
    }

}
