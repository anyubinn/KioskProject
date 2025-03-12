package cart;

import java.util.HashMap;
import java.util.Map;
import menu.MenuItem;

/**
 * 장바구니와 관련된 처리를 하는 클래스이다.
 */
public class Cart {
    private Map<MenuItem, Integer> cartItems;

    public Cart() {
        cartItems = new HashMap<>();
    }

    /**
     * 장바구니에 메뉴 아이템을 추가한다.
     * @param item 장바구니에 추가할 메뉴 아이템
     */
    public void addItem(MenuItem item) {
        // 이미 담은 메뉴라면 개수 증가, 처음 담는 메뉴라면 새로 추가
        cartItems.put(item, cartItems.getOrDefault(item, 0) + 1);
    }

    /**
     * 장바구니에 담은 메뉴 아이템과 개수를 반환한다.
     * @return 장바구니에 담은 메뉴 아이템과 개수
     */
    public Map<MenuItem, Integer> getCartItems() {
        return cartItems;
    }

    /**
     * 장바구니가 비어있는지 여부를 반환한다.
     * @return 장바구니가 비어있다면 true, 아니면 false
     */
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    /**
     * 장바구니를 전부 비운다.
     */
    public void clear() {
        cartItems.clear();
    }

    /**
     * 장바구니에 담긴 총액을 반환한다.
     * @return 장바구니에 담은 메뉴의 총액
     */
    public int getTotalPrice() {
        return cartItems.entrySet().stream()
                .mapToInt(cart -> cart.getKey().getPrice() * cart.getValue())
                .sum();
    }

    /**
     * 특정 하나의 메뉴 아이템을 장바구니에서 제거한다.
     * @param menuName 장바구니에서 제거할 메뉴 이름
     */
    public void removeCartItem(String menuName) {
        // 메뉴 이름이 장바구니에 존재하는지 검사
        boolean isMenuNameExist = cartItems.entrySet().stream()
                .anyMatch(cart -> cart.getKey().getName().equals(menuName));

        // 장바구니에 없다면
        if (!isMenuNameExist) {
            System.out.println(menuName + "가 장바구니에 존재하지 않습니다.");
            return;
        }
        // 장바구니에 존재한다면
        cartItems.entrySet().removeIf(cart -> cart.getKey().getName().equals(menuName));
        System.out.println(menuName + "를 장바구니에서 제거했습니다.");
    }
}
