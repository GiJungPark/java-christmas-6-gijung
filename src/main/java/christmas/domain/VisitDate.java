package christmas.domain;

import christmas.configuration.ErrorMessage;

public class VisitDate {

    private static final int CHRISTMAS = 25;
    private static final int WEEK = 7;
    private static final int FRIDAY = 1;
    private static final int SATURDAY = 2;
    private static final int SUNDAY = 3;


    private final int number;

    public VisitDate(int number) {

        validateNumberSize(number);

        this.number = number;
    }

    private void validateNumberSize(int number) {
        if(1 > number || number > 31) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }

    public boolean isContainChristmas() {
        return number == CHRISTMAS;
    }

    public boolean isContainWeekday() {
        return (number % WEEK != FRIDAY && number % WEEK != SATURDAY);
    }

    public boolean isContainWeekend() {
        return (number % WEEK == FRIDAY || number % WEEK == SATURDAY);
    }

    public boolean isContainSpecial() {
        return (number % WEEK == SUNDAY || number == CHRISTMAS);
    }
}
