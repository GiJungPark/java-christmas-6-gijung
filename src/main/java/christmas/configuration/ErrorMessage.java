package christmas.configuration;

public enum ErrorMessage {
    INPUT_NULL("입력하지 않았습니다. 다시 입력해 주세요.");

    private String message;

    private static final String prefix = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
