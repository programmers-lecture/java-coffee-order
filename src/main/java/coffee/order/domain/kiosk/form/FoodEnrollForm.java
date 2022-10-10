package coffee.order.domain.kiosk.form;

public class FoodEnrollForm {

    private final String categoryName;
    private final String foodName;
    private final Long categoryId;
    private final Long foodId;
    private final Integer price;

    public FoodEnrollForm(String categoryName, String foodName, Long categoryId, Long foodId, Integer price) {
        this.categoryName = categoryName;
        System.out.println("categoryName = " + categoryName);
        this.foodName = foodName;
        System.out.println("foodName = " + foodName);
        this.categoryId = categoryId;
        System.out.println("categoryId = " + categoryId);
        this.foodId = foodId;
        System.out.println("foodId = " + foodId);
        this.price = price;
        System.out.println("price = " + price);
    }

    public String getCategoryName() {
        return categoryName;
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
