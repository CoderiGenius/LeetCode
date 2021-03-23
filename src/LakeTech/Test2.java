//public static int connectedSum(int n, List<String> edges) {
//
//        int sum = 0;
//        if(n==0||edges.isEmpty()){
//        return sum;
//        }
//        Map<String,TreeNode> map = new HashMap<>();
//
//        Map<String,String> went = new HashMap<>();
//        for (String s :
//        edges) {
//        String[] strings = s.split(" ");
//        TreeNode treeNode = map.get(strings[0]);
//        TreeNode childNode = map.get(strings[1]);
//
//        if(treeNode==null){
//        treeNode = new TreeNode(strings[0]);
//        }
//
//        if(childNode==null){
//        childNode = new TreeNode(strings[1]);
//        }
//        treeNode.list.add(childNode);
//        childNode.list.add(treeNode);
//
//        map.put(strings[0],treeNode);
//        map.put(strings[1],childNode);
//
//        }
//
//
//        for (String s :map.keySet()
//        ) {
//        if(went.size()==map.size())break;
//
//        TreeNode treeNode = map.get(s);
//        int result = getTreeNodesNum(treeNode,0,went);
//        sum += handleResult(result);
//        }
//        int absent = n-map.size();
//        return sum+absent;
//        }
//
//private static int handleResult(int result){
//        double aDouble = Math.sqrt(result);
//        return (int)Math.ceil(aDouble);
//        }
//
//private static int getTreeNodesNum(TreeNode treeNode,int num,Map<String,String> went){
//        if(treeNode==null || went.get(treeNode.value)!=null)return num;
//
//        num++;
//        went.put(treeNode.value,treeNode.value);
//        for (TreeNode t :
//        treeNode.list) {
//        num = getTreeNodesNum(t,num,went);
//        }
//        return num;
//        }
//
//static class TreeNode{
//    TreeNode(String value){
//        this.value = value;
//    }
//    String value;
//    List<TreeNode> list = new ArrayList<>();
//
//    @Override
//    public String toString() {
//        return "TreeNode{" +
//                "value='" + value + '\'' +
//                '}';
//    }
//}