package codeup100.service;

import codeup100.model.Solution;

import java.util.Scanner;

/**
 * packageName : codeup100.service
 * fileName : SolutionService
 * author : ds
 * date : 2022-10-11
 * description : 구현클래스 - 업무로직 함수들의 모임
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-11         ds          최초 생성
 */
public class SolutionServiceimpl implements SolutionService{
    @Override
    public Solution CodeUp1001(Solution solution) {
//        Setter / Getter 함수를 이용
//        속성은 접근 금지
//        속성에 값을 저장
        solution.setStrResult("Hello");
        return solution;
    }

    public Solution CodeUp1002(Solution solution){
        solution.setStrResult("Hello World");
        return solution;
    }

    public Solution CodeUp1003(Solution solution){
        solution.setStrResult("Hello"+ "\n" +"World");
        return solution;
    }

    public Solution CodeUp1004(Solution solution){
        solution.setStrResult("'Hello'");
        return solution;
    }

    public Solution CodeUp1005(Solution solution){
        solution.setStrResult("\"Hello World\"");
        return solution;
    }

    public Solution CodeUp1006(Solution solution){
        solution.setStrResult("\"!@#$%^&*()\"");
        return solution;
    }

    public Solution CodeUp1007(Solution solution){
        solution.setStrResult("\"C:\\Download\\hello.cpp\"");
        return solution;
    }

    public Solution CodeUp1008(Solution solution){
        solution.setStrResult("\u250C\u252C\u2510\n\u251C\u253C\u2524\n\u2514\u2534\u2518");
        return solution;
    }

    public Solution CodeUp1010(Solution solution){
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수를 입력해주세요.");
        solution.setStrResult(String.valueOf(scanner.nextInt()));
        return solution;
    }


}
