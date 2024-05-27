package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>{
    private node sennital;
    private class node<T>{
        protected T item;
        protected node pre;
        protected node nest;
    }

    private int size;

    LinkedListDeque(T i){
        node n = new node<T>();
        n.pre = n;
        n.nest = n;
        sennital = n;
    }

    /**
     * @param item
     */
    @Override
    public void addFirst(T item) {
        node<T> nede = new node();
        nede.pre = sennital;
        nede.nest = sennital.nest;
    }

    /**
     * @param item
     */
    @Override
    public void addLast(T item) {

    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * @return
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     *
     */
    @Override
    public void printDeque() {

    }

    /**
     * @return
     */
    @Override
    public T removeFirst() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public T removeLast() {
        return null;
    }

    /**
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
