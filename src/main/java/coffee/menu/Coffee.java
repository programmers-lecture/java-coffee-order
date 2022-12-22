package coffee.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coffee {

    // 이를 출력해보면 빈 리스트로 출력됨
    public List<Menu> coffeeMenu = new ArrayList<>();
    {
        coffeeMenu.add(new Menu("1-1", "에스프레소", 2000));
        coffeeMenu.add(new Menu("1-2", "아메리카노", 3000));
        coffeeMenu.add(new Menu("1-3", "카페라떼", 3500));
        coffeeMenu.add(new Menu("1-4", "돌체라떼", 4000));
    }

}
