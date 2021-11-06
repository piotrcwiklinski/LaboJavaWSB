package devices;

public class Car extends Device {

    public Integer milleage;

    public Car(String manufacturer, String model, Integer yearOfProd) {
        super(manufacturer, model, yearOfProd);
    }

    public void carAdded() {
        System.out.println("Dodano samochód " + this.manufacturer + " " + this.model + " do bazy.");
    }

    public String toString(){
        return manufacturer + " " + model + " " + yearOfProd;
    }
}
