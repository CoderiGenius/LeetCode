package heap;

import com.sun.org.apache.bcel.internal.generic.IXOR;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelfHeap {

    ArrayList<Integer> data ;

    public static void main(String[] args) {

        SelfHeap selfHeap = new SelfHeap();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            Integer integer = random.nextInt(Integer.MAX_VALUE);
            selfHeap.add(integer);
            //System.out.println("add:"+i);
        }

        int[] n = new int[10000];
        for (int i = 0; i <10000 ; i++) {
            n[i] = selfHeap.poll();
        }

        for (int i = 0; i < 9999; i++) {
            System.out.println(n[i]);

            if(n[i]<n[i+1]){
                System.out.println("error");
                break;
            }

        }

            System.out.println("ok");


        System.out.println(selfHeap.data);

    }

    public SelfHeap(int capacity) {
        this.data = new ArrayList<>(capacity);
    }

    public SelfHeap(){
        this.data = new ArrayList<>();
    }

    public void add(Integer integer) {

        data.add(integer);
        shiftUp(data.size()-1);
    }

    private int getLeft(int i){
        return 2 * i +1 ;
    }
    private int getRight(int i){
        return 2*i + 2;
    }
    private int getParents(int i){
        return (i-1)/2;
    }

    private void swap(int i,int k){
        if(i>=data.size() || k>=data.size()){
            System.out.println("out");
            return;
        }
        Integer temp = data.get(i);
        data.set(i,data.get(k));
        data.set(k,temp);
    }

    private void shiftUp(int current){
        if(current<=0 && current>=data.size()){
           System.out.println("error");
        }
        while(data.get(current)>data.get(getParents(current))){
            swap(current,getParents(current));
            current = getParents(current);
        }
    }

    private void shiftDown(int current){

        while(true) {
            int left = getLeft(current);
            int right = getRight(current);
            //如果左右孩子都存在
            if (left < data.size() && right < data.size()) {

                //且当前小于左右孩子中的任意一个
                if (data.get(current) < data.get(left) || data.get(current) < data.get(right)) {

                    //找到较大的那个孩子，交换
                    if (data.get(left) > data.get(right)) {
                        swap(current, left);
                        current = left;
                    } else {
                        swap(current, right);
                        current= right;
                    }

                } else {
                    //比任何一个孩子都大
                    break;
                }

            }
            //左边孩子在，且当前小于左孩子
            else if (left < data.size() && data.get(current) < data.get(left)) {
                swap(current, left);
                current = left;
            }
            //右边孩子在，且当前小于右边孩子
            else if (right < data.size() && data.get(current) < data.get(right)) {
                swap(current, right);
                current = right;
            } else {
                //左右孩子都不在
                break;
            }

        }
    }

    public Integer poll(){
        if(data.isEmpty()){
           System.out.println("error");
           return 0;
        }
        swap(0,data.size()-1);
        Integer result = data.get(data.size()-1);
        data.remove(data.size()-1);
        shiftDown(0);

        return result;

    }
}
