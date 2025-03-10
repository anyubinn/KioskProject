import static java.lang.System.exit;

import cart.Cart;
import io.KioskOutput;
import java.util.InputMismatchException;
import java.util.List;
import io.KioskInput;
import menu.Menu;
import menu.MenuItem;

public class Kiosk {

    private List<Menu> menus;
    private Cart carts;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
        this.carts = new Cart();
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

        if (num == 4) {
            int totalPrice = carts.getTotalPrice();
            KioskOutput.printAllCarts(carts, totalPrice);
            return;
        }

        if (num == 5) {
            System.out.println("장바구니에 담긴 메뉴를 전부 삭제합니다.");
            carts.clear();
            return;
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
        addCart(menuItem);
    }

    private void addCart(MenuItem menuItem) {
        int num = KioskInput.inputNumber();

        if (num == 2) {
            System.out.println("선택을 취소합니다.");
            return;
        }

        if (num != 1) {
            System.out.println("없는 메뉴입니다. 다시 선택하세요.");
            return;
        }

        carts.addItem(menuItem);
        KioskOutput.printOneCart(menuItem.getName());
    }
}
