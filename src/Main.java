import Enums.Flags;
import Enums.Genders;
import Enums.Properies;
import InanimateObjects.InanimateObject;
import Shorties.*;
/** Основной класс, где происходит создание объектов и применение методов*/
public class Main {
    public static void main(String[] args) {
        InanimateObject paints = new InanimateObject("Краски"){};
        Gunka gunka = new Gunka("Гунька", Genders.M, false);
        Drawer dontKnower = new Drawer("Незнайка", Genders.M, false) {};
        Shorty bulka = new Shorty("Булька", Genders.M, true) {};
        Shorty pulka =new Shorty("Пулька", Genders.M, true){};
        Donut donut = new Donut("Пончик", Genders.M, true);
        Shorty knower = new Shorty("Знайка", Genders.M, true) {};
        Shorty hastyGuy = new Shorty("Торопыжка", Genders.M, true) {};
        Shorty pilulka = new Shorty("Пилюлькин", Genders.M, true) {};
        gunka.takeOffence(true);
        gunka.goToSleep(true);
        dontKnower.goToSleep(false);
        dontKnower.grab(paints);
        dontKnower.startDrawing();
        dontKnower.continiueDrawing(donut, Properies.FAT, Flags.BEFORE);
        donut.dontFit();
        dontKnower.continiueDrawing(hastyGuy, Properies.THINLEGS, Flags.BEFORE);
        dontKnower.addToPicture(hastyGuy, "собачий хвост");
        dontKnower.continiueDrawing(bulka, pulka, Properies.HORSEBACK, Properies.UNDER, Flags.AFTER);
        dontKnower.continiueDrawing(pilulka);
        dontKnower.addToPicture(pilulka, "с градусником вместо носа");
        dontKnower.continiueDrawing(knower);
        dontKnower.addToPicture(knower, "ослиные уши");


















        }
    }
