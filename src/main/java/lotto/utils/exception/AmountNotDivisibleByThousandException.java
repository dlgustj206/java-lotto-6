package lotto.utils.exception;

public class AmountNotDivisibleByThousandException extends IllegalArgumentException{
    public AmountNotDivisibleByThousandException() {
        super("구입 금액은 1,000원 단위로 입력해야 합니다.");
    }
}
