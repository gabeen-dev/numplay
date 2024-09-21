package numplay;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Character.getNumericValue;
import static java.lang.Character.isDigit;

public class BaseballGame {
    public static void main(String[] args) {
        System.out.println("< 게임을 시작합니다 >");
        Scanner scanner = new Scanner(System.in);

        // TODO : 램덤값 생성

        //제네릭(<>)에선 무조건 클래스타임을 써야한다
        List<Integer> answers = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        answers.add(4);
        answers.add(2);
        answers.add(3);


        int strikeCnt = 0;
        int ballCnt = 0;
        int outCnt = 0;

        while (true) {

            //게임 초기화
            strikeCnt = 0;
            ballCnt = 0;
            outCnt = 0;
            numbers.clear();

            System.out.println("숫자를 입력하세요");
            String input = scanner.nextLine();

            // TODO : 인터페이스 List학습


            for (char ch : input.toCharArray()) {

                // 문자 예외 처리
                // isDigit : 숫자인지 체크하는 메서트 /클래스 Character의 메서드 중 하나
                if (!isDigit(ch)) {
                    // throw : 예외를 던지다/ 에외 처리 학습
                    throw new RuntimeException("숫자만 입력 가능");
                }

                

                numbers.add(getNumericValue(ch));
            }

            // ball 체크 ChatGPT가져옴
            for (int i = 0; i < numbers.size(); i++) {
                if (answers.contains(numbers.get(i)) && !answers.get(i).equals(numbers.get(i))) {
                    ballCnt++;
                }
            }

            // streik 체크 ChatGPT가져옴
            for (int i = 0; i < answers.size(); i++) {
                if (answers.get(i).equals(numbers.get(i))) {
                    strikeCnt++;
                }
            }

            // out 체크 ChatGPT가져옴
            for (int i = 0; i < numbers.size(); i++) {
                if (!answers.contains(numbers.get(i))) {
                    outCnt++;
                }
            }

            // 정답 체크
            if (strikeCnt == answers.size()) {
                System.out.println("정답입니다.");
                break;
            } else {
                System.out.println("strike : " + strikeCnt + ", ball : " + ballCnt + ", out : " + outCnt);
            }



// 중복 값, 0 예외 처리



        }


    }
}
