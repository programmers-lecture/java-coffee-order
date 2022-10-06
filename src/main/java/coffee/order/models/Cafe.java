package coffee.order.models;

import coffee.order.enums.FoodCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cafe {
    private Menu menu;
    private List<Order> orders;
    private Map<Customer, Coupon> couponMap;

    public Cafe() {
        menu = new Menu();
        orders = new ArrayList<>();
        couponMap = new HashMap<>();
    }

    public void createOrders(List<String> orders, Customer customer) {
        for(String order: orders) {
            String[] orderInfo = order.split(", ");
            this.orders.add(new Order(customer, menu.getFoodByNumber(orderInfo[0]), Integer.parseInt(orderInfo[1])));
        }
        checkOrderIsEmpty();
    }

    private void checkOrderIsEmpty() {
        if(orders.isEmpty())
            throw new IllegalArgumentException("메뉴 주문을 하지 않았습니다.");
    }

    public List<String> getMenuInfo(FoodCategory foodCategory){
        return menu.getFoodsByCategory(foodCategory)
                .stream()
                .map(food -> food.getNumber() + " " + food.getName())
                .collect(Collectors.toList());
    }

    public List<String> getOrdersInfo(Customer customer) {
        return orders.stream()
                .filter(order -> order.getCustomer().isSameObject(customer))
                .map(order -> order.getOrderFoodName() + " " + order.getOrderFoodCount() + "개 " + order.getOrderPrice() + "원")
                .collect(Collectors.toList());
    }

    public List<String> getCouponUseOrdersInfo(Customer customer) {
        return orders.stream()
                .filter(order -> order.getCustomer().isSameObject(customer) && order.getCouponUseCount() != 0)
                .map(order -> order.getOrderFoodName() + " " + order.getCouponUseCount() + "개 쿠폰사용")
                .collect(Collectors.toList());
    }

    public List<String> getOrdersInfoForCouponUse(Customer customer) {
        return orders.stream()
                .filter(order -> order.getCustomer().isSameObject(customer))
                .map(order -> order.getOrderFoodNumber() + ". " + order.getOrderFoodName())
                .collect(Collectors.toList());
    }

    public int getOrdersPriceSum(Customer customer) {
        return orders.stream()
                .filter(order -> order.getCustomer().isSameObject(customer))
                .map(Order::getOrderPrice)
                .reduce(0, Integer::sum);
    }

    public int getOrderFoodsCnt(Customer customer) {
        return orders.stream()
                .filter(order -> order.getCustomer().isSameObject(customer))
                .map(Order::getOrderFoodCount)
                .reduce(0, Integer::sum);
    }

    public int earnCoupons(Customer customer, int couponCnt) {
        Coupon coupon = couponMap.get(customer);
        if(coupon == null)
            coupon = new Coupon();
        coupon.addCouponCnt(couponCnt);
        couponMap.put(customer, coupon);
        return coupon.getCount();
    }

    public void useCouponForOrderedFood(String number, Customer customer) {
        Order order = orders.stream()
                .filter(o -> o.getOrderFoodNumber().equals(number) && o.getCustomer().isSameObject(customer))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
        Coupon coupon = couponMap.get(order.getCustomer());
        int couponUsableOrderCount = coupon.useCoupon(order.getOrderFoodCount());
        order.useCouponForOrderedFood(couponUsableOrderCount);
    }
}
