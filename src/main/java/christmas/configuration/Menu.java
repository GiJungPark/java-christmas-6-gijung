package christmas.configuration;

public enum Menu {
    BUTTON_MUSHROOM_SOUP("양송이수프", 6_000, "애피타이저"),
    TAPAS("타파스", 5_500, "애피타이저"),
    CAESAR_SALAD("시저샐러드", 8_000, "애피타이저"),

    T_BONE_STEAK("티본스테이크", 55_000, "메인"),
    BARBECUE_RIBS("바비큐립", 54_000, "메인"),
    SEAFOOD_PASTA("해산물파스타", 35_000, "메인"),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, "메인"),

    CHOCOLATE_CAKE("초코케이크", 15_000, "디저트"),
    ICE_CREAM("아이스크림", 5_000, "디저트"),

    ZERO_COKE("제로콜라", 3_000, "음료"),
    RED_WINE("레드와인", 60_000, "음료"),
    CHAMPAGNE("샴페인", 25_000, "음료"),

    EMPTY("없음", 0, "없음");

    private String title;
    private int price;
    private String group;

    Menu(String title, int price, String group) {
        this.title = title;
        this.price = price;
        this.group = group;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public static int getPrice(String menuTitle) {
        for (Menu menu : Menu.values()) {
            if (menu.getTitle().equals(menuTitle)) {
                return menu.price;
            }
        }

        return EMPTY.getPrice();
    }

    public String getGroup() {
        return group;
    }

    public static String findMenu(String menuTitle) {

        for (Menu menu : Menu.values()) {
            if (menu.getTitle().equals(menuTitle)) {
                return menu.name();
            }
        }

        return EMPTY.name();
    }

    public static String findTitle(String menuTitle) {

        for (Menu menu : Menu.values()) {
            if (menu.getTitle().equals(menuTitle)) {
                return menu.getTitle();
            }
        }

        return EMPTY.getTitle();
    }

    public static boolean isDrink(String menuTitle) {
        return Menu.valueOf(findMenu(menuTitle)).getGroup().equals("음료");
    }

    public static boolean isDesert(String menuTitle) {
        return Menu.valueOf(findMenu(menuTitle)).getGroup().equals("디저트");
    }

    public static boolean isMain(String menuTitle) {
        return Menu.valueOf(findMenu(menuTitle)).getGroup().equals("메인");
    }
}
