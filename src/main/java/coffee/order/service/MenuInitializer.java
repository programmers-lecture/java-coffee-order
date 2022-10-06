package coffee.order.service;

import coffee.order.model.Coffee;
import coffee.order.model.Dessert;
import coffee.order.model.Tea;
import coffee.order.repository.MenuRepository;

public class MenuInitializer {
    public void initializeMenu(MenuRepository menuRepository) {
        menuRepository.addMenu(new Coffee("에스프레소", 3000));
        menuRepository.addMenu(new Coffee("카페라떼", 4000));
        menuRepository.addMenu(new Coffee("카푸치노", 4500));
        menuRepository.addMenu(new Coffee("에스프레소", 2000));

        menuRepository.addMenu(new Tea("그린티", 2500));

        menuRepository.addMenu(new Dessert("당근 케이크", 3000));
    }
}
