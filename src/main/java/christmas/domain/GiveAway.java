package christmas.domain;

import christmas.domain.configuration.Menu;

public class GiveAway {

    private final String title;
    private final int count;

    public GiveAway(boolean giveAway) {

        if (giveAway) {
            title = Menu.CHAMPAGNE.getTitle();
            count = 1;
            return;
        }

        title = Menu.EMPTY.getTitle();
        count = 0;
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }
}
