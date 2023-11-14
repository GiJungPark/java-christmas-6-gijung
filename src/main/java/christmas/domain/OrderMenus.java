package christmas.domain;

import christmas.configuration.Menu;

import java.util.ArrayList;
import java.util.Map;


public class OrderMenus {

    private final Map<String, Integer> orderMenus;

    public OrderMenus(Map<String, Integer> menus) {

        int totalCount = 0;

        for (String menu : menus.keySet()) {
            validateMenuCount(menus.get(menu));
            totalCount += menus.get(menu);
        }

        validateMenuCount(totalCount);

        Menu.isOnlyDrink(new ArrayList<>(menus.keySet()));

        this.orderMenus = menus;
    }

    private void validateMenuCount(int count) {
        if (count < 1 || count > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public Map<String, Integer> get() {
        return orderMenus;
    }
}
