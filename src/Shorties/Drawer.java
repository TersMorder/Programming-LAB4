package Shorties;

import Enums.*;
import Interfaces.Drawing;
import Shorties.Artist.*;

import java.util.Scanner;

/**
 * Объекты этого класса являются представителями коротышек-художников
 */
public abstract class Drawer extends Shorty implements Drawing {
    /**
     * Картина, которую рисует коротышка
     */
    private Picture picture;

    /**Массив с нарисованными картинами, по умолчанию все слоты забиты пустыми холстами*/
    private final Picture[] donePictures = new Picture[10];

    private final Picture blankPicture = new Picture(PictureType.BLANK) {};
    /**
     * Базовый конструктор
     */
    public Drawer(String name, boolean isSleeping) {
        super(name, isSleeping);
        for (Picture p: donePictures) {
            p = blankPicture;
        }
    }


    public void startDrawing(PictureType pictureType) {
        if (checkActivity()) {
            System.out.println(name + " занят!");
        } else {
            for (int i = 0; i < inventory.length - 1; i++) {
                if (inventory[i].toString().equals("Краски")) {
                    setActivity(ActionStatuses.DRAWING);
                    setActionCheck(true);
                    System.out.println(name + " начал рисовать");
                    System.out.println("Введите количество коротышек, которых " + name + " хочет нарисовать");
                    Picture picture1 = new Picture(pictureType) {
                    };
                    picture = picture1;
                } else {
                    System.out.println(name + " нечем рисовать");
                }
            }
        }
    }

    public void continiueDrawing(Shorty shorty) {
        if (getActivity() != ActionStatuses.DRAWING && getActivity() != ActionStatuses.DONEDRAWING) {
            System.out.println(name + " занят!");
        } else if (getActivity() == ActionStatuses.DONEDRAWING) {
            System.out.println(name + " уже закончил рисовать!");
        } else {
            if (getActivity() == ActionStatuses.DRAWING) {
                String shortyName = shorty.getName();
                System.out.println(name + " нарисовал " + shortyName);
                picture.addDrawnShorty(shorty);
                DrawnShortiesCounter.addDrawnShorty(1);
                calcAndEnd();
            } else {
                System.out.println(name + " ещё не начал рисовать!");
            }
        }
    }

    public void continiueDrawing(Shorty shorty, Properies property, Flags flag) {

        if (getActivity() != ActionStatuses.DRAWING && getActivity() != ActionStatuses.DONEDRAWING) {
            System.out.println(name + " занят!");
        } else if (getActivity() == ActionStatuses.DONEDRAWING) {
            System.out.println(name + " уже закончил рисовать!");
        } else {
            if (getActivity() == ActionStatuses.DRAWING) {
                shorty.giveProperty(property, flag);
                String shortyName = shorty.getName();
                System.out.println(name + " нарисовал " + shortyName);
                picture.addDrawnShorty(shorty);
                DrawnShortiesCounter.addDrawnShorty(1);
                calcAndEnd();
            } else {
                System.out.println(name + " ещё не начал рисовать!");
            }
        }
    }

    public void continiueDrawing(Shorty shorty1, Shorty shorty2, Properies property1, Properies property2, Flags flag) {
        if (getActivity() != ActionStatuses.DRAWING && getActivity() != ActionStatuses.DONEDRAWING) {
            System.out.println(name + " занят!");
        } else if (getActivity() == ActionStatuses.DONEDRAWING) {
            System.out.println(name + " уже закончил рисовать!");
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
                picture.addDrawnShorty(shorty1);
                picture.addDrawnShorty(shorty2);
                DrawnShortiesCounter.addDrawnShorty(2);
                calcAndEnd();
            } else {
                System.out.println(name + " ещё не начал рисовать!");
            }
        }
    }

    public void addToPicture(Shorty shorty, String detail) {
        if (getActivity() != ActionStatuses.DRAWING && getActivity() != ActionStatuses.DONEDRAWING) {
            System.out.println(name + " занят!");
        } else if (getActivity() == ActionStatuses.DONEDRAWING) {
            System.out.println(name + " уже закончил рисовать!");
        } else {
            if (getActivity() == ActionStatuses.DRAWING) {
                System.out.println(name + " пририсовал " + shorty.getName() + " " + detail);
                if (DrawnShortiesCounter.calcDrawnShorties() == picture.getShortyAmount()) {
                    endDrawing();
                }
            } else {
                System.out.println(name + " ещё не начал рисовать!");
            }
        }
    }

    private void calcAndEnd() {
        if (DrawnShortiesCounter.calcDrawnShorties() == picture.getShortyAmount()) {
            System.out.println(name + " закончил рисовать?");
            Scanner Scananswer = new Scanner(System.in);
            String answer = Scananswer.nextLine().toLowerCase();
            if (answer.equals("да") || answer.equals("yes")) {
                endDrawing();
            } else if (!answer.equals("нет") && !answer.equals("no")) {
                System.out.println("Пожалуйста, ответьте да/нет или yes/no");
            }


        }
    }

    public void endDrawing() {
        if (getActivity() != ActionStatuses.DRAWING && getActivity() != ActionStatuses.DONEDRAWING) {
            System.out.println(name + " занят!");
        } else if (getActivity() == ActionStatuses.DONEDRAWING) {
            System.out.println(name + " уже закончил рисовать!");
        } else {
            if (getActivity() == ActionStatuses.DRAWING) {
                if (picture.getDrawnShorties()[picture.getDrawnShorties().length - 1] != null) {
                    System.out.println(name + " нарисовал всех в смешном и нелепом виде");
                    setActionCheck(false);
                    setActivity(ActionStatuses.DONEDRAWING);
                    for (int i = 0; i<donePictures.length; i++ ) {
                        if(donePictures[i] == blankPicture){
                            donePictures[i] = picture;
                            break;
                        }
                        if(donePictures[10] != blankPicture){
                            System.out.println("Нет свободных мест, чтобы сохранить рисунок");
                            setActivity(ActionStatuses.DRAWING);

                        }
                    }
                } else {
                    System.out.println(name + " ещё не нарисовал всех коротышек");
                }
            } else {
                System.out.println(name + " и не начинал рисовать!");
            }
        }
    }

    /**
     * Метод, который позволяет получить любую из нарисованных картин художника, по тому какой по счёту она была нарисована
     * @param picIndex Порядковый номер картины*/
    public PictureType showPicture(int picIndex) {
        try {
            if (donePictures[picIndex - 1] != null) {
                return donePictures[picIndex - 1].getPictureType();
            } else {
                System.out.println("Нет картины под таким номером");
                return blankPicture.getPictureType();
            }
        }
        catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("Нет картины под таким номером");
            return blankPicture.getPictureType();

        }
    }


}


