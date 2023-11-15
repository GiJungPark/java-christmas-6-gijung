package christmas.domain;

import christmas.configuration.Event;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class DiscountEventTest {

    private DiscountEvent discountEvent;

    @DisplayName("정상적으로 이벤트 내역이 생성되는 경우")
    @Test
    void createDiscountEvent() {

        Map<String, Integer> eventHistory=new HashMap<>() {{
            put(Event.SPECIAL_DISCOUNT.getTitle(), Event.SPECIAL_DISCOUNT.getPrice());
        }};

        discountEvent = new DiscountEvent(eventHistory);

        assertThat(discountEvent.getDiscountEventHistory()).isEqualTo(eventHistory);
    }

    @DisplayName("이벤트 내역에 없음이 존재하는 경우")
    @Test
    void createDiscountEventContainEmptyTitle() {

        Map<String, Integer> eventHistory = new HashMap<>() {{
            put(Event.SPECIAL_DISCOUNT.getTitle(), Event.SPECIAL_DISCOUNT.getPrice());
            put(Event.EMPTY_DISCOUNT.getTitle(), Event.EMPTY_DISCOUNT.getPrice());
        }};

        Map<String, Integer> expectedEventHistory = new HashMap<>() {{
            put(Event.SPECIAL_DISCOUNT.getTitle(), Event.SPECIAL_DISCOUNT.getPrice());
        }};

        discountEvent = new DiscountEvent(eventHistory);

        assertThat(discountEvent.getDiscountEventHistory()).isEqualTo(expectedEventHistory);
    }

}
