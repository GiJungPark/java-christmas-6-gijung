package christmas.service;

import christmas.domain.configuration.Menu;

import java.util.HashMap;

public class ConvertorService {

    public HashMap<String, Integer> changeForService(HashMap<String, Integer> menus) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String menu : menus.keySet()) {
            map.put(Menu.convertorTitle(menu), menus.get(menu));
        }

        return map;
    }

    public HashMap<String, Integer> changeForView(HashMap<String, Integer> menus) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String name : menus.keySet()) {
            map.put(Menu.valueOf(name).getTitle(), menus.get(name));
        }

        return map;
    }
}
