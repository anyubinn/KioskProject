package io;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 사용자로부터 입력을 받는 클래스이다.
 */
public class KioskInput {
    static Scanner sc = new Scanner(System.in);

    /**
     * 사용자로부터 숫자를 입력받는다.
     * @return 사용자가 입력한 숫자
     * @throws InputMismatchException 숫자가 아닌 것을 입력했을 떄
     * @throws NumberFormatException 입력한 것을 숫자로 변환할 수 없을 떄
     */
    public static int inputNumber() {
        try {
            String input = sc.nextLine().trim();
            // 공백인 경우
            if (input.isEmpty()) {
                System.out.println("숫자를 입력해주세요.");
            }
            return Integer.parseInt(input);
        } catch (InputMismatchException e) {
            sc.nextLine();
            throw new InputMismatchException("숫자만 입력이 가능합니다.");
        } catch (NumberFormatException e) {
            throw new NumberFormatException("없는 메뉴입니다. 다시 입력하세요.");
        }
    }

    /**
     * 사용자로부터 장바구니에서 제외할 메뉴를 입력받는다.
     * @return 사용자가 입력한 문자열
     */
    public static String inputMenuName() {
        System.out.print("장바구니에서 제외할 메뉴를 입력해주세요: ");
        String input = sc.nextLine().trim();
        // 공백인 경우
        if (input.isEmpty()) {
            System.out.println("장바구니에서 제외할 메뉴를 입력해주세요.");
        }
        return input;
    }
}
