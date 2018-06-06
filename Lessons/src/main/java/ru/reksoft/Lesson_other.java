package ru.reksoft;

import java.util.jar.Attributes;

public class Lesson_other {

    public static void main(String[] args) {

        Team Chealsea = new Team("GusHidding", "Chealsea" , 5000000000L);

        Player Akinfeev = new Player(PlayerType.Goalkeaper, "Акинфеев", 11);
        Player Kerzhakov= new Player(PlayerType.Defender, "Кержаков", 21);
        Player Messi = new Player(PlayerType.Attaker, "Leonel Messi", 5);

        Akinfeev.setSalary(1000000L);
        Kerzhakov.setSalary(500000L);
        Messi.setSalary(300000000L);
        Messi.setGoalCount(1000);
        Kerzhakov.setGoalCount(-3);

        Chealsea.AddPlayer(Akinfeev);
        Chealsea.AddPlayer(Kerzhakov);
        Chealsea.AddPlayer(Messi);


       System.out.println("Создана команда:"+Chealsea.getTeamName()+" во главе с тренером "+Chealsea.coach.FullName+" и игроками:");

       for (int i=0; i<Chealsea.Players.size(); i++) {
           System.out.println(Chealsea.Players.get(i).getFullName()+" - "+Chealsea.Players.get(i).type+" под номером "+Chealsea.Players.get(i).getNumber()+" забил голов: "+Chealsea.Players.get(i).getGoalCount());
       }


    }

}

