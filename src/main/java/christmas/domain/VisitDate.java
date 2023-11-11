package christmas.domain;

public class VisitDate {

    private final int number;

    public VisitDate(int number) {

        validateNumberSize(number);

        this.number = number;
    }

    private void validateNumberSize(int number) {
        if(1 > number || number > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public int getNumber() {
        return number;
    }
}
