package algs4.stack.impl;

import algs4.stack.Stack;
import org.omg.CORBA.Object;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Stack<Item>, Iterable<Item> {
    private Item[] entry;
    private int index;

    @Override
    public void push(Item item) {
        if (index == entry.length) {
            resize(entry.length * 2);
        }
        entry[index++] = item;
    }

    @Override
    public Item pop() {
        Item item = entry[index--];
        entry[index] = null;
        if (index > 0 && index == entry.length / 4) {
            resize(entry.length / 2);
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public int size() {
        return index;
    }

    public void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < entry.length; i++) {
            temp[i] = entry[i];
        }
        entry = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        int i = index;

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
