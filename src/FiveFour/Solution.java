package FiveFour;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> integers = new ArrayList<>();
        if(matrix.length==0){
            return integers;
        }
        int n=0,m = 0;
        int[][] ints = new int[matrix.length][matrix.length];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                ints[i][j] = 0;
            }
        }
        while(true){
            integers.add(matrix[n][m]);
            ints[n][m] = 1;
            if((m+1)<matrix.length && ints[n][m+1]!=1){
                m = m+1;
               // System.out.println("1:n:"+n+" m:"+m);
                continue;
            }
            if((n+1)<matrix.length && ints[n+1][m]!=1){
                n = n + 1;
               // System.out.println("2:n:"+n+" m:"+m);
                continue;
            }
            if((m-1)>=0 && ints[n][m-1]!=1){
                m = m-1;
               // System.out.println("3:n:"+n+" m:"+m);
                continue;
            }
            if((n-1)>=0 && ints[n-1][m]!=1){
                n = n-1;
                //System.out.println("4:n:"+n+" m:"+m);
                continue;
            }
            break;
        }
        return integers;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = k;
                k++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
        System.out.println("---------");
        Solution solution = new Solution();
        System.out.println(solution.spiralOrder(matrix));
    }

}
