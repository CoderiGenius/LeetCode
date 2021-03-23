package BlackRock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CoderiGenius
 * @version 2021/3/18
 */
public class Main1 {
    /**
     * Iterate through each line of input.
     */
    private static final BigDecimal ONE_PENCE = new BigDecimal("0.01");
    private static final BigDecimal TWO_PENCE = new BigDecimal("0.02");
    private static final BigDecimal FIVE_PENCE = new BigDecimal("0.05");
    private static final BigDecimal TEN_PENCE = new BigDecimal("0.1");
    private static final BigDecimal TWENTY_PENCE = new BigDecimal("0.2");
    private static final BigDecimal FIFTY_PENCE = new BigDecimal("0.5");
    private static final BigDecimal ONE_POUND = new BigDecimal("1");
    private static final BigDecimal TWO_POUNDS = new BigDecimal("2");
    private static final BigDecimal FIVE_POUNDS = new BigDecimal("5");
    private static final BigDecimal TEN_POUNDS = new BigDecimal("10");
    private static final BigDecimal TWENTY_POUNDS = new BigDecimal("20");
    private static final BigDecimal FIFTY_POUNDS = new BigDecimal("50");

    private static final String ONE_PENCE_STRING = "One Pence";
    private static final String TWO_PENCE_STRING = "Two Pence";
    private static final String FIVE_PENCE_STRING = "Five Pence";
    private static final String TEN_PENCE_STRING = "Ten Pence";
    private static final String TWENTY_PENCE_STRING = "Twenty Pence";
    private static final String FIFTY_PENCE_STRING = "Fifty Pence";
    private static final String ONE_POUND_STRING = "One Pound";
    private static final String TWO_POUNDS_STRING = "Two Pounds";
    private static final String FIVE_POUNDS_STRING = "Five Pounds";
    private static final String TEN_POUNDS_STRING = "Ten Pounds";
    private static final String TWENTY_POUNDS_STRING = "Twenty Pounds";
    private static final String FIFTY_POUNDS_STRING = "Fifty Pounds";

    private static final String ERROR_MESSAGE = "ERROR";
    private static final String ZERO_MESSAGE = "Zero";


    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);

        try {
            double purchasePrice = Double.parseDouble(in.readLine());
            double cash = Double.parseDouble(in.readLine());
            Main1.calculateChange(purchasePrice, cash);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * calculate Change and print the change Separated by commas
     * @author Sicheng Zhou
     * @version 2021/3/18
     * @param purchasePrice
     * @param cash
     */
    public static void calculateChange(double purchasePrice, double cash) {
        // Access your code here. Feel free to create other classes as required

        List<String> list = new LinkedList<>();
        BigDecimal purchasePriceBigDecimal = new BigDecimal(Double.toString(purchasePrice));
        BigDecimal cashBigDecimal = new BigDecimal(Double.toString(cash));

        if(purchasePriceBigDecimal.compareTo(cashBigDecimal)>0){
            System.out.println(ERROR_MESSAGE);
            return;
        }

        BigDecimal returnedChange = cashBigDecimal.subtract(purchasePriceBigDecimal);
        if(returnedChange.intValue()==0){
            System.out.println(ZERO_MESSAGE);
            return;
        }


       returnedChange = countChangeWithSpecificUnit(FIFTY_POUNDS,FIFTY_POUNDS_STRING,returnedChange,list);
        returnedChange = countChangeWithSpecificUnit(TWENTY_POUNDS,TWENTY_POUNDS_STRING,returnedChange,list);
        returnedChange = countChangeWithSpecificUnit(TEN_POUNDS,TEN_POUNDS_STRING,returnedChange,list);
        returnedChange = countChangeWithSpecificUnit(FIVE_POUNDS,FIVE_POUNDS_STRING,returnedChange,list);
        returnedChange = countChangeWithSpecificUnit(TWO_POUNDS,TWO_POUNDS_STRING,returnedChange,list);
        returnedChange = countChangeWithSpecificUnit(ONE_POUND,ONE_POUND_STRING,returnedChange,list);
        returnedChange = countChangeWithSpecificUnit(FIFTY_PENCE,FIFTY_PENCE_STRING,returnedChange,list);
        returnedChange = countChangeWithSpecificUnit(TWENTY_PENCE,TWENTY_PENCE_STRING,returnedChange,list);
        returnedChange = countChangeWithSpecificUnit(TEN_PENCE,TEN_PENCE_STRING,returnedChange,list);

        returnedChange = countChangeWithSpecificUnit(FIVE_PENCE,FIVE_PENCE_STRING,returnedChange,list);

        returnedChange = countChangeWithSpecificUnit(TWO_PENCE,TWO_PENCE_STRING,returnedChange,list);
        returnedChange = countChangeWithSpecificUnit(ONE_PENCE,ONE_PENCE_STRING,returnedChange,list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if(i!=list.size()-1){
                System.out.print(", ");
            }

        }

    }

    /**
     * Count the change with a specific unit and return the money remain
     * @param unit  unit
     * @param unitString unit name
     * @param money The money need to be handle
     * @param resultList The exchange detail
     * @return The money remain. if no money left return BigDecimal("0")
     */
    private static BigDecimal countChangeWithSpecificUnit(BigDecimal unit,String unitString,BigDecimal money,List<String> resultList){
        if(money==null)return new BigDecimal("0");
        if(money.compareTo(unit)>=0){
            BigDecimal[] left = money.divideAndRemainder(unit);
            for (int i = 0; i < left[0].intValue(); i++) {
                resultList.add(unitString);
            }
            return left[1];
        }else {
            return money;
        }

    }



}