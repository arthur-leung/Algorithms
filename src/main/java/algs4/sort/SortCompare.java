package algs4.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import algs4.sort.impl.*;

public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        switch (alg) {
            case "Insertion":
                Insertion insertion = new Insertion();
                insertion.sort(a);
                break;
            case "Selection":
                Selection selection = new Selection();
                selection.sort(a);
                break;
            case "Shell":
                Shell shell = new Shell();
                shell.sort(a);
                break;
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int length, int count) {
        double total = 0.0;
        Double[] data = new Double[length];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < length; j++) {
                data[j] = StdRandom.uniform();
            }
            total += time(alg, data);
        }

        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Insertion";
        String alg2 = "Selection";
        int length = 1000;
        int count = 100;
        double time1 = timeRandomInput(alg1, length, count);
        double time2 = timeRandomInput(alg2, length, count);
        StdOut.printf("For %d random Doubles \n     %s is ", length, alg1);
        StdOut.printf(" %.1f times faster than %s\n", time2 / time1, alg2);
    }
}
