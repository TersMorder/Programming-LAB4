package Shorties;

import Enums.Genders;
/** Знайка */
public class Knower extends Shorty {
    /**Базовый конструктор*/
    public Knower(String name, Genders gender, boolean isSleeping) {
        super(name, gender, isSleeping);
        this.name = name;
        this.gender = gender;
        this.isSleeping = isSleeping;

    }
}