package coffee.order.view;

import coffee.order.controller.Cafe;
import coffee.order.domain.meals.Coffee;

import java.util.List;
import java.util.stream.Stream;

public class OutputView {

    public static void printSelectMenu(){System.out.println("메뉴를 골라주세요 (번호, 갯수)");}

    public static void printMenuCategory(int categoryNumber,String category ) {
        System.out.println(categoryNumber + ". " + category); }

    public static void printMenuType(List<String> menuType){
        menuType.stream().forEach(System.out::println);    }


}
