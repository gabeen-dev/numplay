package numplay;

import java.util.*;

public class RendomNum {

    public List<Integer> create() {
        int maxLength = 3; //숫자자리 제한
        Random random = new Random();

        Set<Integer> uniqueDigits = new HashSet<>(); //증복을 막기 위해 Set 사용

        while (uniqueDigits.size() < maxLength) {
            int digit = random.nextInt(9) + 1; // 0부터 9까지의 숫자 중 하나를 선택
            uniqueDigits.add(digit); // 중복되지 않으면 Set에 추가됨
        }
        return new ArrayList<>(uniqueDigits);
    }

}
