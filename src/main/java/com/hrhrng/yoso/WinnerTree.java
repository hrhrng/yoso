package com.hrhrng.yoso;

import java.io.File;
import java.util.Iterator;

public class WinnerTree <E>{
    Node[] tree;
    int ways;

    Iterator<E>[] it;

    public WinnerTree (int _ways, Iterator<E>[] _it) {
        ways = _ways;
        it = _it;
        tree = new Node[ways*2];
        combine();
    }
    private void combine () {
        for (int i = ways - 1; i >= 0; ) {
            tree[ways + i].value = it[i].next();
        }
    }
    private void siftUp (int index) {

    }
    static class Node<E> {
        E value;
    }

    private int getLeft (int i) {
        return (i - 1) << 1 + 1;
    }
    private int getRight (int i) {
        return getRight(i) + 1;
    }

    private int getFather (int i) {
        return (i - 2) >>> 2 + 1;
    }



}
