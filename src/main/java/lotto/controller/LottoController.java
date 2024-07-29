package lotto.controller;

import lotto.domain.LottoNumberList;
import lotto.utils.InputValidator;
import lotto.utils.exception.AmountNotDivisibleByThousandException;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

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

        List<List<Integer>> lottoTickets = generateLottoTickets(ticketCount);
        outputView.printLottoTickets(lottoTickets);
    }

    public Integer initBuyAmount() {
        while (true) {
            try {
                String amount = inputView.inputBuyAmount();
                Integer initAmount = Integer.valueOf(amount);
                InputValidator.amountValidator(initAmount);
                return initAmount;
            } catch (AmountNotDivisibleByThousandException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public List<List<Integer>> generateLottoTickets(Integer ticketCount) {
        List<List<Integer>> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(LottoNumberList.generateLottoNumbers());
        }
        return lottoTickets;
    }
}
