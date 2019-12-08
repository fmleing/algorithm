package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉链表工具类
 */
public class BiTNodeUtil {

    /**
     * 前序遍历
     * 从二叉树的根结点出发，当第一次到达结点时就输出结点数据，按照先向左在向右的方向访问。
     */
    public static String preorderTraversal(BiTNode biTNode) {
        String traversal = "";
        // 先遍历根节点
        if (biTNode != null) {
            traversal += biTNode.getData();
            traversal += preorderTraversal(biTNode.getLchild());
            traversal += preorderTraversal(biTNode.getRchild());
        }
        return traversal;
    }

    /**
     * 中序遍历
     * 从二叉树的根结点出发，当第二次到达结点时就输出结点数据，按照先向左在向右的方向访问。
     */
    public static String sequentialTraversal(BiTNode biTNode) {
        String traversal = "";
        // 先遍历左节点
        if (biTNode != null ) {
            traversal += sequentialTraversal(biTNode.getLchild());
            traversal += biTNode.getData();
            traversal += sequentialTraversal(biTNode.getRchild());
        }
        return traversal;
    }

    /**
     * 后序遍历
     * 从二叉树的根结点出发，当第三次到达结点时就输出结点数据，按照先向左在向右的方向访问。
     */
    public static String postOrderTraversal(BiTNode biTNode) {
        String traversal = "";
        // 先遍历左节点
        if (biTNode != null ) {
            traversal += postOrderTraversal(biTNode.getLchild());
            traversal += postOrderTraversal(biTNode.getRchild());
            traversal += biTNode.getData();
        }
        return traversal;
    }

    /**
     * 层序遍历
     * 按照树的层次自上而下的遍历二叉树。
     */
    public static String layerTraversal(BiTNode biTNode){
        String traversal = "";
        // 创建一个队列
        List<BiTNode> biTNodeList = new ArrayList<BiTNode>();
        // 初始化队列
        if (biTNode == null) {
            return traversal;
        }
        biTNodeList.add(biTNode);
        // 初始化定位数据
        int per = 0;
        int tail = biTNodeList.size();
        while (per < tail) {
            BiTNode curr = biTNodeList.get(per);
            traversal += curr.getData();
            if (curr.getLchild() != null) {
                biTNodeList.add(curr.getLchild());
            }
            if (curr.getRchild() != null) {
                biTNodeList.add(curr.getRchild());
            }
            // 刷新定位数据，per向后移动一位，tail更新为最新队列大小。
            per++;
            tail = biTNodeList.size();
        }
        return traversal;
    }

    public static void main(String[] args) {
        BiTNode<String> a = new BiTNode<String>();
        a.setData("a");
        BiTNode<String> b = new BiTNode<String>();
        b.setData("b");
        BiTNode<String> c = new BiTNode<String>();
        c.setData("c");
        BiTNode<String> d = new BiTNode<String>();
        d.setData("d");
        BiTNode<String> e = new BiTNode<String>();
        e.setData("e");
        BiTNode<String> f = new BiTNode<String>();
        f.setData("f");
        BiTNode<String> g = new BiTNode<String>();
        g.setData("g");
        BiTNode<String> h = new BiTNode<String>();
        h.setData("h");
        BiTNode<String> i = new BiTNode<String>();
        i.setData("i");
        BiTNode<String> j = new BiTNode<String>();
        j.setData("j");
        a.setLchild(b);
        a.setRchild(c);
        b.setLchild(d);
        b.setRchild(e);
        c.setLchild(f);
        c.setRchild(g);
        d.setLchild(h);
        d.setRchild(i);
        e.setLchild(j);
        System.out.println("前序：" + preorderTraversal(a));
        System.out.println("中序：" + sequentialTraversal(a));
        System.out.println("后序：" + postOrderTraversal(a));
        System.out.println("层序：" + layerTraversal(a));
    }
}
