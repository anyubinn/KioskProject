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
                chooseCategory(menus);
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void chooseCategory(List<Menu> menus) {
        int num = KioskInput.inputNumber();

        if (num == 0) {
            System.out.println("프로그램을 종료합니다.");
            exit(0);
        }

        if (menus.size() < num) {
            System.out.println("없는 메뉴입니다. 다시 선택하세요.");
            return;
        }
        Menu menu = menus.get(num - 1);
        KioskOutput.printMenu(menu.getCategory(), menu.getMenuItems());
        chooseMenu(menu.getMenuItems());
    }

    private void chooseMenu(List<MenuItem> menuItems) {
        int num = KioskInput.inputNumber();

        if (num == 0) {
            System.out.println("선택을 취소합니다.");
            return;
        }

        if (menuItems.size() < num) {
            System.out.println("없는 메뉴입니다. 다시 선택하세요.");
            return;
        }
        MenuItem menuItem = menuItems.get(num - 1);
        KioskOutput.printOption(menuItem.getName(), menuItem.getPrice());
    }
}
