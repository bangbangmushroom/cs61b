package deque;

import java.lang.reflect.Array;
import java.util.Date;

public class ArrayDeque<T> implements Deque<T> {
    int DataStart = 0;
    int DataEnd = 0;
    int DataSize = 0;
    int arraysize = 7;
    int arrytmp = 8;
    T[] array = (T[]) new Object[arrytmp];

    private int conpoent(int seq){
        if (seq >= 0) {
            return seq;
        }
        else {
            seq = seq + arraysize;
            seq = seq % arraysize;
            return seq;
        }
    }


    private int convertSeq(int seq){
        int absseq = Math.abs(seq);
        while (absseq % arraysize > arraysize)
            absseq %= arraysize;

        if (seq >= 0)
            return absseq;
        else
            return -absseq;
    }

    public int clcle(int seq){
        int ret = seq;
        ret = convertSeq(ret);
        //let it become minus
        ret = conpoent(ret);
        //conpoent it
        ret = ret + DataStart;
        //add the start
        ret = ret % arraysize;
        //mod it
        return ret;
    }

    private void resize(int newsize){
        T[] newarray = (T[]) new Object[newsize];
        newsize = newsize - 1;
        if (DataStart == DataEnd){
            return;
        }

        if (DataStart < DataEnd) {
            System.arraycopy(array, DataStart, newarray, 0, DataSize);
        }

        if (DataEnd < DataStart){
            int gap1 = DataEnd;
            int gap2 = arraysize - DataStart;
            int gap3 = DataSize - gap2;

            System.arraycopy(array, 0, newarray, 0, gap1);
            System.arraycopy(array, DataStart, newarray, newsize - (arraysize - DataSize), arraysize - DataSize);

        }
    }

    public void addFirst(T item){
        int realsize;
        if (DataSize == arraysize){
            resize(arraysize * 2);
        }
        realsize = clcle(-1);
        array[realsize] = item;
        DataStart = realsize;
        DataSize++;
    }

    public void addLast(T item){
        int realseq;
        if (DataSize == arraysize){
            resize(arraysize * 2);
        }
        realseq = clcle(DataEnd);
        array[realseq] = item;
        DataEnd = realseq;
        DataSize++;
    }

    public boolean isEmpty(){
        return DataSize == 0;
    }

    public int size(){
        return DataSize;
    }

    public void printDeque(){
        int i = DataStart;

        while (i != DataEnd){
            System.out.print(array[i] + " ");
            i = clcle(i + 1);
        }
        System.out.println();
    }

    public T removeFirst(){
        if (DataSize == 0){
            return null;
        }
        T ret = array[DataStart];
        array[DataStart] = null;
        DataStart = clcle(DataStart + 1);
        DataSize--;
        return ret;
    }

    public T removeLast(){
        if (DataSize == 0){
            return null;
        }
        T ret = array[DataEnd];
        array[DataEnd] = null;
        DataEnd = clcle(DataEnd - 1);
        DataSize--;
        return ret;
    }

    public T get(int index){
        if (index >= DataSize){
            throw new IndexOutOfBoundsException("index out of range");
        }
        return array[clcle(DataStart + index)];
    }

}
