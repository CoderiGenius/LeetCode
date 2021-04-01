package OneFiveFive;

import OneTwoEight.Solution;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author CoderiGenius
 * @version 2021/3/29 2:01 下午
 */
class MinStack {

    List<Data> data;
    PriorityQueue<Data> queue;

    /** initialize your data structure here. */
    public MinStack() {
        data = new LinkedList<>();
        queue = new PriorityQueue<>();
    }

    public void push(int val) {
        Data d = new Data(val);
        data.add(d);
        queue.offer(d);
    }

    public void pop() {
        if(checkIsEmpty()){
            return;
        }
        data.get(data.size()-1);
        removeFirst();
    }

    public int top() {
        if(checkIsEmpty()){
            return 0;
        }
        return data.get(data.size()-1).val;
    }

    public int getMin() {
        if(checkIsEmpty()){
            return 0;
        }
//        List<Data> list = new LinkedList<>(data);
//        Collections.sort(list);
//        // System.out.println(list);
        return queue.peek().val;
    }

    private void removeFirst(){
        if(checkIsEmpty()){
            return;
        }
        Data d = data.get(data.size()-1);
        data.remove(d);
        queue.remove(d);
    }
    private boolean checkIsEmpty(){
        return data.isEmpty();
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
       // minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    private static class Data implements Comparable<Data>{
        int val;

        public Data(int val) {
            this.val = val;
        }

        @Override
        public int compareTo(Data o) {
            if(o.val>this.val){
                return -1;
            }else if(o.val<this.val){
                return 1;
            }else{
                return 0;
            }
        }

        @Override
        public String toString() {
            return "Data{" +
                    "val=" + val +
                    '}';
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
