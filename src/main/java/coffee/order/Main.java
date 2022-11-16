package coffee.order;

public class Main {
    public static void main(String[] args) {
        class Menu {
            String number;
            String name;
            Integer price;

            Menu(String number, String name, Integer price) {
                this.number = number;
                this.name = name;
                this.price = price;
            }

        }

        Menu coffee = new Menu("1", "Coffee", 1000);
    }
}