package numplay;

import java.util.List;

public class Checkstrikecnt {
    public void checkstrikecnt(int strikeCnt, List<Integer> numbers, List<Integer> answers) {
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).equals(numbers.get(i))) {
                strikeCnt++;
            }
        }
    }
}
