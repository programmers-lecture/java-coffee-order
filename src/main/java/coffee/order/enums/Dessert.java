package coffee.order.enums;

import java.util.Arrays;

public enum Dessert {
    CAKE("케잌", "3-1"),
    COOKIE("쿠키", "3-2", 1000);

    private final String name;
    private final String number;
    private final int price;

    Dessert(String name, String number, int price) {
        this.name = name;
        this.number = number;
        this.price = price;
    }

    Dessert(String name, String number) {
        this.name = name;
        this.number = number;
        this.price = 0;
    }

    public static Dessert findDessert(String number) {
        return Arrays.stream(values())
                .filter(dessert -> dessert.number.equals(number))
                .findFirst()
                .orElse(null);
    }

    public String getDessertMenu() {
        return number + " " + name;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}
