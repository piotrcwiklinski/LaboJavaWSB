package wsb.devices;

import wsb.*;
import wsb.creatures.Human;
import java.util.ArrayList;


public abstract class Car extends Device implements Sellable {

    public ArrayList <String> listOfOwners = new ArrayList<>();

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
        buyer.getFullName();
        seller.getFullName();
        if (buyer.cash < price) {
            System.out.println("Nieudana próba zakupu samochodu: " + this + ". KUPUJĄCY MA ZA MAłO KASY!");
        } else if(!seller.hasCar(this)){
            System.out.println("Nieudana próba zakupu samochodu: " + this + ". SPRZEDAJĄCY NIE MA AUTA w GARAŻU!");
        } else if(!seller.name.equals(this.listOfOwners.get(this.listOfOwners.size() - 1))) {
            System.out.println("Nieudana próba zakupu samochodu: " + this + ". ZLODZIEJ! SPRZEDAJĄCY POSIADA W GARAŻU SAMOCHÓD, ALE NIE JEST OSTATNIM KUPCEM W PAPIERACH!");
            System.out.println("Sprzedawca: " + seller.name + " a w papierach: " + this.listOfOwners.get(this.listOfOwners.size() - 1));
        } else if(!buyer.hasFreeParkingLot()) {
            System.out.println("Nieudana próba zakupu samochodu: " + this + ". KUPUJĄCY NIE MA MIEJSCA W GARAŻU!");
        } else {
            seller.cash += price;
            buyer.cash -= price;
            seller.removeCar(this);
            buyer.addCar(this);
            this.listOfOwners.add(buyer.name);
            SalesRecord.listOfTransactions.add(new SalesRecord(seller.name, buyer.name, price, this.toString()));
            System.out.println("Transakcja się udała, " + buyer.firstName + " kupił/a " + this + " od " + seller.firstName);

        }
    }

    public void checkOwners(Human owner) {
        if(this.listOfOwners.contains(owner.name)){
            System.out.println(owner.name + " był/a właścicielem pojazdu " + this);
        }
        else {
            System.out.println(owner.name + " nie był/a nigdy właścicielem pojazdu " + this );
        }
    }

    public void checkIfHumanASoldToHumanB(Human seller, Human buyer) {
        int success = 0;
        for (int i = 0; i < this.listOfOwners.size(); i++){
            if(this.listOfOwners.get(i).equals(seller.name)){
                if(i + 1 < this.listOfOwners.size()) {
                    if(this.listOfOwners.get(i + 1).equals(buyer.name)) {
                        success++;
                        System.out.println("Wg. listy właścicieli " + seller.name + " sprzedał/a samochód " + this + " osobie " + buyer.name + ";");
                        break;
                    }
                }
            }
        }
        if(success == 0) System.out.println("Wg. listy właścicieli " + seller.name + " nigdy nie sprzedał/a samochodu " + this + " osobie " + buyer.name + ";");
    }

    public void countCarTransactions() {
        int transactionsCount = this.listOfOwners.size();
        System.out.println(this + ": ten samochód uczestniczył w następującej liczbie transakcji: " + transactionsCount);
    }

    public abstract void refuel(String fuelType);


}
