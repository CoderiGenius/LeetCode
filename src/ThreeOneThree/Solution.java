package ThreeOneThree;

import java.util.PriorityQueue;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {

//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//
//        priorityQueue.add(1);
//
//
//        int times = 0;
//        Integer integer = 0;
//        while(times<n){
//            integer = priorityQueue.poll();
//            times++;
//
//            while (!priorityQueue.isEmpty() && integer == priorityQueue.peek()) {
//                priorityQueue.poll();
//            }
//
//            for (int i = 0; i < primes.length ; i++) {
//                priorityQueue.offer(integer * primes[i]);
//            }
//        }
//        return integer;


        int [] dp=new int[n];
        dp[0]=1;

        int k=primes.length;
        int []index=new int[k];



        for(int i=1;i<n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<k;j++){
                if(min>dp[index[j]]*primes[j]){
                    min=dp[index[j]]*primes[j];
                }
            }
            dp[i]=min;
            //滑动index
            for(int j=0;j<k;j++){
                if(min==dp[index[j]]*primes[j]){
                    index[j]++;
                }
            }
        }
        return dp[n-1];



    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthSuperUglyNumber(12,new int[]{2,7,13,19}));
    }


    public int solve(int n) {
        int ans[]=new int[n+5];
        ans[0]=1;
        int p1=0,p2=0,p3=0,p4=0;
        for(int i=1;i<n;i++){
            ans[i]=Math.min(ans[p1]*2,Math.min(ans[p2]*7,Math.min(ans[p3]*13,ans[p4]*19)));
            if(ans[i]==ans[p1]*2) p1++;
            if(ans[i]==ans[p2]*7) p2++;
            if(ans[i]==ans[p3]*13) p3++;
            if(ans[i]==ans[p3]*19) p4++;
        }
        return ans[n-1];
    }
}
