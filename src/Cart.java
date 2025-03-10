import java.util.HashMap;
import java.util.Map;
import menu.MenuItem;

public class Cart {
    private Map<MenuItem, Integer> cartItems;

    Cart() {
        cartItems = new HashMap<>();
    }

    public void addItem(MenuItem item) {
        cartItems.put(item, cartItems.getOrDefault(item, 0) + 1);
    }
}
