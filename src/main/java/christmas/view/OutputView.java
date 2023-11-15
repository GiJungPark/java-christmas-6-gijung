package christmas.view;

import christmas.configuration.Menu;
import christmas.configuration.Message;
import christmas.domain.DiscountEvent;
import christmas.domain.EventBadge;
import christmas.domain.GiveAway;
import christmas.domain.OrderMenus;
import christmas.domain.Price;
import christmas.domain.VisitDate;

import java.text.DecimalFormat;

public class OutputView {

    private static final DecimalFormat df = new DecimalFormat(Message.PRICE.getValue());

    public static void printStart() {
        System.out.println(Message.START.getValue());
    }

    public static void printReadVisitDate() {
        System.out.println(Message.READ_VISIT_DATE.getValue());
    }

    public static void printChangeLine() {
        System.out.println();
    }

    public static void printReadOrderMenu() {
        System.out.println(Message.READ_ORDER_MENU.getValue());
    }

    public static void printGuide(VisitDate visitDate) {
        System.out.println(String.format(Message.WRITE_VISIT_DATE.getValue(), visitDate.getNumber()));
    }

    public static void printMenu(OrderMenus orderMenus) {
        System.out.println(Message.ORDER_MENU.getValue());

        for (String menuTitle : orderMenus.getValues().keySet()) {
            System.out.println(String.
                    format(Message.MENU_NAME_COUNT.getValue(), menuTitle, orderMenus.getValues().get(menuTitle)));
        }
    }

    public static void printTotalPriceBeforeDiscount(Price totalPriceBeforeDiscount) {
        System.out.println(Message.TOTAL_PRICE_BEFORE_DISCOUNT.getValue());

        System.out.println(df.format(totalPriceBeforeDiscount.getValue()));
    }

    public static void printGiveAwayMenu(GiveAway givenAway) {
        System.out.println(Message.GIVE_AWAY.getValue());

        if (givenAway.getTitle().equals(Menu.EMPTY.getTitle())) {
            System.out.println(Message.EMPTY.getValue());
            return;
        }

        System.out.println(String.format(Message.MENU_NAME_COUNT.getValue(), givenAway.getTitle(), givenAway.getCount()));
    }

    public static void printDiscountHistory(DiscountEvent discountEvent) {
        System.out.println(Message.EVENT_HISTORY.getValue());

        if(discountEvent.getDiscountEventHistory().isEmpty()) {
            System.out.println(Message.EMPTY.getValue());
        }

        for (String title : discountEvent.getDiscountEventHistory().keySet()) {
            System.out.println(String.format(Message.EVENT_NAME_PRICE.getValue()
                    , title, df.format(-discountEvent.getDiscountEventHistory().get(title))));
        }
    }

    public static void printTotalDiscountPrice(Price totalDiscountPrice) {
        System.out.println(Message.TOTAL_EVENT_PRICE.getValue());

        System.out.println(df.format(-totalDiscountPrice.getValue()));
    }

    public static void printExpectedPaymentPrice(Price expectedPaymentPrice) {
        System.out.println(Message.EXPECTED_PRICE_AFTER_DISCOUNT.getValue());

        System.out.println(df.format(expectedPaymentPrice.getValue()));
    }

    public static void printEventBadge(EventBadge badge) {
        System.out.println(Message.EVENT_BADGE.getValue());
        System.out.println(badge.toString());
    }
}
