package coffee.order.domain.meals;

import java.util.List;

public interface MenuRepository {

    Menu findBySerialNumber(String serialNumber);

    List<Menu> getMenuByCategory(Category category);

}
