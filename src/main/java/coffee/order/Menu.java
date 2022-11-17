package coffee.order;

public class Menu {
    static class Coffee {
        String code = "coffee"; // 카테고리
        String name; // 메뉴명
        int price; // 가격

        Coffee (String name, int price) {
            this.name  = name;
            this.price = price;
        }
    }

    static class Tea {
        String code = "tea"; // 카테고리
        String name; // 카테고리 이름
        int price; // 가격
        Tea (String name, int price) {
            this.name  = name;
            this.price = price;
        }
    }

    static class Dessert {
        String code = "Dessert"; // 카테고리
        String name; // 카테고리 이름
        int price; // 가격

        Dessert (String name, int price) {
            this.name  = name;
            this.price = price;
        }
    }
}
