package christmas.configuration;

public enum Event {

    DAYS_UNTIL_CHRISTMAS_DISCOUNT("크리스마스 데이 할인", 1000),

    WEEKDAY_DISCOUNT("평일 할인", 2023),
    WEEKEND_DISCOUNT("주말 할인", 2023),
    SPECIAL_DISCOUNT("특별 할인", 1000),
    GIVE_AWAY_EVENT("증정 이벤트", 25000),
    EMPTY_DISCOUNT("없음", 0);

    private String title;
    private int price;

    Event(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }
}
