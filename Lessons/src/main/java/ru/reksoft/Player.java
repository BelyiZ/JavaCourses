package ru.reksoft;

import javax.swing.text.PlainDocument;

public class Player extends Person {
    protected PlayerType type;

    public Player( PlayerType type, String FullName, int Number){
        super(FullName);
        this.Number=Number;
        this.type = type;
    }



    private int Number;
    private int GoalCount;
    private boolean Active;

    public void Play() {
        if (type.equals(PlayerType.Defender)) {
            //защищать;
        } else if (type.equals(PlayerType.Attaker)) {
            //атаковать
        } else if (type.equals(PlayerType.Goalkeaper)) {
            //охранять ворота
        } else if (type.equals(PlayerType.Midfielder)) {
            //держать середину поля
        }
    }

        public void GivePass(){
            //сделать передачу
        }

    public int getGoalCount() {
        return GoalCount;
    }

    public void setGoalCount(int goalCount) {
        GoalCount = goalCount;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public boolean getActive(boolean active) {
        return Active;
    }
}


