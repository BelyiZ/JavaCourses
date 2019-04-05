package ru.java.courses.sport.team.football;

import sun.dc.pr.PRError;

public enum PlayerRole {

    DEFENDER("Защитник"),
    WINGER("Нападающий"),
    GOALKEEPER("Вратарь");

    protected String name;

    PlayerRole(String name) {this.name = name;}

    public String getName() {return name;}


}
