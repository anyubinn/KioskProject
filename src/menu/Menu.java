package menu;

import java.util.List;

/**
 * 메뉴 카테고리와 그에 속하는 메뉴 아이템을 관리하는 클래스이다.
 */
public class Menu {
    private String category;
    private List<MenuItem> menuItems;

    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    /**
     * 메뉴의 카테고리를 반환한다.
     * @return 메뉴의 카테고리
     */
    public String getCategory() {
        return category;
    }

    /**
     * 카테고리에 속하는 메뉴 아이템을 반환한다.
     * @return 카테고리에 속하는 메뉴 아이템
     */
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
