package baseListNode;

public class LinkListNode<T> {

    private T data; // 结点的数据域

    private LinkListNode<T> next; // 下一个结点

    public LinkListNode() {
    }

    public LinkListNode(T data) {
        this.data = data;
        this.next = null;
    }

    public LinkListNode(T data, LinkListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkListNode<T> next) {
        this.next = next;
    }

}
