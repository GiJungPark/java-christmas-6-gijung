package christmas.domain;

import christmas.domain.configuration.Menu;

import java.util.ArrayList;
import java.util.HashMap;


public class OrderMenus {

    private final HashMap<String, Integer> orderMenus;

    public OrderMenus(HashMap<String, Integer> menus) {

        int totalCount = 0;

        HashMap<String, Integer> map = new HashMap<>();
        for (String menu : menus.keySet()) {
            validateMenuCount(menus.get(menu));
            totalCount += menus.get(menu);
            map.put(Menu.convertorTitle(menu), menus.get(menu));
        }

        validateMenuCount(totalCount);

        Menu.isOnlyDrink(new ArrayList<>(map.keySet()));

        this.orderMenus = map;
    }

    private void validateMenuCount(int count) {
        if (count < 1 || count > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public HashMap<String, Integer> get() {

        HashMap<String, Integer> map = new HashMap<>();
        for (String name : orderMenus.keySet()) {
            map.put(Menu.valueOf(name).getTitle(), orderMenus.get(name));
        }

        return map;
    }
}
