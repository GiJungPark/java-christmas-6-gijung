package christmas.configuration;

public enum Message {

    START("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    READ_VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    WRITE_VISIT_DATE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    READ_ORDER_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),

    ORDER_MENU("<주문 메뉴>"),
    TOTAL_PRICE_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    GIVE_AWAY("<증정 메뉴>"),
    EVENT_HISTORY("<혜택 내역>"),
    TOTAL_EVENT_PRICE("<총혜택 금액>"),
    EXPECTED_PRICE_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    EVENT_BADGE("<12월 이벤트 배지>"),

    MENU_NAME_COUNT("%s %d개"),
    PRICE("#,###원"),
    EVENT_NAME_PRICE("%s: %s"),

    EMPTY("없음")
    ;

    private String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
