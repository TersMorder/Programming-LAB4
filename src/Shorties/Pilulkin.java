package Shorties;

import InanimateObjects.InanimateObject;

public class Pilulkin extends Shorty {
    public Pilulkin(String name, boolean isSleeping) {
        super(name, isSleeping);
    }
    public void putOnGlasses(){
        for (InanimateObject thing: inventory) {
            if (thing.toString().equals("пенсне")){
                System.out.println(name + " нацепил на нос пенсне");
            }
            else {
                System.out.println("У " + name + " нет пенсне в инвентаре");
            }
        }

    }

}
