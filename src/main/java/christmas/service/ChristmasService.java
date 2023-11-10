package christmas.service;

import christmas.domain.VisitDate;

public class ChristmasService {

    private VisitDate visitDate;

    public void setVisitDate(int number) {
        this.visitDate = new VisitDate(number);
    }
}
