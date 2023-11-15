package christmas.domain;

import christmas.configuration.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GiveAwayTest {

    @DisplayName("사은품이 증정되는 경우")
    @Test
    void createGiveAwaySuccess() {
        GiveAway giveAway = new GiveAway(true);

        assertThat(giveAway.getTitle()).isEqualTo(Menu.CHAMPAGNE.getTitle());
        assertThat(giveAway.getCount()).isEqualTo(1);
    }

    @DisplayName("사은품이 증정되지 않는 경우")
    @Test
    void createGiveAwayFail() {
        GiveAway giveAway = new GiveAway(false);

        assertThat(giveAway.getTitle()).isEqualTo(Menu.EMPTY.getTitle());
        assertThat(giveAway.getCount()).isEqualTo(0);
    }
}
