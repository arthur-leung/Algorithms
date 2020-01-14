package algs4.uf.impl;

import algs4.uf.IUF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionUF implements IUF {
    private int[] ids;
    private int count;

    public QuickUnionUF(int size) {
        ids = new int[size];
        count = size;
        for (int i = 0; i < size; i++) {
            ids[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        ids[pRoot] = qRoot;
        count--;
    }

    @Override
    public int find(int p) {
        if (ids[p] == p) {
            return p;
        }
        return find(ids[p]);
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        System.out.println("plz input size: ");
        int size = StdIn.readInt();
        IUF uf = new QuickUnionUF(size);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components.");
    }
}
