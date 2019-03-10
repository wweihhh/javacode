package bitetech.ds;

public class DoubleLinkedListImpl implements Sequence {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Node prev;
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public void add(Object data) {
        Node newNode = new Node(tail, data, null);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public boolean remove(int index) {
        rangCheck(index);
        Node cur = node(index);
//        Node prev = cur.prev;
//        Node next = cur.next;
        if(cur.prev == null){
            head = cur.next;
        }else{
            cur.prev.next = cur.next;
//            cur.prev = null;
        }
        if(cur.next == null){
            tail = cur.prev;
        }else{
            cur.next.prev = cur.prev;
//            cur.next = null;
        }
        cur = null;
        size--;
        return false;
    }

    @Override
    public Object get(int index) {
        rangCheck(index);
        return node(index).data;
    }

    @Override
    public boolean contains(Object data) {
        return false;
    }

    @Override
    public Object set(int index, Object newdata) {
        rangCheck(index);
        Node node = node(index);
        Object oldData = node.data;
        node.data = newdata;
        return oldData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for(Node node = head;node != null;){
            node.data = null;
            Node temp = node.next;
            node.next = null;
            node = temp;
            size--;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] data = new Object[size];
        int i = 0;
        for (Node temp = head; temp != null; temp = temp.next) {
            data[i++] = temp.data;
        }
        return data;
    }

    private void rangCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Illegal Index");
        }
    }

    private Node node(int index) {
        if (index < (size >> 1)) {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            Node temp = tail;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
            return temp;
        }
    }
}