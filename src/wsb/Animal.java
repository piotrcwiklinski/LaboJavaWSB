package wsb;

public class Animal {
    public String species;
    public String name;
    public Double weight;
    public Integer age;
    public Boolean alive;

    public Animal(String species) {
        this.species = species;
        this.alive = true;
        if (this.species == "Wilczur") {
            this.weight = 12.0;
        } else if (this.species == "Devon Rex") {
            this.weight = 2.8;
        } else {
            this.weight = 1.0;
        }
    }

    void introduceYourself() {
        System.out.println("I'm " + this.name);
    }

    void doYouLike(String foodType) {
        if (this.species == "Devon Rex" && foodType == "mouse") {
            System.out.println("yes, I like " + foodType);
        } else {
            System.out.println("No, you idiot");
        }
    }

    Integer getHumanAge() {
        if (this.species == "Wilczur") {
            return this.age * 7;
        } else if (this.species == "Devon Rex") {
            return this.age * 10;
        } else {
            return this.age;
        }
    }

    void feed() {
        if (this.alive == true){
            this.weight += 1.0;
            System.out.println("Waga tego zwierzęcia po karmieniu wynosi: " + this.weight);
        } else {
            System.out.println("To zwierzę jest martwe, nie możesz go już nigdy więcej nakarmić.");
        }
    }

    void takeForAWalk() {
        if (this.alive == true){
            this.weight -= 1.0;
            if (this.weight > 0.0) {
                System.out.println("Waga tego zwierzęcia po spacerze wynosi: " + this.weight);
            }else {
                System.out.println("Waga zwierzęcia spadła poniżej 0 :(");
            }
            if(this.weight <= 0.0){
                this.alive = false;
                System.out.println("Twoje zwierze niestety umarło.");
            }
        } else {
            System.out.println("To zwierzę jest martwe, już nigdy więcej nie zabierzesz go na spacer");
        }
    }

    public String toString(){
        return species + " " + name + " " + age;
    }
}
//ctrl + alt + L - auto porządkowanie składni

