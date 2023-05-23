package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import static data.Data.loginPerson;

/// 用户首页
public class UserHomeView extends JFrame {
    public UserHomeView() {
        super("欢迎"+loginPerson.nickName+"回来");

        JPanel root = new JPanel();
        root.setLayout(null);

        JButton back = new JButton("返回");
        back.setBounds(20, 15, 80, 30);
        root.add(back);

        JButton checkLock = new JButton("我要点外卖");
        checkLock.setBounds(20, 55, 260, 35);
        root.add(checkLock);

        JButton enter = new JButton("我的订单");
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

        // 我要点外卖
        checkLock.addActionListener(e -> {
            new createOrderView();
        });

        // 我的订单
        enter.addActionListener(e -> {
            new UserOrderListView();
        });

        setVisible(true);
    }

}
