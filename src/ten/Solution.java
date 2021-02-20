package ten;

class Solution {
    public boolean isMatch(String s, String p) {

//        if(p.length()==0&&s.length()==0)return true;
        //else if(p.length()==0||s.length()==0)return false;

        if (p.length() <= 0) return s.length() <= 0;

        boolean match = (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));


        if(p.length()>1 && p.charAt(1)=='*'){
            return (match
                    && isMatch(s.substring(1),p))
                    || isMatch(s,p.substring(2));
        }else if(match){
            return isMatch(s.substring(1),p.substring(1));
        }else {
            return false;
        }



    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("a",".*..a*"));
    }
}