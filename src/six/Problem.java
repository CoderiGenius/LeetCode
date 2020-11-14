
package six;

/**
 * 建一个二维数组，然后一列一列的填，中间空的列是逐渐上升的，确定好一个step，然后中间的这些列，根据step来确定自己tempHeight，如果与tempHeight
 * 相等，则赋值
 */

public class Problem {

    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        char[][] chars = new char[1000][1000];
        int num = 1;
        int tempHeight = numRows - 1;
        int tempHeight2 = 1;
        String returnString = "";
        for (int z = 1; z < 1000; z++) {


            for (int i = 1; i <= numRows; i++) {
                if (z == 1 || z % (numRows - 1) == 1 || numRows==2) {
                    //System.out.println(num+"::"+(num>=s.length()));
                    chars[i][z] = s.charAt(num-1);
                    num++;

                    tempHeight = numRows - 1;
                } else if (i == tempHeight) {
                    //System.out.println(num+"::"+(num>s.length()));
                    chars[i][z] = s.charAt(num-1);
                    num++;
                    tempHeight--;

                }

                if(num>s.length())break;
            }
            //System.out.println(num+":"+(num>s.length()));
            if(num>s.length())break;
        }

        if (num >=s.length()) {
            for (int t = 1; t <= numRows; t++) {
                for (int k = 1; k < 1000; k++) {

                                if(chars[t][k]!='\0'){
                                //System.out.println(chars[t][k]);
                                returnString = returnString + chars[t][k];
                            }
                    //System.out.print(chars[t][k] + "｜");
                    //returnString += chars[t][k];
                }
                //System.out.println("");
            }
            return returnString;
        }
        return returnString;
    }

    public static void main(String[] args) {
        Problem problem = new Problem();
        System.out.println(problem.convert("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmcoqhnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcacehchzvfrkmlnozjkpqpxrjxkitzyxacbhhkicqcoendtomfgdwdwfcgpxiqvkuytdlcgdewhtaciohordtqkvwcsgspqoqmsboaguwnnyqxnzlgdgwpbtrwblnsadeuguumoqcdrubetokyxhoachwdvmxxrdryxlmndqtukwagmlejuukwcibxubumenmeyatdrmydiajxloghiqfmzhl",80));
    }

}









//package six;
//
//public class Problem {
//
//    public String convert(String s, int numRows) {
//
//        int line = 10;
//        int num = 0;
//        int step = numRows-2;
//        int stepRow = numRows - 1;
//        int currentStep = 1;
//        String returnString = "";
////        if(s.length()<numRows){
////            line = 1;
////        }else {
////            line = (s.length() - 2)/2;
////        }
//
//        char[][] chars = new char[numRows+1][line+1];
//
//        int start = 1;
//        for (int j = 1; j <=line ; j++) {
//
//
//
//            for (int i = 1; i <= numRows; i++) {
//                if (j == 1 || j%stepRow==1) { //找出所有全部填充
//                    chars[i][j] = s.charAt(num);
//                    System.out.println(s.charAt(num)+":"+i+":"+j);
//                    num++;
//                    start = j;
//
//                }
//                if(i!=1 && i!=numRows ){ //找出所有非第一行和最后一行
//                    if(j-start<=step) { //如果那一行对应的列刚好是指定列，则填充
//                        chars[i][j] = s.charAt(num);
//                        System.out.println(s.charAt(num) + ":" + i + ":" + j);
//                        num++;
//                        //System.out.println(s.charAt(num));
//
//                        step--;
//                        if(step<=0){
//                            step = numRows -2;
//                        }
//                    }
//                }
//
//
//
//                if (num >= s.length()) {
//                    for (int t = 1; t <= numRows; t++) {
//                        for (int k = 1; k <=line; k++) {
////                            if(!Character.isSpace(chars[t][k])){
////                                returnString = returnString + chars[t][k];
////                            }
//                            System.out.print(chars[t][k]+"｜");
//                            returnString+=chars[t][k];
//                        }
//                        System.out.println("");
//                    }
//
//
//                    return returnString;
//                }
//            }
//
//        }
//
//return "";
//    }
//
//    public static void main(String[] args) {
//        Problem problem = new Problem();
//        System.out.println(problem.convert("PAYPALISHIRING",4));
//    }
//
//}
