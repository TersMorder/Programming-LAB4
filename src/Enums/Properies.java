package Enums;

import Shorties.Shorty;

/** Enum со свойствами которые могут получить коротышки*/
public enum Properies {

    OFFENSED("обижен"),

    FAT("толстый"),

    THINLEGS("тонокогий"),

    HORSEBACK("верхом"),

    UNDER("\"лощадь\"");



    private final String propName;
    Properies(String propName){this.propName=propName;}
    /** Переопределение toString для корректного вывода свойств */
    @Override
    public String toString() {
        return propName;
    }
}

