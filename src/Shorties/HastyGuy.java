package Shorties;
import Enums.Genders;
/** Торопыжка */
public class HastyGuy extends Shorty {
    /**Базовый конструктор*/
    public HastyGuy(String name, Genders gender, boolean isSleeping) {
        super(name, gender, isSleeping);
        this.name = name;
        this.gender = gender;
        this.isSleeping = isSleeping;

    }
}
