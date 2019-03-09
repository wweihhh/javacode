package bitetech.ds;

public class SequenceLinkImpl implements Sequence {
    private Node dummyHead;
    private int size;

    public SequenceLinkImpl(){
        this.dummyHead=new Node(null,null);
    }
    private class Node{
        Object data;
        Node next;
        public Node(Object data,Node next){
            this.data=data;
            this.next=next;
        }
        public Node(Object data){
            this.data=data;
        }
    }
    @Override
    public void add(Object data) {
        addLast(data);
    }

    @Override
    public boolean remove(int index) {
        rangCheck(index);
        Node prev = dummyHead;
        for(int i = 0;i < index;i++){
            prev = prev.next;
        }
        Node cur = node(index);
        prev.next = cur.next;//前驱指向当前节点的下一个节点
        cur.next = cur = null;//清空当前节点
        size--;
        return true;
    }

    @Override
    public Object get(int index) {
        rangCheck(index);
        //取得相应的Node节点
        Node node=node(index);
        return node.data;
    }

    @Override
    public boolean contains(Object data) {
        Object[] datas=toArray();
        if(data == null){
            for(int i = 0;i < datas.length;i++){
                if(datas[i] == data){
                    return true;
                }
            }
        }else{
            for(int i = 0;i < datas.length;i++){
                if(data.equals(datas[i])){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object newdata) {
        rangCheck(index);
        //取得相应的Node节点
        Node node=node(index);
        Object oldData=node.data;
        node.data=newdata;
        return oldData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for(Node node = dummyHead.next;node!=null;){
            node.data = null;
            Node temp = node.next;
            node.next = null;
            node = temp;
            size--;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] datas = new Object[size];
        int i = 0;
        for(Node temp = dummyHead.next;temp!=null;temp=temp.next){
            datas[i++]=temp.data;
        }
        return datas;
    }
    //任意位置插入
    public void add(int index,Object data){
        rangCheck(index);
        Node prev=dummyHead;
        //找到前驱节点
        for(int i = 0;i < index;i++){
            prev=prev.next;
        }
        Node newNode=new Node(data);
        newNode.next=prev.next;
        prev.next=newNode;
        size++;
    }
    private void addFirst(Object data){
        add(0,data);
    }
    private void addLast(Object data){
        add(size,data);
    }
    //判断index是否合法
    private void rangCheck(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("index Illegal");
        }
    }
    //找到index的当前节点
    private Node node(int index){
        Node cur=dummyHead.next;
        for(int i = 0;i < index;i++){
            cur=cur.next;
        }
        return cur;

    }
}
