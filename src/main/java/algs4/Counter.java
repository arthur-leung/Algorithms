package algs4;

public class Counter {
    final private String name;
    private int counter;

    public Counter(String id) {
        name = id;
    }

    public void increment() {
        counter++;
    }

    public int tally() {
        return counter;
    }

    @Override
    public String toString() {
        return name + ": " + counter;
    }

    public static void main(String[] args) {
        Counter heads = new Counter("heads");
        Counter tail = new Counter("tail");
        heads.increment();
        heads.increment();
        tail.increment();
        System.out.println(heads);
        System.out.println(tail);
        System.out.println("heads.tally() - tail.tally() = " + (heads.tally() - tail.tally()));
    }
}
