package christmas.view;

public class View {

    public static String readDate() {
        OutputView.printReadVisitDate();
        return InputView.readDate();
    }

    public static String readOrderMenu() {
        OutputView.printReadOrderMenu();
        return InputView.readOrderMenu();
    }

}
