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
        return cartItems.entrySet().stream()
                .mapToInt(cart -> cart.getKey().getPrice() * cart.getValue())
                .sum();
    }

    public void removeCartItem(String menuName) {
        boolean isMenuNameExist = cartItems.entrySet().stream()
                .anyMatch(cart -> cart.getKey().getName().equals(menuName));

        if (!isMenuNameExist) {
            System.out.println(menuName + "가 장바구니에 존재하지 않습니다.");
            return;
        }
        cartItems.entrySet().removeIf(cart -> cart.getKey().getName().equals(menuName));
        System.out.println(menuName + "를 장바구니에서 제거했습니다.");
    }
}
