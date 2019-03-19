package ru.java.courses.sport.team.football;

public class Main {
    public static void main(String[] args) {
        Coach coach = new Coach("Vero Luki", 5);
        Player player1 = new Player("Ficha");

        for (int i = 0; i < 20; i++) {
            Player player1 +i = new Player("Ficha" + i);
        }
        FootballTeam team1 = new FootballTeam("Bulls", coach, new Player[]{player1});
    }

}
