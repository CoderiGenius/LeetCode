package test;

import java.util.ArrayList;
import java.util.List;

public class TestStatic {

    static {
        list = new ArrayList<>();
        testStatic =  new TestStatic();
    }

    static List<String> list;
static TestStatic testStatic;
    TestStatic(){
        addurl();
        System.out.println(list);
    }



    public static void addurl(){
        list.add("1");

    }

    public static void main(String[] args) {
        String i = "1";
        String[] strings = new String[1];
        strings[0] = "2";
        setTestSta(i,strings);
        System.out.println(i);
        System.out.println(strings[0]);
    }

    public static void setTestSta(String i,String[] j){
        i = "3";
        j[0] = "4";
    }
}
