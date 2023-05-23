package listNode;

import java.util.Objects;

import baseListNode.LinkListNode;
import baseListNode.SingleLinkList;
import model.FoodMenu;
import model.Person;

public class foodMenuListNode extends SingleLinkList<FoodMenu> {

    /**
     * 查找菜名
     */
    public FoodMenu checkValue(String name) {
        LinkListNode<FoodMenu> p = head;

        while (p.getNext() != null) {
            p = p.getNext();
            if (Objects.equals(p.getData().name, name)) {
                return p.getData();
            }
        }
        return null;
    }
}
