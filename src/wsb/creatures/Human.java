package wsb.creatures;

import wsb.Sellable;
import wsb.devices.Car;
import wsb.devices.Phone;

import java.util.Date;

public class Human extends Animal implements Sellable {
    private static final int DEFAULT_GARAGE_SIZE = 3;
    public Double cash;
    public String firstName;
    public String lastName;
    public Integer age;
    public Double salary;
    public Animal pet;
    public Car[] garage;
    public Phone phone;

    public Human() {
        super("Homo Sapiens");
        this.salary = 1200.0;
        this.garage = new Car[DEFAULT_GARAGE_SIZE];
    }

    public Human(int garageSize) {
        super("Homo Sapiens");
        this.salary = 1200.0;
        this.garage = new Car[garageSize];
    }

    public void setSalary(Double salary) {
        if (salary > 0) {
            System.out.println("Dane wysłane do systemu księgowego.");
            System.out.println("Odbierz aneks wynagrodzenia z księgowości.");
            this.salary = salary;
            System.out.println("Nowe wynagrodzenie: " + this.salary);
        } else {
            System.out.println("Wynagrodzenie nie może być ujemne.");
        }
    }


    public Double getSalary() {
        System.out.println("Data/Czas: " + new Date());
        System.out.println("Wynagrodzenie: " + this.salary);

        return this.salary;
    }

    public void getFullName() {
        this.name = this.firstName + " " + this.lastName;

    }

    public void setCar(Car newCar, Integer garageSpace) {
        if (this.salary > newCar.value) {
            this.garage[garageSpace] = newCar;
            System.out.println("gratulacje, kupiłeś za gotówkę");
        } else if (this.salary > newCar.value / 12) {
            this.garage[garageSpace] = newCar;
            System.out.println("Kupiłeś na raty");
        } else {
            System.out.println("Nie da się kupić samochodu.");
        }
    }

    public Car getCar(Integer garagePosition) {
        return this.garage[garagePosition];
    }

    public Phone getPhone() {
        return this.phone;
    }

    public Animal getPet() {
        return this.pet;
    }

    public String toString() {
        return firstName + " " + lastName + " a imie pupila to: " + pet.name + ". Telefon którego używam to: " + phone;
    }

    public void sale(Human seller, Human buyer, Double price) {
        System.out.println("Handel ludźmi jest zakazany, zgłaszam Cię do prokuratury " + seller.firstName + "!");
    }

    public boolean hasCar(Car car) {
        for (int i = 0; i < this.garage.length; i++) {
            if (this.garage[i] == car) {
                return true;
            }
        }
        return false;
    }

    public boolean hasFreeParkingLot() {
        for (int i = 0; i < this.garage.length; i++) {
            if (this.garage[i] == null) {
                return true;
            }
        }
        return false;
    }

    public void removeCar(Car car) {
        for (int i = 0; i < this.garage.length; i++) {
            if (this.garage[i] == car) {
                this.garage[i] = null;
                break;
            }
        }
    }

    public void addCar(Car car) {
        for (int i = 0; i < this.garage.length; i++) {
            if(this.garage[i] == null) {
                this.garage[i] = car;
                break;
            }
        }
    }

    public void printGarage() {
        for (int i = 0; i < this.garage.length; i++) {
            System.out.println(">Na miejscu " + i + " w garażu " + this.name + " stoi auto: " + this.garage[i]);
        }
    }
}
