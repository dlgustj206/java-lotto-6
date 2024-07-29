package lotto.controller;

import lotto.utils.InputValidator;
import lotto.utils.exception.AmountNotDivisibleByThousandException;
import lotto.view.InputView;
import lotto.view.OutputView;

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
}
