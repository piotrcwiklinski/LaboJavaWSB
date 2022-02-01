package wsb;

import java.time.LocalDate;
import java.util.ArrayList;

public class SalesRecord {
    String sellerName;
    String buyerName;
    Double price;
    LocalDate transactionDate;
    String transactionItem;

    public SalesRecord(String sName, String bName, Double tPrice, String what) {
        this.sellerName = sName;
        this.buyerName = bName;
        this.price = tPrice;
        this.transactionDate = LocalDate.now();
        this.transactionItem = what;
    }

    public static ArrayList<SalesRecord> listOfTransactions = new ArrayList<SalesRecord>();

    public String toString(){
        return "\tSprzedający: " + sellerName + " \t\tKupujący: " + buyerName + "\tKwota transakcji: " + price + "\t\tData transakcji: " + transactionDate + "\t\tPrzedmiot transakcji: " + transactionItem + ";";
    }

    public static void printTransactionList(){
        System.out.println("::: REJESTR WSZYSTKICH SPRZEDAŻY :::\n");
        int i = 1;
        for (Object o : listOfTransactions){
            System.out.println(i + ". " + o);
            i++;
        }
    }


}
