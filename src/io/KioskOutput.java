package io;

import java.util.List;
import menu.Menu;
import menu.MenuItem;

public class KioskOutput {

    public static void printCategory(List<Menu> menus) {
        System.out.println("[ MAIN MENU ]");
        int index = 1;
        for (Menu menu : menus) {
            System.out.println(index++ + ". " + menu.getCategory());
        }
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
}
