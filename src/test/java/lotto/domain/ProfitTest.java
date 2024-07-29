package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitTest {

    @DisplayName("수익률을 올바르게 계산해야 한다.")
    @Test
    void calculateProfitRate() {
        Map<Rank, Integer> rankCounts = Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 1,
                Rank.THIRD, 1
        );

        Profit profit = new Profit(rankCounts, 8000);
        double profitRate = profit.calculateProfitRate();

        double expectedProfitRate = ((2000000000L + 30000000L + 1500000L) / 8000.0) * 100;
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}
