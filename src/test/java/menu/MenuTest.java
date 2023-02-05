package menu;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuTest {
    static Menu menu;
    static MenuItem menuItem1;
    static MenuItem menuItem2;
    static MenuItem menuItem3;
    static MenuItem menuItem4;

    @BeforeAll
    static void init() {
        menu = new Menu();
        menuItem1 = new MenuItem(MenuCategory.COFFEE,
                1,
                "에스프레소",
                BigDecimal.valueOf(2000.0));
        menuItem2 = new MenuItem(MenuCategory.TEA,
                1,
                "녹차",
                BigDecimal.valueOf(2000.0));
        menuItem3 = new MenuItem(MenuCategory.DESSERT,
                1,
                "브라우니",
                BigDecimal.valueOf(2000.0));
        menuItem4 = new MenuItem(MenuCategory.COFFEE,
                2,
                "아메리카노",
                BigDecimal.valueOf(2000.0));
    }


    @Test
    @DisplayName("메뉴 등록 테스트")
    void registerMenuItem() {
        menu.registerMenuItem(menuItem1);
        menu.registerMenuItem(menuItem2);
        menu.registerMenuItem(menuItem3);

        assertThat(menu.getMenuItems()
                .get(menuItem1.getMenuCategory())
                .get(0))
                .isEqualTo(menuItem1);
        assertThat(menu.getMenuItems()
                .get(menuItem2.getMenuCategory())
                .get(0))
                .isEqualTo(menuItem2);
        assertThat(menu.getMenuItems()
                .get(menuItem3.getMenuCategory())
                .get(0))
                .isEqualTo(menuItem3);
    }

    @Test
    @DisplayName("수량 등록 테스트")
    void setStock() {
        menu.registerMenuItem(menuItem1);
        menu.registerMenuItem(menuItem2);
        menu.registerMenuItem(menuItem3);

        menu.setStock(MenuCategory.COFFEE, 1, 5);
        menu.setStock(MenuCategory.TEA, 1, 0);
        menu.setStock(MenuCategory.DESSERT, 1, 1);

        assertThat(menu.getMenuItems()
                .get(MenuCategory.COFFEE)
                .get(0)
                .getStock())
                .isEqualTo(5);
        assertThat(menu.getMenuItems()
                .get(MenuCategory.TEA)
                .get(0)
                .getStock())
                .isEqualTo(0);
        assertThat(menu.getMenuItems()
                .get(MenuCategory.DESSERT)
                .get(0)
                .getStock())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("가격 변경 테스트")
    void changePrice() {
        menu.registerMenuItem(menuItem1);
        menu.registerMenuItem(menuItem2);
        menu.registerMenuItem(menuItem3);

        menu.changePrice(MenuCategory.COFFEE, 1, BigDecimal.valueOf(1000.0));
        menu.changePrice(MenuCategory.TEA, 1, BigDecimal.valueOf(10000.0));
        menu.changePrice(MenuCategory.DESSERT, 1, BigDecimal.valueOf(1600.0));

        assertThat(menu.getMenuItems()
                .get(MenuCategory.COFFEE)
                .get(0)
                .getPrice())
                .isEqualTo(BigDecimal.valueOf(1000.0));
        assertThat(menu.getMenuItems()
                .get(MenuCategory.TEA)
                .get(0)
                .getPrice())
                .isEqualTo(BigDecimal.valueOf(10000.0));
        assertThat(menu.getMenuItems()
                .get(MenuCategory.DESSERT)
                .get(0)
                .getPrice())
                .isEqualTo(BigDecimal.valueOf(1600.0));
    }

    @Test
    void showMenuItems() {
        menu.registerMenuItem(menuItem1);
        menu.registerMenuItem(menuItem2);
        menu.registerMenuItem(menuItem3);
        menu.registerMenuItem(menuItem4);

        menu.showMenuItems();
    }
}