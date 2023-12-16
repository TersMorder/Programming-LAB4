package Shorties;
import Enums.Genders;
import Interfaces.Drawing;
/**Объекты этого класса являются представителями коротышек-художников*/
public abstract class Drawer extends Shorty implements Drawing {
    /**Базовый конструктор*/
    public Drawer(String name, Genders gender, boolean isSleeping) {
        super(name, gender, isSleeping);
        this.name = name;
        this.gender = gender;
        this.isSleeping = isSleeping;
    }
}
