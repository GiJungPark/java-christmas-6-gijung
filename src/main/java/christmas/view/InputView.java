package christmas.view;

import camp.nextstep.edu.missionutils.Console;

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

    // ...
}
