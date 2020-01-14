package algs4.uf.impl;

import algs4.uf.IUF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindUF implements IUF {
    private int[] ids;
    private int count;

    public QuickFindUF(int size) {
        ids = new int[size];
        count = size;
        for (int i = 0; i < size; i++) {
            ids[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        for (int i = 0; i < ids.length; i++) {
            if (pId == ids[i]) {
                ids[i] = qId;
            }
        }
        count--;
    }

    @Override
    public int find(int p) {
        return ids[p];
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
        IUF quickFindUF = new QuickFindUF(size);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (quickFindUF.connected(p, q)) {
                continue;
            }
            quickFindUF.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(quickFindUF.count() + " components.");
    }
}
