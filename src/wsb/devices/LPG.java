package wsb.devices;

public class LPG extends Car{

    public LPG(String manufacturer, String model, Integer yearOfProd) {
        super(manufacturer, model, yearOfProd);
    }

    public void refuel(String fuelType){
        System.out.println("Usiłujesz zatankować pojazd: " + this.manufacturer + " przy użyciu paliwa: " + fuelType);
        if(fuelType == "LPG"){
            System.out.println("Udało Ci się zatankować ten pojazd.");
        } else {
            System.out.println("Ten samochód można zatankować tylko gazem LPG.");
        }
    }
}
