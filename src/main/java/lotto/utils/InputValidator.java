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

        for (Integer number : inputNumber) {
            if (number == null) {
                throw new NullPointerException();
            }
            if (number < 1 || number > 45) {
                throw new OutOfRangeNumberException();
            }
        }
    }

    public static void bonusNumberValidator(String inputNumber, List<Integer> winningNumbers) {
        if (inputNumber.isEmpty()) {
            throw new EmptyInputException();
        }

        int num = Integer.parseInt(inputNumber);
        if (num < 1 || num > 45) {
            throw new OutOfRangeNumberException();
        }
        if (winningNumbers.contains(num)) {
            throw new DuplicatedNumberException();
        }
    }
}
