package coffee.order.domain.meals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tea implements MenuRepository{

    private List<Menu> tea;

    public Tea(){
        tea = new ArrayList<>();
        tea.add(new Menu(Category.TEA,"2-1","그린티",2000));
        tea.add(new Menu(Category.TEA, "2-2", "히비스커스", 3000));
        tea.add(new Menu(Category.TEA, "2-3", "로즈", 4000));
        tea.add(new Menu(Category.TEA, "2-4","체리블로썸",4500));
    }

    @Override
    //메뉴 조회
    public Menu findBySerialNumber(String serialNumber){
        return tea.stream()
                .filter(menu -> menu.getSerialNumber().equals(serialNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 항목이 없습니다."));
    }

    @Override
    public List<Menu> getMenuByCategory(Category category){
        return tea.stream()
                .filter(menu -> menu.isCategory(category))
                .collect(Collectors.toList());
    }
}
