package lotto.domain;

import lotto.global.constant.LottoRankAndPrize;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static lotto.global.constant.LottoConstant.*;

public class LottoResult {

    private static final int NONE = 0;

    private final Map<LottoRankAndPrize, Integer> totalRanks;
    private final int lottoPurchasePrice;
    private int totalPrize = NONE;

    public LottoResult(int lottoPurchasePrice) {
        this.totalRanks = new HashMap<>();
        this.lottoPurchasePrice = lottoPurchasePrice;
    }

    public void accumulateLottoResult(LottoRankAndPrize lottoRankAndPrize){
        if(totalRanks.containsKey(lottoRankAndPrize)){
            totalRanks.put(lottoRankAndPrize, totalRanks.get(lottoRankAndPrize) + 1);
            return;
        }
        totalRanks.put(lottoRankAndPrize, 1);
    }

    public int getLottoPurchasePrice() {
        return lottoPurchasePrice;
    }

    public int calculateTotalPrize(){
        int totalPrize = 0;

        for (Map.Entry<LottoRankAndPrize, Integer> entry : totalRanks.entrySet()) {
            LottoRankAndPrize rankAndPrize = entry.getKey();
            int count = entry.getValue();
            totalPrize += rankAndPrize.getPrize() * count;
        }
        this.totalPrize = totalPrize;
        return totalPrize;
    }

    public int getTotalPrizeAmount() {
        return totalPrize;
    }
}