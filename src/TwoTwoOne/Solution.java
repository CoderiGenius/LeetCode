package TwoTwoOne;

/**
 * @author CoderiGenius
 * @version 2021/4/2 9:41 下午
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {

        int max = 0;

        if(matrix.length==0 ||matrix[0].length==0){
            return 0;
        }


        for(int i=0;i<matrix.length;i++){
            int length = 0;
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]=='1'){
                    max =Math.max(check(matrix,i,j),max);
                }

            }
        }
        return max*max;

    }

    public int check(char[][] matrix,int i,int j){
        int  length = Math.min(matrix.length-i,matrix[i].length-j);
        //System.out.println(length);
        int returnValue = 0;
        for(int k=0;k<length;k++){
            if(checkIsMatrix(matrix,i,j,k)){
                System.out.println(k+1);
                returnValue = Math.max(returnValue,k+1);
            }
        }
        return  returnValue;
    }

    public boolean checkIsMatrix(char[][] matrix,int i,int j,int length){
        System.out.println("s:"+i+ " "+j+" "+length);
        int maxi = i+length;
        int maxj = j+length;
        int orgJ = j;
        for(;i<=maxi;i++){
            for(j = orgJ;j<=maxj;j++){
                System.out.println(i+" "+j);
                if(matrix[i][j]!='1')return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        char[][] ints = new char[4][];
//        ints[0] = new char[]{'1','0','1','0','0'};
//        ints[1] = new char[]{'1','0','1','1','1'};
//        ints[2] = new char[]{'1','1','1','1','1'};
//        ints[3] = new char[]{'1','0','0','1','0'};

        char[][] ints = new char[2][];
        ints[0] = new char[]{'1','1'};
        ints[1] = new char[]{'1','1'};


        System.out.println(new Solution().maximalSquare(ints));
    }
}
//[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
