package listNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import baseListNode.LinkListNode;
import baseListNode.SingleLinkList;
import model.Person;

public class PersonListNode extends SingleLinkList<Person> {

    /**
     * 查找：遍历单链表,查询是否具有某个值
     */
    public Person checkValue(String phone) {
        LinkListNode<Person> p = head;

        while (p.getNext() != null) {
            p = p.getNext();
            if (Objects.equals(p.getData().phone, phone)) {
                return p.getData();
            }
        }
        return null;
    }
}
