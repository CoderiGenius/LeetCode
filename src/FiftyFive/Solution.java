package FiftyFive;

import sun.misc.LRUCache;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public boolean canJump(int[] nums) {

        if(nums.length==1){
            return true;
        }
        int sum = 0;
        return helper(0,nums,nums.length-1);


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
