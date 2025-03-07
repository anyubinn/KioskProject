import static java.lang.System.exit;

import io.KioskOutput;
import java.util.InputMismatchException;
import java.util.List;
import io.KioskInput;
import menu.Menu;
import menu.MenuItem;

public class Kiosk {

    private List<Menu> menus;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {

        while (true){
            try {
                KioskOutput.printCategory(menus);
                int num1 = KioskInput.inputNumber();
                switch (num1) {
                    case 1:
                        KioskOutput.printMenu(menus.get(0).menuItems);
                        chooseMenu(menus.get(0).menuItems);
                        break;
                    case 2:
                        KioskOutput.printMenu(menus.get(1).menuItems);
                        chooseMenu(menus.get(1).menuItems);
                        break;
                    case 3:
                        KioskOutput.printMenu(menus.get(2).menuItems);
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

    private void chooseMenu(List<MenuItem> menuItems) {
        int num = KioskInput.inputNumber();
        switch (num) {
            case 1:
                KioskOutput.printOption(menuItems.get(0).name, menuItems.get(0).price);
                break;
            case 2:
                KioskOutput.printOption(menuItems.get(1).name, menuItems.get(1).price);
                break;
            case 3:
                KioskOutput.printOption(menuItems.get(2).name, menuItems.get(2).price);
                break;
            case 4:
                KioskOutput.printOption(menuItems.get(3).name, menuItems.get(3).price);
                break;
            case 0:
                System.out.println("선택을 취소합니다.");
                break;
            default:
                System.out.println("없는 메뉴입니다. 다시 선택하세요.");
        }
    }
}
