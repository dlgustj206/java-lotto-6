package lotto.utils;

import lotto.utils.exception.*;

public class InputValidator {

    public static void amountValidator(Integer amount) {
        if (amount % 1000 != 0) {
            throw new AmountNotDivisibleByThousandException();
        }
    }
}
