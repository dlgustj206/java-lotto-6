package lotto.utils.exception;

public class EmptyInputException extends IllegalArgumentException{
    public EmptyInputException() {
        super("입력이 비어 있습니다.");
    }
}
