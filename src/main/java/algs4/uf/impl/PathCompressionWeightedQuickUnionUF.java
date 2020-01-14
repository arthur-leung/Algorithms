package algs4.uf.impl;

import algs4.uf.IUF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class PathCompressionWeightedQuickUnionUF implements IUF {
    private int[] ids;
    private int[] rootIdContactSize;
    private int count;

    public PathCompressionWeightedQuickUnionUF(int size) {
        count = size;
        ids = new int[size];
        for (int i = 0; i < size; i++) {
            ids[i] = i;
        }
        rootIdContactSize = new int[size];
        for (int i = 0; i < size; i++) {
            rootIdContactSize[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (rootIdContactSize[pRoot] < rootIdContactSize[qRoot]) {
            ids[pRoot] = qRoot;
            rootIdContactSize[qRoot] += rootIdContactSize[pRoot];
        } else {
            ids[qRoot] = ids[pRoot];
            rootIdContactSize[pRoot] += rootIdContactSize[qRoot];
        }
        count--;
    }

    @Override
    public int find(int p) {
        int findId = p;
        while (findId != ids[findId]) {
            findId = ids[findId];
        }
        while (p != ids[p]) {
            int tmp = p;
            p = ids[p];
            ids[tmp] = findId;
        }
        return findId;
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
        IUF uf = new PathCompressionWeightedQuickUnionUF(size);
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
