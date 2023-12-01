import Enums.Action;
import Enums.Flag;
import Enums.Genders;
import Objects.DoAble;
import Objects.Props;
import Objects.Things;
import Objects.ProgrammActions;

public class Main {
    public static void main(String[] args) {
        DoAble Gunka = new DoAble("Гунька", Genders.M);
        DoAble DontKnower = new DoAble("Незнайка", Genders.M);
        DoAble Donut = new DoAble("Пончик", Genders.M);
        DoAble FastGuy = new DoAble("Торопыжка", Genders.M);
        Props HunterPulka= new Props("Пулька", Genders.M);
        DoAble DoctorPilulka = new DoAble("Пилюлька", Genders.M);
        DoAble Knower = new DoAble("Знайка", Genders.M);
        DoAble AllVillagers = new DoAble();
        Things Can = new Things("краски");
        FastGuy.getName();
        Gunka.doSomething(Action.goCryAboutIt);
        DontKnower.doSomething(Action.dontGoToSleep);
        AllVillagers.doSomething(Action.everyoneIsSleeping);
        DontKnower.doSomething(Action.grab, Can);
        DontKnower.doSomething(Action.drawStart);
        Donut.giveProperty("толстый");
        Donut.changeProperty();
        DontKnower.doSomething(Action.drawContiniue, Donut, Flag.AFTER);
        ProgrammActions.switchToNext();
        DontKnower.doSomething(Action.dontFit, Donut, Flag.BEFORE);
        ProgrammActions.switchToNext();
        FastGuy.giveProperty("тонконогий");
        FastGuy.changeProperty();
        DontKnower.doSomething(Action.drawContiniue, FastGuy, Flag.AFTER);
        ProgrammActions.switchToNext();
        DontKnower.doSomething(Action.addToPicture, "собачий хвост");
        ProgrammActions.switchToNext();
        HunterPulka.giveStartProperty("наездник");
        HunterPulka.changeProperty();
        HunterPulka.giveProperty("на Бульке");
        DontKnower.doSomething(Action.drawContiniue, HunterPulka, Flag.AFTER);
        ProgrammActions.switchToNext();
        DoctorPilulka.giveProperty("Доктор");
        DoctorPilulka.changeProperty();
        DontKnower.doSomething(Action.drawContiniue, DoctorPilulka, Flag.AFTER, "с градусником вместо носа");
        ProgrammActions.switchToNext();
        DontKnower.doSomething(Action.drawContiniue, Knower, Flag.AFTER, "с ослиными ушами");
        ProgrammActions.switchToNext();
        DontKnower.doSomething(Action.drawEnd);














        }
    }
