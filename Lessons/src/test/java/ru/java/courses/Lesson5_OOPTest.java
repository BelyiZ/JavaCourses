package ru.java.courses;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.java.courses.football.Coach;
import ru.java.courses.football.Person;
import ru.java.courses.football.Player;
import ru.java.courses.football.PlayerRole;
import ru.java.courses.football.Team;

public class Lesson5_OOPTest {

    private static Team team;

    @BeforeAll
    public static void setup() {
        team = new Team("Вымпел");

        Coach coach = new Coach("Иван Гоняймяч");
        coach.setExperience(12);
        team.setCoach(coach);

        Player goalkeeper = new Player("Алексей Петров", PlayerRole.GOALKEEPER);
        Player winger = new Player("Сергей Забивалов", PlayerRole.WINGER);
        Player defender1 = new Player("Николай Башкоймяч", PlayerRole.DEFENDER);

        team.addPlayers(goalkeeper, winger, defender1);

        Player defender2 = new Player("Евгений Забейгол", PlayerRole.DEFENDER);
        team.addPlayers(defender2);

        team.removePlayer(2); // удалили первого защитника

        winger.score();
        winger.score();
        winger.score();

        defender1.score(); // уже не в команде

        goalkeeper.score();
    }

    @Test
    public void teamScoreTest() {
        int teamScore = team.getScore();
        assertEquals(4, teamScore, "Всего в команда забила 4 гола");
    }

    @Test
    public void playersCountTest() {
        int playersCount = team.getPlayersCount();
        assertEquals(3, playersCount, "Всего в команде должно быть 3 игрока");
    }

    @Test
    public void coachExperienceTest() {
        int experience = team.getCoach().getExperience();
        assertEquals(12, experience, "Опыт тренера - 12 лет");
    }

    @Test
    public void nullablePlayerRoleTest() {
        try {
            new Player("Петька", null);
        } catch (Exception ignore) {
            try {
                Player player = new Player("Семён", PlayerRole.GOALKEEPER);
                Method setter = Player.class.getMethod("setRole", PlayerRole.class);
                setter.invoke(player, new Object[]{null});
                if (player.getRole() != null) {
                    return;
                }
            } catch (Exception ignore2) {
                return;
            }
            throw new AssertionError("Не должно быть возможность задать игроку роль null");
        }
        throw new AssertionError("Не должно быть возможность создать игрока с ролью null");
    }

    @Test
    public void inheritanceTest() {
        assertTrue(team.getCoach() instanceof Person, "Тренер тоже человек!");
        assertTrue(team.getPlayers().get(0) instanceof Person, "Игроки тоже люди!");
        assertTrue(PlayerRole.class.isEnum(), "Роли игроков должны быть перечисление");
    }

    @Test
    public void reservedPlayerScoreTest() {
        Player player = new Player("Artem", PlayerRole.DEFENDER);
        player.setActive(false);

        try {
            player.score();
        } catch (Exception ignore) {
            return;
        }
        assertEquals(0, player.getGoals(), "Запасные игроки не могу забивать голы");

    }

    @Test
    public void maxPlayersTest() {
        Team team = new Team("Не резиновая");
        try {
            for (int i = 0; i < 25; i++) {
                team.addPlayers(new Player("NoName", PlayerRole.GOALKEEPER));
            }
        } catch (Exception ignore) {
        }

        assertTrue(team.getPlayers().size() <= 20, "В команде не может быть больше 20 игроков");
    }

    @Test
    public void playerWithoutNameTest() {
        try {
            new Player(null, PlayerRole.WINGER);
            new Player("", PlayerRole.WINGER);
        } catch (Exception ignore) {
            try {
                Player player = new Player("NoName", PlayerRole.WINGER);
                Method setter = Player.class.getMethod("setName", String.class);
                setter.invoke(player, new Object[]{null});
                setter.invoke(player, "");
                if (player.getName() != null && !player.getName().isEmpty()) {
                    return;
                }
            } catch (Exception ignore2) {
                return;
            }
            throw new AssertionError("Не должно быть возможность задать игроку имя null или пустое");
        }
        throw new AssertionError("Не должно быть возможность создать игрока с пустым или null именем");
    }

    @Test
    public void coachWithoutNameTest() {
        try {
            new Coach(null);
            new Coach("");
        } catch (Exception ignore) {
            try {
                Coach coach = new Coach("NoName");
                Method setter = Coach.class.getMethod("setName", String.class);
                setter.invoke(coach, new Object[]{null});
                setter.invoke(coach, "");
                if (coach.getName() != null && !coach.getName().isEmpty()) {
                    return;
                }
            } catch (Exception ignore2) {
                return;
            }
            throw new AssertionError("Не должно быть возможность задать тренеру имя null или пустое");
        }
        throw new AssertionError("Не должно быть возможность создать тренера с пустым или null именем");
    }

    @Test
    public void teamWithoutNameTest() {
        try {
            new Team(null);
            new Team("");
        } catch (Exception ignore) {
            try {
                Team team = new Team("NoName");
                Method setter = Team.class.getMethod("setName", String.class);
                setter.invoke(team, new Object[]{null});
                setter.invoke(team, "");
                if (team.getName() != null && !team.getName().isEmpty()) {
                    return;
                }
            } catch (Exception ignore2) {
                return;
            }
            throw new AssertionError("Не должно быть возможность задать команде название null или пустое");
        }
        throw new AssertionError("Не должно быть возможность создать команду с пустым или null названием");
    }
}
