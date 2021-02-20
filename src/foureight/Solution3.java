package foureight;

public class Solution3 {

    public void rotate(int[][] matrix) {

        if(matrix==null || matrix.length==0){
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                if(i==j)continue;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
             }
        }


        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[0].length-1;
            while (left<right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }

    }
}
