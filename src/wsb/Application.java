package wsb;

import java.util.Random;

public class Application {

    public String appName;
    public Double version;
    public Double price;
    public Integer size;

    Random rand = new Random();

    public Application(String appName, Double version, Double price){
        this.appName = appName;
        this.version = version;
        this.price = price;
        this.size = rand.nextInt(60000);
    }

    public String toString(){
        return appName;
    }

}
