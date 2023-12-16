package Shorties;
import Enums.Flags;
import Enums.Genders;
import Enums.Properies;
/** Гунька */
public class Gunka extends Shorty{
    /**Базовый конструктор*/
    public Gunka(String name, Genders gender, boolean isSleeping) {
        super(name, gender, isSleeping);
        this.name = name;
        this.gender = gender;
        this.isSleeping = isSleeping;

    }
    /** Даёт свойство обижен коротышке и проверяет, ушёл ли тот домой после этого, после чего выводит соответсвующее сообщение
     * @param gohome используется для проверки */
    public void takeOffence(boolean gohome){
        giveProperty(Properies.OFFENSED, Flags.AFTER);
        if (gohome){
            System.out.println(name + " и ушёл домой");
            clearProperty();
        }
        else{
            System.out.println(name);
            clearProperty();
        }

    }

}
