package christmas.domain.configuration;

import java.util.List;

public enum Menu {
    BUTTON_MUSHROOM_SOUP("양송이수프", 6_000, "애피타이저"),
    TAPAS("타파스",5_500, "애피타이저"),
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

    public String getGroup() {
        return group;
    }

    public static String convertorTitle(String menuTitle) {

        for(Menu menu: Menu.values()) {
            if(menu.getTitle().equals(menuTitle)){
                return menu.name();
            }
        }

        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    public static void isOnlyDrink(List<String> menuTitles) {

        for(String menuTitle : menuTitles) {
            if(!Menu.valueOf(menuTitle).getGroup().equals("음료")){
                return;
            }
        }

        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
