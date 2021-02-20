package anagrams;

import java.util.*;

public class Solutions {

    // Complete the sherlockAndAnagrams function below.
    public static final int ALPHABET_CNT = 26;

    static boolean isAnagrams(String s1, String s2) {

        System.out.println(s1+" "+s2);

        char[] chCnt1 = new char[ALPHABET_CNT];
        char[] chCnt2 = new char[ALPHABET_CNT];


        for (int i = 0, n = s1.length(); i < n; i++) {
            chCnt1[s1.charAt(i) - 97] += 1;
            chCnt2[s2.charAt(i) - 97] += 1;
        }

        for (int i = 0; i < ALPHABET_CNT; i++) {
            if (chCnt1[i] != chCnt2[i]) {
                return false;
            }
        }

        return true;
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int cnt = 0;
        for (int i = 1, n = s.length(); i < n; i++) {
            List<String> subsetList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i + j <= n) {
                    subsetList.add(s.substring(j, i + j));
                }
            }

            for (int k = 0, size = subsetList.size(); k < size; k++) {
                for (int l = k + 1; l < size; l++) {
                    if (isAnagrams(subsetList.get(k), subsetList.get(l))) {
                        cnt++;
                    }
                }
            }
        }


        return cnt;
    }

    private static int getAnagrams(String s){
        System.out.println(s);
        int result = isSame(s.substring(1,s.length()-1));
        if(result==-1)return 2;
        return result+1;
    }

    private static int isSame(String s){
        if(s==null)return -1;
        if(s.length()==0)return 0;
        int length = s.length();
        int middle = length/2;
        for(int i=0;i<middle;i++){
            if(s.charAt(i)!=s.charAt(length-1-i)){
                return -1;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("zjekimenscyiamnwlpxytkndjsygifmqlqibxxqlauxamfviftquntvkwppxrzuncyenacfivtigvfsadtlytzymuwvpntngkyhw"));
    }
}
