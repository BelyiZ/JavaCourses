package ru.java.courses;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.java.courses.sport.Athlete;
import ru.java.courses.sport.Coach;
import ru.java.courses.sport.team.football.FootballPlayer;
import ru.java.courses.sport.team.football.FootballTeam;
import ru.java.courses.sport.team.football.PlayerRole;

public class Lesson5to8_OOPTest {

    private static FootballTeam team;

    @BeforeAll
    public static void setup() {
        team = new FootballTeam("Вымпел");

        Coach coach = new Coach("Иван Гоняймяч");
        coach.setExperience(12);
        team.setCoach(coach);

        FootballPlayer goalkeeper = new FootballPlayer("Алексей Петров", PlayerRole.GOALKEEPER);
        FootballPlayer winger = new FootballPlayer("Сергей Забивалов", PlayerRole.WINGER);
        FootballPlayer defender1 = new FootballPlayer("Николай Башкоймяч", PlayerRole.DEFENDER);

        team.addPlayers(goalkeeper, winger, defender1);

        FootballPlayer defender2 = new FootballPlayer("Евгений Забейгол", PlayerRole.DEFENDER);
        team.addPlayer(defender2);

        team.removePlayer(defender1); // удалили первого защитника

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
            new FootballPlayer("Петька", null);
        } catch (Exception ignore) {
            try {
                FootballPlayer player = new FootballPlayer("Семён", PlayerRole.GOALKEEPER);
                Method setter = FootballPlayer.class.getMethod("setRole", PlayerRole.class);
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
        assertTrue(team.getPlayers().get(0) instanceof Athlete, "Игроки - атлеты!");
        assertTrue(PlayerRole.class.isEnum(), "Роли игроков должны быть перечисление");
    }

    @Test
    public void reservedPlayerScoreTest() {
        FootballPlayer player = new FootballPlayer("Artem", PlayerRole.DEFENDER);
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
        FootballTeam team = new FootballTeam("Не резиновая");
        try {
            for (int i = 0; i < 25; i++) {
                team.addPlayer(new FootballPlayer("NoName", PlayerRole.GOALKEEPER));
            }
        } catch (Exception ignore) {
        }

        assertTrue(team.getMaxPlayersCount() <= 20, "В команде не может быть больше 20 игроков");
    }

    @Test
    public void playerWithoutNameTest() {
        try {
            new FootballPlayer(null, PlayerRole.WINGER);
            new FootballPlayer("", PlayerRole.WINGER);
        } catch (Exception ignore) {
            try {
                FootballPlayer player = new FootballPlayer("NoName", PlayerRole.WINGER);
                Method setter = FootballPlayer.class.getMethod("setName", String.class);
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
            new FootballTeam(null);
            new FootballTeam("");
        } catch (Exception ignore) {
            try {
                FootballTeam team = new FootballTeam("NoName");
                Method setter = FootballTeam.class.getMethod("setName", String.class);
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
