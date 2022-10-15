package coffee.order.view.input.kiosk.barista.form;

public class FoodUpdateForm {

    private final Long categoryId;
    private final Long foodId;
    private final Integer foodQuantity;

    private final Integer foodPrice;

    public FoodUpdateForm(Long categoryId, Long foodId, Integer foodQuantity, Integer foodPrice) {
        this.categoryId = categoryId;
        this.foodId = foodId;
        this.foodQuantity = foodQuantity;
        this.foodPrice = foodPrice;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getFoodId() {
        return foodId;
    }

    public Integer getFoodQuantity() {
        return foodQuantity;
    }

    public Integer getFoodPrice() {
        return foodPrice;
    }
}
