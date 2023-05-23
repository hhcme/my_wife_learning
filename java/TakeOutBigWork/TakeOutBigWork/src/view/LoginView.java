package view;

import data.Data;
import listNode.PersonListNode;
import model.Person;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/// 登录首页
public class LoginView extends JFrame {

    // 首页入口
    public LoginView() {
        super("用户界面");
        PersonListNode personList = Data.personList;

        JPanel root = new JPanel();
        root.setLayout(null);
        JLabel user = new JLabel("账号:");
        user.setBounds(25, 20, 50, 35);
        root.add(user);

        JTextField textUser = new JTextField("", 20);
        textUser.setBounds(60, 20, 220, 35);
        root.add(textUser);

        JLabel pass = new JLabel("密码:");
        pass.setBounds(25, 60, 50, 35);
        root.add(pass);

        JTextField textPass = new JTextField("", 20);
        textPass.setBounds(60, 60, 220, 35);
        root.add(textPass);

        JButton login = new JButton("用户登录");
        login.setBounds(20, 100, 120, 35);
        root.add(login);

        JButton mangerLogin = new JButton("管理员登录");
        mangerLogin.setBounds(160, 100, 120, 35);
        root.add(mangerLogin);

        JLabel tips = new JLabel("");
        tips.setBounds(25, 190, 120, 35);
        root.add(tips);

        add(root);

        setSize(300, 600);

        // 进行登录操作
        login.addActionListener(e -> {

            /// 首先查询用户列表内有没有这个手机号,有就代表已经注册了
            Person person = personList.checkValue(textUser.getText());

            // 先判断ID
            if (person == null) {
                System.out.println("无此用户");
                tips.setText("无此用户");
                repaint();
                return;
            }
            if (!Objects.equals(person.passWord, textPass.getText())) {
                System.out.println("密码错误");
                tips.setText("密码错误");
                repaint();
                return;
            }

            // 定义时间格式
            String format = "YYYY-MM-dd hh:mm:ss";
            // 获取现在的时间
            LocalDateTime time = LocalDateTime.now();
            System.out.println("登录成功 => " + person.nickName + " " + time.format(DateTimeFormatter.ofPattern(format)));
            Data.isUser = true;
            Data.loginPerson = person;

            tips.setText("");
            repaint();
            new UserHomeView();
            setVisible(false);
        });

        // 管理员登录
        mangerLogin.addActionListener(e -> {

//            if (!Objects.equals("hyc", textUser.getText())) {
//                System.out.println("管理员账号错误");
//                tips.setText("管理员账号错误");
//                repaint();
//                return;
//            }
//
//            if (!Objects.equals("123456", textPass.getText())) {
//                System.out.println("密码错误");
//                tips.setText("密码错误");
//                repaint();
//                return;
//            }

            // 定义时间格式
            String format = "YYYY-MM-dd hh:mm:ss";
            // 获取现在的时间
            LocalDateTime time = LocalDateTime.now();
            System.out.println("管理员登录成功 => " + time.format(DateTimeFormatter.ofPattern(format)));

            Data.isUser = false;
            tips.setText("");
            new MangerHomeView();
            setVisible(false);
        });

        setVisible(true);
    }
}
