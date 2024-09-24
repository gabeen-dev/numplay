package numplay;

import java.util.List;

public class Checkballcnt {
    // 파라미터의 갯수를 참조와 맞춰 줘야 한다
    public void chekballcnt(int ballCnt,  List<Integer> numbers, List<Integer> answers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (answers.contains(numbers.get(i)) && !answers.get(i).equals(numbers.get(i))) {
                ballCnt++;
            }
        }
    }
}
