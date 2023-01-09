package coffee.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String serialNumber;
    private String menuName;
    private int price;


    public Menu(String serialNumber, String menuName, int price) {
        this.serialNumber = serialNumber;
        this.menuName = menuName;
        this.price = price;
    }


    // coffee, tea, dessert 클래스등 serialnumber를 확인한 다음 다양하게 오도록 하고 싶은데 방법을 모르겟다.
    public Menu findBySerialNumber(String serialNumber){
        String serial = serialNumber.split("")[0];
        // 이런 방식 말고 더 나은 방식이 있을 것 같다..
//        if (category.equals("1")){Object i = Coffee.class;}
//        else if (category.equals("2")){Object i = Tea.class;}
//        else (Dessert.class);
        return i.stream().filter(m -> m.getSerialNumber().equals(serialNumber))
                .findFirst()
                .get();
    }
}
