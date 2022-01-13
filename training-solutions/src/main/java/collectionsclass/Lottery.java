package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("Ball count must be bigger than drawn numbers!");
        }
        List<Integer> ballPool = createBallPool(ballCount);
        Collections.shuffle(ballPool);
        List<Integer> winningNumbers = ballPool.subList(0, lotteryType);
        Collections.sort(winningNumbers);
        return winningNumbers;
    }

    private List<Integer> createBallPool(int ballCount) {
        List<Integer> ballPool = new ArrayList<>();
        for (int i = 1; i <= ballCount; i++) {
            ballPool.add(i);
        }
        return ballPool;
    }
}
