package devices;

public class Device {
    public String manufacturer;
    public String model;
    public Integer yearOfProd;
    public String color;
    public Double value;

    public Device(String manufacturer, String model, Integer yearOfProd) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearOfProd = yearOfProd;
    }
}
