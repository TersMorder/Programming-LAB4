package Shorties;

import Enums.ActionStatuses;
import InanimateObjects.InanimateObject;
import Shorties.Artist.Picture;
/**Класс Пилюлькина*/
public class Pilulkin extends Shorty {
    /**Базовый конструктор*/
    public Pilulkin(String name, boolean isSleeping) {
        super(name, isSleeping);
    }

    /**Выводит сообщение о том, что Пилюлькин надел очки*/
    public void putOnGlasses(){
        for (InanimateObject thing: inventory) {
            if (thing.toString().equals("пенсне")){
                setActivity(ActionStatuses.PUTTINGON);
                System.out.println(name + " " + getActivity() + " " + thing);
                setActivity(ActionStatuses.NONE);
            }
            else {
                System.out.println("У " + name + " нет пенсне в инвентаре");
            }
        }
    }
    /**
     * Выводит сообщение о том, что коротышка рассматривает какую-то картину
     * @param picture Та самая картина
     */
    public void takeALook(Picture picture) {
        setActivity(ActionStatuses.TAKINGLOOK);
        System.out.println(name + " " + getActivity() + " " + picture.getPictureType());
    }

    /**
     * Выводит сообщение о том, что коротышка увидел какую-то картину
     *
     * @param picture Та самая картина
     */
    public void seePicture(Picture picture) {
        System.out.println(name + " увидел " + picture.getPictureType());
    }
/**Меняет состояние Пилюлькина на смеющиеся и выводит сообщение о том, что он смеется*/
    public void takeAGoodLaugh(){
        setActivity(ActionStatuses.LAUGHING);
        System.out.println(name + " " + getActivity());
    }

}
