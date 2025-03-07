import static java.lang.System.exit;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    List<Menu> menus;

    Scanner sc = new Scanner(System.in);

    Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    void start() {

        while (true){
            try {
                printCategory();
                int num1 = inputNumber();
                switch (num1) {
                    case 1:
                        printMenu(menus.get(0).menuItems);
                        chooseMenu(menus.get(0).menuItems);
                        break;
                    case 2:
                        printMenu(menus.get(1).menuItems);
                        chooseMenu(menus.get(1).menuItems);
                        break;
                    case 3:
                        printMenu(menus.get(2).menuItems);
                        chooseMenu(menus.get(2).menuItems);
                        break;
                    case 0:
                        System.out.println("프로그램을 종료합니다.");
                        exit(0);
                    default:
                        System.out.println("없는 메뉴입니다. 다시 선택하세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    void printCategory() {
        System.out.println("[ MAIN MENU ]");
        int index = 1;
        for (Menu menu : menus) {
            System.out.println(index++ + ". " + menu.category);
        }
        System.out.println("0. 종료 | 종료");
        System.out.print("카테고리를 입력하세요: ");
    }

    void printMenu(List<MenuItem> menuItems) {
        System.out.println("[ SHAKESHACK MENU ]");
        int index = 1;
        for (MenuItem menuItem : menuItems) {
            System.out.println(index++ + ". " + menuItem.name + " | " + menuItem.price + " | " + menuItem.comment);
        }
        System.out.println("0. 뒤로가기 | 뒤로가기");
        System.out.print("메뉴를 선택하세요: ");
    }

    int inputNumber() {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            sc.nextLine();
            throw new InputMismatchException("숫자만 입력이 가능합니다.");
        }
    }

    void chooseMenu(List<MenuItem> menuItems) {
        int num = inputNumber();
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
                System.out.println("선택을 취소합니다.");
                break;
            default:
                System.out.println("없는 메뉴입니다. 다시 선택하세요.");
        }
    }

    void printOption(String menu, int price) {
        System.out.println(menu + "를 선택했습니다. 가격은 " + price + "원입니다.");
    }
}
