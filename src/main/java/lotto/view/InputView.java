package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {


    public String inputBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return numberList(Console.readLine());
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> numberList(String input) {
        String[] numbers = input.split(",");
        List<Integer> winningNumberList = new ArrayList<Integer>();
        for (String number : numbers) {
            winningNumberList.add(Integer.parseInt(number));
        }
        return winningNumberList;
    }
}
