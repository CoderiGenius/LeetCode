package foureight;

public class Solution2 {

    public void rotate(int[][] matrix) {
        if(matrix.length==0){
            return;
        }

        for (int i = 0; i < matrix.length ; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                if(i!=j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[i].length-1;
            while(left<right){
               int temp = matrix[i][left];
               matrix[i][left] = matrix[i][right];
               matrix[i][right] = temp;
               left++;
               right--;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j]);
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
        Solution2 solution = new Solution2();
        solution.rotate(matrix);
    }
}
