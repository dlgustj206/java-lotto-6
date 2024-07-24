package lotto.domain;

import java.util.Map;

public class Profit {

    private final Map<Rank, Integer> result;
    private final Integer totalAmount;

    public Profit(Map<Rank, Integer> result, Integer totalAmount) {
        this.result = result;
        this.totalAmount = totalAmount;
    }

    public Double calculateProfitRate() {
        long totalReward = 0;
        for (Rank rank : Rank.values()) {
            totalReward += rank.getReward() * result.getOrDefault(rank, 0);
        }
        return ((double) totalReward / totalAmount) * 100;
    }
}
