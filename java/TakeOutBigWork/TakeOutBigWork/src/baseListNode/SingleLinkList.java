package baseListNode;

import java.util.ArrayList;

public class SingleLinkList<T> {

    public LinkListNode<T> head;// 定义单链表的头结点

    private int length;// 用来记录单链表的长度

    /**
     * 单链表的初始化 init() 无参
     */
    public SingleLinkList() {
        this.head = new LinkListNode<T>();
    }

    /**
     * 单链表的初始化 init() 有参
     */
    public SingleLinkList(T data, LinkListNode<T> next) {
        this.head = new LinkListNode<T>();
        LinkListNode<T> node = new LinkListNode<T>();
        node.setData(data);
        node.setNext(next);
        head.setNext(node);
    }

    /**
     * 求单链表长度
     */
    public int getLength() {
        return length;
    }

    /**
     * 更新: 通过传入原有的数据进行指定更新
     */
    public void update(int index, T data) {
        /// 先根据指定下标匹配到对应的节点
        LinkListNode<T> oldData = getByIndex(index);
        /// 设置新的节点
        oldData.setData(data);
    }

    /**
     * 新增：默认在最后插入一个数据元素；
     */
    public LinkListNode<T> insert(T data) {
        LinkListNode<T> newNode = new LinkListNode<T>(data);
        LinkListNode<T> p = head;
        while (p.getNext() != null) {
            p = p.getNext();
        }
        p.setNext(newNode);
        length++;
        return newNode;
    }

    /**
     * 新增：在位置i插入一个数据元素；
     */
    public void insertByIndex(int index, T data) {
        // 如果位置i大于了单链表的长度 或者 位置不合理 则直接将新结点添加到最后
        if (index > length || index - 1 < 0) {
            insert(data);
            return;
        }
        index--;
        // 将指针p指向首元结点
        LinkListNode<T> p = head;
        while (index != 0) {
            p = p.getNext();
            index--;
        }
        LinkListNode<T> newNode = new LinkListNode<T>(data, p.getNext());
        p.setNext(newNode);
        length++;
    }

    /**
     * 查找：按位置查找
     */
    public LinkListNode<T> getByIndex(int index) {
        // 如果查找的元素大于了单链表的长度则返回null
        if (index > length) {
            return null;
        }
        // 将指针p指向头结点
        LinkListNode<T> p = head;
        while (index != 0) {
            p = p.getNext();
            index--;
        }
        return p;
    }

    /**
     * 查找：按值查找
     */
    public int getByData(T data) {
        // 将指针p指向首元结点
        LinkListNode<T> p = head;
        int index = 0;
        while (p.getNext() != null) {
            p = p.getNext();
            index++;
            if (p.getData().equals(data)) {
                return index;
            }
        }
        if (index == length && !p.getData().equals(data)) {
            return 0;
        }
        return index;
    }

    /**
     * 查找：遍历单链表
     */
    public void traverse() {
        LinkListNode<T> p = head;
        while (p.getNext() != null) {
            p = p.getNext();
            System.out.println("结点值：" + p.getData());
        }
    }

    /**
     * 删除：按位置i删除数据元素；
     */
    public T deleteByIndex(int index) {
        // 如果位置i大于了单链表的长度则返回null
        if (index > length || index - 1 < 0) {
            return null;
        }
        // 提前将index-- 是为了将p指针移到被删除元素的前一个位置
        index--;
        // 将指针p指向头结点
        LinkListNode<T> p = head;
        while (index != 0) {
            p = p.getNext();
            index--;
        }
        T res = p.getNext().getData();
        p.setNext(p.getNext().getNext());
        length--;
        return res;
    }

    public ArrayList<T> toArrayList() {
        LinkListNode<T> p = head;
        ArrayList<T> list = new ArrayList<>();
        while (p.getNext() != null) {
            p = p.getNext();
            list.add(p.getData());
        }
        return list;
    }

    /**
     * 合并链表
     */
    public void marge(SingleLinkList<T> singleLinkList) {
        LinkListNode<T> p = head;
        length = length + singleLinkList.length;
        while (p.getNext() != null) {
            p = p.getNext();
        }
        p.setNext(singleLinkList.head.getNext());
    }
}
