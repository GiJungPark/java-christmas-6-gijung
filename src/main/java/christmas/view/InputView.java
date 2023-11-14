package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.configuration.Message;

import java.util.HashMap;
import java.util.List;

public class InputView {
    public int readDate() {

        System.out.println(Message.READ_VISIT_DATE.getValue());

        String input = readLineByRemovingSpaces();

        validateNull(input);

        validateDate(input);

        return Integer.parseInt(input);
    }

    private String readLineByRemovingSpaces() {

        String input = Console.readLine();

        return input.replaceAll(" ", "");
    }

    private void validateNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력하지 않았습니다. 다시 입력해 주세요.");
        }
    }

    private void validateDate(String input) {
        if (!input.matches("\\d*")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public HashMap<String, Integer> readMenu() {

        System.out.println(Message.READ_MENU.getValue());

        String input = readLineByRemovingSpaces();

        validateNull(input);

        validateEndWithComma(input);

        return separate(input);
    }

    private void validateEndWithComma(String input) {
        if (input.charAt(input.length() - 1) == ',') {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private HashMap<String, Integer> separate(String input) {

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

    private void validateKorean(String input) {
        if (!input.matches("^[ㄱ-ㅎ가-힣]*$")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateNumber(String input) {
        if (!input.matches("\\d*")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private List<String> separateWithComma(String input) {

        List<String> separatedInput = List.of(input.split(","));

        return separatedInput;
    }

    private List<String> separateWithHyphen(String input) {

        List<String> separatedInput = List.of(input.split("-"));

        validateSeparateSize(separatedInput.size());

        return separatedInput;
    }

    private void validateSeparateSize(int size) {
        if (size != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void duplicateMenuTitle(HashMap<String, Integer> separatedInput, String menuTitle) {
        if (separatedInput.containsKey(menuTitle)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
    // ...
}
