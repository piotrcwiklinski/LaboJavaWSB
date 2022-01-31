package wsb.devices;

import wsb.*;
import wsb.creatures.Human;

import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Phone extends Device implements Sellable {

    private static final Double DEFAULT_APP_VERSION = 1.0;
    private static final String DEFAULT_SERVER_NAME = "imaginaryappserver.com";
    private static final String DEFAULT_PROTOCOL = "https";
    public String operatingSys;
    public Double screenSize;
    public URL defaultServer;
    public BigInteger freeSpace;

    {
        try {
            defaultServer = new URL("https://discord.com/api/downloads/distributions/app/installers/latest?channel=stable&platform=win&arch=x86");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public Phone(String manufacturer, String model, Integer yearOfProd, Double value) {
        super(manufacturer, model, yearOfProd);
        this.value = value;
        this.operatingSys = "Android";
        this.freeSpace = new BigInteger("50000");
    }

    public void turnOn() {
        System.out.println("Naduszam przycisk włącznika przez 3 sekundy");
    }

    public String toString() {
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

    public void installAnApp(String appName) {
        this.installAnApp(appName, DEFAULT_APP_VERSION);
    }

    public void installAnApp(String appName, Double version) {
        this.installAnApp(appName, version, DEFAULT_SERVER_NAME);
    }

    public void installAnApp(String appName, Double version, String serverURL) {
        try {
            URL url = new URL(DEFAULT_PROTOCOL, serverURL,443, appName + "-" + version);
            this.installAnApp(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void installAnApp(URL url) {
        //log
        //sprawdzanie miejsca
        //sprawdzanie czy jest płatna
            //obsługa płatności
        //pobranie aplikacji
        //rozpakowanie
        //instalacja
        String logFile =    "\t\n::LOG PRZEBIEGU INSTALACJI APLIKACJI::\n" +
                            ">Adres URL Serwera Instalacji: " + url + ";\n" +
                            ">Sprawdzanie dostępności miejsca na urządzeniu...";
        BigInteger size = new BigInteger("1");
        HttpURLConnection conn;
        try
        {
            conn = (HttpURLConnection)url.openConnection();

            conn.setRequestMethod("HEAD");

            conn.getInputStream();

            size = BigInteger.valueOf(conn.getContentLength());

            conn.getInputStream().close();
        }
        catch (Exception e)
        {
            System.out.println("Connection failed");
        }
        if(size.compareTo(this.freeSpace) < 1){
            logFile = logFile + "\n>Ilość dostępnego miejsca na dysku jest wystarczająca;\n" +
                                ">Rozmiar pliku: " + size + " bajtów. Wolne miejsce: " + this.freeSpace + " bajtów.\n" +
                    ">Sprawdzanie, czy usługa jest płatna...";

        } else {
            logFile = logFile + "\n>BRAK WYSTARCZAJĄCEJ ILOSCI WOLNEGO MIEJSCA!\n" +
                                ">Rozmiar pliku: " + size + " bajtów. Wolne miejsce: " + this.freeSpace + " bajtów.\n" +
                                ">PROCES INSTALACJI ZAKONCZONY NIEPOWODZENIEM! ";
        }

        System.out.println(logFile);
    }

    public void installAnApp(List<String> appNames) {
        for (String appName : appNames) {
            this.installAnApp(appName);
        }
    }
}