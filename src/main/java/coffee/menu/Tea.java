package coffee.menu;

import java.util.ArrayList;
import java.util.List;
public class Tea {

    public static List<Menu> teaMenu = new ArrayList<>();

    {
        teaMenu.add(new Menu("2-1", "히비스커스", 4000));
        teaMenu.add(new Menu("2-2", "얼그레이", 4500));
        teaMenu.add(new Menu("2-3","로즈",  5000));
        teaMenu.add(new Menu("2-4", "체리블로썸", 5500));
    }

    public static Object findBySerialNumber(String serialNumber) {
        return teaMenu.stream().filter(s -> s.getSerialNumber().equals(serialNumber));
    }
}
