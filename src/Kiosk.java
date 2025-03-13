import static java.lang.System.exit;

import cart.Cart;
import cart.Discount;
import io.KioskOutput;
import java.util.InputMismatchException;
import java.util.List;
import io.KioskInput;
import menu.Menu;
import menu.MenuItem;

/**
 * 키오스크와 관련된 기능을 처리하는 클래스
 */
public class Kiosk {

    private List<Menu> menus;
    private Cart carts;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
        this.carts = new Cart();
    }

    /**
     * 키오스크의 전반적인 과정을 담당한다.
     */
    public void start() {

        while (true){
            try {
                // 메뉴 카테고리 선택
                KioskOutput.printCategory(menus);
                chooseCategory(menus);
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 선택한 카테고리에 해당하는 메뉴를 출력하고, 메뉴 선택을 처리한다.
     * @param menus 메뉴 리스트
     */
    private void chooseCategory(List<Menu> menus) {
        // 카테고리 번호 입력
        int num = KioskInput.inputNumber();

        if (num == 0) {
            System.out.println("프로그램을 종료합니다.");
            exit(0);
        }

        if (num == 4) {
            // 구매
            purchaseItem();
            return;
        }

        if (num == 5) {
            // 장바구니가 비었는지 검사
            if (carts.isEmpty()) {
                System.out.println("장바구니에 담긴 메뉴가 없습니다.");
                return;
            }
            // 장바구니 비우기
            System.out.println("장바구니에 담긴 메뉴를 전부 삭제합니다.");
            carts.clear();
            return;
        }

        // 메뉴 번호와 다른 번호를 입력한 경우
        if (menus.size() < num) {
            System.out.println("없는 메뉴입니다. 다시 선택하세요.");
            return;
        }
        // 선택한 카테고리에 해당하는 메뉴 출력
        Menu menu = menus.get(num - 1);
        KioskOutput.printMenu(menu.getCategory(), menu.getMenuItems());
        // 메뉴 아이템 선택
        chooseMenu(menu.getMenuItems());
    }

    /**
     * 주문하고 싶은 메뉴 아이템을 선택한다.
     * @param menuItems 주문하고 싶은 메뉴 아이템
     */
    private void chooseMenu(List<MenuItem> menuItems) {
        // 주문하고 싶은 메뉴 아이템 번호 입력
        int num = KioskInput.inputNumber();

        if (num == 0) {
            System.out.println("선택을 취소합니다.");
            return;
        }

        // 메뉴 아이템 번호와 다른 번호를 입력한 경우
        if (menuItems.size() < num) {
            System.out.println("없는 메뉴입니다. 다시 선택하세요.");
            return;
        }
        // 메뉴 아이템을 장바구니에 추가
        MenuItem menuItem = menuItems.get(num - 1);
        KioskOutput.printOption(menuItem.getName(), menuItem.getPrice());
        addCart(menuItem);
    }

    /**
     * 선택한 메뉴 아이템을 장바구니에 추가한다.
     * @param menuItem 장바구니에 추가할 메뉴 아이템
     */
    private void addCart(MenuItem menuItem) {
        // 장바구니에 담을지 번호 입력
        int num = KioskInput.inputNumber();

        if (num == 2) {
            System.out.println("선택을 취소합니다.");
            return;
        }

        // 선택사항에 없는 번호를 입력한 경우
        if (num != 1) {
            System.out.println("없는 메뉴입니다. 다시 선택하세요.");
            return;
        }

        // 장바구니에 메뉴 아이템 추가
        carts.addItem(menuItem);
        // 장바구니에 담은 메뉴 아이템 정보 출력
        KioskOutput.printOneCart(menuItem.getName());
    }

    /**
     * 장바구니에 담긴 메뉴 아이템을 결제한다.
     */
    private void purchaseItem() {
        // 장바구니에 담긴 메뉴 아이템의 총액을 계산
        int totalPrice = carts.getTotalPrice();
        // 장바구니가 빈 경우
        if (carts.isEmpty()) {
            System.out.println("장바구니에 담긴 메뉴가 없습니다. 장바구니를 담아주세요.");
            return;
        }
        // 장바구니에 담은 전체 메뉴 아이템 정보 출력
        KioskOutput.printAllCarts(carts, totalPrice);
        // 결제, 메뉴판, 장바구니 제거 중 번호 입력
        int num = KioskInput.inputNumber();

        switch (num) {
            case 1 -> {
                // 할인 정보 계산
                calculateDiscountPrice(totalPrice);
            }
            case 2 -> {
                System.out.println("메뉴판으로 돌아갑니다.");
            }
            case 3 -> {
                // 장바구니에서 제거할 메뉴 아이템 선택
                removeCartItem();
            }
            // 선택사항에 없는 번호를 입력한 경우
            default -> {
                System.out.println("없는 메뉴입니다. 다시 선택하세요.");
            }
        }
    }

    /**
     * 할인 유형을 선택하여 최종 결제 금액을 계산한다.
     * @param totalPrice 할인 금액을 적용하기 전 총액
     */
    private void calculateDiscountPrice(int totalPrice) {
        // 할인 대상에 해당하는지 선택
        KioskOutput.printDiscountInfo();
        int num = KioskInput.inputNumber();
        boolean isValidNumber = true;

        int totalDiscountPrice = 0;

        switch (num) {
            case 1 -> {
                totalDiscountPrice = Discount.PATRIOT.getTotalDiscountPrice(totalPrice);
            }
            case 2 -> {
                totalDiscountPrice = Discount.SOLDIER.getTotalDiscountPrice(totalPrice);
            }
            case 3 -> {
                totalDiscountPrice = Discount.STUDENT.getTotalDiscountPrice(totalPrice);
            }
            case 4 -> {
                totalDiscountPrice = Discount.COMMONER.getTotalDiscountPrice(totalPrice);
            }
            default -> {
                System.out.println("없는 메뉴입니다. 다시 선택하세요.");
                isValidNumber = false;
            }
        }

        // 유효한 번호를 입력한 경우
        if (isValidNumber) {
            // 할인 적용 후 최종 금액 출력
            KioskOutput.printTotalPrice(totalDiscountPrice);
            // 장바구니 비우기
            carts.clear();
        }
    }

    /**
     * 입력한 메뉴 아이템을 장바구니에서 제거한다.
     */
    private void removeCartItem() {
        // 장바구니에서 제거할 메뉴 아이템 이름 입력
        String menuName = KioskInput.inputMenuName();
        // 메뉴 아이템 제거
        carts.removeCartItem(menuName);
    }
}
