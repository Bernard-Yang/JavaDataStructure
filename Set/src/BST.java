import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //添加新的元素
    public void add(E e){
        root = add(root, e);
    }

    //向以node为根的二分搜索树插入元素E，递归算法
    //返回插入新节点后二分搜索树的根
    private Node add(Node node, E e){

        if (node == null){
            size ++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    public boolean contains(E e){
        return contains(root, e);

    }

    private boolean contains(Node node, E e){
        if (node == null)
            return false;
        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else //e.compareTo(node.e)>0
            return contains(node.right, e);
    }

    //前序遍历
    public void preOrder(){
        preOrder(root);
    }

    //非递归前序遍历
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);

        }
    }
    private void preOrder(Node node){

        if (node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);

    }

    //中序遍历
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){

        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);

    }

    //后序遍历
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){

        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);


    }

    public void levelOrder(){

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);

            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);

        }
    }

    //找到最小
    public E minimum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");

        return minimum(root).e;
    }

    private Node minimum(Node node){
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    //找到最大
    public E maxmum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");

        return minimum(root).e;
    }

    private Node maxmum(Node node){
        if (node.right == null)
            return node;
        return maxmum(node.right);
    }

    //删除最小并返回
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }
    //删除以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    //删除最小并返回
    public E removeMax(){
        E ret = maxmum();
        root = removeMax(root);
        return ret;
    }
    //删除以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){

        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e){
        root = remove(root,e);
    }

    //删除以node为根的二分搜索树中值为e的节点，递归节点
    //返回删除节点后的二分搜索树的根
    private Node remove(Node node,E e){

        if (node == null)
            return null;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        else if (e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }
        else {
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            //待删除节点左右子树均不为空的情况
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替掉待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;

            //待删除节点左右子树均不为空的情况
            //找到比待删除节点小的最大节点，即待删除节点左子树的最大节点
            //用这个节点顶替掉待删除节点的位置
//            Node precursor = maxmum(node.left);
//            precursor.left = removeMax(node.left);
//            precursor.right = node.right;
//
//            node.left = node.right = null;
//            return precursor;
        }

    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res){
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e +"\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);

    }


    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }




}
