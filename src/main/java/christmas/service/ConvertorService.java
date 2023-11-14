package christmas.service;

import christmas.configuration.Menu;

import java.util.HashMap;
import java.util.Map;

public class ConvertorService {

    public Map<String, Integer> changeForService(Map<String, Integer> menus) {

        Map<String, Integer> map = new HashMap<>();

        for (String menu : menus.keySet()) {
            map.put(Menu.convertorTitle(menu), menus.get(menu));
        }

        return map;
    }

    public Map<String, Integer> changeForView(Map<String, Integer> menus) {

        Map<String, Integer> map = new HashMap<>();

        for (String name : menus.keySet()) {
            map.put(Menu.valueOf(name).getTitle(), menus.get(name));
        }

        return map;
    }
}
