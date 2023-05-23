package model;

import baseListNode.SingleLinkList;

import java.time.LocalDateTime;

public class FoodOrder {
    public FoodOrder(String nickName, String phone, SingleLinkList<FoodMenu> foodList, int priceTotal, LocalDateTime createTime, LocalDateTime completeTime) {
        this.nickName = nickName;
        this.phone = phone;
        this.foodList = foodList;
        this.priceTotal = priceTotal;
        this.createTime = createTime;
        this.completeTime = completeTime;
    }

    /// 联系人
    public String nickName;
    /// 手机号
    public String phone;
    /// 菜品列表
    public SingleLinkList<FoodMenu> foodList;
    /// 总价
    public int priceTotal;
    /// 下单时间
    public LocalDateTime createTime;
    /// 收货时间
    public LocalDateTime completeTime;
}
