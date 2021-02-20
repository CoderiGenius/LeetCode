package MST$;

import entity.TreeNode;

class Solution {
    static int times = 0;

    static void minimumBribes(int[] q) {
        times = 0;

        if (q.length == 0 || q.length == 1) {
            System.out.println(0);
        }
        int[] newQ = new int[q.length+1];
        while(!isSorted(q)) {
            for (int i = 0; i < q.length; i++) {
                if ((i + 1) < q.length) {
                    if (q[i] < q[i + 1]) {
                        continue;
                    }
                    if (!helper(q, i, i + 1, newQ)) {
                        System.out.println("Too chaotic");
                        return;
                    }


                }

            }
        }

//        for (int i = 0; i < q.length; i++) {
//            if (i + 1 < q.length) {
//                if (q[i] - q[i + 1] != -1) {
//                    System.out.println("Too chaotic");
//                    return;
//                }
//            }
//        }
        System.out.println(times);
    }

    private static boolean isSorted(int[] q){
        for (int i = 0; i < q.length; i++) {
            if (i + 1 < q.length) {
                if (q[i] - q[i + 1] != -1) {

                    return false;
                }
            }
        }
        return true;
    }


    private static boolean helper(int[] q,int left,int right,int[] newQ){
        if(newQ[q[left]]>=2){
            return false;
        }
        newQ[q[left]] = newQ[q[left]]+1;
        System.out.println(newQ[q[left]]);
        int temp = q[left];
        q[left] = q[right];
        q[right] = temp;
        times++;
        return true;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2,5,1,3,4};
        minimumBribes(ints);
    }


}
