package wsb.creatures;

public abstract class Animal implements Feedable {
    private static final Double DEFAULT_FOOD_WEIGHT = 1.0;
    public String species;
    public String name;
    public Double weight;
    public Integer age;
    public Boolean alive;
    public Double value;

    public Animal(String species) {
        this.species = species;
        this.alive = true;
        if (this.species == "Wilczur") {
            this.weight = 12.0;
        } else if (this.species == "Devon Rex") {
            this.weight = 2.8;
        } else if (this.species == "Homo Sapiens") {
            this.weight = 80.0;
        } else {
            this.weight = 1.0;
        }
    }

    public void introduceYourself() {
        System.out.println("I'm " + this.name);
    }

    public void doYouLike(String foodType) {
        if (this.species == "Devon Rex" && foodType == "mouse") {
            System.out.println("yes, I like " + foodType);
        } else {
            System.out.println("No, you idiot");
        }
    }

    public Integer getHumanAge() {
        if (this.species == "Wilczur") {
            return this.age * 7;
        } else if (this.species == "Devon Rex") {
            return this.age * 10;
        } else {
            return this.age;
        }
    }

    public void feed() {
        this.feed(DEFAULT_FOOD_WEIGHT);
    }

    public void feed(Double foodWeight) {
        if (this.alive) {
            this.weight += foodWeight;
            System.out.println("Waga " + this.name + " po karmieniu wynosi: " + this.weight);
        } else {
            System.out.println("To zwierzę jest martwe, nie możesz go już nigdy więcej nakarmić.");
        }
    }

    public void takeForAWalk() {
        if (this.alive) {
            this.weight -= 1.0;
            if (this.weight > 0.0) {
                System.out.println("Waga tego zwierzęcia po spacerze wynosi: " + this.weight);
            } else {
                System.out.println("Waga zwierzęcia spadła poniżej 0 :(");
            }
            if (this.weight <= 0.0) {
                this.alive = false;
                System.out.println("Twoje zwierze niestety umarło.");
            }
        } else {
            System.out.println("To zwierzę jest martwe, już nigdy więcej nie zabierzesz go na spacer");
        }
    }

    public String toString() {
        return species + " " + name;
    }
}

