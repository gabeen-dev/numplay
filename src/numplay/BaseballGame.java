package numplay;

import java.util.*;

import static java.lang.Character.getNumericValue;
import static java.lang.Character.isDigit;

public class BaseballGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //ball, out, strike 인스턴스
        Checkballcnt checkballcnt = new Checkballcnt();
        Checkstrikecnt checkstrikecnt = new Checkstrikecnt();
        Checkoutcnt checkoutcnt = new Checkoutcnt();
        RendomNum rendomNum = new RendomNum();

        while (true) {//정답을 맞추면 다시 시작
            System.out.println("< 게임을 시작합니다 >");

            List<Integer> answers = rendomNum.create();  // 외부 루프: 새로운 정답 생성
            List<Integer> numbers = new ArrayList<>();
            int strikeCnt, ballCnt, outCnt;

            while (true) {  // 내부 루프: 정답을 맞추면 탈출
                try {
                    //게임 초기화
                    strikeCnt = 0;
                    ballCnt = 0;
                    outCnt = 0;
                    numbers.clear();

                    System.out.println("숫자를 입력하세요");
                    String input = scanner.nextLine();// 사용자아게 값을 받음

                    for (char ch : input.toCharArray()) {

                        // 문자 예외 처리
                        if (!isDigit(ch)) {  // isDigit : 숫자인지 체크하는 메서트 /클래스 Character의 메서드 중 하나
                            throw new RuntimeException("숫자만 입력 해 주세요");

                        } else if (ch == '0') {// 0 에외 처리
                            throw new RuntimeException("1~9까지 숫자를 사용해 주세요");
                        }

                        int number = getNumericValue(ch);// 숫자 중복 처리
                        if (numbers.contains(number)) {
                            throw new RuntimeException("중복된 숫자가 있습니다: " + number);
                        }

                        if (input.length() != 3) { //숫자 자릿수 예외 처리
                            throw new RuntimeException("세 자리 숫자를 입력해 주세요.");
                        }
                        numbers.add(number);
                    }

                    ballCnt = checkballcnt.chekballcnt(ballCnt, numbers, answers);// ball 체크(리턴 값을 받아서 할당)
                    strikeCnt = checkstrikecnt.checkstrikecnt(strikeCnt, numbers, answers);// strike 체크(리턴 값을 받아서 할당)
                    outCnt = checkoutcnt.checkoutcnt(outCnt, numbers, answers);// out 체크(리턴 값을 받아서 할당)

                    // 정답 체크
                    if (strikeCnt == answers.size()) {
                        System.out.println("정답입니다.");
                        break;
                    } else {
                        System.out.println("strike : " + strikeCnt + ", ball : " + ballCnt + ", out : " + outCnt);
                    }

                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
