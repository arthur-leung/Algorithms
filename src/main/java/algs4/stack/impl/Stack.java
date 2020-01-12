package algs4.stack.impl;

import algs4.stack.Stack;

import java.util.Iterator;

public class Stack<Item> implements algs4.stack.Stack<Item>, Iterable<Item> {
    private Node head;
    private int size;

    private class Node {
        Item item;
        Node next;
    }

    @Override
    public void push(Item item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
    }

    @Override
    public Item pop() {
        if (head == null) {
            throw new NullPointerException();
        }
        Item item = head.item;
        size--;
        head = head.next;
        return item;
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
