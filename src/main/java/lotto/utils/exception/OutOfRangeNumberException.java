package lotto.utils.exception;

public class OutOfRangeNumberException extends IllegalArgumentException{
    public OutOfRangeNumberException() {
        super("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
