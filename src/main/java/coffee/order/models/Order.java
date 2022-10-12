package coffee.order.models;

public class Order {
    private final Customer customer;
    private final Menu menu;
    private int orderCount;
    private int couponUseCount;

    public Order(Customer customer, Menu menu, int count) {
        this.customer = customer;
        this.menu = menu;
        this.orderCount = count;
        this.couponUseCount = 0;
    }

    public int getOrderPrice() {
        return orderCount * menu.getPrice();
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getOrderMenuName() {
        return menu.getName();
    }

    public String getOrderFoodNumber() {
        return menu.getNumber();
    }

    public int getOrderCount() {
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
