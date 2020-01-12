package algs4;

public class Accumulator {
    final private String name;
    private int count = 0;
    private double total = 0;

    public Accumulator(String name) {
        this.name = name;
    }

    public void addDataValue(double val) {
        total += val;
        count++;
    }

    public double mean() {
        return total / count;
    }

    @Override
    public String toString() {
        return String.format("%s[total: %.2f, count: %d][mean: %.7f]", name, total, count, mean());
    }
}
