package ru.java.courses.sport.team.football;

public enum PlayerRole {

    GOALKEEPER("Вратарь"),
    DEFENDER("Защитник"),
    WINGER("Нападающий");

    private String name;

    PlayerRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
