package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderMenusTest {

    @DisplayName("정상적인 주문 처리")
    @Test
    void test() {

        HashMap<String, Integer> menus = new HashMap<>() {{
            put("양송이수프", 1);
            put("제로콜라", 1);
        }};

        assertThat(new OrderMenus(menus)).isInstanceOf(OrderMenus.class);
    }

    @DisplayName("메뉴 개수가 1보다 작은 경우에 대한 예외 처리")
    @Test
    void createOrderMenuByUnderSize() {

        HashMap<String, Integer> menus = new HashMap<>() {{
            put("양송이수프", 0);
            put("타파스", 0);
        }};

        assertThatThrownBy(() -> new OrderMenus(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 개수가 20보다 큰 경우에 대한 예외 처리")
    @Test
    void createOrderMenuByOverSize() {

        HashMap<String, Integer> menus = new HashMap<>() {{
            put("양송이수프", 10);
            put("티본스테이크", 6);
            put("제로콜라", 6);
        }};

        assertThatThrownBy(() -> new OrderMenus(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴판에 존재하지 않는 메뉴에 대한 예외 처리")
    @Test
    void createOrderMenuByInvalidMenu() {

        HashMap<String, Integer> menus = new HashMap<>() {{
            put("없는메뉴", 6);
            put("티본스테이크", 6);
        }};

        assertThatThrownBy(() -> new OrderMenus(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료만 주문에 대한 예외 처리")
    @Test
    void createOrderMenuByOnlyDrink() {

        HashMap<String, Integer> menus = new HashMap<>() {{
            put("제로콜라", 3);
            put("레드와인", 3);
        }};

        assertThatThrownBy(() -> new OrderMenus(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메인 메뉴의 개수를 출력 - 메인 메뉴가 있는 경우")
    @Test
    void getMainMenuCount() {

        int mainMenuCount = 10;
        HashMap<String, Integer> menus = new HashMap<>() {{
            put("해산물파스타", mainMenuCount);
            put("레드와인", 3);
        }};

        OrderMenus orderMenus = new OrderMenus(menus);

        assertThat(orderMenus.getMainCount()).isEqualTo(mainMenuCount);
    }

    @DisplayName("메인 메뉴의 개수를 출력 - 메인 메뉴가 없는 경우")
    @Test
    void getMainMenuCountByNone() {

        HashMap<String, Integer> menus = new HashMap<>() {{
            put("초코케이크", 3);
            put("레드와인", 3);
        }};

        OrderMenus orderMenus = new OrderMenus(menus);

        assertThat(orderMenus.getMainCount()).isEqualTo(0);
    }

    @DisplayName("디저트 메뉴의 개수를 출력 - 디저트 메뉴가 있는 경우")
    @Test
    void getDesertMenuCount() {

        int desertMenuCount = 10;
        HashMap<String, Integer> menus = new HashMap<>() {{
            put("초코케이크", desertMenuCount);
            put("레드와인", 3);
        }};

        OrderMenus orderMenus = new OrderMenus(menus);

        assertThat(orderMenus.getDesertCount()).isEqualTo(desertMenuCount);
    }

    @DisplayName("메인 메뉴의 개수를 출력 - 메인 메뉴가 없는 경우")
    @Test
    void getDesertMenuCountByNone() {

        HashMap<String, Integer> menus = new HashMap<>() {{
            put("바비큐립", 3);
            put("레드와인", 3);
        }};

        OrderMenus orderMenus = new OrderMenus(menus);

        assertThat(orderMenus.getDesertCount()).isEqualTo(0);
    }
}
