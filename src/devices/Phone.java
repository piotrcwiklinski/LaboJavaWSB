package devices;

public class Phone extends Device {

    public String operatingSys;
    public Double screenSize;

    public Phone(String manufacturer, String model, Integer yearOfProd){
        super(manufacturer, model, yearOfProd);
        this.operatingSys = "Android";
    }

    public String toString(){
        return manufacturer + " " + model + " (System Operacyjny: " + operatingSys + ")";
    }
}
