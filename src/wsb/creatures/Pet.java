package wsb.creatures;

import wsb.Sellable;

public class Pet extends Animal implements Sellable, Edible {

    public Pet(String species, Double value) {
        super(species);
        this.value = value;
    }

    public void sale(Human seller, Human buyer, Double price) {
        if (buyer.cash < price) {
            System.out.println("KUPUJĄCY MA ZA MAłO KASY");
        } else if(seller.getPet() == null){
            System.out.println("SPRZEDAJĄCY NIE MA ZADNEGO ZWIERZA");
        } else if(!seller.getPet().equals(this)) {
            System.out.println("SPRZEDAJĄCY NIE MA TEGO KONKRETNEGO ZWIERZA (ZłODZIEJ)");
        } else {
            seller.cash += price;
            buyer.cash -= price;
            seller.pet = null;
            buyer.pet = this;
            System.out.println("Transakcja się udała, kupiono " + this);

        }
    }

    public void beEaten(Human eater) {
        System.out.println("Próbujesz zjeść zwierzę z gatunku " + this.species + ", o wadze: " + this.weight + " kg. Rezultat: ");
        System.out.println("Spożywanie zwierząt domowych jest w tym kraju nielegalne, zgłaszam Cię do prokuratury " + eater.firstName + "!\n");
    }
}
