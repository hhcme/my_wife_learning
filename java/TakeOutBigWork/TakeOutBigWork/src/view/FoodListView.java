package view;


import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Data;
import model.FoodMenu;
import view.components.createFoodMenuDialog;

/// 菜单列表
public class FoodListView extends JFrame {
    // 获取全局的食物库存
    ArrayList<FoodMenu> foodMenuList = Data.foodMenuList.toArrayList();

    JPanel root = new JPanel();

    /// isUser : 表示是不是用户,用户为 true, 管理员为 false
    public FoodListView() {
        super("菜品库存");
        init();
    }

    public void init(){
        root.setLayout(null);

        JButton back = new JButton("返回");
        back.setBounds(20, 15, 60, 30);
        root.add(back);

        JButton createFood = new JButton("新增");
        createFood.setBounds(100, 15, 60, 30);
        root.add(createFood);

        JButton refresh = new JButton("刷新");
        refresh.setBounds(180, 15, 60, 30);
        root.add(refresh);

        JLabel foodName = new JLabel("菜名");
        foodName.setBounds(20, 50, 80, 30);
        root.add(foodName);

        JLabel foodPrice = new JLabel("价格");
        foodPrice.setBounds(150, 50, 80, 30);
        root.add(foodPrice);

        JLabel foodCount = new JLabel("库存");
        foodCount.setBounds(200, 50, 80, 30);
        root.add(foodCount);

        JLabel foodExit = new JLabel("操作");
        foodExit.setBounds(250, 50, 80, 30);
        root.add(foodExit);

        for (int x = 0; x < foodMenuList.size(); x++) {
            // 拿到单条数据
            FoodMenu food = foodMenuList.get(x);
            String txtFoodName = "" + food.name;
            String txtFoodPrice = "" + food.price;
            String txtFoodCount = "" + food.count;
            // 还需要添加gui的显示界面
            JLabel jLabelFoodName = new JLabel(txtFoodName);
            JLabel jLabelFoodPrice = new JLabel(txtFoodPrice);
            JLabel jLabelFoodCount = new JLabel(txtFoodCount);
            JButton jLabelFoodExit = new JButton("编辑");
            jLabelFoodName.setBounds(20, 80 + x * 35, 600, 35);
            jLabelFoodPrice.setBounds(150, 80 + x * 35, 600, 35);
            jLabelFoodCount.setBounds(200, 80 + x * 35, 600, 35);
            jLabelFoodExit.setBounds(250, 80 + x * 35, 60, 25);
            // 编辑菜品信息
            jLabelFoodExit.addActionListener(e -> {
                new createFoodMenuDialog(food);
                setVisible(false);
            });

            root.add(jLabelFoodName);
            root.add(jLabelFoodPrice);
            root.add(jLabelFoodCount);
            root.add(jLabelFoodExit);
        }

        // 返回
        back.addActionListener(e -> setVisible(false));

        // 新增菜品
        createFood.addActionListener(e -> {
            new createFoodMenuDialog(null);
            setVisible(false);
        });

        // 刷新
        refresh.addActionListener(e -> onRefresh());

        add(root);
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        repaint();
        setVisible(true);
    }

    /// 刷新方法
    public void onRefresh(){
        setVisible(false);
        new FoodListView();
    }

}
