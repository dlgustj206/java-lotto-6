package lotto.view;

import lotto.domain.Rank;
import lotto.dto.LottoTicketDto;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printBuyAmount(Integer num) {
        System.out.println();
        System.out.println(num + "개를 구매했습니다.");
    }

    public void printLottoTickets(List<LottoTicketDto> lottoTickets) {
        for (LottoTicketDto ticket : lottoTickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public void printRank(Map<Rank, Integer> result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.getOrDefault(Rank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getOrDefault(Rank.FIRST, 0) + "개");
    }

    public void printProfitRate(Double profitRate) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", profitRate));
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
