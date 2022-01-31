package wsb.devices;

import wsb.*;
import wsb.creatures.Human;

public abstract class Car extends Device implements Sellable {

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
            System.out.println("Nieudana próba zakupu samochodu: " + this + ". KUPUJĄCY MA ZA MAłO KASY!");
        } else if(!seller.hasCar(this)){
            System.out.println("Nieudana próba zakupu samochodu: " + this + ". SPRZEDAJĄCY NIE MA AUTA!");
        } else if(!buyer.hasFreeParkingLot()) {
            System.out.println("Nieudana próba zakupu samochodu: " + this + ". KUPUJĄCY NIE MA MIEJSCA W GARAŻU!");
        } else {
            seller.cash += price;
            buyer.cash -= price;
            seller.removeCar(this);
            buyer.addCar(this);
            System.out.println("Transakcja się udała, " + buyer.firstName + " kupił/a " + this + " od " + seller.firstName);

        }
    }

    public abstract void refuel(String fuelType);
}
