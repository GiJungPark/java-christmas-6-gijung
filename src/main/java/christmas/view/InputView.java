package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.configuration.ErrorMessage;
import christmas.configuration.Message;

import java.util.HashMap;
import java.util.List;

public class InputView {

    private static final String SPACES = " ";
    private static final String EMPTY = "";

    public static String readDate() {

        String input = readLineByRemovingSpaces();

        validateNull(input);

        return input;
    }

    public static String readOrderMenu() {

        String input = readLineByRemovingSpaces();

        validateNull(input);

        return input;
    }

    private static String readLineByRemovingSpaces() {

        String input = Console.readLine();

        return input.replaceAll(SPACES, EMPTY);
    }

    private static void validateNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getMessage());
        }
    }
}
