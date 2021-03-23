package LakeTech;

import java.util.LinkedList;
import java.util.List;

/**
 * @author CoderiGenius
 * @version 2021/3/16 2:44 上午
 */
public class Three {


    public static List<Integer> commonPrefix(List<String> inputs) {

        List<Integer> list =new LinkedList<>();
        // Write your code here
        for (String s :
                inputs) {
            int sum = 0;
           String builder = s;
            for (int i = 0; i < builder.length(); i++) {
                //String pre = builder.substring(0, i);
                String suffix = builder.substring(i);
                sum += helper(builder, suffix);
            }
            list.add(sum);
        }

        return list;
    }

    private static int helper(String prefix,String suffix){
        if(prefix!=null && prefix.length()==0 && suffix!=null){
            return suffix.length();
        }
        int sum = 0;
        int prefixInt = 0;
        int suffixInt = 0;
        while (prefixInt<prefix.length() && suffixInt<suffix.length()){
            if(prefix.charAt(prefixInt)==suffix.charAt(suffixInt)){
                sum++;
            }else {
                break;
            }
            prefixInt++;
            suffixInt++;
        }
        return sum;
    }
}
