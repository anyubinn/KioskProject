package io;

import cart.Cart;
import cart.Discount;
import java.util.List;
import menu.Menu;
import menu.MenuItem;

/**
 * 메뉴와 장바구니를 출력하는 클래스이다.
 */
public class KioskOutput {

    /**
     * 메인 메뉴 카테고리를 출력한다.
     * @param menus 메뉴 리스트
     */
    public static void printCategory(List<Menu> menus) {
        System.out.println("[ MAIN MENU ]");
        int index = 1;
        // 전체 카테고리 출력
        for (Menu menu : menus) {
            System.out.println(index++ + ". " + menu.getCategory());
        }
        System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
        System.out.println("0. 종료 | 종료");
        System.out.print("카테고리를 입력하세요: ");
    }

    /**
     * 선택한 카테고리의 메뉴 아이템을 출력한다.
     * @param category 선택한 카테고리
     * @param menuItems 선택한 카테고리의 메뉴 아이템
     */
    public static void printMenu(String category, List<MenuItem> menuItems) {
        System.out.println("[ " + category.toUpperCase() +" MENU ]");
        int index = 1;
        // 메뉴 아이템의 이름, 가격, 설명 출력
        for (MenuItem menuItem : menuItems) {
            System.out.println(index++ + "." + menuItem.getName() + " | " + menuItem.getPrice() + " | " + menuItem.getComment());
        }
        System.out.println("0. 뒤로가기 | 뒤로가기");
        System.out.print("메뉴를 선택하세요: ");
    }

    /**
     * 메뉴 선택 후 가격과 장바구니 추가 여부를 출력한다.
     * @param menu 선택한 메뉴 이름
     * @param price 선택한 메뉴의 가격
     */
    public static void printOption(String menu, int price) {
        System.out.println(menu + "를 선택했습니다. 가격은 " + price + "원입니다.");
        System.out.println(menu + "를 장바구니에 추가하겠습니까?");
        System.out.println("1. 확인        2. 취소");
    }

    /**
     * 장바구니에 추가한 메뉴를 출력한다.
     * @param menu 장바구니에 추가한 메뉴
     */
    public static void printOneCart(String menu) {
        System.out.println(menu + "이 장바구니에 추가되었습니다.");
    }

    /**
     * 장바구니에 담은 메뉴를 전체 출력한다.
     * @param carts 장바구니
     * @param totalPrice 장바구니에 담은 총액
     */
    public static void printAllCarts(Cart carts, int totalPrice) {
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println("[ Orders ]");
        // stream을 이용하여 모든 장바구니 메뉴 출력
        carts.getCartItems().entrySet().stream()
            .map(cart -> String.format("%s | % d | %s | %d", cart.getKey().getName(), cart.getKey().getPrice(),
                    cart.getKey().getComment(), cart.getValue()))
            .forEach(System.out::println);

        System.out.println("[ Total ]");
        System.out.println(totalPrice);
        System.out.println("1. 주문      2. 메뉴판      3. 장바구니 메뉴 제거");
    }

    /**
     * 주문 후 총액을 출력한다.
     * @param totalPrice 결제 후 최종 금액
     */
    public static void printTotalPrice(int totalPrice) {
        System.out.println("주문이 완료되었습니다. 금액은 " + totalPrice + "원입니다.");
    }

    /**
     * 할인에 대한 정보를 출력한다.
     */
    public static void printDiscountInfo() {
        System.out.println("할인 정보를 입력해주세요.");
        int index = 1;
        // 전체 할인 정보 출력
        for (Discount discount : Discount.values()) {
            System.out.println(index++ + ". " + discount.getDiscountType() + " : " + discount.getDiscountRate() + "%");
        }
    }
}
