package wsb.devices;

import wsb.*;
import wsb.creatures.Human;

import java.net.MalformedURLException;
import java.net.URL;

public class Phone extends Device implements Sellable {

    public String operatingSys;
    public Double screenSize;
    public URL defaultServer;
    {
        try {
            defaultServer = new URL("https://discord.com/api/downloads/distributions/app/installers/latest?channel=stable&platform=win&arch=x86");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public Phone(String manufacturer, String model, Integer yearOfProd, Double value)  {
        super(manufacturer, model, yearOfProd);
        this.value = value;
        this.operatingSys = "Android";
    }

    public void turnOn() {
        System.out.println("Naduszam przycisk włącznika przez 3 sekundy");
    }

    public String toString(){
        return manufacturer + " " + model + " (System Operacyjny: " + operatingSys + ")";
    }

    public void sale(Human seller, Human buyer, Double price) {
        if (buyer.cash < price) {
            System.out.println("KUPUJĄCY MA ZA MAłO KASY");
        } else if (seller.getPhone() == null) {
            System.out.println("SPRZEDAJĄCY NIE MA ZADNEGO TELEFONU");
        } else if (!seller.getPhone().equals(this)) {
            System.out.println("SPRZEDAJĄCY NIE MA TEGO KONKRETNEGO TELEFONU (ZłODZIEJ)");
        } else {
            seller.cash += price;
            buyer.cash -= price;
            seller.phone = null;
            buyer.phone = this;
            System.out.println("Transakcja się udała, kupiono " + this);

        }
    }

    public void installAnApp(String appName){
        System.out.println("Zainstalowano aplikację o nazwie: \"" + appName + "\" w telefonie marki " + this.manufacturer + ".");
    }

    public void installAnApp(String appName, Double version){
        System.out.println("Zainstalowano aplikację o nazwie: \"" + appName + "\" (w wersji v." + version + ")  w telefonie marki " + this.manufacturer + ".");
    }

    public void installAnApp(String appName, Double version, String serverURL) {
        if (appName == "Discord" && version == 1.0 && serverURL == "discord.com") {
            installAnApp(defaultServer);
        } else {
            System.out.println("Zainstalowano aplikację o nazwie: \"" + appName + "\" (w wersji v." + version + ")  w telefonie marki " + this.manufacturer + ". Została pobrana z serwera o adresie: " + serverURL);
        }
    }

    public void installAnApp(String appName1, String appName2, String appName3){
        System.out.println("W telefonie marki " + this.manufacturer + " zainstalowano następujące aplikacje: " +
                appName1 +
                ", " +appName2 +
                ", " +appName3) ;
    }

    public static void installAnApp(URL defaultServer){
        System.out.println("Zainstalowano aplikację na podstawie linku domyślnego: " + defaultServer + ".");
    }
}
