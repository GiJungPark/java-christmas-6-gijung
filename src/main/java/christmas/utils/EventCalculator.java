package christmas.utils;

import christmas.configuration.Event;
import christmas.domain.OrderMenus;
import christmas.domain.VisitDate;

import java.util.Set;

public class EventCalculator {

    public static String christmasTitle(VisitDate visitDate) {
        if(visitDate.isContainChristmas()) {
            return Event.DAYS_UNTIL_CHRISTMAS_DISCOUNT.getTitle();
        }

        return Event.EMPTY_DISCOUNT.getTitle();
    }

    public static int christmasDiscount(VisitDate visitDate) {
        if(visitDate.isContainChristmas()) {
            return Event.DAYS_UNTIL_CHRISTMAS_DISCOUNT.getPrice() + (visitDate.getNumber() - 1) * 100;
        }

        return 0;
    }

    public static String weekdayTitle(VisitDate visitDate) {
        if(visitDate.isContainWeekday()) {
            return Event.WEEKDAY_DISCOUNT.getTitle();
        }

        return Event.EMPTY_DISCOUNT.getTitle();
    }

    public static int weekdayDiscount(OrderMenus orderMenus) {
        return orderMenus.getDesertCount() * Event.WEEKDAY_DISCOUNT.getPrice();
    }

    public static String weekendTitle(VisitDate visitDate) {
        if(visitDate.isContainWeekend()) {
            return Event.WEEKEND_DISCOUNT.getTitle();
        }

        return Event.EMPTY_DISCOUNT.getTitle();
    }

    public static int weekendDiscount(OrderMenus orderMenus) {
        return orderMenus.getMainCount() * Event.WEEKEND_DISCOUNT.getPrice();
    }

    public static String specialTitle(VisitDate visitDate) {
        if (visitDate.isContainSpecial()) {
            return Event.SPECIAL_DISCOUNT.getTitle();
        }

        return Event.EMPTY_DISCOUNT.getTitle();
    }

    public static int specialDiscount() {
        return Event.SPECIAL_DISCOUNT.getPrice();
    }

    public static String giveAwayTitle(int GiveAwayCount) {
        if (GiveAwayCount > 0) {
            return Event.GIVE_AWAY_EVENT.getTitle();
        }

        return Event.EMPTY_DISCOUNT.getTitle();
    }

    public static boolean isEmpty(Set<String> eventTitles) {
       return  eventTitles.contains(Event.EMPTY_DISCOUNT.getTitle());
    }

    public static boolean isEmpty(int eventDiscount) {
        return eventDiscount == 0;
    }
}
