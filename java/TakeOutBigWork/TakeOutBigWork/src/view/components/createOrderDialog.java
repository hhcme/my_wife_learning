package view.components;

import baseListNode.SingleLinkList;
import listNode.foodMenuListNode;
import model.FoodMenu;
import model.FoodOrder;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static data.Data.*;

/// 新建或修改菜品信息弹窗
public class createOrderDialog extends JFrame {
    JPanel root = new JPanel();

    ArrayList<Integer> countList;

    Integer allPrice;

    SingleLinkList<FoodMenu> foodList = new foodMenuListNode();

    public createOrderDialog(ArrayList<Integer> countList, Integer allPrice) {
        super("确定下单信息");
        this.countList = countList;
        this.allPrice = allPrice;
        init();
    }

    public void init() {
        root.setLayout(null);

        JButton back = new JButton("返回");
        back.setBounds(20, 15, 60, 30);
        root.add(back);

        JLabel totalPrice = new JLabel("总价: ");
        totalPrice.setBounds(150, 15, 60, 30);
        root.add(totalPrice);

        JLabel showTotalPrice = new JLabel(String.valueOf(allPrice));
        showTotalPrice.setBounds(200, 15, 60, 30);
        root.add(showTotalPrice);

        JButton createFood = new JButton("确定下单");
        createFood.setBounds(250, 15, 90, 30);
        root.add(createFood);

        JLabel foodName = new JLabel("菜名");
        foodName.setBounds(20, 50, 80, 30);
        root.add(foodName);

        JLabel foodPrice = new JLabel("价格");
        foodPrice.setBounds(150, 50, 80, 30);
        root.add(foodPrice);

        JLabel foodCount = new JLabel("数量");
        foodCount.setBounds(200, 50, 80, 30);
        root.add(foodCount);
        int index = 0;
        for (int x = 0; x < countList.size(); x++) {
            if (countList.get(x) <= 0) {
                continue;
            }

            // 拿到单条数据
            FoodMenu food = foodMenuList.getByIndex(x + 1).getData();
            String txtFoodName = "" + food.name;
            String txtFoodPrice = "" + food.price;
            String txtFoodCount = "" + countList.get(x);
            // 还需要添加gui的显示界面
            JLabel jLabelFoodName = new JLabel(txtFoodName);
            JLabel jLabelFoodPrice = new JLabel(txtFoodPrice);
            JLabel jLabelFoodCount = new JLabel(txtFoodCount);
            jLabelFoodName.setBounds(20, 80 + index * 35, 600, 35);
            jLabelFoodPrice.setBounds(150, 80 + index * 35, 600, 35);
            jLabelFoodCount.setBounds(200, 80 + index * 35, 600, 35);

            root.add(jLabelFoodName);
            root.add(jLabelFoodPrice);
            root.add(jLabelFoodCount);
            foodList.insert(new FoodMenu(food.name, food.price, countList.get(x)));
            index += 1;
        }

        // 返回
        back.addActionListener(e -> setVisible(false));

        // 确定下单
        createFood.addActionListener(e -> {
            if (loginPerson != null) {
                // 获取现在的时间
                LocalDateTime createTime = LocalDateTime.now();
                orderListNode.insert(new FoodOrder(loginPerson.nickName, loginPerson.phone, foodList, allPrice, createTime, null));
            }
            setVisible(false);
        });

        add(root);
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        repaint();
        setVisible(true);
    }
}
