package christmas.domain;

import christmas.configuration.Count;
import christmas.configuration.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class OrderMenus {

    private final Map<Menu, Integer> values;

    public OrderMenus(Map<String, Integer> orderMenus) {

        Map<Menu, Integer> menus = new HashMap<>();
        for (String menu : orderMenus.keySet()) {

            validateMenuCount(orderMenus.get(menu));

            menus.put(Menu.findMenu(menu), orderMenus.get(menu));
        }

        validateMenuName(menus.keySet());
        validateMenuCount(menus.values().stream().reduce(0, Integer::sum));
        validateOnlyDrink(menus.keySet());

        this.values = menus;
    }

    private static void validateMenuName(Set<Menu> menus) {
        if(menus.contains(Menu.EMPTY)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void validateMenuCount(int count) {
        if (Count.isIncludeScope(count)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void validateOnlyDrink(Set<Menu> menus) {
        if (menus.stream().anyMatch(menu -> Menu.isDrink(menu.name()))) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public Map<String, Integer> get() {
        return new HashMap<String, Integer>();
    }
}
