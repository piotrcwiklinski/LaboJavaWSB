package wsb.devices;

import wsb.*;
import wsb.creatures.Human;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Phone extends Device implements Sellable {

    private static final Double DEFAULT_APP_VERSION = 1.0;
    private static final String DEFAULT_SERVER_NAME = "imaginaryappserver.com";
    private static final String DEFAULT_PROTOCOL = "https";
    public String operatingSys;
    public Integer freeSpace;
    Random rand = new Random();
    Scanner in = new Scanner(System.in);

    public Phone(String manufacturer, String model, Integer yearOfProd, Double value) {
        super(manufacturer, model, yearOfProd);
        this.value = value;
        this.operatingSys = "Android";
        this.freeSpace = 50000;
    }

    public void turnOn() {
        System.out.println("Naduszam przycisk włącznika przez 3 sekundy...");
        System.out.println("Naduszam przycisk włącznika przez 3 sekundy...");
        System.out.println("Naduszam przycisk włącznika przez 3 sekundy...");
        System.out.println("Urządzenie uruchomione pomyślnie!");
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
            URL url = new URL(DEFAULT_PROTOCOL, serverURL, 443, appName + "-" + version);
            this.installAnApp(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void installAnApp(URL url) {

        System.out.println("\n::LOG PRZEBIEGU INSTALACJI APLIKACJI::");
        System.out.println(">Adres URL Serwera Instalacji: " + url + ";");
        System.out.println(">Sprawdzanie dostępności miejsca na urządzeniu...");
        int tempSize = rand.nextInt(60000);
        if (tempSize < this.freeSpace) {
            System.out.println(">Ilość dostępnego miejsca na dysku jest wystarczająca;");
            System.out.println(">Rozmiar pliku: " + tempSize + " bajtów. Wolne miejsce: " + this.freeSpace + " bajtów.");
            System.out.println(">Sprawdzanie, czy usługa jest płatna...");
            if (rand.nextInt(100) < 50) {
                double tempPrice = Math.round(rand.nextDouble(150.0));
                System.out.println(">Aplikacja jest płatna. Jej koszt to " + tempPrice + " zł. Czy jesteś gotowy na taki wydatek?");
                System.out.println(">(wpisz \"tak\" by potwierdzić płatność)");
                String input = in.nextLine();
                if ("tak".equals(input)) {
                    System.out.println(">Zgodziłeś się na obciążenie Twojego konta kwotą: " + tempPrice + " zł;");
                    System.out.println(">Pobieranie aplikacji...");
                    System.out.println(">Aplikacja pobrana pomyślnie");
                    System.out.println(">Rozpakowywanie aplikacji...");
                    System.out.println(">Instalacja aplikacji...");
                    System.out.println(">APLIKACJA ZOSTALA ZAINSTALOWANA POMYSLNIE!");

                } else {
                    System.out.println(">PROCES INSTALACJI ZAKONCZONY NIEPOWODZENIEM! ");
                }

            } else {
                System.out.println(">Aplikacja jest bezpłatna.");
                System.out.println(">Pobieranie aplikacji...");
                System.out.println(">Aplikacja pobrana pomyślnie");
                System.out.println(">Rozpakowywanie aplikacji...");
                System.out.println(">Instalacja aplikacji...");
                System.out.println(">APLIKACJA ZOSTALA ZAINSTALOWANA POMYSLNIE!");
            }


        } else {
            System.out.println("BRAK WYSTARCZAJĄCEJ ILOSCI WOLNEGO MIEJSCA!\n" +
                    ">Rozmiar pliku: " + tempSize + " bajtów. Wolne miejsce: " + this.freeSpace + " bajtów.\n" +
                    ">PROCES INSTALACJI ZAKONCZONY NIEPOWODZENIEM! ");
        }
    }

    HashSet<Application> setOfApps = new HashSet<>();

    public void installAnApp(Human user, Application app){
        System.out.println("\n::LOG PRZEBIEGU INSTALACJI APLIKACJI::");
        if(user.phone.equals(this)) {
            System.out.println(">Nazwa Aplikacji: " + app.appName + ";");
            System.out.println(">Sprawdzanie dostępności miejsca na urządzeniu...");
            if (app.size < this.freeSpace) {
                System.out.println(">Ilość dostępnego miejsca na dysku jest wystarczająca;");
                System.out.println(">Rozmiar pliku: " + app.size + " bajtów. Wolne miejsce: " + this.freeSpace + " bajtów.");
                System.out.println(">Sprawdzanie, czy usługa jest płatna...");
                if (app.price > 0.0) {
                    System.out.println(">Aplikacja jest płatna. Jej koszt to " + app.price + " zł. Czy jesteś gotowy na taki wydatek?");
                    System.out.println(">(wpisz \"tak\" by potwierdzić płatność)");
                    String input = in.nextLine();
                    if ("tak".equals(input)) {
                        System.out.println(">Zgodziłeś się na obciążenie Twojego konta kwotą: " + app.price + " zł;");
                        if(user.cash < app.price) {
                            System.out.println(">Nie stać Cię na dokonanie takiego zakupu...");
                            System.out.println(">PROCES INSTALACJI ZAKONCZONY NIEPOWODZENIEM! ");
                        } else {
                            user.cash -= app.price;
                            System.out.println(">Twoje konto zostało pomyślnie obciążone kwotą " + app.price + " zł;");
                            System.out.println(">Pobieranie aplikacji...");
                            System.out.println(">Aplikacja pobrana pomyślnie");
                            System.out.println(">Rozpakowywanie aplikacji...");
                            System.out.println(">Instalacja aplikacji...");
                            System.out.println(">APLIKACJA ZOSTALA ZAINSTALOWANA POMYSLNIE!");
                            this.setOfApps.add(app);
                        }

                    } else {
                        System.out.println(">PROCES INSTALACJI ZAKONCZONY NIEPOWODZENIEM! ");
                    }

                } else {
                    System.out.println(">Aplikacja jest bezpłatna.");
                    System.out.println(">Pobieranie aplikacji...");
                    System.out.println(">Aplikacja pobrana pomyślnie");
                    System.out.println(">Rozpakowywanie aplikacji...");
                    System.out.println(">Instalacja aplikacji...");
                    System.out.println(">APLIKACJA ZOSTALA ZAINSTALOWANA POMYSLNIE!");
                    this.setOfApps.add(app);
                }


            } else {
                System.out.println("BRAK WYSTARCZAJĄCEJ ILOSCI WOLNEGO MIEJSCA!\n" +
                        ">Rozmiar pliku: " + app.size + " bajtów. Wolne miejsce: " + this.freeSpace + " bajtów.\n" +
                        ">PROCES INSTALACJI ZAKONCZONY NIEPOWODZENIEM! ");
            }
        } else System.out.println("ZłODZIEJ! Telefon w którym chcesz zainstalować aplikację nie należy do podanego użytkownika!");
    }

    public void checkIfInstalled(Application app){
            if(this.setOfApps.contains(app)){
                System.out.println("Aplikacja \"" + app.appName + "\" jest zainstalowana w tym telefonie.");
        } else {
                System.out.println("Aplikacja \"" + app.appName + "\" nie jest zainstalowana w tym telefonie.");
            }
    }

    public void checkIfInstalled(String appName){
        int counter = 0;
        for(Application app : setOfApps){
            if(app.appName.equals(appName)){
                counter++;
            }
        }
        if(counter == 0) System.out.println("Aplikacja \"" + appName + "\" nie jest zainstalowana w tym telefonie.");
        else             System.out.println("Aplikacja \"" + appName + "\" jest zainstalowana w tym telefonie.");
    }

    public void printFreeAppsList() {
        System.out.print("Bezpłatne aplikacje zainstalowane na telefonie " + this.manufacturer + ": ");
        for (Application app : setOfApps){
            if(app.price.equals(0.0)) System.out.print(app.appName + "; ");
        }
        System.out.println("");
    }

    public void sumAppsValue() {
        double sum = 0.0;
        for (Application app: setOfApps){
            sum += app.price;
        }
        System.out.println("Lączna wartość aplikacji zainstalowanych na tym telefonie wynosi: " + sum + " zł;");
    }

    public void printAppNamesSortedByName(){

        List<Application> sortedList = new ArrayList<>(setOfApps);
        sortedList.sort(new Comparator<Application>() {
            @Override
            public int compare(Application o1, Application o2) {
                return o1.appName.compareTo(o2.appName);
            }
        });
        System.out.println("LISTA ZAINSTALOWANYCH APLIKACJI (posortowane po nazwie): ");
        System.out.println(sortedList);
        }

    public void printAppNamesSortedByPrice(){

        List<Application> sortedList = new ArrayList<>(setOfApps);
        sortedList.sort(new Comparator<Application>() {
            @Override
            public int compare(Application o1, Application o2) {
                return o1.price.compareTo(o2.price);
            }
        });
        System.out.println("LISTA ZAINSTALOWANYCH APLIKACJI (posortowane po cenie): ");
        System.out.println(sortedList);
    }


    public void installAnApp(List<String> appNames) {
        for (String appName : appNames) {
            this.installAnApp(appName);
        }
    }
}