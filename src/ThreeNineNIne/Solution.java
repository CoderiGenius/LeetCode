package ThreeNineNIne;

import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        if(queries==null || queries.size()==0)return new double[0];

        Map<String, Map<String,Double>> map = new HashMap<>();

        int i = 0;
        for (List<String> l:
             equations) {

                Map<String,Double> element = map.get(l.get(0));
                if(element==null){
                    element = new HashMap<>();
                    element.put(l.get(1),values[i]);
                    map.put(l.get(0),element);
                }else {
                    element.put(l.get(1),values[i]);
                }

            Map<String,Double> element2 = map.get(l.get(1));
            if(element2==null){
                element2 = new HashMap<>();
                element2.put(l.get(0),1/values[i]);
                map.put(l.get(1),element2);
            }else {
                element2.put(l.get(0),1 / values[i]);
            }

            i++;

        }

        double[] doubles = new double[queries.size()];

        int k=0;
        for (List<String> l :
                queries) {
            Map<String,Boolean> last = new HashMap<>();
            last.put(l.get(0),true);
            Double returnValue =helper(l.get(0),l.get(1),1.0,map,last);
            if(returnValue.equals(1.0))
            doubles[k] = -1.0;
            else {
                doubles[k] = returnValue;
            }
            k++;

        }
return doubles;

    }

    private Double helper(String key,String value,double current, Map<String, Map<String,Double>> map,Map<String,Boolean> last){
        Map<String,Double> map1 = map.get(key);
        if(map1==null)return current;

        for (String s :
                map1.keySet()) {
            if(value.equals(s))return current * map1.get(value);
            else{
                if(last.get(s)==null){
                    last.put(s,true);
                    Double a = helper(s,value,current * map1.get(s),map,last);
                    if(!a.equals(-1.0)){
                        return a;
                    }
                    last.remove(s);
                }

            }
        }
        return current;
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

        List<String> list2 = new ArrayList<>();
        list2.add("b");
        list2.add("c");

        List<List<String>> lists = new ArrayList<>();
        lists.add(list);
        lists.add(list2);

        double[] doubles = new double[2];
        doubles[0] = 2.0;
        doubles[1] = 3.0;


        List<String> list3 = new ArrayList<>();
        list3.add("a");
        list3.add("c");

        List<String> list4 = new ArrayList<>();
        list4.add("b");
        list4.add("a");


        List<List<String>> lists1 = new ArrayList<>();
        lists1.add(list3);
        lists1.add(list4);

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.calcEquation(lists, doubles, lists1)));
    }
}