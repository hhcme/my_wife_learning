package listNode;

import baseListNode.LinkListNode;
import baseListNode.SingleLinkList;
import model.FoodOrder;

import java.util.List;
import java.util.Objects;

public class OrderListNode extends SingleLinkList<FoodOrder> {

    /**
     * 查找：遍历单链表,查询是否具有某个值
     */
    public List<FoodOrder> checkValue(String phone) {
        LinkListNode<FoodOrder> p = head;
        List<FoodOrder> list = null;
        while (p.getNext() != null) {
            p = p.getNext();
            if (Objects.equals(p.getData().phone, phone)) {
                list.add(p.getData());
            }
        }
        return list;
    }
}
