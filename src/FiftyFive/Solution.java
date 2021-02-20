package FiftyFive;

import sun.misc.LRUCache;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public boolean canJump(int[] nums) {

        int targetPosition = nums.length-1;
        for (int i = nums.length-1; i >=0; i--) {
            if(targetPosition<=(i+nums[i])){
                targetPosition = i;
            }
        }
    return targetPosition==0;

    }

    private boolean helper(int position,int[] nums,int lengthToEnd){

        System.out.println(position+":"+lengthToEnd);

        for(int i=nums[position];i>0;i--){

            if((i)>=lengthToEnd){
                return true;
            }else{
                if(helper(position+i,nums,lengthToEnd-i)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {



    }

    public static String readFile(String strFile){
        try{
            InputStream is = new FileInputStream(strFile);
            int iAvail = is.available();
            byte[] bytes = new byte[iAvail];
            is.read(bytes);
            is.close();
            return new String(bytes);

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
