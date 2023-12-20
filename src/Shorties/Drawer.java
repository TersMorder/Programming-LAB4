package Shorties;
import Enums.ActionStatuses;
import Enums.Flags;
import Enums.Genders;
import Enums.Properies;
import Interfaces.Drawing;
import Shorties.Artist.DrawnShortiesCounter;

/**Объекты этого класса являются представителями коротышек-художников*/
public abstract class Drawer extends Shorty implements Drawing {
    /**Базовый конструктор*/
    public Drawer(String name, Genders gender, boolean isSleeping) {
        super(name, gender, isSleeping);
        this.name = name;
        this.gender = gender;
        this.isSleeping = isSleeping;
    }
    public void startDrawing(){
            if (checkActivity()) {
                System.out.println(name + " занят!");
            } else {
                setActivity(ActionStatuses.DRAWING);
                for (int i = 0; i < inventory.length - 1; i++) {
                    if (inventory[i].toString().equals("Краски")) {
                        setActionCheck(true);
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

    public void continiueDrawing(Shorty shorty){
            if (getActivity() != ActionStatuses.DRAWING) {
                System.out.println(name + " занят!");
            } else {
                if (getActivity() == ActionStatuses.DRAWING) {
                    String shortyName = shorty.getName();
                    System.out.println(name + " нарисовал " + shortyName);
                    DrawnShortiesCounter.addDrawnShorty(1);
                } else {
                    System.out.println(name + " ещё не начал рисовать!");
                }
            }
    }

    public void continiueDrawing(Shorty shorty, Properies property, Flags flag){

            if (getActivity() != ActionStatuses.DRAWING) {
                System.out.println(name + " занят!");
            } else {
                if (getActivity() == ActionStatuses.DRAWING) {
                    shorty.giveProperty(property, flag);
                    String shortyName = shorty.getName();
                    System.out.println(name + " нарисовал " + shortyName);
                    DrawnShortiesCounter.addDrawnShorty(1);
                } else {
                    System.out.println(name + " ещё не начал рисовать!");
                }
            }
    }

    public void continiueDrawing(Shorty shorty1, Shorty shorty2, Properies property1, Properies property2, Flags flag){

            if (getActivity() != ActionStatuses.DRAWING) {
                System.out.println(name + " занят!");
            } else {
                if (getActivity() == ActionStatuses.DRAWING) {
                    if (property1 == Properies.HORSEBACK) {
                        shorty1.giveProperty(property1, flag);
                        String shortyName1 = shorty1.getName();
                        char[] shorty2CharArray = shorty2.getName().toCharArray();
                        shorty2CharArray[shorty2CharArray.length - 1] = 'е';
                        String shortyName2 = new String(shorty2CharArray);
                        System.out.println(name + " нарисовал " + shortyName1 + " на " + shortyName2);
                        shorty2.giveProperty(property2, Flags.BEFORE);
                    } else {
                        shorty1.giveProperty(property1, flag);
                        shorty2.giveProperty(property2, flag);
                        String shortyName1 = shorty1.getName();
                        String shortyName2 = shorty2.getName();
                        System.out.println(name + " нарисовал " + shortyName1 + " и " + shortyName2);
                    }
                    DrawnShortiesCounter.addDrawnShorty(2);
                } else {
                    System.out.println(name + " ещё не начал рисовать!");
                }
            }
    }
    public void addToPicture(Shorty shorty, String detail){
            if (getActivity() != ActionStatuses.DRAWING) {
                System.out.println(name + " занят!");
            } else {
                if (getActivity() == ActionStatuses.DRAWING) {
                    System.out.println(name + " пририсовал " + shorty.getName() + " " + detail);
                } else {
                    System.out.println(name + " ещё не начал рисовать!");
                }
            }
    }
    public void endDrawing(){
            if (getActivity() != ActionStatuses.DRAWING) {
                System.out.println(name + " занят!");
            } else {
                if (getActivity() == ActionStatuses.DRAWING) {
                    if (DrawnShortiesCounter.calcDrawnShorties() == 6) {
                        System.out.println(name + " нарисовал всех в смешном и нелепом виде");
                    } else {
                        System.out.println(name + "ещё не нарисовал всех коротышек");
                    }
                } else {
                    System.out.println(name + " и не начинал рисовать!");
                }
            }

    }
}


