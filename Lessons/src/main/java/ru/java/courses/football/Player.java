package ru.java.courses.football;

public class Player extends Person {

    private PlayerRole role;
    private int number;
    private int goals;
    private static boolean active=true;

    public Player(String name, PlayerRole role){
        super(name);
        this.setRole(role);
    }



    public void Play() {
        if (role.equals(PlayerRole.DEFENDER)) {
            //защищать;
        } else if (role.equals(PlayerRole.WINGER)) {
            //атаковать
        } else if (role.equals(PlayerRole.GOALKEEPER)) {
            //охранять ворота
        }
    }

    public void score(){
        if (this.active) {
            goals++;
        }
        else
            throw new IllegalArgumentException("Сорян, но игрок-то запасной! Какие голы?!");
        }

    public int getGoals() {
        return goals;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive(boolean active) {
        return this.active;
    }

    public PlayerRole getRole() {
        return role;
    }

    public void setRole(PlayerRole role) {
        if (role == null || role.toString() == ""){
            throw new IllegalArgumentException("Что за пустая роль?");
        }
        else
        this.role = role;
    }
}


