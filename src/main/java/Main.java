import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        Integer[][] teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };

        Integer[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]
        System.out.println("Суммарный рейтинг команды: " + sumRating(nationalTeam));
    }

    /**
     * Метод для слияния всех команд в одну национальную
     */
    public static Integer[] mergeAll(Integer[][] teams) {
        int countPlayers = 10;
        Integer[] bestPlayers = teams[0];
        for (int i = 1; i < teams.length; i++) {
            bestPlayers = merge(bestPlayers, teams[i]);
        }
        return bestPlayers;

    }

    /**
     * Метод для слияния двух команд в одну
     */
    public static Integer[] merge(Integer[] teamA, Integer[] teamB) throws  ArrayIndexOutOfBoundsException{
        int countPlayers = 10;
        int ia = 0;
        int ib = 0;
        Integer[] bestPlayers = new Integer[countPlayers];
        for (int i = 0; i < countPlayers; i++) {
            if (teamA[ia] >= teamB[ib]) {
                bestPlayers[i] = teamA[ia];
                ia++;
            } else {
                bestPlayers[i] = teamB[ib];
                ib++;
            }

        }
        return bestPlayers;
        // Ваш код
    }

    public static int sumRating (Integer[] team) {
        int rating = 0;
        for (int i = 0; i < team.length; i++) {
            rating += team[i];
        }
        return rating;
    }
}