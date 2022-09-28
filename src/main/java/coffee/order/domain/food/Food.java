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

    public void decreasePrice(int inputPrice) {
        this.price.decreasePrice(inputPrice);
    }

    public void increasePrice(int inputPrice) {
        this.price.increasePrice(inputPrice);
    }

    public void decreaseQuantity(int inputQuantity) {
        this.quantity.decreaseQuantity(inputQuantity);
    }

    public void increaseQuantity(int inputQuantity) {
        this.quantity.increaseQuantity(inputQuantity);
    }}
