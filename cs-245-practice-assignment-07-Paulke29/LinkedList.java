public class LinkedList<T> implements List<T> {
    // 链表查询的开始节点
    private Node first;

    // 链表默认从末尾节点开始添加新的节点
    private Node last;

    //当前节点的个数
    private int size;
    // default Object array;
    private Object[] elements=null;
    private int current;
    // default size;
    // dafault size of array;
    private int capacity;
    public static final int DEFAULT_SIZE=10;
    public LinkedList(){
        this(DEFAULT_SIZE);
    }
    public LinkedList(int size){
        if (size<0){
            throw new RuntimeException();
        }else {
            this.elements=new Object[size];
            this.current=0;
            capacity=size;
        }
    }

    public void add(Object obj) {
        Node newNode = new Node();
        newNode.value = obj;
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        this.size++;
        this.current++;
    }

    public T remove(int index) {
        checkElementIndex(index);
//        if (index == 0) { // 第一个节点
//            first = first.next;
//            if (first != null)
//                first.prev = null;
//        } else if (index == size - 1) { // 最后一个节点
//            last = last.prev;
//            last.next = null;
//        } else {
//            Node current = (Node<T>)getNode(index);
//            Node node1 = current.prev;
//            Node node3 = current.next;
//            node1.next = node3;
//            node3.prev = node1;
//        }
        this.size--;
        this.current--;
        return (T) getNode(index);
    }

    public Node<T> getNode(int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public void add(int pos, T item) {
//        checkElementIndex(pos);
        Node temp = null;
        if(first!=null) {
            temp = first;
            for(int i=0;i<pos;i++) {
                temp = temp.next;
            }
        }
        Node newNode = new Node();
        newNode.value = item;
        if(temp!=null) {
            newNode.prev=temp.prev;
            newNode.next=temp;
            temp.prev=newNode;
            newNode.prev.next=newNode;
            this.size++;
        }
        this.current++;

    }

    public T get(int index) {
        checkElementIndex(index);
        return getNode(index).value;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public int size() {
        return this.size;
    }
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
////            System.out.println("Hello");
//            throw new IndexOutOfBoundsException("查询越界啦！");
            add(index);
    }

    private boolean isElementIndex(int index) {

        return index >= 0 && index < size;
    }


}
