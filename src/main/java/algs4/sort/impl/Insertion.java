package algs4.sort.impl;

import algs4.sort.ISort;

public class Insertion implements ISort {
    @Override
    public void sort(Comparable[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
    }
}
