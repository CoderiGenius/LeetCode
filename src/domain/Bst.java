package domain;

import java.util.Stack;

/**
 * 二分搜素树 查找 添加
 * @param <E>
 */

public class Bst <E extends Comparable<E>> {


    /**
     * 二分查找,递归
     *
     * @param e
     * @return
     */
    Node findRecuseve(E e, Node n) {
        if (n == null) {
            return null;
        }
        if (e.equals(n.e)) return n;
        if (n.e.compareTo(e) > 0) {
            return findRecuseve(e, n.left);
        } else {
            return findRecuseve(e, n.right);
        }
    }


    /**
     * 二分查找,递归
     *
     * @param e
     * @return
     */
    Node findLinked(E e, Node n) {
        if (n == null) {
            return null;
        }
        while (n != null) {
            if (e.equals(n.e)) return n;
            if (n.e.compareTo(e) > 0) {
                n = n.left;
            } else {
                n = n.right;
            }
        }
        return null;
    }

    /**
     * 前序遍历非递归 用栈
     * @param node
     */
    static void DLRStack(Node<Integer> node) {
        if (node == null) {
            return;
        }
        Stack<Node<Integer>> stack = new Stack<>();
        while (node!=null){
            System.out.println(node.e);
            if(node.right!=null){
                stack.add(node.right);
            }
            if (node.left != null) {
                node = node.left;
            }else {
                try {
                    node = stack.pop();
                } catch (Exception e) {
                    node = null;
                }
            }

        }
    }

    /**
     * 前序遍历
     * @param node
     */
    static void DLR(Node node) {

        if(node==null)return;
        System.out.println(node.e);
        DLR(node.left);
        DLR(node.right);
    }


    /**
     * 中序遍历
     * @param node
     */
    static void LDR(Node node) {

        if(node==null)return;

        LDR(node.left);
        System.out.println(node.e);
        LDR(node.right);
    }

    /**
     * 后序遍历
     * @param node
     */
    static void LRD(Node node) {

        if(node==null)return;

        LRD(node.left);
        LRD(node.right);
        System.out.println(node.e);
    }

    public static void main(String[] args) {
        Node node = new Node(null,null, 3);
        Node node1 = new Node(null,null,4);
        Node node2 = new Node(node,node1,2);
        Node node3 = new Node(null,null,6);
        Node node4 = new Node(null,null,7);
        Node node5 = new Node(node3,node4,5);
        Node node6 = new Node(node2,node5,1);
//        LDR(node6);
        DLRStack(node6);

    }

}



class Node <E extends Comparable<E>>{
    Node<E> left;
    Node<E> right;
    public E e;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public Node(Node left, Node right, E e) {
        this.left = left;
        this.right = right;
        this.e = e;
    }
}
