package algs4.queue.impl;

import algs4.queue.IQueue;

import java.util.Iterator;

public class ResizingArrayIQueue<Item> implements IQueue<Item>, Iterable<Item> {
    private Item[] items = (Item[]) new Object[2];
    private int head = 0;
    private int tail = 0;

    public void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        int h = head;
        int i;
        for (i = 0; i < capacity; i++) {
            if (h == tail) {
                break;
            }
            temp[i] = items[h++];
        }
        items = temp;
        head = 0;
        tail = i;
    }

    @Override
    public void enqueue(Item item) {
        if ((tail - head) == items.length) {
            resize(items.length * 2);
        }
        items[tail++] = item;
    }

    @Override
    public Item dequeue() {
        Item item = items[head];
        items[head] = null;
        head++;
        if (tail > 0 && (tail - head) == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return tail == 0;
    }

    @Override
    public int size() {
        return tail - head;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        int h = head;
        int t = tail;

        @Override
        public boolean hasNext() {
            return t > 0 && t != h;
        }

        @Override
        public Item next() {
            return items[h++];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        ResizingArrayIQueue<String> resizingArrayQueue = new ResizingArrayIQueue<String>();

        String[] s = {"a", "b", "c", "d", "e"};
        for (String s1 : s) {
            resizingArrayQueue.enqueue(s1);
        }
        System.out.println("size: " + resizingArrayQueue.size());
        /*while (!resizingArrayQueue.isEmpty()) {
            System.out.println(resizingArrayQueue.dequeue());
        }*/

        Iterator iterator = resizingArrayQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
