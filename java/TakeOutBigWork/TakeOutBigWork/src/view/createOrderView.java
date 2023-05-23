package view;

import data.Data;
import model.FoodMenu;
import view.components.createOrderDialog;

import javax.swing.*;
import java.util.ArrayList;

/// 创建外卖订单
public class createOrderView extends JFrame {
    JPanel root = new JPanel();
    JPanel foodListJPanel = new JPanel();
    ArrayList<FoodMenu> foodMenuList = Data.foodMenuList.toArrayList();
    ArrayList<Integer> countList = new ArrayList<>();

    Integer allPrice = 0;

    JLabel showTotalPrice;


    public createOrderView() {
        super("创建外卖订单");
        root.setLayout(null);
        foodListJPanel.setLayout(null);

        JButton back = new JButton("返回");
        back.setBounds(20, 15, 80, 30);
        foodListJPanel.add(back);

        JLabel totalPrice = new JLabel("总价: ");
        totalPrice.setBounds(150, 15, 60, 30);
        foodListJPanel.add(totalPrice);

         showTotalPrice = new JLabel(String.valueOf(allPrice));
        showTotalPrice.setBounds(200, 15, 60, 30);
        foodListJPanel.add(showTotalPrice);

        JButton createFood = new JButton("下单");
        createFood.setBounds(250, 15, 60, 30);
        foodListJPanel.add(createFood);

        // 返回
        back.addActionListener(e -> setVisible(false));

        // 下单
        createFood.addActionListener(e -> {
            new createOrderDialog(countList, allPrice);
            repaint();
        });

        /// 初始化已选的菜品数量
        for (int x = 0; x < Data.foodMenuList.getLength(); x++) {
            countList.add(0);
        }

        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        refreshFoodList();
    }

    /// 刷新显示菜品列表
    public void refreshFoodList() {
        remove(foodListJPanel);
        JLabel foodName = new JLabel("菜名");
        foodName.setBounds(20, 50, 80, 30);
        foodListJPanel.add(foodName);

        JLabel foodPrice = new JLabel("价格");
        foodPrice.setBounds(150, 50, 80, 30);
        foodListJPanel.add(foodPrice);

        JLabel foodCount = new JLabel("库存");
        foodCount.setBounds(200, 50, 80, 30);
        foodListJPanel.add(foodCount);


        for (int x = 0; x < foodMenuList.size(); x++) {
            int finalX = x;
            // 拿到单条数据
            FoodMenu food = foodMenuList.get(finalX);
            String txtFoodName = "" + food.name;
            String txtFoodPrice = "" + food.price;
            String txtFoodCount = "" + food.count;
            // 还需要添加gui的显示界面
            JLabel jLabelFoodName = new JLabel(txtFoodName);
            JLabel jLabelFoodPrice = new JLabel(txtFoodPrice);
            JLabel jLabelFoodCount = new JLabel(txtFoodCount);
            JButton jLabelFoodAdd = new JButton("+");
            JLabel jLabelFoodChoose = new JLabel(String.valueOf(countList.get(finalX)));
            JButton jLabelFoodReduce = new JButton("-");
            jLabelFoodName.setBounds(20, 80 + finalX * 35, 600, 35);
            jLabelFoodPrice.setBounds(150, 80 + finalX * 35, 600, 35);
            jLabelFoodCount.setBounds(200, 80 + finalX * 35, 600, 35);
            jLabelFoodAdd.setBounds(250, 80 + finalX * 35, 50, 25);
            jLabelFoodChoose.setBounds(310, 80 + finalX * 35, 60, 25);
            jLabelFoodReduce.setBounds(335, 80 + finalX * 35, 50, 25);
            /// 加个菜
            jLabelFoodAdd.addActionListener(e -> {
                int value = countList.get(finalX);
                if (value < food.count) {
                    countList.set(finalX, value + 1);
                    jLabelFoodChoose.setText(String.valueOf(countList.get(finalX)));
                    calculate();
                    repaint();
                }
            });
            /// 减个菜
            jLabelFoodReduce.addActionListener(e -> {
                int value = countList.get(finalX);
                if (value > 0) {
                    countList.set(finalX, value - 1);
                    jLabelFoodChoose.setText(String.valueOf(countList.get(finalX)));
                    calculate();
                    repaint();
                }
            });

            foodListJPanel.add(jLabelFoodName);
            foodListJPanel.add(jLabelFoodPrice);
            foodListJPanel.add(jLabelFoodCount);
            foodListJPanel.add(jLabelFoodAdd);
            foodListJPanel.add(jLabelFoodChoose);
            foodListJPanel.add(jLabelFoodReduce);
        }
        add(foodListJPanel);
        repaint();
    }

    /// 计算总价
    public void calculate() {
        int value = 0;
        for (int x = 0; x < foodMenuList.size(); x++) {
            value += foodMenuList.get(x).price * countList.get(x);
        }
        allPrice=value;
        showTotalPrice.setText(String.valueOf(value));
    }
}
