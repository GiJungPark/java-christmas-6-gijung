package christmas.domain;

public class EventBadge {

    private final String badge;

    public EventBadge(int totalDiscountPrice) {

        if(totalDiscountPrice >= 20_000) {
            badge = "산타";
            return;
        }

        if(totalDiscountPrice >= 10_000) {
            badge = "트리";
            return;
        }

        if(totalDiscountPrice >= 5_000) {
            badge = "별";
            return;
        }

        badge = "없음";
    }

    public String getBadge() {
        return badge;
    }
}
