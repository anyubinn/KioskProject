package cart;

import java.util.HashMap;
import java.util.Map;
import menu.MenuItem;

public class Cart {
    private Map<MenuItem, Integer> cartItems;

    public Cart() {
        cartItems = new HashMap<>();
    }

    public void addItem(MenuItem item) {
        cartItems.put(item, cartItems.getOrDefault(item, 0) + 1);
    }

    public Map<MenuItem, Integer> getCartItems() {
        return cartItems;
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public void clear() {
        cartItems.clear();
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<MenuItem, Integer> cart : cartItems.entrySet()) {
            totalPrice += cart.getKey().getPrice() * cart.getValue();
        }

        return totalPrice;
    }
}
