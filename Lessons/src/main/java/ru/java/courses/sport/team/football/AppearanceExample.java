package ru.java.courses.sport.team.football;

public class AppearanceExample {
    public static void main(String[] args) {
        FootballTeam team = new FootballTeam("test");
        AppearanceBuilder hawaiianTeamBuilder = new FootballTeam("test");
        team.setAppearanceBuilder(hawaiianTeamBuilder);
        team.constructAppearance();

        Appearance appearance = team.getAppearance();
    }
}

