package coffee.order.domain;

public class Kiosk {

    private static final String SEPARATOR = "...";
    private final Menus menus = new Menus();

    public String showMenus() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Category category : Category.values()) {
            stringBuilder.append(category.getCodeAndName())
                    .append(menus.getListOf(category) + "\n")
                    .append(SEPARATOR + "\n");
        }
        return String.valueOf(stringBuilder);
    }

    public Menu getMenu(String menuInfo) {
        return menus.findByCode(menuInfo);
    }
}
