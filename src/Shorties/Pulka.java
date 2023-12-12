package Shorties;

import Enums.Genders;
/** Охотник Пулька */
public class Pulka extends Shorty {
    /**Базовый конструктор*/
    public Pulka(String name, Genders gender, boolean isSleeping) {
        super(name, gender, isSleeping);
        this.name = name;
        this.gender = gender;
        this.isSleeping = isSleeping;

    }
}
