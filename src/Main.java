
public class  Main {

    public static void main(String[] args) {
        Animal dog = new Animal("Wilczur");
        Animal cat = new Animal("Devon Rex");

        dog.name = "Szarik";

        System.out.println("Pies nazywa się " + dog.name + ". A jego waga wynosi: " + dog.weight + ".");
        dog.weight = 12.3;
        dog.age = 7;
        cat.age = 2;

        System.out.println();

        cat.name = "Vincent";
        System.out.println("a kot żyje? " + cat.alive);
        System.out.println("Waga kota: " + cat.weight);
        cat.introduceYourself();

        cat.doYouLike("mouse");
        dog.doYouLike("mouse");

        Integer humanAge = cat.getHumanAge();
        System.out.println("If I'll be human I'll be " + humanAge + " years old.");

        Human me = new Human();

        me.firstName = "Piotr";
        me.lastName = "Cwiklinski";
        me.pet = cat;
        System.out.println("I have a " + me.pet.species);
        System.out.println("I call it " + me.pet.name);


        Car myCar = new Car();
        myCar.manufacturer = "Volkswagen";
        myCar.model = "Passat";
        myCar.yearOfProd = 2021;
        myCar.color = "Silver";
        myCar.value = 120900.99;

        me.car = myCar;
        System.out.println("I drive a " + me.car.manufacturer + " " + me.car.model + ".");
        System.out.println("It's painted in " + me.car.color + ". It was produced in " + me.car.yearOfProd + ", and it's estimated value in PLN is around " + me.car.value);

        cat.feed();
        cat.feed();
        cat.takeForAWalk();
        cat.takeForAWalk();
        cat.takeForAWalk();
        cat.takeForAWalk();
        cat.takeForAWalk();
        cat.feed();
        cat.takeForAWalk();


        System.out.println();
        me.getSalary();
        System.out.println();
        me.setSalary(-1.0);
        System.out.println();
        me.setSalary(12500.50);

        Car fiat = new Car();
        fiat.value = 12000.0;
        fiat.manufacturer = "fiat";
        fiat.model = "bravo";

        me.setSalary(20000.0);
        me.setCar(fiat);
        System.out.println("Model samochodu który udało Ci się kupić to: " + me.getCar().manufacturer + " " + me.getCar().model);

        System.out.println("");
        System.out.println("Dokonuję zmiany aby przetestować GitCommit");


    }
}
