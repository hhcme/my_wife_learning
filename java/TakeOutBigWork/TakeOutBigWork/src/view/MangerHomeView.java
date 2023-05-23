package view;

import javax.swing.*;

import data.Data;

/// 管理员首页
public class MangerHomeView extends JFrame {
    public MangerHomeView() {
        super("hyc的管理员界面");

        JPanel root = new JPanel();
        root.setLayout(null);

        JButton back = new JButton("返回");
        back.setBounds(20, 15, 80, 30);
        root.add(back);

        JButton checkLock = new JButton("查询菜品");
        checkLock.setBounds(20, 55, 260, 35);
        root.add(checkLock);

        JButton enter = new JButton("查看订单信息");
        enter.setBounds(20, 120, 260, 35);
        root.add(enter);

        add(root);
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 返回
        back.addActionListener(e -> {
            setVisible(false);
            new LoginView();
            validate();
        });

        // 查询菜品
        checkLock.addActionListener(e -> {
            new FoodListView();
            validate();
        });

        // 查看订单信息
        enter.addActionListener(e -> {

        });

        setVisible(true);
    }

}
