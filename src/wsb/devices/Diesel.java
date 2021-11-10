package wsb.devices;

public class Diesel extends Car{

    public Diesel(String manufacturer, String model, Integer yearOfProd) {
        super(manufacturer, model, yearOfProd);
    }

    public void refuel(String fuelType){
        System.out.println("Usiłujesz zatankować pojazd: " + this.manufacturer + " przy użyciu paliwa: " + fuelType);
        if(fuelType == "Diesel"){
            System.out.println("Udało Ci się zatankować ten pojazd.");
        } else {
            System.out.println("Ten samochód można zatankować tylko ropą.");
        }
    }
}
