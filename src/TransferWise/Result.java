//package TransferWise;
//
//import java.math.BigDecimal;
//import java.util.List;
//
///**
// * @author CoderiGenius
// * @version 2021/3/24 9:57 下午
// */
//public class Result {
//
//    private static final String DEPOSIT = "DEPOSIT";
//    private static final String WITHDRAWAL = "WITHDRAWAL";
//    private static final String SPLIT  = ",";
//    private static final String EUR = "EUR";
//    private static final String GBP = "GBP";
//    private static final String USD = "USD";
//    private static final BigDecimal ZERO = new BigDecimal(0);
//
//
//
//    public static String printBalances(List<String> requests) {
//
//        Account account = new Account();
//
//        for (String s :
//                requests) {
//            String[] strings = s.split(SPLIT);
//            if(strings.length!=3)continue;
//            if(strings[0].equals(DEPOSIT)){
//                account.deposit(strings[1],strings[2]);
//            }else {
//                if(account.withdraw(strings[1],strings[2])){
//                    System.out.println("Not enough money");
//                    break;
//                }
//            }
//        }
//
//        return account.print();
//    }
//
//    static class Account implements Cloneable{
//        static BigDecimal EUR;
//       static BigDecimal GBP;
//       static BigDecimal USD;
//
//         Account() {
//            this.EUR = new BigDecimal("0");
//            this.GBP = new BigDecimal("0");
//            this.USD = new BigDecimal("0");
//        }
//
//        public  void deposit(String amount,String type){
//             if(type.equals(Result.EUR)){
//                 EUR.add(new BigDecimal(amount));
//             }else if(type.equals(Result.GBP)){
//                 GBP.add(new BigDecimal(amount));
//             }else if(type.equals(Result.USD)){
//                 USD.add(new BigDecimal(amount));
//             }else {
//                 System.out.println("ERROR");
//             }
//        }
//
//        /**
//         * withdraw money in transaction
//         * @param amount
//         * @param type
//         * @return success or not
//         */
//        public  boolean withdraw(String amount,String type){
//            //this is a  virtual account which is used for virtual transactions, if there is a problem, you can uncommit
//            Account account = null;
//            if(type.equals(Result.EUR)){
//                 account= this.tryWithdrawEUR(amount);
//            }else if(type.equals(GBP)){
//                 account = this.tryWithdrawGBP(amount);
//            }else if(type.equals(USD)){
//                 account = this.tryWithdrawUSD(amount);
//            }else {
//                System.out.println("ERROR");
//                return false;
//            }
//            if(account.validAccount()){
//                this.setAccount(account);
//                return true;
//            }else
//            {
//                return false;
//            }
//        }
//
//        private Account tryWithdrawEUR(String amount){
//             BigDecimal withdrawAmount = new BigDecimal(amount);
//             Account tempAccount = this.clone();
//             if(withdrawAmount.compareTo(tempAccount.getEUR())>0){
//
//                 //confirm how many we still need
//                 tempAccount.setEUR(tempAccount.getEUR().subtract(withdrawAmount));
//
//                 BigDecimal moneyInUSD = new BigDecimal(RateService.getMidMarketRate("EUR","USD"))
//                         .multiply(tempAccount.getEUR().abs(),BigDecimal.ROUND_UP);
//
//                 tempAccount.setUSD(tempAccount.getUSD().subtract(moneyInUSD));
//
//                 if(tempAccount.getUSD().compareTo(ZERO)<0){
//                     BigDecimal moneyInGBP = new BigDecimal(RateService.getMidMarketRate("USD","GBP"))
//                             .multiply(tempAccount.getUSD().abs(),BigDecimal.ROUND_UP);
//                     tempAccount.setGBP(tempAccount.getGBP().subtract(moneyInGBP));
//
//                 }
//                 return tempAccount;
//
//             }else {
//                 BigDecimal bigDecimal = tempAccount.getEUR().subtract(withdrawAmount);
//                 tempAccount.setEUR(bigDecimal);
//                 return tempAccount;
//             }
//        }
//        private Account tryWithdrawGBP(String amount){
//            BigDecimal withdrawAmount = new BigDecimal(amount);
//            Account tempAccount = this.clone();
//            if(withdrawAmount.compareTo(tempAccount.getGBP())>0){
//
//
//                tempAccount.setGBP(tempAccount.getGBP().subtract(withdrawAmount));
//
//                BigDecimal moneyInUSD = new BigDecimal(RateService.getMidMarketRate("GBP","USD"))
//                        .multiply(tempAccount.getEUR().abs(),BigDecimal.ROUND_UP);
//
//                tempAccount.setUSD(tempAccount.getUSD().subtract(moneyInUSD));
//
//                if(tempAccount.getUSD().compareTo(ZERO)<0){
//                    BigDecimal moneyInEUR = new BigDecimal(RateService.getMidMarketRate("USD","GBP"))
//                            .multiply(tempAccount.getUSD().abs(),BigDecimal.ROUND_UP);
//                    tempAccount.setEUR(tempAccount.getEUR().subtract(moneyInEUR));
//
//                }
//                return tempAccount;
//
//            }else {
//                BigDecimal bigDecimal = tempAccount.getGBP().subtract(withdrawAmount);
//                tempAccount.setGBP(bigDecimal);
//
//                return tempAccount;
//            }
//        }
//        private Account tryWithdrawUSD(String amount){
//            BigDecimal withdrawAmount = new BigDecimal(amount);
//            Account tempAccount = this.clone();
//            if(withdrawAmount.compareTo(tempAccount.getUSD())>0){
//
//
//                tempAccount.setGBP(tempAccount.getGBP().subtract(withdrawAmount));
//
//                BigDecimal moneyInEUR = new BigDecimal(RateService.getMidMarketRate("EUR","USD"))
//                        .multiply(tempAccount.getGBP().abs(),BigDecimal.ROUND_UP);
//
//                tempAccount.setEUR(tempAccount.getEUR().subtract(moneyInEUR));
//
//                if(tempAccount.getUSD().compareTo(ZERO)<0){
//                    BigDecimal moneyInGBP = new BigDecimal(RateService.getMidMarketRate("USD","GBP"))
//                            .multiply(tempAccount.getUSD().abs(),BigDecimal.ROUND_UP);
//                    tempAccount.setGBP(tempAccount.getGBP().subtract(moneyInGBP));
//
//                }
//                return tempAccount;
//
//            }else {
//                BigDecimal bigDecimal = tempAccount.getUSD().subtract(withdrawAmount);
//                tempAccount.setUSD(bigDecimal);
//                return tempAccount;
//            }
//        }
//
//        public boolean validAccount(){
//             return getUSD().compareTo(ZERO)>=0 && getEUR().compareTo(ZERO)>=0 && getGBP().compareTo(ZERO)>=0;
//        }
//
//        public String print(){
//             String EUR = "EUR, " + getEUR()+"\n";
//             String BGP = "BGP, "+ getGBP()+"\n";
//             String USD = "USD, "+getUSD() + "\n";
//             return BGP+EUR+USD;
//        }
//
//        public  BigDecimal getEUR() {
//            return EUR;
//        }
//
//        public  void setEUR(BigDecimal EUR) {
//            Account.EUR = EUR;
//        }
//
//        public  BigDecimal getGBP() {
//            return GBP;
//        }
//
//        public  void setGBP(BigDecimal GBP) {
//            Account.GBP = GBP;
//        }
//
//        public  BigDecimal getUSD() {
//            return USD;
//        }
//
//        public  void setUSD(BigDecimal USD) {
//            Account.USD = USD;
//        }
//        public void setAccount(Account account){
//             if(account.getGBP().compareTo(ZERO)>=0){
//                 this.setGBP(account.getGBP());
//             }
//            if(account.getEUR().compareTo(ZERO)>=0){
//                this.setEUR(account.getEUR());
//            }if(account.getUSD().compareTo(ZERO)>=0){
//                this.setUSD(account.getUSD());
//            }
//        }
//
//        /**
//         * clone an virtual account for undo log of transactions
//         * if there is any problem，them do not commit
//         * @return
//         */
//        @Override
//        public Account clone(){
//             Account account = new Account();
//             account.setEUR(this.getEUR());
//             account.setGBP(this.getGBP());
//             account.setUSD(this.getUSD());
//             return account;
//        }
//    }
//}
