package io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class KioskInput {
    static Scanner sc = new Scanner(System.in);

    public static int inputNumber() {
        try {
            String input = sc.nextLine().trim();
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

    public static String inputMenuName() {
        System.out.print("장바구니에서 제외할 메뉴를 입력해주세요: ");
        String input = sc.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("장바구니에서 제외할 메뉴를 입력해주세요.");
        }
        return input;
    }
}
