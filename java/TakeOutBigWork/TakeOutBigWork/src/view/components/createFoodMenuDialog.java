package view.components;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.Data;
import model.FoodMenu;
import view.FoodListView;

/// 新建或修改菜品信息弹窗
public class createFoodMenuDialog extends JFrame {
    public createFoodMenuDialog(FoodMenu food) {
        super("更新菜品信息");

        JPanel root = new JPanel();
        root.setLayout(null);

        JButton back = new JButton("返回");
        back.setBounds(25, 15, 60, 30);
        root.add(back);

        JLabel foodName = new JLabel("菜名:");
        foodName.setBounds(25, 55, 50, 35);
        root.add(foodName);

        JTextField changeFoodName = new JTextField(food != null ? food.name : "", 20);
        changeFoodName.setBounds(60, 60, 220, 25);
        root.add(changeFoodName);

        JLabel foodPrice = new JLabel("价格:");
        foodPrice.setBounds(25, 95, 50, 35);
        root.add(foodPrice);

        JTextField changeFoodPrice = new JTextField(food != null ? String.valueOf(food.price) : "", 20);
        changeFoodPrice.setBounds(60, 100, 220, 25);
        root.add(changeFoodPrice);

        JLabel foodCount = new JLabel("数量:");
        foodCount.setBounds(25, 135, 50, 35);
        root.add(foodCount);

        JTextField changeFoodCount = new JTextField(food != null ? String.valueOf(food.count) : "", 20);
        changeFoodCount.setBounds(60, 140, 220, 25);
        root.add(changeFoodCount);

        JButton updateFood = new JButton(food != null ? "更新" : "添加");
        updateFood.setBounds(20, 180, 60, 30);
        root.add(updateFood);

        if (food != null) {
            JButton deleteFood = new JButton("删除");
            deleteFood.setBounds(100, 180, 60, 30);
            root.add(deleteFood);
            // 删除
            deleteFood.addActionListener(e -> {

                /// 根据传入的 food 去寻找 对应的需要更新的菜品下标
                int index = Data.foodMenuList.getByData(food);
                Data.foodMenuList.deleteByIndex(index);
                System.out.println("更新成功");

                new FoodListView();
                setVisible(false);
            });
        }

        // 返回
        back.addActionListener(e -> {
            new FoodListView();
            setVisible(false);
        });

        // 新增
        updateFood.addActionListener(e -> {
            /// 逐个校验里面的参数
            /// 如果菜名不为空
            if (changeFoodName.getText().isEmpty()) {
                return;
            }

            /// 如果菜品价格不为空且大于0
            if (changeFoodPrice.getText().isEmpty() || Integer.parseInt(changeFoodPrice.getText()) <= 0) {
                return;
            }

            /// 如果菜品库存不为空且大于0
            if (changeFoodCount.getText().isEmpty() || Integer.parseInt(changeFoodCount.getText()) <= 0) {
                return;
            }

            /// 如果开始的入参 food 不为 null ,则代表是更新,先寻找原先的数据,然后直接覆盖上去
            /// 如果 food 为null, 则是新增,直接在菜单链表的尾部新增一个
            if (food == null) {
                Data.foodMenuList.insert(new FoodMenu(changeFoodName.getText(), Integer.parseInt(changeFoodPrice.getText()), Integer.parseInt(changeFoodCount.getText())));
            } else {
                /// 根据传入的 food 去寻找 对应的需要更新的菜品下标
                int index = Data.foodMenuList.getByData(food);
                /// 生成新的菜单,用作替换原来的节点的 data
                FoodMenu newFoodMenu = new FoodMenu(changeFoodName.getText(), Integer.parseInt(changeFoodPrice.getText()), Integer.parseInt(changeFoodCount.getText()));
                /// 更新原来节点的 data
                Data.foodMenuList.update(index, newFoodMenu);
                System.out.println("更新成功");
            }
            new FoodListView();
            setVisible(false);
        });

        add(root);
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        repaint();
        setVisible(true);
    }
}
