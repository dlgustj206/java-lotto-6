package lotto.domain;

public enum Rank {

    FIRST(6, false, 2000000000L),
    SECOND(5, true, 30000000L),
    THIRD(5, false, 1500000L),
    FOURTH(4, false, 50000L),
    FIFTH(3, false, 5000L),
    OTHERS(0, false, 0L);

    private final Integer matchedNumber;
    private final boolean matchedBonusNumber;
    private final Long reward;

    Rank(Integer matchedNumber, boolean matchedBonusNumber, Long reward) {
        this.matchedNumber = matchedNumber;
        this.matchedBonusNumber = matchedBonusNumber;
        this.reward = reward;
    }

    public Long getReward() {
        return reward;
    }

    public static Rank setRank(Integer matchedNumber, boolean matchedBonusNumber) {
        for (Rank rank : Rank.values()) {
            if (rank.matchedNumber.equals(matchedNumber) && rank.matchedBonusNumber == matchedBonusNumber) {
                return rank;
            }
        }
        return OTHERS;
    }
}
