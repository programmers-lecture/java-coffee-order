package coffee.order.dto.food;

import java.util.List;

public class FoodsDto {

    private final List<FoodDto> foodsDto;

    public FoodsDto(List<FoodDto> foodsDto) {
        this.foodsDto = foodsDto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        foodsDto.forEach(foodDto -> sb.append(foodDto.toString()));
        return sb.toString();
    }
}
