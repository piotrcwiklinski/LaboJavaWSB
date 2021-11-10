package wsb.creatures;

public class FarmAnimal extends Animal implements Edible {

    public Double foodWeight;

    public FarmAnimal(String species, Double weight) {
        super(species);
        this.weight = weight;
    }

    public void beEaten(Human eater) {
        System.out.println("Próbujesz zjeść zwierzę z gatunku " + this.species + ", o wadze: " + this.weight + " kg. Rezultat: ");
        if(this.alive == false){
            System.out.println("ZWIERZE JUŻ ZOSTALO WCZESNIEJ ZJEDZONE. Nie możesz go zjeść drugi raz.");
        } else if( this.weight > (eater.weight * 0.1)) {
            System.out.println("Nie dasz rady zjeść więcej, niż 1/10 Twojej obecnej wagi, wybierz coś mniejszego.");
        } else{
        this.foodWeight = weight;
        System.out.println("Człowiek, który nazywa się " + eater.name + " zjada zwierzę z gatunku " + this.species + " o wadze " + this.weight + ".");
        eater.feed(this.foodWeight);
        this.alive = false;
        }
        System.out.println("");
    }
}
