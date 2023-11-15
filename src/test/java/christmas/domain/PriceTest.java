package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest {

    @DisplayName("정상적인 가격 객체 생성")
    @ValueSource(strings = {"0", "1", "1000", "10000"})
    @ParameterizedTest
    void createPrice(int price) {

        Price createPrice = new Price(price);

        assertThat(createPrice.getValue()).isEqualTo(price);
    }

    @DisplayName("비정상적인 가격 객체 생성")
    @ValueSource(strings = {"-1", "-1000", "-10000"})
    @ParameterizedTest
    void createPriceOutOfRange(int price) {
        assertThatThrownBy(() -> new Price(price))
                .isInstanceOf(ArithmeticException.class);
    }
}
