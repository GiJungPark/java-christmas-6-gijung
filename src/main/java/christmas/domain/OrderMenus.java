package christmas.domain;

import christmas.configuration.Count;
import christmas.configuration.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class OrderMenus {

    private final Map<String, Integer> values;

    public OrderMenus(Map<String, Integer> orderMenus) {

        Map<String, Integer> menus = new HashMap<>();
        for (String menuTitle : orderMenus.keySet()) {

            validateMenuCount(orderMenus.get(menuTitle));
            menus.put(Menu.findTitle(menuTitle), orderMenus.get(menuTitle));
        }

        validateMenuName(menus.keySet());
        validateMenuCount(menus.values().stream().reduce(0, Integer::sum));
        validateOnlyDrink(menus.keySet());

        this.values = menus;
    }

    public int getDesertCount() {

        int count = 0;

        for (String menuTitle : values.keySet()) {
            if(Menu.isDesert(menuTitle)) {
                count += values.get(menuTitle);
            }
        }

        return count;
    }

    public int getMainCount() {

        int count = 0;

        for (String menuTitle : values.keySet()) {
            if(Menu.isMain(menuTitle)) {
                count += values.get(menuTitle);
            }
        }

        return count;
    }

    public Map<String, Integer> getValues() {
        return values;
    }

    private static void validateMenuName(Set<String> menus) {
        if (menus.contains(Menu.EMPTY.getTitle())) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void validateMenuCount(int count) {
        if (!Count.isIncludeScope(count)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void validateOnlyDrink(Set<String> menus) {
        if (menus.stream().allMatch(menu -> Menu.isDrink(menu))) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
