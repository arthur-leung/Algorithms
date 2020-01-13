package algs4.queue.impl;

import algs4.queue.IQueue;

import java.util.Iterator;

public class Queue<Item> implements IQueue<Item>, Iterable<Item> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Item item;
        Node next;
    }

    @Override
    public void enqueue(Item item) {
        Node oldTail = tail;
        tail = new Node();
        tail.item = item;
        tail.next = null;
        if (isEmpty()) {
            head = tail;
        } else {
            oldTail.next = tail;
        }
        size++;
    }

    @Override
    public Item dequeue() {
        if (head == null) {
            throw new NullPointerException();
        }
        Item item = head.item;
        head = head.next;
        if (isEmpty()) {
            tail = null;
        }
        size--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NullPointerException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
