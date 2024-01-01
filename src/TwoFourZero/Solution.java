package TwoFourZero;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CoderiGenius
 * @version 2021/4/5 5:27 下午
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        Map<Integer, Boolean> list = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            if (searchInTheRow(matrix, target, i)) {
                list.put(i, true);
            }
        }
        Map<Integer, Boolean> list2 = new HashMap<>();

        for (int i = 0; i < matrix[0].length; i++) {
            if (searchInFirstColumn(matrix, target, i)) {
                list2.put(i, true);
            }
        }

        if (list.size() < list2.size()) {
            for (Integer k : list.keySet()
            ) {

                for (int i = 0; i < matrix[k].length; i++) {
                    if (matrix[k][i] == target) return true;
                }
            }
        } else {
            for (Integer k : list2.keySet()
            ) {
                for (int i = 0; i < matrix.length; i++) {
                    if (matrix[i][k] == target) return true;
                }
            }
        }

        return false;

    }

    private boolean searchInTheRow(int[][] matrix, int target, int row) {
        int[] rows = matrix[row];

        if (rows[0] <= target && rows[rows.length - 1] >= target) return true;
        return false;
    }

    private boolean searchInFirstColumn(int[][] matrix, int target, int coloumn) {
        if (matrix[0][coloumn] <= target && matrix[matrix.length - 1][coloumn] >= target) {
            return true;
        }
        return false;
    }
}
