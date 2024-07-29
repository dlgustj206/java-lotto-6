package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberList;
import lotto.utils.InputValidator;
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

        List<Lotto> lottoTickets = generateLottoTickets(ticketCount);
        outputView.printLottoTickets(lottoTickets);

        Lotto winningNumbers = initWinningNumbers();
        Integer bonusNumber = initBonusNumber(winningNumbers);
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
}
