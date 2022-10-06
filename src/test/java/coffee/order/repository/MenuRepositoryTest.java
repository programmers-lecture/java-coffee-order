package coffee.order.repository;

import coffee.order.model.Coffee;
import coffee.order.model.Dessert;
import coffee.order.model.Menu;
import coffee.order.model.MenuType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;


class MenuRepositoryTest {
    private final MenuRepository menuRepository = new MenuRepository();

    @DisplayName("메뉴 추가 테스트")
    @Test
    void addMenuTest() {
        // given
        menuRepository.addMenu(new Coffee("아메리카노", 3000));
        menuRepository.addMenu(new Coffee("카페라떼", 4000));
        menuRepository.addMenu(new Coffee("카푸치노", 4500));
        menuRepository.addMenu(new Coffee("에스프레소", 2000));
        menuRepository.addMenu(new Dessert("초코케이크", 4500));
        menuRepository.addMenu(new Dessert("당근케이크", 2000));

        // when
        ArrayList<? super Menu> coffeeList = menuRepository.getMenuDatabase().get(MenuType.COFFEE);
        ArrayList<? super Menu> dessertList = menuRepository.getMenuDatabase().get(MenuType.DESSERT);

        // then
        assertThat(coffeeList.size())
                .as("메뉴 타입별 사이즈")
                .isEqualTo(4);

        assertThat(dessertList.size())
                .as("메뉴 타입별 사이즈")
                .isEqualTo(3);
    }
}