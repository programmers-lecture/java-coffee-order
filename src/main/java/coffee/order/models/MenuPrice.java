package coffee.order.models;

public class MenuPrice {
    private final int price;

    public MenuPrice(int price) {
        if(price < 0)
            throw new IllegalArgumentException("가격은 음수가 될 수 없습니다.");
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
