import Enums.Flags;
import Enums.Genders;
import Enums.Properies;
import InanimateObjects.Paints;
import Shorties.*;
/** Основной класс, где происходит создание объектов и применение методов*/
public class Main {
    public static void main(String[] args) {
        Paints paints = new Paints("Краски");
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
        dontKnower.startDrawing(dontKnower);
        dontKnower.continiueDrawing(dontKnower, donut, Properies.FAT, Flags.BEFORE);
        donut.dontFit();
        dontKnower.continiueDrawing(dontKnower, hastyGuy, Properies.THINLEGS, Flags.BEFORE);
        dontKnower.addToPicture(dontKnower, hastyGuy, "собачий хвост");
        dontKnower.continiueDrawing(dontKnower, bulka, pulka, Properies.HORSEBACK, Properies.UNDER, Flags.AFTER);
        dontKnower.continiueDrawing(dontKnower, pilulka);
        dontKnower.addToPicture(dontKnower, pilulka, "с градусником вместо носа");
        dontKnower.continiueDrawing(dontKnower, knower);
        dontKnower.addToPicture(dontKnower, knower, "ослиные уши");
        dontKnower.endDrawing(dontKnower);


















        }
    }
