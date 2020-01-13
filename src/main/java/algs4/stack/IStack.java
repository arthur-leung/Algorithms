package algs4.stack;

public interface IStack<Item> {
    void push(Item item);

    Item pop();

    boolean isEmpty();

    int size();
}
