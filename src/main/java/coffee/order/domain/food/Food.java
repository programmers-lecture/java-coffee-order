package coffee.order.domain.food;

import java.util.Objects;

import static coffee.order.view.output.UnitMessage.WON;

public class Food {

    private final Long id;
    private final Long categoryId;
    private final FoodName name;
    private final FoodPrice price;
    private final FoodQuantity quantity;

    public Food(Long id, Long categoryId, String name, int price, int quantity) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = new FoodName(name);
        this.price = new FoodPrice(price);
        this.quantity = new FoodQuantity(quantity);
    }

    public int getPrice() {
        return price.getPrice();
    }

    public void decreaseQuantity(int inputQuantity) {
        this.quantity.decreaseQuantity(inputQuantity);
    }

    private void increaseQuantity(int inputQuantity) {
        this.quantity.increaseQuantity(inputQuantity);
    }

    private void decreasePrice(int inputPrice) {
        this.price.decreasePrice(inputPrice);
    }

    private void increasePrice(int inputPrice) {
        this.price.increasePrice(inputPrice);
    }

    protected boolean checkSameId(Long foodId) {
        return Objects.equals(this.id, foodId);
    }

//    public void toFoodMenuStringBuilder(StringBuilder foodMenuBuilder, Long categoryId) {
//        foodMenuBuilder
//                .append(categoryId)
//                .append("-")
//                .append(id)
//                .append(".")
//                .append(" ")
//                .append(name)
//                .append(" ")
//                .append("//")
//                .append(" ")
//                .append(price)
//                .append(WON.unit)
//                .append("\n");
//    }

    public String toFoodNameString() {
        return name.toString();
    }

    @Override
    public String toString() {
        return categoryId + "-" + id + ". " + toFoodNameString() + " // " + price.toString() + WON.unit + "\n";
    }
}
