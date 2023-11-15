package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class VisitDateTest {

    @DisplayName("정상적인 방문 날짜 처리")
    @ValueSource(strings = {"1", "10", "20", "31"})
    @ParameterizedTest
    void createVisitDate(int visitDateNumber) {
        assertThat(new VisitDate(visitDateNumber)).isInstanceOf(VisitDate.class);
    }

    @DisplayName("1 ~ 31 이외의 방문 날짜에 대한 예외 처리")
    @ValueSource(strings = {"-1", "0", "32"})
    @ParameterizedTest
    void createVisitDateOutOfRange(int visitDateNumber) {
        assertThatThrownBy(() -> new VisitDate(visitDateNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
