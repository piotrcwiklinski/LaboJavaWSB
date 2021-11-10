package wsb;

import wsb.devices.*;

public class  Main {

    public static void main(String[] args) {
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
        me.pet = cat;
        me.phone = samsung;
        System.out.println("I have a " + me.pet.species);
        System.out.println("I call it " + me.pet.name);


        Car myCar = new Car("Volkswagen", "Passat", 2021);
        myCar.color = "Silver";
        myCar.value = 120900.99;

        System.out.println(" ");
        me.car = myCar;
        System.out.println("I drive a " + me.car.manufacturer + " " + me.car.model + ".");
        System.out.println("It's painted in " + me.car.color + ". It was produced in " + me.car.yearOfProd + ", and it's estimated value in PLN is around " + me.car.value);
        System.out.println(" ");

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
        System.out.println();

        Car fiat = new Car("Fiat", "Bravo", 1998);
        fiat.value = 12000.0;
        fiat.carAdded();
/*
        me.setSalary(20000.0);
        me.setCar(fiat);
        System.out.println("Model samochodu który udało Ci się kupić to: " + me.getCar().manufacturer + " " + me.getCar().model);
*/
        Car opel = new Car("Opel", "Corsa", 2001);
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
        System.out.println("Kasa kupującego przed sprzedażą auta: " + me.cash);
        System.out.println("Kasa sprzedającego przed sprzedażą auta: " + myWife.cash);

        System.out.println("");
        fiat.sale(myWife, me , fiat.value);

        System.out.println("");
        System.out.println("Kasa kupującego po sprzedaży auta: " + me.cash);
        System.out.println("Kasa sprzedającego po sprzedaży auta: " + myWife.cash);

        System.out.println("");
        dog.sale(myWife, me , dog.value);

        System.out.println("");
        System.out.println("Kasa kupującego po sprzedaży zwierza: " + me.cash);
        System.out.println("Kasa sprzedającego po sprzedaży zwierza: " + myWife.cash);

        System.out.println("");
        myWife.phone.sale(myWife, me , myWife.phone.value);

        System.out.println("");
        System.out.println("Kasa kupującego po sprzedaży telefonu: " + me.cash);
        System.out.println("Kasa sprzedającego po sprzedaży telefonu: " + myWife.cash);

        System.out.println("");
        System.out.println("Próba zakupu człowieka za pieniądze:");
        me.sale(me, myWife , 0.0);




    }
}
