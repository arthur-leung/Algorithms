package com.arthur;

public abstract class UF {
    abstract void union(int p, int q);
    abstract boolean connected(int p, int q);
    abstract int find(int q);
    abstract int count();
}
