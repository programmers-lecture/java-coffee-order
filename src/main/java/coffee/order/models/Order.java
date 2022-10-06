package coffee.order.models;

public class Order {
    private final Customer customer;
    private final Food food;
    private int orderCount;
    private int couponUseCount;

    public Order(Customer customer, Food food, int count) {
        this.customer = customer;
        this.food = food;
        this.orderCount = count;
        this.couponUseCount = 0;
    }

    public int getOrderPrice() {
        return orderCount * food.getPrice();
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getOrderFoodName() {
        return food.getName();
    }

    public String getOrderFoodNumber() {
        return food.getNumber();
    }

    public int getOrderFoodCount() {
        return orderCount;
    }

    public int getCouponUseCount() {
        return couponUseCount;
    }

    public void useCouponForOrderedFood(int couponUseCount) {
        if(couponUseCount < 0 || orderCount - couponUseCount < 0)
            throw new IllegalArgumentException("사용 쿠폰 수량은 주문 수보다 크거나 음수일 수 없습니다.");
        this.orderCount -= couponUseCount;
        this.couponUseCount += couponUseCount;
    }
}
