package algs4.queue;

public interface Queue<Item> {
    void enqueue(Item item);

    Item dequeue();

    boolean isEmpty();

    int size();
}
