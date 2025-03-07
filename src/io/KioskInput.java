package io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class KioskInput {
    static Scanner sc = new Scanner(System.in);

    public static int inputNumber() {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            sc.nextLine();
            throw new InputMismatchException("숫자만 입력이 가능합니다.");
        }
    }
}
