package Interfaces;

import Enums.ActionStatuses;
import Enums.Flags;
import Enums.Genders;
import Enums.Properies;
import InanimateObjects.InanimateObject;
import InanimateObjects.Paints;
import Shorties.Artist.DrawnShortiesCounter;
import Shorties.Drawer;
import Shorties.Shorty;

/** Интерфейс реализующий рисование, используется у коротышек-художников, использует equals, чтобы избежать нарушения S принципа */
public interface Drawing extends ShortyActions{
    /** Проверяет есть ли в инвентаре коротышки краски и даёт добро на их использование для начала рисования первой части рисунка
     * @param shorty рисующий коротышка*/
    default void startDrawing(Drawer shorty){
        if (this.equals(shorty)) {
            if (checkActivity(shorty)) {
                System.out.println(shorty.getName() + " занят!");
            } else {
                InanimateObject[] inventory = shorty.getInventory();
                Genders gender = shorty.getGender();
                String name = shorty.getName();
                setActivity(shorty, ActionStatuses.DRAWING);
                for (int i = 0; i < inventory.length - 1; i++) {
                    if (inventory[i] instanceof Paints) {
                        shorty.setActionCheck(true);
                        switch (gender) {
                            case M:
                                System.out.println(name + " начал рисовать");
                                break;
                            case W:
                                System.out.println(name + " начала рисовать");
                                break;
                        }
                    } else {
                        System.out.println(name + " нечем рисовать");
                    }
                }
            }
        }
        else {
            System.out.println("Один художник не может рисовать за другого");
        }
    }
    /** Рисование следующего фрагмента рисунка без свойств у нарисованного коротышки
     * @param shorty1 коротышка, который рисует
     * @param shorty2 коротышка, которого нужно нарисовать*/
    default void continiueDrawing(Drawer shorty1, Shorty shorty2){
        if(this.equals(shorty1)) {
            if (getActivity(shorty1) != ActionStatuses.DRAWING) {
                System.out.println(shorty1.getName() + " занят!");
            } else {
                String name = shorty1.getName();
                if (getActivity(shorty1) == ActionStatuses.DRAWING) {
                    String shortyName = shorty2.getName();
                    System.out.println(name + " нарисовал " + shortyName);
                    DrawnShortiesCounter.addDrawnShorty(1);
                } else {
                    System.out.println(name + " ещё не начал рисовать!");
                }
            }
        }
        else {
            System.out.println("Один художник не может рисовать за другого");
        }
    }
    /** Рисование следующего фрагмента рисунка
     * @param shorty1 коротышка, который рисует
     * @param shorty2 коротышка которого нужно нарисовать
     * @param property то каким он должен быть нарисован
     * @param flag с какой стороны относительно имени должно находиться свойство*/
    default void continiueDrawing(Drawer shorty1, Shorty shorty2, Properies property, Flags flag){
        if(this.equals(shorty1)) {
            if (getActivity(shorty1) != ActionStatuses.DRAWING) {
                System.out.println(shorty1.getName() + " занят!");
            } else {
                String name = shorty1.getName();
                if (getActivity(shorty1) == ActionStatuses.DRAWING) {
                    shorty2.giveProperty(property, flag);
                    String shortyName = shorty2.getName();
                    System.out.println(name + " нарисовал " + shortyName);
                    DrawnShortiesCounter.addDrawnShorty(1);
                } else {
                    System.out.println(name + " ещё не начал рисовать!");
                }
            }
        }
        else {
            System.out.println("Один художник не может рисовать за другого");
        }
    }
    /** Рисование следующего фрагмента рисунка
     * @param shorty1 коротышка, который рисует
     * @param shorty2 коротышка которого нужно нарисовать
     * @param shorty3 коротышка с которым происходит взаимодействие в рисунке
     * @param property1 свойство с которым будет shorty1
     * @param property2 свойство с которым будет shorty2
     * @param flag с какой стороны относительно имени должно находиться свойство*/
    default void continiueDrawing(Drawer shorty1, Shorty shorty2, Shorty shorty3, Properies property1, Properies property2, Flags flag){
        if(this.equals(shorty1)) {
            if (getActivity(shorty1) != ActionStatuses.DRAWING) {
                System.out.println(shorty1.getName() + " занят!");
            } else {
                String name = shorty1.getName();
                if (getActivity(shorty1) == ActionStatuses.DRAWING) {
                    if (property1 == Properies.HORSEBACK) {
                        shorty2.giveProperty(property1, flag);
                        String shortyName1 = shorty2.getName();
                        char[] shorty2CharArray = shorty3.getName().toCharArray();
                        shorty2CharArray[shorty2CharArray.length - 1] = 'е';
                        String shortyName2 = new String(shorty2CharArray);
                        System.out.println(name + " нарисовал " + shortyName1 + " на " + shortyName2);
                        shorty3.giveProperty(property2, Flags.BEFORE);
                    } else {
                        shorty2.giveProperty(property1, flag);
                        shorty3.giveProperty(property2, flag);
                        String shortyName1 = shorty2.getName();
                        String shortyName2 = shorty3.getName();
                        System.out.println(name + " нарисовал " + shortyName1 + " и " + shortyName2);

                    }
                    DrawnShortiesCounter.addDrawnShorty(2);
                } else {
                    System.out.println(name + " ещё не начал рисовать!");
                }
            }
        }
        else {
            System.out.println("Один художник не может рисовать за другого");
        }
    }
    /** Добавляет к фрагменту рисунка какую-то деталь
     * @param detail деталь которую нужно добавить к рисунку
     * @param shorty1 коротышка, который рисует
     * @param shorty2 коротышка к которому нужно пририсовать деталь*/
    default void addToPicture(Drawer shorty1, Shorty shorty2, String detail){
        if(this.equals(shorty1)) {
            if (getActivity(shorty1) != ActionStatuses.DRAWING) {
                System.out.println(shorty1.getName() + " занят!");
            } else {
                if (getActivity(shorty1) == ActionStatuses.DRAWING) {
                    final String shortyname = shorty2.toString();

                    System.out.println(shorty1.getName() + " пририсовал " + shortyname + " " + detail);
                } else {
                    System.out.println(shorty1.getName() + " ещё не начал рисовать!");
                }
            }
        }
        else {
            System.out.println("Один художник не может рисовать за другого");
        }
    }
    /** Завершает рисование, в случае если были нарисованы все коротышки то выводит соответсвующее сообщение
     * @param shorty1 коротышка, который заканчивает рисование*/
    default void endDrawing(Drawer shorty1){
        if(shorty1.equals(this)) {
            if (getActivity(shorty1) != ActionStatuses.DRAWING) {
                System.out.println(shorty1.getName() + " занят!");
            } else {
                if (getActivity(shorty1) == ActionStatuses.DRAWING) {
                    if (DrawnShortiesCounter.calcDrawnShorties() == 6) {
                        System.out.println(shorty1.getName() + " нарисовал всех в смешном и нелепом виде");
                    } else {
                        System.out.println(shorty1.getName() + "ещё не нарисовал всех коротышек");
                    }
                } else {
                    System.out.println(shorty1.getName() + " и не начинал рисовать!");
                }
            }
        }
        else {
            System.out.println("Один художник не может рисовать за другого");
        }
    }
}
