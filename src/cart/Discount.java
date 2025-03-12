package cart;

/**
 * 할인 정보를 관리하는 enum 클래스이다.
 */
public enum Discount {
    PATRIOT("국가유공자", 0.1),
    SOLDIER("군인", 0.05),
    STUDENT("학생", 0.03),
    COMMONER("일반", 0);

    private final String discountType;
    private final double discountRate;

    Discount(String discountType, double discountRate) {
        this.discountType = discountType;
        this.discountRate = discountRate;
    }

    /**
     * 할인 유형을 반환한다.
     * @return 할인 유형
     */
    public String getDiscountType() {
        return discountType;
    }

    /**
     * 할인율을 반환한다.
     * @return 할인율
     */
    public double getDiscountRate() {
        return discountRate;
    }

    /**
     * 할인 적용 후 최종 금액을 반환한다.
     * @param totalPrice 할인 적용 전 총액
     * @return 할인 적용 후 최종 금액
     */
    public int getTotalDiscountPrice(int totalPrice) {
        return (int) (totalPrice - (totalPrice * this.discountRate));
    }
}
