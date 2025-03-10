package io;

import cart.Cart;
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
        if (carts.isEmpty()) {
            System.out.println("장바구니에 담긴 메뉴가 없습니다. 장바구니를 담아주세요.");
            return;
        }
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println("[ Orders ]");
        for (Map.Entry<MenuItem, Integer> cart : carts.getCartItems().entrySet()) {
            System.out.println(cart.getKey().getName() + " | " + cart.getKey().getPrice() + " | " + cart.getKey().getComment() + " | " + cart.getValue());
        }

        System.out.println("[ Total ]");
        System.out.println(totalPrice);
        System.out.println("1. 주문      2. 메뉴판");
    }
}
