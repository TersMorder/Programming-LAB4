import Enums.Flags;
import Enums.PictureType;
import Enums.Properies;
import InanimateObjects.InanimateObject;
import Shorties.*;

/** Основной класс, где происходит создание объектов и применение методов*/
public class Main {
    public static void main(String[] args) {
        InanimateObject paints = new InanimateObject("Краски"){};
        InanimateObject glasses = new InanimateObject("Пенсне") {};
        Gunka gunka = new Gunka("Гунька", false);
        Drawer dontKnower = new Drawer("Незнайка", false) {};
        Shorty bulka = new Shorty("Булька", true) {};
        Shorty pulka =new Shorty("Пулька", true){};
        Donut donut = new Donut("Пончик",true);
        Shorty knower = new Shorty("Знайка", true) {};
        Shorty hastyGuy = new Shorty("Торопыжка", true) {};
        Pilulkin pilulkin = new Pilulkin("Пилюлькин", true) {};
        gunka.takeOffence(true);
        gunka.goToSleep(true);
        dontKnower.goToSleep(false);
        dontKnower.grab(paints);
        dontKnower.startDrawing(PictureType.PORTRAITS);
        dontKnower.continiueDrawing(donut, Properies.FAT, Flags.BEFORE);
        donut.dontFit();
        dontKnower.continiueDrawing(hastyGuy, Properies.THINLEGS, Flags.BEFORE);
        dontKnower.addToPicture(hastyGuy, "собачий хвост");
        dontKnower.continiueDrawing(bulka, pulka, Properies.HORSEBACK, Properies.UNDER, Flags.AFTER);
        dontKnower.continiueDrawing(pilulkin);
        dontKnower.addToPicture(pilulkin, "с градусником вместо носа");
        dontKnower.continiueDrawing(knower);
        dontKnower.addToPicture(knower, "ослиные уши");
        pilulkin.wakeUp();
        pilulkin.see(dontKnower.showPicture(1));
        pilulkin.grab(glasses);
        pilulkin.takeALook(dontKnower.showPicture(1));
        pilulkin.takeAGoodLaugh();



















        }
    }
