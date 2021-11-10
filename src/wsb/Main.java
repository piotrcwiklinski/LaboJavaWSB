package wsb;

import wsb.creatures.*;
import wsb.devices.*;

//ctrl + alt + L - auto porządkowanie składni

public class  Main {

    public static void main(String[] args)  {
        Pet dog = new Pet("Wilczur", 300.0);
        Pet cat = new Pet("Devon Rex", 500.0);

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

        Phone samsung = new Phone("Samsung", "Galaxy S21 5G", 2021, 5000.0);

        Human me = new Human();

        me.firstName = "Piotr";
        me.lastName = "Cwiklinski";
        me.getFullName();
        me.pet = cat;
        me.phone = samsung;
        System.out.println("I have a " + me.pet.species);
        System.out.println("I call it " + me.pet.name);


        Electric myCar = new Electric("Volkswagen", "Passat", 2021);
        myCar.color = "Silver";
        myCar.value = 120900.99;

        System.out.println(" ");
        me.car = myCar;
        System.out.println("I drive a " + me.car.manufacturer + " " + me.car.model + ".");
        System.out.println("It's painted in " + me.car.color + ". It was produced in " + me.car.yearOfProd + ", and it's estimated value in PLN is around " + me.car.value);
        System.out.println(" ");

        cat.feed();
        cat.feed(0.5);
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
        System.out.println();

        Diesel fiat = new Diesel("Fiat", "Bravo", 1998);
        fiat.value = 12000.0;
        fiat.carAdded();
/*
        me.setSalary(20000.0);
        me.setCar(fiat);
        System.out.println("Model samochodu który udało Ci się kupić to: " + me.getCar().manufacturer + " " + me.getCar().model);
*/
        LPG opel = new LPG("Opel", "Corsa", 2001);
        opel.value = 22000.0;
        opel.carAdded();

/*
        System.out.println(" ");
        System.out.println("Porównanie dwóch samochodów o takich samych wartościach pól: " + fiat.equals(opel));
        System.out.println(" ");
        System.out.println("Wypisanie dwóch samochodów o takich samych wartościach pól (przy użyciu toString):");
        System.out.println("1)Wypisanie obiektu o nazwie \"opel\": " + opel);
        System.out.println("2)Wypisanie obiektu o nazwie \"fiat\": " + fiat);

        System.out.println(" ");
        System.out.println("Wypisanie dwóch zwierzaków o różnych wartościach pól (przy użyciu toString):");
        System.out.println("1)Wypisanie obiektu o nazwie \"cat\": " + cat);
        System.out.println("2)Wypisanie obiektu o nazwie \"dog\": " + dog);
*/
        System.out.println(" ");
        System.out.println("Wypisanie dwóch osób o różnych wartościach pól (przy użyciu toString):");
        System.out.println("1)Wypisanie obiektu o nazwie \"me\": " + me);

        Human myWife = new Human();
        myWife.firstName = "Malgorzata";
        myWife.lastName = "Cwiklinska";
        myWife.pet = dog;
        myWife.phone = new Phone("Google", "Pixel 4a", 2019, 3500.0);

        System.out.println("2)Wypisanie obiektu o nazwie \"myWife\": " + myWife);


        myWife.cash = 0.0;
        myWife.car = fiat;

        me.cash = 17500.0;


        System.out.println("");
        System.out.println("Stan konta Piotra przed sprzedażą auta: " + me.cash);
        System.out.println("Stan konta Małgosi przed sprzedażą auta: " + myWife.cash);

        System.out.println("");
        fiat.sale(myWife, me , fiat.value);

        System.out.println("");
        System.out.println("Stan konta Piotra po sprzedaży auta: " + me.cash);
        System.out.println("Stan konta Małgosi po sprzedaży auta: " + myWife.cash);

        System.out.println("");
        cat.sale(me, myWife , cat.value);

        System.out.println("");
        System.out.println("Stan konta Piotra po sprzedaży zwierza: " + me.cash);
        System.out.println("Stan konta Małgosi po sprzedaży zwierza: " + myWife.cash);

        System.out.println("");
        myWife.phone.sale(myWife, me , myWife.phone.value);

        System.out.println("");
        System.out.println("Stan konta Piotra po sprzedaży telefonu: " + me.cash);
        System.out.println("Stan konta Małgosi po sprzedaży telefonu: " + myWife.cash);

        System.out.println("");
        System.out.println("Próba zakupu człowieka za pieniądze:");
        me.sale(me, myWife , 0.0);

        System.out.println("");
        FarmAnimal cow = new FarmAnimal("Krowa", 1200.0);
        FarmAnimal chicken = new FarmAnimal("Kurczak", 5.00);
        FarmAnimal turkey = new FarmAnimal("Indyk", 8.50);

        cow.beEaten(me);
        turkey.beEaten(me);
        chicken.beEaten(me);
        chicken.beEaten(me);
        turkey.beEaten(me);
        dog.beEaten(me);



        samsung.installAnApp("Twitter");
        samsung.installAnApp("Twitter", 1.1);
        samsung.installAnApp("Twitter", 1.2, "https://google.com");
        samsung.installAnApp("Twitter", "Facebook", "YouTube");
        samsung.installAnApp("Discord", 1.0, "discord.com");

        System.out.println("");
        opel.refuel("Electric");
        opel.refuel("LPG");
        fiat.refuel("Diesel");
        myCar.refuel("Benzyna 95");

    }
}
