package coffee.order.enums;

import java.util.Arrays;

public enum Coffee {
    ESPRESSO("에스프레소", "1-1", 2000),
    AMERICANO("아메리카노", "1-2", 3000),
    COLD_BREW("콜드블루", "1-3", 4000),
    CAFE_LATTE("카페라떼", "1-4");

    private final String name;
    private final String number;
    private final int price;

    Coffee(String name, String number, int price) {
        this.name = name;
        this.number = number;
        this.price = price;
    }

    Coffee(String name, String number) {
        this.name = name;
        this.number = number;
        this.price = 0;
    }

    public static Coffee findCoffee(String number) {
        return Arrays.stream(values())
                .filter(coffee -> coffee.number.equals(number))
                .findFirst()
                .orElse(null);
    }

    public String getCoffeeMenu() {
        return number + " " + name;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}
