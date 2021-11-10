package wsb;

import wsb.creatures.Human;

public interface Sellable {

    void sale(Human seller, Human buyer, Double price);
}
