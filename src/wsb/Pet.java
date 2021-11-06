package wsb;

public class Pet extends Animal implements Sellable{

    public Pet(String species) {
        super(species);
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
}
