package coffee.order.domain.food;

public class Food {

    private final Long id;
    private final FoodName name;
    private final FoodPrice price;
    private final FoodQuantity quantity;

    public Food(Long id, String name, int price, int quantity) {
        this.id = id;
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
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPrice() {
        return this.price.getPrice();
    }

    public Long getId() {
        return this.id;
    }
}
