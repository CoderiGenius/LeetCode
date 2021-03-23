package BlackRock;

/**
 * @author CoderiGenius
 * @version 2021/3/9 10:54 下午
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    /**
     * Iterate through each line of input.
     */

    private static final String STOCK = "STOCK";
    private static final String BOND = "BOND";
    private static final String BUY_STRING = "BUY, ";
    private static final String SELL_STRING = "SELL, ";


    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            Main.matchBenchmark(line);
        }
    }

    public static void matchBenchmark(String input) {
        // Access your code here. Feel free to create other classes as required
        String[] companies = input.split(":");
        Set<String> companiesName = new HashSet<>();

        //Handle part one
        String[] partOneCompanies = companies[0].split("\\|");
        Map<String,CompanyPortfolio> companyPortfolioMap = new TreeMap<>();

        for (String s :
                partOneCompanies) {
            String[] detail = s.split(",");
            companiesName.add(detail[0]);
            CompanyPortfolio companyPortfolio = companyPortfolioMap.get(detail[0]);
            if(companyPortfolio==null){
                companyPortfolio = new CompanyPortfolio();
            }

            if(STOCK.equals(detail[1])){
                companyPortfolio.Stock = new BigDecimal(detail[2]);
            }else {
                companyPortfolio.Bond = new BigDecimal(detail[2]);
            }

            companyPortfolioMap.put(detail[0],companyPortfolio);
        }

        //Handle part two
        String[] partTwoCompanies = companies[1].split("\\|");
        Map<String,CompanyPortfolio> companyPortfolioMapPartTwo = new TreeMap<>();
        for (String s :
                partTwoCompanies) {
            String[] detail = s.split(",");
            companiesName.add(detail[0]);
            CompanyPortfolio companyPortfolio = companyPortfolioMapPartTwo.get(detail[0]);
            if(companyPortfolio==null){
                companyPortfolio = new CompanyPortfolio();
            }

            if(STOCK.equals(detail[1])){
                companyPortfolio.Stock = new BigDecimal(detail[2]);
            }else {
                companyPortfolio.Bond = new BigDecimal(detail[2]);
            }

            companyPortfolioMapPartTwo.put(detail[0],companyPortfolio);
        }


        //compare part one and part two
        for (String s :
                companiesName) {
            CompanyPortfolio companyPortfolioOne = companyPortfolioMap.get(s);
            CompanyPortfolio companyPortfolioTwo = companyPortfolioMapPartTwo.get(s);

            StringBuilder companyNameStringBuilder = new StringBuilder(s);
            companyNameStringBuilder.delete(0,companyNameStringBuilder.length());
            int difference = companyPortfolioOne.getStock().subtract(companyPortfolioTwo.getStock()).intValue();
            if(difference>0){
                companyPortfolioOne.getSellStock().add(SELL_STRING+s+", "+STOCK+", "+difference);
            }else if(difference < 0){
                companyPortfolioOne.getBuyStock().add(BUY_STRING+s+", "+STOCK+", "+Math.abs(difference));
            }

            difference = companyPortfolioOne.getBond().subtract(companyPortfolioTwo.getBond()).intValue();
            if(difference>0){
                companyPortfolioOne.getSellBond().add(SELL_STRING+s+", "+BOND+", "+difference);
            }else if(difference < 0){
                companyPortfolioOne.getBuyBond().add(BUY_STRING+s+", "+BOND+", "+Math.abs(difference));
            }


            companyPortfolioMap.put(s,companyPortfolioOne);
        }

        for (String s :
                companyPortfolioMap.keySet()) {
           CompanyPortfolio c = companyPortfolioMap.get(s);
           c.printSellBond();
           c.printBuyBond();
           c.printSellStock();
           c.printBuyStock();
        }
    }




    static class CompanyPortfolio{

        private BigDecimal Stock;
        private BigDecimal Bond;
        private List<String> buyBond;
        private List<String> sellBond;
        private List<String> buyStock;
        private List<String> sellStock;


        public CompanyPortfolio() {
            this.Stock = new BigDecimal("0");
            this.Bond = new BigDecimal("0");
            this.buyBond = new LinkedList<>();
            this.sellBond = new LinkedList<>();
            this.buyStock = new LinkedList<>();
            this.sellStock = new LinkedList<>();
        }

        public CompanyPortfolio(double stock, double bond) {
           this.Stock = new BigDecimal(Double.toString(stock));
           this.Bond = new BigDecimal(Double.toString(bond));
           this.buyBond = new LinkedList<>();
           this.sellBond = new LinkedList<>();
           this.buyStock = new LinkedList<>();
            this.sellStock = new LinkedList<>();
        }



        public void printSellBond(){
            if(!getSellBond().isEmpty())
                for (String s :
                        getSellBond()) {
                    System.out.println(s);
                }
        }
        public void printSellStock(){
            if(!getSellStock().isEmpty())
            {
                for (String s :
                        getSellStock()) {
                    System.out.println(s);
                }
            }
        }
        public void printBuyStock(){
            if(!getBuyStock().isEmpty())
            {
                for (String s :
                        getBuyStock()) {
                    System.out.println(s);
                }
            }
        }
        public void printBuyBond(){
            if(!getBuyBond().isEmpty())
            {
                for (String s :
                        getBuyBond()) {
                    System.out.println(s);
                }
            }
        }


        public List<String> getBuyBond() {
            return buyBond;
        }

        public void setBuyBond(List<String> buyBond) {
            this.buyBond = buyBond;
        }

        public List<String> getSellBond() {
            return sellBond;
        }

        public void setSellBond(List<String> sellBond) {
            this.sellBond = sellBond;
        }

        public List<String> getBuyStock() {
            return buyStock;
        }

        public void setBuyStock(List<String> buyStock) {
            this.buyStock = buyStock;
        }

        public List<String> getSellStock() {
            return sellStock;
        }

        public void setSellStock(List<String> sellStock) {
            this.sellStock = sellStock;
        }

        public BigDecimal getStock() {
            return Stock;
        }

        public void setStock(BigDecimal stock) {
            Stock = stock;
        }

        public BigDecimal getBond() {
            return Bond;
        }

        public void setBond(BigDecimal bond) {
            Bond = bond;
        }

        @Override
        public String toString() {
            return "CompanyPortfolio{" +
                    "Stock=" + Stock +
                    ", Bond=" + Bond +
                    ", buyBond=" + buyBond +
                    ", sellBond=" + sellBond +
                    ", buyStock=" + buyStock +
                    ", sellStock=" + sellStock +
                    '}';
        }
    }




}