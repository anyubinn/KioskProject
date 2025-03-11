package io;

import cart.Cart;
import cart.Discount;
import java.util.List;
import java.util.Map;
import menu.Menu;
import menu.MenuItem;

public class KioskOutput {

    public static void printCategory(List<Menu> menus) {
        System.out.println("[ MAIN MENU ]");
        int index = 1;
        for (Menu menu : menus) {
            System.out.println(index++ + ". " + menu.getCategory());
        }
        System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
        System.out.println("0. 종료 | 종료");
        System.out.print("카테고리를 입력하세요: ");
    }

    public static void printMenu(String category, List<MenuItem> menuItems) {
        System.out.println("[ " + category.toUpperCase() +" MENU ]");
        int index = 1;
        for (MenuItem menuItem : menuItems) {
            System.out.println(index++ + "." + menuItem.getName() + " | " + menuItem.getPrice() + " | " + menuItem.getComment());
        }
        System.out.println("0. 뒤로가기 | 뒤로가기");
        System.out.print("메뉴를 선택하세요: ");
    }

    public static void printOption(String menu, int price) {
        System.out.println(menu + "를 선택했습니다. 가격은 " + price + "원입니다.");
        System.out.println(menu + "를 장바구니에 추가하겠습니까?");
        System.out.println("1. 확인        2. 취소");
    }

    public static void printOneCart(String menu) {
        System.out.println(menu + "이 장바구니에 추가되었습니다.");
    }

    public static void printAllCarts(Cart carts, int totalPrice) {
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println("[ Orders ]");
        carts.getCartItems().entrySet().stream()
            .map(cart -> String.format("%s | % d | %s | %d", cart.getKey().getName(), cart.getKey().getPrice(),
                    cart.getKey().getComment(), cart.getValue()))
            .forEach(System.out::println);

        System.out.println("[ Total ]");
        System.out.println(totalPrice);
        System.out.println("1. 주문      2. 메뉴판      3. 장바구니 메뉴 제거");
    }

    public static void printTotalPrice(int totalPrice) {
        System.out.println("주문이 완료되었습니다. 금액은 " + totalPrice + "입니다.");
    }

    public static void printDiscountInfo() {
        System.out.println("할인 정보를 입력해주세요.");
        int index = 1;
        for (Discount discount : Discount.values()) {
            System.out.println(index++ + ". " + discount.getDiscountType() + " : " + discount.getDiscountRate() + "%");
        }
    }
}
