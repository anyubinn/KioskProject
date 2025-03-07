import java.util.List;

public class Menu {
    String category;
    List<MenuItem> menuItems;

    Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }
}
