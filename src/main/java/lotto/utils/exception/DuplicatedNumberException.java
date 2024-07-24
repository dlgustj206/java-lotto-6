package lotto.utils.exception;

public class DuplicatedNumberException extends IllegalArgumentException{
    public DuplicatedNumberException() {
        super("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
    }
}
