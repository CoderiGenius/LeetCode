package SevenNine;

import java.util.*;

class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0){
            return "".equals(word);
        }
        int[][] passed = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(helper(i,j,board,passed,word,0)){
                    return true;
                }
            }
        }
        return false;

//        if(board.length<2||board[0].length<2){
//
//        }
//        Map<Character, List<List<Integer>>> grid = new HashMap<>();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                List<List<Integer>> listMap = grid.get(board[i][j]);
//                if(listMap==null){
//                    listMap = new ArrayList<>();
//                }
//                List<Integer> list = new LinkedList<>();
//                list.add(i);
//                list.add(j);
//                listMap.add(list);
//                grid.put(board[i][j],listMap);
//            }
//        }
//
//        List<List<Integer>> list = grid.get(word.charAt(0));
//        if(list==null)return false;
//        for (List<Integer> l :
//                list) {
//            if(helper(l.get(0),l.get(1),board,passed,word,0)){
//                return true;
//            }
//            passed = new int[board.length][board[0].length];
//        }
//        return false;
    }

    private boolean helper(int h,int v,char[][] board,int[][] passed,String word,int current){
        if(current>=word.length()){
            return true;
        }
        if(h<0 || v<0 || h >=board.length || v>= board[h].length || passed[h][v]==1 || word.charAt(current)!=board[h][v]){
            return false;
        }

        passed[h][v] = 1;
        if(helper(h-1,v,board,passed,word,current+1)){
            return true;
        }

        if (helper(h,v-1,board,passed,word,current+1)){
            return true;
        }
        //if(h>0 && v>0 && h <board.length-1 && v< board[h].length-1 )passed[h][v-1] = 0;

        if(helper(h+1,v,board,passed,word,current+1)){
            return true;
        }
        //if(h>0 && v>0 && h <board.length-1 && v< board[h].length-1 )passed[h+1][v] = 0;

        if (helper(h, v+1, board, passed, word,current+1)){
            return true;
        }else {
           // if(h>0 && v>0 && h <board.length-1 && v< board[h].length-1 )passed[h][v+1] = 0;
            passed[h][v] = 0;
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] chars = new char[3][4];
        chars[0] = new char[]{'A','B','C','E'};
        chars[1] = new char[]{'S','F','E','S'};
        chars[2] = new char[]{'A','D','E','E'};
//        char[][] chars = new char[1][1];
//        chars[0] = new char[]{'A'};

        System.out.println(new Solution().exist(chars,"p"));
    }
}
