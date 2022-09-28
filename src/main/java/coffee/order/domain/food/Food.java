package coffee.order.domain.food;

public class Food {

    private final FoodId id;
    private final FoodName name;
    private final FoodPrice price;
    private final FoodQuantity quantity;

    public Food(int id, String name, int price, int quantity) {
        this.id = new FoodId(id);
        this.name = new FoodName(name);
        this.price = new FoodPrice(price);
        this.quantity = new FoodQuantity(quantity);
    }

    public void decreasePrice(int price) {
        this.price.decreasePrice(price);
    }

    public void increasePrice(int price) {
        this.price.increasePrice(price);
    }
}
