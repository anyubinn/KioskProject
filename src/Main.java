import static java.lang.System.exit;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<MenuItem> menuItems = new ArrayList<>();

    public static void main(String[] args) {
        menuItems.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));
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
                    printOption(menuItems.get(0).name, menuItems.get(0).price);
                    break;
                case 2:
                    printOption(menuItems.get(1).name, menuItems.get(1).price);
                    break;
                case 3:
                    printOption(menuItems.get(2).name, menuItems.get(2).price);
                    break;
                case 4:
                    printOption(menuItems.get(3).name, menuItems.get(3).price);
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
        int index = 1;
        for (MenuItem menuItem : menuItems) {
            System.out.println(index++ + ". " + menuItem.name + " | " + menuItem.price + " | " + menuItem.comment);
        }
        System.out.println("0. 종료 | 종료");
        System.out.print("메뉴를 선택하세요: ");
    }

    private static void printOption(String menu, int price) {
        System.out.println(menu + "를 선택했습니다. 가격은 " + price + "원입니다.");
    }
}