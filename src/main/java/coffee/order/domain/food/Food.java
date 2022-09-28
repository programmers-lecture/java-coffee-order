package coffee.order.domain.food;

public class Food {

    private final FoodId id;
    private final FoodName name;
    private FoodPrice price;
    private FoodQuantity quantity;

    public Food(FoodId id, FoodName name, FoodPrice price, FoodQuantity quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

}
