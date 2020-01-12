package algs4.stack.impl;

import algs4.stack.Stack;
import org.omg.CORBA.Object;

import java.util.Iterator;

public class FixCapacityStack<Item> implements Stack<Item>, Iterable<Item> {
    private Item[] entry;
    private int index = 0;

    public FixCapacityStack(int capacity) {
        entry = (Item[]) new Object[capacity];
    }

    @Override
    public void push(Item item) {
        entry[index++] = item;
    }

    @Override
    public Item pop() {
        return entry[--index];
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = index;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return entry[--i];
        }

        @Override
        public void remove() {

        }
    }
}
