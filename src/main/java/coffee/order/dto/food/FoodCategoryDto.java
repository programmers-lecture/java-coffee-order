package coffee.order.dto.food;

public class FoodCategoryDto {

    private final FoodsDto foodsDto;
    private final String name;
    private final Long id;

    public FoodCategoryDto(FoodsDto foodsDto, String name, Long id) {
        this.foodsDto = foodsDto;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ". " + name + "\n" + foodsDto.toString();
    }
    
}
