package christmas.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Convertor {

    private static final String ORDER_SEPARATOR = ",";
    private static final String NAME_COUNT_SEPARATOR = "-";

    public static Integer toDate(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static Map<String, Integer> toMenus(String value) {
        List<String> keyValuePairs = List.of(value.split(ORDER_SEPARATOR));

        Map<String, Integer> organizedData = new HashMap<>();

        for (String pair : keyValuePairs) {
            List<String> entry = List.of(pair.split(NAME_COUNT_SEPARATOR));

            validateFormat(entry.size());
            duplicateMenu(organizedData.keySet(), entry.get(0));

            organizedData.put(entry.get(0), toCount(entry.get(1)));
        }

        return organizedData;
    }

    private static int toCount(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void duplicateMenu(Set<String> menus, String menu) {
        if (menus.contains(menu)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void validateFormat(int size) {
        if (size != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
