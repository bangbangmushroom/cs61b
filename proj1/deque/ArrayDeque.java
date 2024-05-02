package deque;

import java.lang.reflect.Array;

public class ArrayDeque<T> implements Deque<T> {
    int DataStart = 0;
    int DataEnd = 0;
    int DataSize = 0;
    int arraysize = 8;
    T[] array = (T[]) new Object[arraysize];

    private int conpoent(int seq){
        if (seq >= 0) {
            while (seq >= arraysize)
                seq %= arraysize;
            return seq;
        }
        else {
            while (seq > -arraysize)
                seq %= arraysize;
            return seq + arraysize;
        }
    }

    /* this is naked cercle array
    *  useage : inedx[conertIndex(index)];
    *  good for remove and add
     */
    private int conertIndex(int index){
        int conpoent = conpoent(index);
        return (DataStart + conpoent) % arraysize;
    }

}
