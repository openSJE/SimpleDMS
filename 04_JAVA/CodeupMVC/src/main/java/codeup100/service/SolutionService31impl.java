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
public class SolutionService21impl implements SolutionService{


    @Override
    public Solution CodeUp1001(Solution solution) {
        Scanner scanner = new Scanner;
        System.out.print("단어를 입력해 주세요:");

        solution.setStrResult(scanner.nextLine());
        return solution;
    }


//    1022
    public Solution CodeUp1002(Solution solution) {
        Scanner scanner = new Scanner;
        System.out.print("문장을 입력해 주세요:");

        solution.setStrResult(scanner.nextLine());
        return solution;
    }

//     1023
    public Solution CodeUp1003(Solution solution) {
        Scanner scanner = new Scanner;
        System.out.print("첫 번째 줄에 정수 부분을, 두 번째 줄에 실수 부분을 출력한다.");
        String[] result = scanner.nextLine().split("\\.");

        solution.setStrResult(result[0] + "\n" + result[1]);
        return solution;
    }

//   1024 Boy
    public Solution CodeUp1004(Solution solution) {
        Scanner scanner = new Scanner;
        System.out.print("단어를 입력하세요.");
        String result = scanner.nextLine();

        String result2 = "";

//        *문자열.charAt(인덱스번호) : 문자열에서 인덱스번호에 해당하는 한문자 가져오기
        for (int i = 0; i < result.length(); i++) {
            result2 += "'" + result.charAt(i) + "'" + "\n"
        }
        solution.setStrResult(result2);
        return solution;
    }

//   1025
    public Solution CodeUp1005(Solution solution) {
        Scanner scanner = new Scanner;
        System.out.print("숫자 다섯자리를 입력해주세요");
        String result = scanner.nextLine();

        int result2 = 0;
        result2 =

        solution.setStrResult();
        return solution;
    }


    public Solution CodeUp1006(Solution solution) {
        solution.setStrResult("23");
        return solution;
    }


    public Solution CodeUp1007(Solution solution) {
        solution.setStrResult("15-07-2014 ");
        return solution;
    }


    public Solution CodeUp1008(Solution solution) {
        solution.setStrResult("2147483648");
        return solution;
    }


    public Solution CodeUp1010(Solution solution) {
        solution.setStrResult("3.14159265359");
        return solution;
    }




}
