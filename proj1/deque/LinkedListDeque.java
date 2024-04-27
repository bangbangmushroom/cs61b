package deque;
import org.junit.Test;

public class LinkedListDeque<tp>{
    int size = 0;
    private Node sentinel;

    private class Node{
        public tp item;
        public Node prev;
        public Node next;
    }

    public LinkedListDeque(){
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(tp item){
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = sentinel.next;
        newNode.prev = sentinel;
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    public void addLast(tp item){
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = sentinel;
        newNode.prev = sentinel.prev;
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node p = sentinel.next;
        while(p != sentinel){
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public tp removeFirst(){
        if(size == 0){
            return null;
        }
        Node first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        size--;
        return first.item;
    }

    public tp removeLast(){
        if(size == 0){
            return null;
        }
        Node last = sentinel.prev;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        size--;
        return last.item;
    }

    public boolean equals(Object o)

    {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        // comfirm object o is LinkedListDeque

        LinkedListDeque other = (LinkedListDeque) o;
        // convert object o to LinkedListDeque

        if (other.size() != this.size()) {
            return false;
        }

        Node p = sentinel.next;
        Node q = other.sentinel.next;
        while (p != sentinel) {
            if (!p.item.equals(q.item)) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

    public tp get(int index){
        if(index >= size){
            return null;
        }
        Node p = sentinel.next;
        for(int i = 0; i < index; i++){
            p = p.next;
        }
        return p.item;
    }
    
    public tp getRecursive(int index){
        if(index >= size){
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }
    
    private tp getRecursiveHelper(Node p, int index){
        if(index == 0){
            return p.item;
        }
        tp recursiveHelper = getRecursiveHelper(p.next, index - 1);
        return recursiveHelper;
    }
}


