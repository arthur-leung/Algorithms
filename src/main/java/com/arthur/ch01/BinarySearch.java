package com.arthur.ch01;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        int[] whitelist = {1, 3, 2, 4, 6, 5, 7, 9};
        Arrays.sort(whitelist);

        final Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int key = in.nextInt();
            if (rank(key, whitelist) < 0) {
                System.out.println(key);
            }
        }
        System.exit(0);
    }

    private static int rank(int key, int[] whitelist) {
        int low = 0;
        int high = whitelist.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) / 2);
            if (key > whitelist[middle]) {
                low = middle + 1;
            } else if (key < whitelist[middle]) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
