package CarRace;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRaceTest {
    @DisplayName("자동차가 랜덤값이 3이하면 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testGoOrStop3down(int value) {
        //given
        CarRace carrace = new CarRace();
        //when
        int result = carrace.GoOrStop(value);
        //then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("자동차가 랜덤값이 4이상이면 움직인다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void testGoOrStop4up(int value) {
        //given
        CarRace carrace = new CarRace();
        //when
        int result = carrace.GoOrStop(value);
        //then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("적절한 범위의 랜덤값을 제공한다.")
    @RepeatedTest(value = 100)
    void testGenerateRandom() {
        //given
        CarRace carrace = new CarRace();
        //when
        int n = carrace.GenerateRandom0to9();
        boolean result = (n >= 0) && (n <= 9);
        //then
        assertThat(result).isTrue();
    }
    @DisplayName("자동차가 여러대일때 우승자를 구한다.")
    @Test
    void testGetWinner() {
        //given
        CarRace carrace = new CarRace();
        //when
        int[] carsscores = {4,2,6,8,5};
        String maxscorecar = carrace.GetWinner(carsscores);
        //then
        assertThat(maxscorecar).isEqualTo("CCar3");

    }
    @DisplayName("자동차가 여러대일때 우승자가 여러명일때 우승자를 구한다.")
    @Test
    void testGetWinners() {
        //given
        CarRace carrace = new CarRace();
        //when
        int[] carsscores = {4,2,8,8,5};
        String maxscorecar = carrace.GetWinner(carsscores);
        //then
        assertThat(maxscorecar).isEqualTo("CCar2, CCar3");

    }
}
