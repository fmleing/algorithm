package algorithm;

/**
 * 二叉链表
 */
public class BiTNode<T> {
    // 数据
    T data;

    // 左孩子节点
    BiTNode lchild;
    // 右孩子节点
    BiTNode rchild;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BiTNode getLchild() {
        return lchild;
    }

    public void setLchild(BiTNode lchild) {
        this.lchild = lchild;
    }

    public BiTNode getRchild() {
        return rchild;
    }

    public void setRchild(BiTNode rchild) {
        this.rchild = rchild;
    }
}
