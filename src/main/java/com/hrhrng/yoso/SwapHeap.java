package com.hrhrng.yoso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class SwapHeap<E> {

    private Object[] heap;
    private int capacity;
    private int heapSize;

    private Comparator<? super E> comparator;

    public SwapHeap(int initialCapacity, Comparator<? super E> comparator) {
        this.heap = new Object[initialCapacity];
        capacity = initialCapacity;
        heapSize = 0;
        this.comparator = comparator;
    }
    public SwapHeap(Collection<? extends E> c) {
        initFromCollection(c);
    }
    public E swapAndRebuild(Iterator<E> iterator) {
        // 需要重建秩序
        if (heapSize == 0) {
            heapSize = capacity;
            heapify();
            return null;
        }
        E poll = (E) heap[0];
        E insert = iterator.next();
        // insert 优先级较高
        if(compare(insert, poll)>0) {
            heap[0] = insert;
            heapify();
        } else {
            this.pollAndRebuild();
            heap[heapSize] = insert;
        }
        return poll;
    }
    private void pollAndRebuild() {
        final E result;
        if((result = (E)heap[0]) != null) {
            E x = (E) heap[--heapSize];
            siftDown(0, x);
        }
    }
    private void initFromCollection(Collection<? extends E> c) {
        var es = c.toArray();
        var len = es.length;
        if(len == 1 || this.comparator != null) {
            for (Object e :
                    es) {
                if (e == null)
                    throw new NullPointerException();
            }
        }
        this.heap = es;
        this.heapSize = len;
        this.capacity = len;
        heapify();
    }
    private int compare(E a, E b) {
        if(comparator != null) {
            return comparator.compare(a, b);
        } else {
            // 往上找compareTo
            return ((Comparable<? super E>) a).compareTo((E)b);
        }
    }
    private void siftDown(int index, E elem) {
        int half = heapSize >>> 1;
        while(index < half) {
            // init child as left
            int child = (index << 1) + 1;
            Object c = heap[child];
            int right = child + 1;
            // find the little one and swap
            if (right < heapSize && (compare((E)c, (E) heap[right])>0)) {
                c = heap[child = right];
            }
            if (compare(elem, (E)c) <= 0)
                break;
            heap[index] = c;
            index = child;
        }
        heap[index] = elem;
    }
    private void heapify() {
        final Object[] es = heap;
        int i = (heapSize >>> 1) - 1;
        for (i = (heapSize >>> 1) - 1; i >= 0; i--) {
            siftDown(i, (E) heap[i]);
        }
    }
}
