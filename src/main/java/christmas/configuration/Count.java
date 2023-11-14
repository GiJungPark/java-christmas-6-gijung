package christmas.configuration;

public enum Count {
    MIN(1),
    MAX(20);

    private int number;

    Count(int number) {
        this.number = number;
    }

    public static boolean isIncludeScope(int number) {
        return (MIN.number <= number && number <= MAX.number);
    }
}
