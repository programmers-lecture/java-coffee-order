package menu;

import static org.assertj.core.api.Assertions.assertThat;

import domain.menu.Menu;
import domain.menu.MenuCategory;
import domain.menu.MenuItem;
import io.input.information.ChangePriceInformation;
import io.input.InputDataManagement;
import io.input.information.SetStockInformation;
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
                BigDecimal.valueOf(2500));
        menuItem2 = new MenuItem(MenuCategory.TEA,
                1,
                "녹차",
                BigDecimal.valueOf(3000));
        menuItem3 = new MenuItem(MenuCategory.DESSERT,
                1,
                "브라우니",
                BigDecimal.valueOf(6000));
        menuItem4 = new MenuItem(MenuCategory.COFFEE,
                2,
                "아메리카노",
                BigDecimal.valueOf(2000));
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

        InputDataManagement inputDataManager = new InputDataManagement();
        SetStockInformation setStockInformation1 = inputDataManager.getInformationForSetStock("1-1, 5");
        SetStockInformation setStockInformation2 = inputDataManager.getInformationForSetStock("2-1, 0");
        SetStockInformation setStockInformation3 = inputDataManager.getInformationForSetStock("3-1, 1");

        menu.setStock(setStockInformation1);
        menu.setStock(setStockInformation2);
        menu.setStock(setStockInformation3);

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

        InputDataManagement inputDataManager = new InputDataManagement();
        ChangePriceInformation changePriceInformation1 =
                inputDataManager.getInformationForChangePrice("1-1, 1000");
        ChangePriceInformation changePriceInformation2 =
                inputDataManager.getInformationForChangePrice("2-1, 10000");
        ChangePriceInformation changePriceInformation3 =
                inputDataManager.getInformationForChangePrice("3-1, 1600");

        menu.changePrice(changePriceInformation1);
        menu.changePrice(changePriceInformation2);
        menu.changePrice(changePriceInformation3);

        assertThat(menu.getMenuItems()
                .get(MenuCategory.COFFEE)
                .get(0)
                .getPrice())
                .isEqualTo(BigDecimal.valueOf(1000));
        assertThat(menu.getMenuItems()
                .get(MenuCategory.TEA)
                .get(0)
                .getPrice())
                .isEqualTo(BigDecimal.valueOf(10000));
        assertThat(menu.getMenuItems()
                .get(MenuCategory.DESSERT)
                .get(0)
                .getPrice())
                .isEqualTo(BigDecimal.valueOf(1600));
    }

    @Test
    void showPrice() {
        menu.registerMenuItem(menuItem1);
        menu.registerMenuItem(menuItem2);
        menu.registerMenuItem(menuItem3);
        menu.registerMenuItem(menuItem4);

        menu.showPrice();
    }

    @Test
    void showStock() {
        menu.registerMenuItem(menuItem1);
        menu.registerMenuItem(menuItem2);
        menu.registerMenuItem(menuItem3);
        menu.registerMenuItem(menuItem4);

        menu.showStock();
    }
}