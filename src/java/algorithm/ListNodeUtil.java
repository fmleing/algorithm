package algorithm;

/**
 * 单链表工具类
 */
public class ListNodeUtil {

    /**
     * 查找
     * @param nodes 单链表数据
     * @param value 查找数据
     */
    public boolean select(ListNode<Integer> nodes, Integer value) {
        ListNode<Integer> currNode = nodes;
        while (currNode.getNext() != null) {
            if (currNode.getData().equals(value)) {
                return true;
            }
            currNode = currNode.getNext();
        }
        return false;
    }

    /**
     * 删除
     * @param nodes 单链表数据
     * @param value 删除链表中存在该数据的节点
     * @return 删除后的单链表
     */
    public ListNode<Integer> deleted(ListNode<Integer> nodes, Integer value){
        // 先决判断条件
        if (nodes == null) {
            return null;
        }
        ListNode<Integer> curr = nodes;
        ListNode<Integer> next = nodes.getNext();
        // 标示位 默认没有找到
        boolean flag = false;
        while (next != null) {
            if (value.equals(next.getData())) {
                flag = true;
                break;
            }
            curr = next;
            next = next.getNext();
        }

        if (flag) {
            curr.setNext(next.getNext());
            next.setNext(null);
            next = null;
        }

        return nodes;
    }

    /**
     * 增加
     */
    public ListNode<Integer> add(ListNode<Integer> nodes, int index, Integer value) {
        // 判断index 是否符合逻辑
        if (index < 0) {
            throw new IndexOutOfBoundsException("索引越界异常："+index);
        }

        // 定位到前一个节点
        ListNode<Integer> perNode = nodes;
        for (int i = 0; i < index; i++) {
            perNode = perNode.getNext();
        }

        // 创建一个新节点
        ListNode<Integer> newNode = new ListNode<Integer>();
        newNode.setData(value);
        newNode.setNext(perNode.getNext());
        perNode.setNext(newNode);
        return nodes;
    }
}
