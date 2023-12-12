package Shorties;
import Enums.Genders;
import Enums.Properies;

/** Пончик */
public class Donut extends Shorty {
    /**Базовый конструктор*/
    public Donut(String name, Genders gender, boolean isSleeping) {
        super(name, gender, isSleeping);
        this.name = name;
        this.gender = gender;
        this.isSleeping = isSleeping;
    }
    /** Проверка помещается ли пончик на картине и вывод этого*/
    public void dontFit(){
        for(int i = 0; i< props.length-1; i++){
            if(props[i] == Properies.FAT){
                System.out.println(oldName + " не поместился на картине");
                break;
            }
            else {
                System.out.println(oldName + " поместился на картине");
                break;
            }
        }

    }
    
}