import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MainTests {

    @Test
    public void testMerge() {
        // given:
        Integer[] comand1 = {45, 31, 24, 22, 20, 17, 14, 13, 12, 10};
        Integer[] comand2 = {31, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        Integer[] expected = {45, 31, 31, 24, 22, 20, 18, 17, 15, 14};

        // when:
        Integer[] result = Main.merge(comand1, comand2);

        // then:
        assertThat(expected, arrayContaining(result));
    }

    @Test
    public void testMergeAll() {
        // given:
        Integer[][] teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };
        Integer[] expected = {51, 45, 31, 31, 30, 24, 22, 20, 18, 17};

        // when:
        Integer[] result = Main.mergeAll(teams);

        // then:
        assertThat(expected, arrayContaining(result));

    }

    @Test
    public void testSumRating() {
        // given:
        Integer[] comand1 = {51, 30, 10, 9, 8, 7, 6, 5, 2, 1};
        int expected = 129;

        // when:
        int act = Main.sumRating(comand1);


        // then:
        Assertions.assertEquals(expected, act);
//        assertThat();
    }

    @Test
    public void commandContainsAllPlayers() {
        // given:
        Integer[][] teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };
        int expected = 10;

        // when:
        Integer[] result = Main.mergeAll(teams);

        // then:
        assertThat(result, arrayWithSize(expected));

    }

    @Test
    public void commandContainsBestPlayers() {
        // given:
        Integer[][] teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };
        int expected = 51;

        // when:
        Integer[] result = Main.mergeAll(teams);

        // then:
        assertThat(result, hasItemInArray(expected));

    }

    @Test
    public void commandRaitingIsHigh() {
        // given:
        Integer[] comand1 = {51, 30, 10, 9, 8, 7, 6, 5, 2, 1};

        int expected = 100;

        // when:
        int result = Main.sumRating(comand1);

        // then:
        assertThat(result, greaterThanOrEqualTo(expected));

    }


}
