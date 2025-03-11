package cart;

public enum Discount {
    PATRIOT("국가유공자", 0.1),
    SOLDIER("군인", 0.05),
    STUDENT("학생", 0.03),
    COMMONER("일반", 0);

    private String discountType;
    private double discountRate;

    Discount(String discountType, double discountRate) {
        this.discountType = discountType;
        this.discountRate = discountRate;
    }

    public String getDiscountType() {
        return discountType;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public int getTotalDiscountPrice(int totalPrice) {
        return (int) (totalPrice - (totalPrice * this.discountRate));
    }
}
