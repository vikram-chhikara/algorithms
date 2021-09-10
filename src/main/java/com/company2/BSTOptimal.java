package main.java.com.company2;

import java.util.*;
import java.io.File;
import java.math.BigInteger;

public class BSTOptimal {
     
    /* A Dynamic Programming based function that calculates
        minimum cost of a Binary Search Tree.  */
    static double optimalSearchTree(int keys[], double freq[], int n) {
 
        /* Create an auxiliary 2D matrix to store results of
           subproblems */
        double cost[][] = new double[n + 1][n + 1];
 
        /* cost[i][j] = Optimal cost of binary search tree that
           can be formed from keys[i] to keys[j]. cost[0][n-1]
           will store the resultant cost */
 
        // For a single key, cost is equal to frequency of the key
        for (int i = 0; i < n; i++)
            cost[i][i] = freq[i];
 
        // Now we need to consider chains of length 2, 3, ... .
        // L is chain length.
        for (int L = 2; L <= n; L++) {
 
            // i is row number in cost[][]
            for (int i = 0; i <= n - L + 1; i++) {
 
                // Get column number j from row number i and
                // chain length L
                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;
 
                // Try making all keys in interval keys[i..j] as root
                for (int r = i; r <= j; r++) {
 
                    // c = cost when keys[r] becomes root of this subtree
                    double c = ((r > i) ? cost[i][r - 1] : 0)
                            + ((r < j) ? cost[r + 1][j] : 0) + sum(freq, i, j);
                    if (c < cost[i][j])
                        cost[i][j] = c;
                }
            }
        }
        return cost[0][n - 1];
    }
    static double sum(double freq[], int i, int j) {
        double s = 0;
        for (int k = i; k <= j; k++) {
            if (k >= freq.length)
                continue;
            s += freq[k];
        }
        return s;
    }
 
    public static void main(String[] args) {
         
        int keys[] = { 1, 2, 3, 4, 5 ,6 ,7 };
        double freq[] = { .2, .05,
            .17,
            .1,
            .2,
            .03,
            .25 };
        int n = keys.length;
        System.out.println("Cost of Optimal BST is "
                + optimalSearchTree(keys, freq, n));
    }
}
