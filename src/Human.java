import java.util.Date;

public class Human {
    String firstName;
    String lastName;
    Integer age;
    Double salary;
    Animal pet;
    Car car;

    Human(){
        this.salary = 1200.0;
    }

    void setSalary(Double salary){
        if(salary > 0){
            System.out.println("Dane wysłane do systemu księgowego.");
            System.out.println("Odbierz aneks wynagrodzenia z księgowości.");
            this.salary = salary;
            System.out.println("Nowe wynagrodzenie: " + this.salary);
        }else{
            System.out.println("Wynagrodzenie nie może być ujemne.");
        }
    }


    Double getSalary(){
        System.out.println("Data/Czas: " + new Date());
        System.out.println("Wynagrodzenie: " + this.salary);

        return this.salary;
    }

    void setCar(Car newCar){
        if(this.salary > newCar.value){
            this.car = newCar;
            System.out.println("gratulacje, kupiłeś za gotówkę");
        } else if(this.salary > newCar.value / 12) {
            this.car = newCar;
            System.out.println("Kupiłeś na raty");
        } else {
            System.out.println("Nie da się kupić samochodu.");
        }
    }

    Car getCar() {
        return this.car;
    }

}
