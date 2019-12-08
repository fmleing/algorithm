package algorithm;

/**
 * 单链表
 * 描述：单链表是一种链式存取的数据结构，用一组地址任意的存储单元存放线性表中的数据元素。
 * 链表中的数据是以结点来表示的，每个结点的构成：元素(数据元素的映象) + 指针(指示后继元素存储位置)，
 * 元素就是存储数据的存储单元，指针就是连接每个结点的地址数据。
 * 本质：一种链式存取的数据结构
 */
public class ListNode<T> {
    // 下一个节点
    ListNode<T> next;
    // 节点数据
    T data;

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
