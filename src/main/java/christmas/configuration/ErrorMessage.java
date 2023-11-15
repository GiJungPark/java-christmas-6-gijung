package christmas.configuration;

public enum ErrorMessage {
    INPUT_NULL("입력하지 않았습니다. 다시 입력해 주세요."),
    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_PRICE("금액이 0원 보다 작을 수 없습니다."),
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private String message;

    private static final String prefix = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
