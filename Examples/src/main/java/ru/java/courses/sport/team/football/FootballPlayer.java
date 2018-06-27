package ru.java.courses.sport.team.football;

import ru.java.courses.sport.Athlete;
import ru.java.courses.sport.ScoringPlayer;

/**
 * Футболист
 */
public class FootballPlayer extends Athlete implements ScoringPlayer {

    /**
     * Количество забитых голов
     */
    private int goals;

    /**
     * Роль игрока в команде
     */
    private PlayerRole role;

    public FootballPlayer(String name, PlayerRole playerRole) {
        super(name);

        if (playerRole == null) {
            throw new IllegalArgumentException("");
        }
        this.role = playerRole;
    }

    @Override
    public void score() {
        if (isActive()) {
            goals++;
        } else {
            throw new UnsupportedOperationException("Запасные игроки не могут забивать голы");
        }
    }

    @Override
    public int getScore() {
        return goals;
    }

    public int getGoals() {
        return goals;
    }

    public PlayerRole getRole() {
        return role;
    }

    public void setRole(PlayerRole role) {
        if (role == null) {
            throw new IllegalArgumentException("");
        }
        this.role = role;
    }
}
