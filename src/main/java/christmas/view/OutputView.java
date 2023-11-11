package christmas.view;

import java.text.DecimalFormat;
import java.util.HashMap;

public class OutputView {

    public void printStart() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printChangeLine() {
        System.out.println();
    }

    public void printGuide(int visitDate) {
        System.out.println(String.format("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", visitDate));
    }

    public void printMenu(HashMap<String, Integer> orderMenus) {
        System.out.println("<주문 메뉴>");

        for(String title : orderMenus.keySet()) {
            System.out.println(String.format("%s %d개", title, orderMenus.get(title)));
        }
    }

    public void printTotalPriceBeforeDiscount(int totalPriceBeforeDiscount) {
        System.out.println("<할인 전 총주문 금액>");

        DecimalFormat df = new DecimalFormat("#,###원");
        System.out.println(df.format(totalPriceBeforeDiscount));
    }
}
