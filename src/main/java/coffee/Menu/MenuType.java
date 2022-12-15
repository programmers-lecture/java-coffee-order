package coffee.Menu;

public enum MenuType {
    COFFEE("1"),
    TEA("2"),
    DESSERT("3"),
    NONE("0");

    private String categoryNumber;

    MenuType(String categoryNumber){this.categoryNumber = categoryNumber;}

    public String getCategoryNumber(){return categoryNumber;}
}
