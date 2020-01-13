package algs4.queue;

public interface IQueue<Item> {
    void enqueue(Item item);

    Item dequeue();

    boolean isEmpty();

    int size();
}
