package TransferWise;

/**
 * @author CoderiGenius
 * @version 2021/3/24 8:34 下午
 */
public class Main {

    //including "-"
    private final static int ACCOUNT_NUMBER_LENGTH = 10;
    private final static int BANK_CODE_LENGTH = 4;
    private final static String ERROR_RETURN = "";
    private final static String HYPHEN = "-";
    private final static int ALPHA_START = 10;
    private final static int DIVIDER = 89;

    public static String checkDetailsAreValid(String accountNumber, String bankCode) {

        accountNumber = accountNumber.replaceAll(" ","");
        bankCode = bankCode.replaceAll(" ","");

        if( ! validAccountNumber(accountNumber) || ! validBankCode(bankCode)){
            return ERROR_RETURN;
        }

        String accountNumberWithoutCheckSum = getAccountNumberWithoutCheckSum(accountNumber);
        String accountNumberCheckSum = getAccountNumberCheckSum(accountNumber);
        String payload = accountNumberWithoutCheckSum+bankCode;

        int sum = 0;
        for (int i = 0; i < payload.length(); i++) {
            int weight = getWeightFromIndex(i+1);
            sum += transformAlphaToNumber(payload.charAt(i)) * weight;
        }
        int handledSum = handleSum(sum);
        int customerCheckSum = Integer.parseInt(accountNumberCheckSum);
        if(handledSum==customerCheckSum){
            if(handledSum<10)return "0"+handledSum;
            else return handledSum+"";
        }else {
            return ERROR_RETURN;
        }


    }


    private static int handleSum(int sum){
        if(sum % 2 ==0){
            return sum % DIVIDER;
        }else {
            return 89-(sum % 89);
        }
    }

    /**
     * getAccountNumberWithoutCheckSum
     * @param s
     * @return if error return empty string
     */
    private static String getAccountNumberWithoutCheckSum(String s){
        String[] strings = s.split(HYPHEN);
        if(strings.length!=2){
            return "";
        }
        return strings[1];
    }
    private static String getAccountNumberCheckSum(String s){
        String[] strings = s.split(HYPHEN);
        if(strings.length!=2){
            return "";
        }
        return strings[0];
    }

    private static boolean validBankCode(String s){

        if(s.length()!=BANK_CODE_LENGTH)return false;
        if( ! Character.isAlphabetic(s.charAt(0)) || ! Character.isAlphabetic(s.charAt(1)))return false;
        if( ! Character.isDigit(s.charAt(2)) || ! Character.isDigit(s.charAt(3)))return false;
        return true;
    }


    private static boolean validAccountNumber(String s){
        if(s.length() != ACCOUNT_NUMBER_LENGTH){
            return false;
        }
        if( ! s.contains(HYPHEN)){
            return false;
        }
        return true;
    }

    private static int getWeightFromIndex(int character) {

        switch (character){
            case 1: return 7;
            case 2: return 3;
            case 3: return 1;
            case 4: return 5;
            case 5: return 2;
            case 6: return 4;
            case 7: return 8;
            case 8: return 6;
            case 9: return 1;
            case 10: return 6;
            case 11: return 5;
            default:return 0;

        }
    }

    private static int transformAlphaToNumber(Character character) {
        if(Character.isAlphabetic(character)){
            return character-'A'+ALPHA_START;
        }else if(Character.isDigit(character)){
            return Integer.parseInt(character.toString());
        }else return 0;
    }


    public static void main(String[] args) {
        //System.out.println(Main.checkDetailsAreValid("12-7654321","AB11"));
        System.out.println(Main.checkDetailsAreValid("11-0007395","XX55"));


        System.out.println(Main.transformAlphaToNumber('X'));
    }
}
