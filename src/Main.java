import static java.lang.System.exit;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            printMenu();
            int num = 0;
            try {
                num = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("숫자만 입력이 가능합니다.");
                continue;
            }

            switch (num) {
                case 1:
                    printOption("ShackBurger", 6900);
                    break;
                case 2:
                    printOption("SmokeShack", 8900);
                    break;
                case 3:
                    printOption("Cheeseburger", 6900);
                    break;
                case 4:
                    printOption("Hamburger", 5400);
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    exit(0);
                default:
                    System.out.println("없는 메뉴입니다. 다시 선택하세요.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("[ SHAKESHACK MENU ]");
        System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        System.out.println("3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        System.out.println("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
        System.out.println("0. 종료           | 종료");
        System.out.print("메뉴를 선택하세요: ");
    }

    private static void printOption(String menu, int price) {
        System.out.println(menu + "를 선택했습니다. 가격은 " + price + "입니다");
    }
}