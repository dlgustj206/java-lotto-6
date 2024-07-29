package lotto.utils;

import lotto.utils.exception.AmountNotDivisibleByThousandException;
import lotto.utils.exception.DuplicatedNumberException;
import lotto.utils.exception.InvalidLottoSizeException;
import lotto.utils.exception.OutOfRangeNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void amountValidatorTest() {
        assertThatThrownBy(() -> InputValidator.amountValidator(1500))
                .isInstanceOf(AmountNotDivisibleByThousandException.class);
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void winningNumberValidatorTest() {
        assertThatThrownBy(() -> InputValidator.winningNumberValidator(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(InvalidLottoSizeException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void bonusNumberValidatorDuplicatedTest() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> InputValidator.bonusNumberValidator("1", winningNumbers))
                .isInstanceOf(DuplicatedNumberException.class);
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void bonusNumberValidatorOutOfRangeTest() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> InputValidator.bonusNumberValidator("46", winningNumbers))
                .isInstanceOf(OutOfRangeNumberException.class);
    }
}