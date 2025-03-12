package menu;

/**
 * 개별 메뉴 아이템의 정보를 관리하는 클래스이다.
 */
public class MenuItem {
    private String name;
    private int price;
    private String comment;

    public MenuItem(String name, int price, String comment) {
        this.name = name;
        this.price = price;
        this.comment = comment;
    }

    /**
     * 메뉴 아이템의 이름을 반환한다.
     * @return 메뉴 아이템 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 메뉴 아이템의 가격을 반환한다.
     * @return 메뉴 아이템 가격
     */
    public int getPrice() {
        return price;
    }

    /**
     * 메뉴 아이템의 설명을 반환한다.
     * @return 메뉴 아이템 설명
     */
    public String getComment() {
        return comment;
    }
}
