package algs4.stack.impl;

import algs4.stack.IStack;
import org.omg.CORBA.Object;

import java.util.Iterator;

public class ResizingArrayIStack<Item> implements IStack<Item>, Iterable<Item> {
    private Item[] items =  (Item[]) new Object[1];
    private int index;

    @Override
    public void push(Item item) {
        if (index == items.length) {
            resize(items.length * 2);
        }
        items[index++] = item;
    }

    @Override
    public Item pop() {
        Item item = items[index--];
        items[index] = null;
        if (index > 0 && index == items.length / 4) {
            resize(items.length / 2);
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
        for (int i = 0; i < this.items.length; i++) {
            temp[i] = this.items[i];
        }
        items = temp;
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
            return ResizingArrayIStack.this.items[--i];
        }

        @Override
        public void remove() {

        }
    }
}
