package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.configuration.Message;

import java.util.HashMap;
import java.util.List;

public class InputView {
    public static int readDate() {

        String input = readLineByRemovingSpaces();

        validateNull(input);

        validateDate(input);

        return Integer.parseInt(input);
    }

    private static String readLineByRemovingSpaces() {

        String input = Console.readLine();

        return input.replaceAll(" ", "");
    }

    private static void validateNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력하지 않았습니다. 다시 입력해 주세요.");
        }
    }

    private static void validateDate(String input) {
        if (!input.matches("\\d*")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static HashMap<String, Integer> readOrderMenu() {

        String input = readLineByRemovingSpaces();

        validateNull(input);

        validateEndWithComma(input);

        return separate(input);
    }

    private static void validateEndWithComma(String input) {
        if (input.charAt(input.length() - 1) == ',') {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static HashMap<String, Integer> separate(String input) {

        HashMap<String, Integer> separatedInput = new HashMap<>();
        for (String inputLine : separateWithComma(input)) {
            List<String> inputValues = separateWithHyphen(inputLine);

            validateKorean(inputValues.get(0));
            validateNumber(inputValues.get(1));
            duplicateMenuTitle(separatedInput, inputValues.get(0));

            separatedInput.put(inputValues.get(0), Integer.parseInt(inputValues.get(1)));
        }

        return separatedInput;
    }

    private static void validateKorean(String input) {
        if (!input.matches("^[ㄱ-ㅎ가-힣]*$")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void validateNumber(String input) {
        if (!input.matches("\\d*")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static List<String> separateWithComma(String input) {

        List<String> separatedInput = List.of(input.split(","));

        return separatedInput;
    }

    private static List<String> separateWithHyphen(String input) {

        List<String> separatedInput = List.of(input.split("-"));

        validateSeparateSize(separatedInput.size());

        return separatedInput;
    }

    private static void validateSeparateSize(int size) {
        if (size != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void duplicateMenuTitle(HashMap<String, Integer> separatedInput, String menuTitle) {
        if (separatedInput.containsKey(menuTitle)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
    // ...
}
