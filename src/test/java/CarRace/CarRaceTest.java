package CarRace;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
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
        String result = carrace.GoOrStop(value);
        //then
        assertThat(result).isEqualTo("CCar Stop");
    }

    @DisplayName("자동차가 랜덤값이 4이상이면 움직인다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void testGoOrStop4up(int value) {
        //given
        CarRace carrace = new CarRace();
        //when
        String result = carrace.GoOrStop(value);
        //then
        assertThat(result).isEqualTo("CCar Go");
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
}
