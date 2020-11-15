package foureight;

public class Solution {

    public void rotate(int[][] matrix) {
        if(matrix.length==0){
            return;
        }

        int[][] ne = new int[matrix.length][30];
        int k=matrix.length-1;
        int o = 0;
        for (int i = 0; i < matrix.length; i++) {
            o=0;
            for (int j = 0; j < matrix.length; j++) {
                if(o>=matrix.length){
                    break;
                }
                ne[j][k] = matrix[i][o];
                o++;
            }
            k--;
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(ne[i][j]);
            }
            System.out.println("");
        }
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
        solution.rotate(matrix);
    }
}
