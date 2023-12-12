package Shorties;

import Enums.Genders;
/** Доктор Пилюлька */
public class Pilulka extends Shorty {
    /**Базовый конструктор*/
    public Pilulka(String name, Genders gender, boolean isSleeping) {
        super(name, gender, isSleeping);
        this.name = name;
        this.gender = gender;
        this.isSleeping = isSleeping;

    }
}
