package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;

public class InputView {
    public int readDate() {

        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

        String input = readLineByRemovingSpaces();

        validateNull(input);

        validateNumber(input);

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

    private void validateNumber(String input) {
        if (!input.matches("\\d*")) {
            throw new IllegalArgumentException("[ERROR] 날짜는 숫자로 입력해야 합니다. 다시 입력해 주세요.");
        }
    }

    public HashMap<String, Integer> readMenu() {

        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

        String input = readLineByRemovingSpaces();

        validateNull(input);

        return separate(input);
    }

    private void validateKorean(String input) {
        if (!input.matches("^[ㄱ-ㅎ가-힣]*$")) {
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

    private List<String> separateWithComma(String input) {

        List<String> separatedInput = List.of(input.split(","));

        validateSeparateSize(separatedInput.size());

        return separatedInput;
    }

    private List<String> separateWithHyphen(String input) {

        List<String> separatedInput = List.of(input.split("-"));

        validateSeparateSize(separatedInput.size());

        return separatedInput;
    }

    private void validateSeparateSize(int size) {
        if (size != 2) {
            throw new IllegalArgumentException("입력값 형식에 맞지 않는다.");
        }
    }

    private void duplicateMenuTitle(HashMap<String, Integer> separatedInput, String menuTitle) {
        if (separatedInput.containsKey(menuTitle)) {
            throw new IllegalArgumentException("중복");
        }
    }
    // ...
}
