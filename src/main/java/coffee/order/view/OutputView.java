package coffee.order.view;

import coffee.order.model.Menu;
import coffee.order.model.MenuType;

import java.util.ArrayList;
import java.util.HashMap;

public class OutputView {
    private static final String GREETING_MESSAGE = "Welcome! 손님 역할을 실행합니다...";
    private static final String MENU_GUIDE_MESSAGE = "메뉴를 골라주세요 (번호, 개수)";

    private static final String HYPHEN = "-";
    private static final String BLANK = " ";
    private static final int INDEX_BOUNDARY = 1;

    public void printGreetingMessage() {
        System.out.println(GREETING_MESSAGE);
        System.out.println();
    }

    public void printMenu(MenuType[] menuTypes, HashMap<MenuType, ArrayList<? super Menu>> menuDatabase) {
        System.out.println(MENU_GUIDE_MESSAGE);

        for (MenuType menuType : menuTypes) {
            System.out.println(menuType.getOrder() + ". " + menuType.getKoreanName());
            ArrayList<? super Menu> menuList = menuDatabase.get(menuType);
            menuList.forEach(menu -> System.out.println(menuFormat(menuType, menuList, menu)));
            System.out.println();
        }
    }

    private String menuFormat(MenuType menuType, ArrayList<? super Menu> menuList, Object menu) {
        return menuIndexGenerator(menuType, menuList, menu) + BLANK + menu.toString();
    }

    private String menuIndexGenerator(MenuType menuType, ArrayList<? super Menu> menuList, Object menu) {
        return menuType.getOrder() + HYPHEN + (menuList.indexOf(menu) + INDEX_BOUNDARY);
    }
}
