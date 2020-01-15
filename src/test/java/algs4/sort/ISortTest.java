package algs4.sort;

import algs4.sort.impl.Insertion;
import algs4.sort.impl.Selection;
import org.junit.Test;

import static org.junit.Assert.*;

public class ISortTest {

    private Comparable[] getData() {
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        return a;
    }

    @Test
    public void sortBySelection() {
        Comparable[] data = getData();
        ISort sortInstance = new Selection();
        sortInstance.sort(data);
        assert sortInstance.isSorted(data);
        sortInstance.show(data);
    }

    @Test
    public void sortByInsertion() {
        Comparable[] data = getData();
        ISort sortInstance = new Insertion();
        sortInstance.sort(data);
        assert sortInstance.isSorted(data);
        sortInstance.show(data);
    }
}