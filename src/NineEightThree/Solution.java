package NineEightThree;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        int[] everyDay = new int[366];

        int currentI = 0;

        for (int i = 1; i <366 ; i++) {
            if(days[currentI]==i){
                int value = Math.min(helper(i-1,everyDay)+costs[0],helper(i-7,everyDay)+costs[1]);
                value = Math.min(helper(i-30,everyDay),value);
                everyDay[i]=value;
                currentI++;
            }else {
                everyDay[i] = everyDay[i-1];
            }
        }
    return everyDay[365];
    }

    int helper(int day,int[] everyDay){
        if(day<=0 || day>365){
            return 0;
        }
        return everyDay[day];

    }
}