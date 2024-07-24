package lotto.utils.exception;

public class InvalidLottoSizeException extends IllegalArgumentException{
    public InvalidLottoSizeException() {
        super("[ERROR] 로또 번호는 6개여야 합니다.");
    }
}
