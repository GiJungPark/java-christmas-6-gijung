package christmas.configuration;

public enum Badge {

    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    EMPTY("없음", 0);

    private String title;
    private int price;

    Badge(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public static String getWhat(int eventPrice) {

        for (Badge badge : Badge.values()) {
            if (badge.price <= eventPrice) {
                return badge.title;
            }
        }

        return EMPTY.title;
    }

    public String getTitle() {
        return title;
    }
}
