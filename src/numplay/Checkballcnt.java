package numplay;

import java.util.List;

public class Checkballcnt {

    public int chekballcnt(int ballCnt, List<Integer> numbers, List<Integer> answers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (answers.contains(numbers.get(i)) && !answers.get(i).equals(numbers.get(i))) {
                ballCnt++;
            }
        }
        return ballCnt;
    }
}
