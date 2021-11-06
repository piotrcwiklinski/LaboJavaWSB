package wsb.devices;

import wsb.*;

public class Car extends Device implements Sellable {

    public Integer milleage;

    public Car(String manufacturer, String model, Integer yearOfProd) {
        super(manufacturer, model, yearOfProd);
    }

    public void turnOn() {
        System.out.println("Przekęcam kluczyk");
    }

    public void carAdded() {
        System.out.println("Dodano samochód " + this.manufacturer + " " + this.model + " do bazy.");
    }

    public String toString(){
        return manufacturer + " " + model + " " + yearOfProd;
    }

    public void sale(Human seller, Human buyer, Double price) {
        if (buyer.cash < price) {
            System.out.println("KUPUJĄCY MA ZA MAłO KASY");
        } else if(seller.getCar() == null){
            System.out.println("SPRZEDAJĄCY NIE MA ZADNEGO AUTA");
        } else if(!seller.getCar().equals(this)) {
            System.out.println("SPRZEDAJĄCY NIE MA TEGO KONKRETNEGO AUTA (ZłODZIEJ)");
        } else {
            seller.cash += price;
            buyer.cash -= price;
            seller.car = null;
            buyer.car = this;
            System.out.println("Transakcja się udała, kupiono " + this);

        }
    };
}
