package numplay;

import java.util.*;

import static java.lang.Character.getNumericValue;
import static java.lang.Character.isDigit;

public class BaseballGame {
    public static void main(String[] args) {
        System.out.println("< 게임을 시작합니다 >");
        Scanner scanner = new Scanner(System.in);

        //ball, out, strike 인스턴스 생성
        Checkballcnt checkballcnt = new Checkballcnt();
        Checkstrikecnt checkstrikecnt = new Checkstrikecnt();
        Checkoutcnt checkoutcnt = new Checkoutcnt();
        RendomNum rendomNum = new RendomNum();

        //제네릭(<>)에선 무조건 클래스타임을 써야한다
        List<Integer> answers = rendomNum.create();
        //사용자에게 받을 값
        List<Integer> numbers = new ArrayList<>();

        int strikeCnt, ballCnt, outCnt;

        while (true) {
            try {
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
                        // 예외처리 이후 게임 재시작 할 수 없음 -> try catch 사용
                        throw new RuntimeException("숫자만 입력 해 주세요");
                    } else if (isDigit(ch) && ch =='0') {
                        throw new RuntimeException("1~9까지 숫자를 사용해 주세요");
                    }

                    // 숫자 중복 처리
                    int number = getNumericValue(ch);
                    if (numbers.contains(number)) {
                        throw new RuntimeException("중복된 숫자가 있습니다: " + number);
                    }

                    //숫자 자릿수 예외 처리
                    if (input.length() != 3) {
                        throw new RuntimeException("세 자리 숫자를 입력해 주세요.");
                    }
                    numbers.add(number);
                }

                // ball 체크(리턴 값을 받아서 할당)
                ballCnt = checkballcnt.chekballcnt(ballCnt, numbers, answers);
                // strike 체크(리턴 값을 받아서 할당)
                strikeCnt = checkstrikecnt.checkstrikecnt(strikeCnt, numbers, answers);
                // out 체크(리턴 값을 받아서 할당)
                outCnt = checkoutcnt.checkoutcnt(outCnt, numbers, answers);

                // 정답 체크
                if (strikeCnt == answers.size()) {
                    System.out.println("정답입니다.");
                    break;
                } else {
                    System.out.println("strike : " + strikeCnt + ", ball : " + ballCnt + ", out : " + outCnt);
                }

            } catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
