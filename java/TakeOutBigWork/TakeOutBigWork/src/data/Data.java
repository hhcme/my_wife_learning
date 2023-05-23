package data;

import listNode.OrderListNode;
import listNode.PersonListNode;
import listNode.foodMenuListNode;
import model.FoodMenu;
import model.Person;

/// 用来存放数据
public class Data {

    /// 全局数据,当前登录是普通用户还是管理员
    public static Boolean isUser =true;

    public static Person loginPerson =null;

    // 初始化用户列表,有默认的几个用户
    public static PersonListNode personList = new PersonListNode();

    // 初始化菜单
    public static foodMenuListNode foodMenuList = new foodMenuListNode();

    // 所有订单信息
    public static OrderListNode orderListNode = new OrderListNode();

    /// 初始化数据
    public static void init() {
        personList.insert(new Person("123", "123456", "张三"));
        personList.insert(new Person("456", "123456", "李四"));
        foodMenuList.insert(new FoodMenu("宫保鸡丁", 35, 20));
        foodMenuList.insert(new FoodMenu("鱼香肉丝", 30, 20));
        foodMenuList.insert(new FoodMenu("香辣鸡翅", 15, 20));
        foodMenuList.insert(new FoodMenu("米饭", 5, 20));
        foodMenuList.insert(new FoodMenu("乌鸡汤", 20, 20));
        foodMenuList.insert(new FoodMenu("冻柠茶", 10, 20));
    }
}

