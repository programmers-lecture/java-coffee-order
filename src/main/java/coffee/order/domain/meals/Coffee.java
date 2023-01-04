package coffee.order.domain.meals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coffee implements MenuRepository{
    private final List<Menu> coffee;

    public Coffee(){
        coffee = new ArrayList<>();
        coffee.add(new Menu(Category.COFFEE,"1-1","에스프레소 ",2000));
        coffee.add(new Menu(Category.COFFEE, "1-2", "아메리카노", 3000));
        coffee.add(new Menu(Category.COFFEE, "1-3", "콜드브루", 4000));
        coffee.add(new Menu(Category.COFFEE, "1-4","카페라떼",4500));
    }

    @Override
    //메뉴 조회
    public Menu findBySerialNumber(String serialNumber){
        return coffee.stream()
                .filter(menu -> menu.getSerialNumber().equals(serialNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 항목이 없습니다."));
    }

    @Override
    public List<Menu> getMenuByCategory(Category category){
        return coffee.stream()
                .filter(menu -> menu.isCategory(category))
                .collect(Collectors.toList());
    }

    public List<Menu> getCoffee() {
        return coffee;
    }

    @Override
    public String toString(){
        return coffee.toString();
    }



}
