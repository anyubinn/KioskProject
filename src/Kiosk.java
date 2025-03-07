import static java.lang.System.exit;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    List<MenuItem> menuItems;

    Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    void start() {
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

    void printMenu() {
        System.out.println("[ SHAKESHACK MENU ]");
        int index = 1;
        for (MenuItem menuItem : menuItems) {
            System.out.println(index++ + ". " + menuItem.name + " | " + menuItem.price + " | " + menuItem.comment);
        }
        System.out.println("0. 종료 | 종료");
        System.out.print("메뉴를 선택하세요: ");
    }

    void printOption(String menu, int price) {
        System.out.println(menu + "를 선택했습니다. 가격은 " + price + "원입니다.");
    }
}
