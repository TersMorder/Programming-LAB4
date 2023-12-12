package Shorties;

import Enums.Genders;
/** Булька */
public class Bulka extends Shorty {
    /**Базовый конструктор*/
    public Bulka(String name, Genders gender, boolean isSleeping) {
        super(name, gender, isSleeping);
        this.name = name;
        this.gender = gender;
        this.isSleeping = isSleeping;

    }
}
