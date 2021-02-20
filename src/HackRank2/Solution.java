package HackRank2;

import sun.misc.BASE64Encoder;

import java.io.*;
import java.math.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {

        int steps = 0;
        int length = c.length;
        for(int i=0;i<c.length;i++){
            //if(i==0){steps++;continue;};
            if(i==c.length-1)break;
            if((i+1)<length && c[i+1]!=1){
                if((i+2)<length && c[i+2]!=1){

                    i = i+1;
                }//i++;

            }else{
                i = i+1;
            }
            steps++;
            System.out.println(i);
        }

        return steps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] c = new int[n];
//
//        String[] cItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int cItem = Integer.parseInt(cItems[i]);
//            c[i] = cItem;
//        }
//
//        int result = jumpingOnClouds(c);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
//        int[] ints = new int[]{0,0,1,0,0,1,0};
        int[] ints = new int[]{0,0,0,1,0,0};
        String a = "aab";
        long n = 882787L;
        System.out.println(Solution.repeatedString(a,n));
    }



    static long repeatedString(String s, long n) {






        int[] ints = new int[s.length()];

        //int i = 0;
        int number = 0;
        System.out.println(s.charAt(0));
        System.out.println(s.charAt(1));
        System.out.println(s.charAt(2));
        for (int j = 0; j < s.length(); j++) {



            if('a'==(s.charAt(j))){
                number++;
                ints[j] = number;
            }else {
                ints[j] = number;
            }
            System.out.println(ints[j]);
        //j++;
        }

        long x = n % s.length();

        long times = n/s.length();
        System.out.println("times:"+times+" x:"+x);
        if(x>0)
        return times*ints[s.length()-1]+ints[(int) (x-1)];
        else{
            return times*ints[s.length()-1];
        }


    }
}

