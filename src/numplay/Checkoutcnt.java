package numplay;

import java.util.List;

public class Checkoutcnt {
    public int checkoutcnt(int outCnt, List<Integer> numbers, List<Integer> answers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (!answers.contains(numbers.get(i))) {
                outCnt++;
            }
        }
        return outCnt;
    }
}
