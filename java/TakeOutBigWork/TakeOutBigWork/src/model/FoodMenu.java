package model;

public class FoodMenu {
    public FoodMenu(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    /// 菜名
    public String name;
    /// 价格
    public int price;
    /// 库存
    public int count;
}
