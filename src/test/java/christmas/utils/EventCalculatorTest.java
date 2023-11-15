package christmas.utils;

import christmas.configuration.Event;
import christmas.domain.GiveAway;
import christmas.domain.OrderMenus;
import christmas.domain.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class EventCalculatorTest {

    @DisplayName("크리스마스 혜택을 가져오는지 테스트")
    @Test
    void getChristmasDiscount() {
        VisitDate visitDate = new VisitDate(25);
        int expectedDiscount = 3400;

        assertThat(EventCalculator.christmasTitle(visitDate)).isEqualTo(Event.DAYS_UNTIL_CHRISTMAS_DISCOUNT.getTitle());
        assertThat(EventCalculator.christmasDiscount(visitDate)).isEqualTo(expectedDiscount);
    }

    @DisplayName("평일 혜택을 가져오는지 테스트")
    @Test
    void getWeekdayDiscount() {
        VisitDate visitDate = new VisitDate(4);
        int count = 4;

        HashMap<String, Integer> menus = new HashMap<>() {{
            put("초코케이크", count);
            put("제로콜라", 1);
        }};

        OrderMenus orderMenus = new OrderMenus(menus);

        assertThat(EventCalculator.weekdayTitle(visitDate)).isEqualTo(Event.WEEKDAY_DISCOUNT.getTitle());
        assertThat(EventCalculator.weekdayDiscount(orderMenus))
                .isEqualTo(Event.WEEKDAY_DISCOUNT.getPrice() * count);
    }

    @DisplayName("주말 혜택을 가져오는지 테스트")
    @Test
    void getWeekendDiscount() {
        VisitDate visitDate = new VisitDate(8);
        int count = 4;

        HashMap<String, Integer> menus = new HashMap<>() {{
            put("티본스테이크", count);
            put("제로콜라", 1);
        }};

        OrderMenus orderMenus = new OrderMenus(menus);

        assertThat(EventCalculator.weekendTitle(visitDate)).isEqualTo(Event.WEEKEND_DISCOUNT.getTitle());
        assertThat(EventCalculator.weekendDiscount(orderMenus))
                .isEqualTo(Event.WEEKEND_DISCOUNT.getPrice() * count);
    }

    @DisplayName("특별 혜택을 가져오는지 테스트")
    @Test
    void getSpecialDiscount() {
        VisitDate visitDate = new VisitDate(3);

        assertThat(EventCalculator.specialTitle(visitDate)).isEqualTo(Event.SPECIAL_DISCOUNT.getTitle());
        assertThat(EventCalculator.specialDiscount())
                .isEqualTo(Event.SPECIAL_DISCOUNT.getPrice());
    }

    @DisplayName("증정 이벤트를 가져오는지 테스트")
    @Test
    void getGiveAwayEvent() {

        GiveAway giveAway = new GiveAway(true);

        assertThat(EventCalculator.giveAwayTitle(giveAway.getCount())).isEqualTo(Event.GIVE_AWAY_EVENT.getTitle());
    }
}