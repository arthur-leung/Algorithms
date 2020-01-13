package algs4.bag.impl;

import algs4.bag.IBag;

import java.util.Iterator;

public class Bag<Item> implements IBag<Item>, Iterable<Item> {
    private Node head;
    private int size;

    private class Node {
        private Item item;
        private Node next;
    }

    @Override
    public void add(Item item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
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
