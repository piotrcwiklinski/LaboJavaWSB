package devices;

public class Phone {
    public String manufacturer;
    public String model;
    public String operatingSys;

    public Phone(String manufacturer, String model){
        this.manufacturer = manufacturer;
        this.model = model;
        this.operatingSys = "Android";
    }

    public String toString(){
        return manufacturer + " " + model + " (System Operacyjny: " + operatingSys + ")";
    }
}
