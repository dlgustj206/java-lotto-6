package lotto.utils;

import lotto.utils.exception.*;

import java.util.List;

public class InputValidator {

    public static void amountValidator(Integer amount) {
        if (amount % 1000 != 0) {
            throw new AmountNotDivisibleByThousandException();
        }
    }

    public static void winningNumberValidator(List<Integer> inputNumber) {
        if (inputNumber.isEmpty()) {
            throw new EmptyInputException();
        }
        if (inputNumber.size() != 6) {
            throw new InvalidLottoSizeException();
        }

        for (Integer number : inputNumber) {
            if (number == null) {
                throw new NullPointerException();
            }
            if (number < 1 || number > 45) {
                throw new OutOfRangeNumberException();
            }
        }
    }
}
