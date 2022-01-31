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

    public static ArrayList listOfTransactions = new ArrayList();

    public String toString(){
        return "\t1)Sprzedający: " + sellerName + " \t\t2)Kupujący: " + buyerName + "\t\t3)Kwota transakcji: " + price + "\t\t4)Data transakcji: " + transactionDate + "\t\t5)Przedmiot transakcji: " + transactionItem + ";";
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
