package NineEightThree;

public class Solution {

    public int mincostTickets(int[] days, int[] costs) {

        int[] dailyCosts = new int[366];
        int daysId = 0;
        for (int i = 1; i < 366; i++) {
            if(i==days[daysId]){
                int value = Math.min(costs[0]+helper(i-1,dailyCosts),costs[1]+helper(i-7,dailyCosts));
                value = Math.min(value,costs[2]+helper(i-30,dailyCosts));
                dailyCosts[i] = value;
                daysId++;
            }else {
                dailyCosts[i] = dailyCosts[i-1];
            }
        }
        return dailyCosts[365];
    }

    boolean finder(int[] days,int day){
        for (int i = 0; i < days.length; i++) {
            if(day==days[i])return true;
        }
        return false;
    }

    int helper(int day,int[] dailyCost){
        if(day>365){
            return 0;
        }
        if(day<1){
            return 0;
        }

        return dailyCost[day];
    }
}

