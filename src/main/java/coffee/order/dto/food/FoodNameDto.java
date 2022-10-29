package coffee.order.dto.food;

public class FoodNameDto {

    private String name;

    public FoodNameDto(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
