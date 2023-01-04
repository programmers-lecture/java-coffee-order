package coffee.order.domain.meals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Menus implements MenuRepository{
    private Coffee coffee;
    private Tea tea;
    private Dessert dessert;
    private List<Menu> menus;

    public Menus() {
        menus = new ArrayList<>();
        this.coffee = new Coffee();
        this.tea= new Tea();
        this.dessert = new Dessert();
        menus.addAll(coffee.getCoffee());
        menus.addAll(tea.getTea());
        menus.addAll(dessert.getDessert());
    }

    public List<Menu> getAllMenu(){
        return menus;
    }


    @Override
    public Menu findBySerialNumber(String serialNumber) {
        return menus.stream()
                .filter(menu -> menu.getSerialNumber().equals(serialNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 항목이 없습니다"));
    }

    @Override
    public List<Menu> getMenuByCategory(Category category) {
        return menus.stream()
                .filter(menu -> menu.isCategory(category))
                .collect(Collectors.toList());
    }
}
