package com.arthur;

public class TestUF extends UF {
    int[] data;
    TestUF(int n) {
        data = new int[n];
    }

    void union(int p, int q) {

    }

    boolean connected(int p, int q) {
        return false;
    }

    int find(int q) {
        return 0;
    }

    int count() {
        return 0;
    }

    public static void main(String[] args) {
        int N = 10;
        int[][] pqs = {{4, 3}, {3, 8}, {6, 5}, {9, 4}, {2, 1}, {8, 9}, {5, 0}, {7, 2}, {6, 1}, {1, 0}, {6, 7}};
        UF uf = new TestUF(N);

        for (int[] pq : pqs) {
            int p = pq[0];
            int q = pq[1];
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                System.out.println(p + " -- " + q);
            }
        }
    }
}
