package christmas.domain;

import christmas.configuration.Badge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class EventBadgeTest {

    private EventBadge eventBadge;

    @DisplayName("이벤트 배지가 산타인 경우 테스트")
    @ValueSource(strings = {"20000", "30000"})
    @ParameterizedTest
    void 혜택_금액_20_000원_이상(int price) {

        eventBadge = new EventBadge(price);

        assertThat(eventBadge.toString()).isEqualTo(Badge.SANTA.getTitle());
    }

    @DisplayName("이벤트 배지가 트리인 경우 테스트")
    @ValueSource(strings = {"10000", "15000", "19999"})
    @ParameterizedTest
    void 혜택_금액_10_000원_이상_20_000원_미만(int price) {

        eventBadge = new EventBadge(price);

        assertThat(eventBadge.toString()).isEqualTo(Badge.TREE.getTitle());
    }

    @DisplayName("이벤트 배지가 별인 경우 테스트")
    @ValueSource(strings = {"5000", "7500", "9999"})
    @ParameterizedTest
    void 혜택_금액_5_000원_이상_10_000원_미만(int price) {

        eventBadge = new EventBadge(price);

        assertThat(eventBadge.toString()).isEqualTo(Badge.STAR.getTitle());
    }

    @DisplayName("이벤트 배지를 받지 못하는 경우 테스트")
    @ValueSource(strings = {"0", "2500", "4999"})
    @ParameterizedTest
    void 혜택_금액_0원_이상_5_000원_미만(int price) {

        eventBadge = new EventBadge(price);

        assertThat(eventBadge.toString()).isEqualTo(Badge.EMPTY.getTitle());
    }
}
