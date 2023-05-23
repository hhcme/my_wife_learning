package view;

import data.Data;
import model.FoodMenu;
import model.FoodOrder;

import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

import static data.Data.loginPerson;

/// 查看个人订单信息
public class UserOrderListView extends JFrame {

    ArrayList<FoodOrder> orderList = Data.orderListNode.toArrayList();

    JPanel root = new JPanel();

    public UserOrderListView() {
        super(loginPerson.nickName+"的全部订单");
        init();
    }

    public void init() {
        root.setLayout(null);

        JButton back = new JButton("返回");
        back.setBounds(20, 15, 60, 30);
        root.add(back);

        JButton refresh = new JButton("刷新");
        refresh.setBounds(100, 15, 60, 30);
        root.add(refresh);

        JLabel foodCreateTime = new JLabel("下单时间");
        foodCreateTime.setBounds(20, 50, 120, 30);
        root.add(foodCreateTime);

        JLabel foodList = new JLabel("菜品");
        foodList.setBounds(180, 50, 200, 30);
        root.add(foodList);

        JLabel foodCount = new JLabel("总价");
        foodCount.setBounds(430, 50, 50, 30);
        root.add(foodCount);

        JLabel orderStatus = new JLabel("状态");
        orderStatus.setBounds(480, 50, 80, 30);
        root.add(orderStatus);

        // 定义时间格式
        String format = "YYYY-MM-dd hh:mm:ss";

        for (int x = 0; x < orderList.size(); x++) {
            if (!Objects.equals(orderList.get(x).phone, loginPerson.phone)) {
                continue;
            }
            // 拿到单条数据
            FoodOrder order = orderList.get(x);
            String txtFoodCreateTime = order.createTime.format(DateTimeFormatter.ofPattern(format));
            String txtFoodList = "";
            System.out.println(" " + order.foodList.getLength());
            for (int y = 0; y < order.foodList.getLength(); y++) {
                FoodMenu food = order.foodList.getByIndex(y+1).getData();
                txtFoodList+=food.name+" ";
            }

            String txtFoodPrice = "" + order.priceTotal;
            // 还需要添加gui的显示界面
            JLabel jLabelFoodName = new JLabel(txtFoodCreateTime);
            JLabel jLabelFoodList = new JLabel(txtFoodList.toString());
            JLabel jLabelFoodPrice = new JLabel(txtFoodPrice);

            jLabelFoodName.setBounds(20, 80 + x * 35, 600, 35);
            jLabelFoodList.setBounds(180, 80 + x * 35, 600, 35);
            jLabelFoodPrice.setBounds(430, 80 + x * 35, 600, 35);

            root.add(jLabelFoodName);
            root.add(jLabelFoodList);
            root.add(jLabelFoodPrice);
            if (order.completeTime == null) {
                JButton jLabelFoodExit = new JButton("编辑");
                jLabelFoodExit.setBounds(470, 80 + x * 35, 60, 30);
                root.add(jLabelFoodExit);
                // 编辑菜品信息
                jLabelFoodExit.addActionListener(e -> {
//                    setVisible(false);
                });
            } else {
                String txtFoodCompleteTime = order.completeTime.format(DateTimeFormatter.ofPattern(format));
                JLabel jLabelFoodExit = new JLabel(txtFoodCompleteTime);
                jLabelFoodExit.setBounds(480, 80 + x * 35, 60, 35);
                root.add(jLabelFoodExit);
            }
        }

        // 返回
        back.addActionListener(e -> setVisible(false));

        // 刷新
//        refresh.addActionListener(e -> onRefresh());

        add(root);
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        repaint();
        setVisible(true);
    }
}
