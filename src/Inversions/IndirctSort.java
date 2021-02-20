package Inversions;

public class IndirctSort {

    public static void main(String[] args)
    {
        int[] A = new int[] {5,2,6,0};
        int N = A.length;
        System.out.print("Indices for array A:    ");
        for (int i=0; i<N; ++i) System.out.print(" "+i);
        System.out.println();
        System.out.print("Values in array A:      ");
        for (int i=0; i<N; ++i) System.out.print(" "+A[i]);
        System.out.println();

        // do indirect sorting (does not modify A)
        indirectSort(A);

        // do pair-based sorting (does not modify A)
        //  pairsSort(A);
    }

    static void indirectSort(int[] A)
    {
        int N = A.length;
        // Here we do indirect insertion sort.
        // First setup an array B, with B[i]==i for 0 <=i<N.
        // Then sort these "pointer" values in B, thinking of
        // B[i] as representing (or pointing to) value A[B[i]].
        // Note that A is not modified.
        int[] B = new int[N];
        for (int i=0; i<N; ++i)
            B[i] = i;
        // Sort the pointers using insertion sort.
        for (int i = 1; i < N; ++i)
            for (int j=i; j>0 && A[B[j]] < A[B[j-1]]; --j)
            {
                int tmp = B[j]; // swap ints
                B[j] = B[j-1];
                B[j-1] = tmp;
            }
        // print results
        System.out.println("Using indirectSort ...");
        System.out.print("Sorted values from A:   ");
        for (int i=0; i<N; ++i)
            System.out.print(" "+A[B[i]]);
        System.out.println();
        System.out.print("Original positions in A:");
        for (int i=0; i<N; ++i)
            System.out.print(" "+B[i]);
        System.out.println();
    }

    // objects used by pairsSort
    static class Pair {
        int v; // a value from array A
        int p; // its position, so A[p]==v
        Pair(int v, int p) { this.v = v; this.p = p; }
    }



}
