package coffee.order.domain.meals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dessert implements MenuRepository{
    private final List<Menu> dessert;

    public Dessert(){
        dessert = new ArrayList<>();
        dessert.add(new Menu(Category.DESSERT,"3-1","초코케잌 ",2000));
        dessert.add(new Menu(Category.DESSERT, "3-2", "딸기케잌", 3000));
        dessert.add(new Menu(Category.DESSERT, "3-3", "치즈케잌", 4000));
        dessert.add(new Menu(Category.DESSERT, "3-4","블루베리케잌",4500));
    }

    @Override
    //메뉴 조회
    public Menu findBySerialNumber(String serialNumber){
        return dessert.stream()
                .filter(menu -> menu.getSerialNumber().equals(serialNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 항목이 없습니다."));
    }

    @Override
    public List<Menu> getMenuByCategory(Category category){
        return dessert.stream()
                .filter(menu -> menu.isCategory(category))
                .collect(Collectors.toList());
    }

    public List<Menu> getDessert() {
        return dessert;
    }

    @Override
    public String toString(){
        return dessert.toString();
    }
}
