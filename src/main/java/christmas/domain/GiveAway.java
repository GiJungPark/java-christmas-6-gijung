package christmas.domain;

import christmas.configuration.Menu;

public class GiveAway {

    private static final String GIVE_AWAY_TITLE = Menu.CHAMPAGNE.getTitle();
    private static final int GIVE_AWAY_COUNT = 1;
    private static final String EMPTY_TITLE = Menu.EMPTY.getTitle();
    private static final int EMPTY_COUNT = 0;

    private final String title;
    private final int count;

    public GiveAway(boolean giveAway) {

        if (giveAway) {
            title = GIVE_AWAY_TITLE;
            count = GIVE_AWAY_COUNT;
            return;
        }

        title = EMPTY_TITLE;
        count = EMPTY_COUNT;
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }
}
