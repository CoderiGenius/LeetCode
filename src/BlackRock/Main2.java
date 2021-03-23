package BlackRock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class Main2 {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            String[] splittedInput = line.split(";");
            String pattern = splittedInput[0];
            String blobs = splittedInput[1];
            Main2.doSomething(pattern, blobs);
        }
    }

    public static void doSomething(String pattern, String blobs) {
        // Write your code here. Feel free to create more methods and/or classes
        String[] blobsArrays = blobs.split("\\|");

        List<Integer> list = new LinkedList<>();
        int total = 0;
        //For each blobsArray check every position if it can match the target pattern
        for (String blobsArray : blobsArrays) {
            int count = 0;
            for (int j = 0; j < blobsArray.length(); j++) {
                int result = findOutIfTargetMatchTheBlob(pattern, blobsArray, 0, j, 0);
                if (result != 0) count++;
            }
            list.add(count);
            total += count;
        }

        for (Integer i :
                list) {
            System.out.print(i);
            System.out.print("|");
        }
        System.out.print(total);
    }

    /**
     * FindOutIfTargetMatchTheBlob
     * @param target the target we need to find
     * @param blob the blob string where we should find target
     * @param currentPosition the current position of the target string
     * @param blobPosition the current position of the blob string
     * @param currentLength
     * @return if match return length, if not return 0
     */
    private static int findOutIfTargetMatchTheBlob(String target,String blob,int currentPosition,int blobPosition,int currentLength){
        if(target==null  || blob==null){
            return 0;
        }
        if(currentPosition >= target.length() ){
            return currentLength;
        }
        if(blobPosition >= blob.length()){
            return 0;
        }
        if(target.charAt(currentPosition)!=blob.charAt(blobPosition)){
            return 0;
        }
        return findOutIfTargetMatchTheBlob(target,blob,currentPosition+1,blobPosition+1,currentLength+1);
    }
}