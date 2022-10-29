package coffee.order.view.input.kiosk.barista.form;

public class FoodEnrollForm {

    private final String foodName;
    private final Long categoryId;
    private final Long foodId;
    private final Integer price;

    public FoodEnrollForm(String foodName, Long categoryId, Long foodId, Integer price) {
        this.foodName = foodName;
        this.categoryId = categoryId;
        this.foodId = foodId;
        this.price = price;
    }

    public String getFoodName() {
        return foodName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getFoodId() {
        return foodId;
    }

    public Integer getPrice() {
        return price;
    }
}
