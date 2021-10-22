package devices;

public class Car {
    public String manufacturer;
    public String model;
    public Integer yearOfProd;
    public String color;
    public Double value;

    public void carAdded() {
        System.out.println("Dodano samochód " + this.manufacturer + " " + this.model + " do bazy.");
    }

    public String toString(){
        return manufacturer + " " + model + " " + yearOfProd;
    }
}
