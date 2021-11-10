package wsb.devices;

import wsb.*;
import wsb.creatures.Human;

public class Phone extends Device implements Sellable {

    public String operatingSys;
    public Double screenSize;

    public Phone(String manufacturer, String model, Integer yearOfProd, Double value){
        super(manufacturer, model, yearOfProd);
        this.value = value;
        this.operatingSys = "Android";
    }

    public void turnOn() {
        System.out.println("Naduszam przycisk włącznika przez 3 sekundy");
    }

    public String toString(){
        return manufacturer + " " + model + " (System Operacyjny: " + operatingSys + ")";
    }

    public void sale(Human seller, Human buyer, Double price) {
        if (buyer.cash < price) {
            System.out.println("KUPUJĄCY MA ZA MAłO KASY");
        } else if (seller.getPhone() == null) {
            System.out.println("SPRZEDAJĄCY NIE MA ZADNEGO TELEFONU");
        } else if (!seller.getPhone().equals(this)) {
            System.out.println("SPRZEDAJĄCY NIE MA TEGO KONKRETNEGO TELEFONU (ZłODZIEJ)");
        } else {
            seller.cash += price;
            buyer.cash -= price;
            seller.phone = null;
            buyer.phone = this;
            System.out.println("Transakcja się udała, kupiono " + this);

        }
    }
}
