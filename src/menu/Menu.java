package menu;

import java.util.List;

public class Menu {
    String category;
    List<MenuItem> menuItems;

    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    String getCategory() {
        return category;
    }
}
