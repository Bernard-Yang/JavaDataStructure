public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }


        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    //获取元素
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //链表的index(0-based)添加元素e
    public void add(E e){

//
//        if (index < 0 || index > size)
//            throw new IllegalArgumentException("Add failed. Illegal index.");
//
//            Node prev = dummyHead;
//            for (int i = 0 ; i < index ; i ++)
//                prev = prev.next;
//
//            prev.next = new Node(e, prev.next);
//            size ++;
        dummyHead.next = add(dummyHead.next,e);
    }

    private Node add(Node node, E e){
        if (node == null){
            size ++;
            return new Node(e);
        }

        node.next = add(node.next, e);

        return node;
    }

    //链表头添加元素e
//    public void addFirst(E e){
//        // Node node = new Node(e);
//        // node.next = head;
//        // head = node;
//
//        // head = new Node(e, head);
//
//        add(e,0);
//    }
//
//    public void addLast(E e){
//        add(e, size);
//    }

    //获得链表的第index个位置的元素(练习)
    public E get(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        Node cur = dummyHead.next;
        for (int i = 0 ; i < index  ; i ++)
            cur = cur.next;
        return cur.e;
    }

    //获得链表的第1个位置的元素(练习)
    public E getFirst(){
        return get(0);
    }

    //获得链表的最后一个位置的元素(练习)
    public E getLast(){
        return get(size - 1);
    }

    //修改链表的第index个位置的元素为e(练习)
    public void set(int index, E e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set failed. Illegal index.");
        Node cur = dummyHead.next;
        for (int i = 0 ; i < index  ; i ++)
            cur = cur.next;
        cur.e = e;
    }

    //查找链表中是否存在元素e(练习)
    public boolean contains(E e){
        Node cur = dummyHead.next;
        //for (int i = 0 ; i < size - 1  ; i ++)
        while(cur != null){
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    //删除第index个元素e并返回
    public E remove(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        Node prev = dummyHead;
        for (int i = 0 ; i < index ; i ++)
            prev = prev.next;

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;

        return retNode.e;
    }

    //删除第1个元素e并返回
    public E removeFirst(){
        return remove(0);
    }

    //删除最后一个元素e并返回
    public E removeLast(){
        return remove(size -1 );
    }

    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();

        //for (Node cur = dummyHead.next; cur != null; cur=cur.next)
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }

        res.append("NULL");
        return res.toString();
    }
}






