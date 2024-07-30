package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberList {

    public static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> lottoNumberList = new ArrayList<>(lottoNumbers);
        Collections.sort(lottoNumberList);
        return lottoNumberList;
    }
}
