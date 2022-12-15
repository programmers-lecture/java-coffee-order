package coffee.Menu;
import java.util.Arrays;
import java.util.Collections;

public enum Menu {
    ESPRESSO("1-1",2000,MenuType.COFFEE),
    AMERICANO("1-2",3000, MenuType.COFFEE),
    COLDBREW("1-3",4000, MenuType.COFFEE),
    CAFELATTE("1-4",4000, MenuType.COFFEE),
    GREENTEA("2-1",4000, MenuType.TEA),
    CHAMOMILE("2-2",4500, MenuType.TEA),
    ROSEMILKTEA("2-3",5000, MenuType.TEA),
    EARLGRAYTEA("2-4",3500, MenuType.TEA),
    CHEESECAKE("1-1",7000,MenuType.DESSERT),
    TIRAMISU("1-2",8000,MenuType.DESSERT),
    STRAWBERRYCAKE("1-3",9000,MenuType.DESSERT),
    CHOCOCAKE("1-4",10000,MenuType.DESSERT),
    EMPTY("0",0,MenuType.NONE);

    private final String serialNumber;
    private final int price;
    private MenuType menuType;

    Menu(String serialNumber, int price, MenuType menuType) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.menuType = menuType;
    }

    //가격 조회. 손님이 선택한 메뉴를 찾게 되는 메소드, 메뉴를 보여주는 메소드,

    public int getPrice() {
        return price;
    }

    public static Menu findBySerialNumber(String serialNumber){
        return Arrays.stream(values())
                .filter(coffee -> coffee.serialNumber.equals(serialNumber))
                .findAny()
                .orElse(EMPTY);
    }

}
