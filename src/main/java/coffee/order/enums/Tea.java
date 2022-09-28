package coffee.order.enums;

import java.util.Arrays;

public enum Tea {
    GREEN_TEA("그린티", "2-1", 2000),
    BLACK_TEA("홍차", "2-2");

    private final String name;
    private final String number;
    private final int price;

    Tea(String name, String number, int price) {
        this.name = name;
        this.number = number;
        this.price = price;
    }

    Tea(String name, String number) {
        this.name = name;
        this.number = number;
        this.price = 0;
    }

    public static Tea findTea(String number) {
        return Arrays.stream(values())
                .filter(tea -> tea.number.equals(number))
                .findFirst()
                .orElse(null);
    }

    public String getTeaMenu() {
        return number + " " + name;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}
