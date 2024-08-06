package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberList;
import lotto.domain.Profit;
import lotto.domain.Rank;
import lotto.dto.LottoTicketDto;
import lotto.utils.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Integer amount = initBuyAmount();
        Integer ticketCount = amount / 1000;
        outputView.printBuyAmount(ticketCount);

        List<Lotto> lottoTickets = generateLottoTickets(ticketCount);
        List<LottoTicketDto> lottoTicketDTOs = convertLottoTicketDTOs(lottoTickets);
        outputView.printLottoTickets(lottoTicketDTOs);

        Lotto winningLotto = initWinningNumbers();
        Integer bonusNumber = initBonusNumber(winningLotto);

        Map<Rank, Integer> result = calculateRank(lottoTickets, winningLotto, bonusNumber);
        outputView.printRank(result);

        Profit profit = new Profit(result, amount);
        Double profitRate = profit.calculateProfitRate();
        outputView.printProfitRate(profitRate);
    }

    public Integer initBuyAmount() {
        while (true) {
            try {
                String amount = inputView.inputBuyAmount();
                Integer initAmount = Integer.valueOf(amount);
                InputValidator.amountValidator(initAmount);
                return initAmount;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public List<Lotto> generateLottoTickets(Integer ticketCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = LottoNumberList.generateLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    public Lotto initWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = inputView.inputWinningNumber();
                InputValidator.winningNumberValidator(winningNumbers);
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public Integer initBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                String bonusNumber = inputView.inputBonusNumber();
                InputValidator.bonusNumberValidator(bonusNumber, winningNumbers.getNumbers());
                return Integer.valueOf(bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Map<Rank, Integer> calculateRank(List<Lotto> lottoTickets, Lotto winningLotto, Integer bonusNumber) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Lotto ticket : lottoTickets) {
            Integer matchedCount = countMatchedNumbers(ticket.getNumbers(), winningLotto.getNumbers());
            boolean matchedBonus = ticket.getNumbers().contains(bonusNumber);
            Rank rank = Rank.setRank(matchedCount, matchedBonus);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount;
    }

    private Integer countMatchedNumbers(List<Integer> ticketNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : ticketNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private List<LottoTicketDto> convertLottoTicketDTOs(List<Lotto> lottoTickets) {
        List<LottoTicketDto> lottoTicketDtos = new ArrayList<>();
        for (Lotto ticket : lottoTickets) {
            lottoTicketDtos.add(new LottoTicketDto(ticket.getNumbers()));
        }
        return lottoTicketDtos;
    }
}
