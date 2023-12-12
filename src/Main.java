import Enums.Flags;
import Enums.Genders;
import Enums.Properies;
import Objects.*;
import Shorties.*;
/** Основной класс, где происходит создание объектов и применение методов*/
public class Main {
    public static void main(String[] args) {
        Paints paints = new Paints("Краски");
        Gunka gunka = new Gunka("Гунька", Genders.M, false);
        DontKnower dontKnower = new DontKnower("Незнайка", Genders.M, false);
        Bulka bulka = new Bulka("Булька", Genders.M, true);
        Pulka pulka =new Pulka("Пулька", Genders.M, true);
        Donut donut = new Donut("Пончик", Genders.M, true);
        Knower knower = new Knower("Знайка", Genders.M, true);
        HastyGuy hastyGuy = new HastyGuy("Торопыжка", Genders.M, true);
        Pilulka pilulka = new Pilulka("Пилюлькин", Genders.M, true);
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
        dontKnower.addToPicture(pilulka, "градусник вместо носа");
        dontKnower.continiueDrawing(knower);
        dontKnower.addToPicture(knower, "ослиные уши");
        dontKnower.endDrawing();


















        }
    }