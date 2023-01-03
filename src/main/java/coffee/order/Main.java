package coffee.order;

import coffee.order.domain.meals.Category;
import coffee.order.domain.meals.Coffee;
import coffee.order.domain.meals.Menu;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        List<Menu> res= coffee.getMenuByCategory(Category.COFFEE);
        System.out.println(res);

    }
}