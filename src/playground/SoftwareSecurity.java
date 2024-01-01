package playground;

/**
 * @author CoderiGenius
 * @version 2021/5/7 11:30 下午
 */
public class SoftwareSecurity {

    public static void main(String[] args) {
        int total = 12;
        //The first part of the number can be 0-9
        for (int i = 0; i < total && i < 10; i++) {
            //Generate part 1
            String part1 = "000" + i + "0-";

            //The second part of the number can be 0-9 and also smaller than 12 minus the number of part 1
            for (int j = 0; j < total - i && j < 10; j++) {
                String part2 = part1 + "00" + j + "00-";

                //The number of part3 should be the remain result of 12 minus the number of part 1 and part 2
                //And also it should be smaller than 10
                if ((total - j - i) < 10) {
                    String part3 = part2 + "0" + (total - i - j) + "000-00000";

                    //This prints the final result
                    System.out.println(part3);
                }
            }
        }
    }
}
