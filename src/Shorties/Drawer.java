package Shorties;

import Enums.*;
import Interfaces.Drawing;
import Shorties.Artist.*;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Объекты этого класса являются представителями коротышек-художников
 */
public abstract class Drawer extends Shorty implements Drawing {
    /**
     * Картина, которую рисует коротышка
     */
    private Picture picture;
    /**
     * Используется несколько раз для корректной реализации рисования
     */
    private final Scanner scanner = new Scanner(System.in);
    /**
     * Массив с нарисованными картинами, по умолчанию все слоты забиты пустыми холстами
     */
    private final Picture[] donePictures = new Picture[10];
    /**Пустой холст, который есть по умолчанию у художников*/
    private final Picture blankPicture = new Picture(PictureType.BLANK) {
    };

    /**
     * Базовый конструктор
     */
    public Drawer(String name, boolean isSleeping) {
        super(name, isSleeping);
        Arrays.fill(donePictures, blankPicture);
    }


    public void startDrawing(PictureType pictureType) {
        if (checkActivity()) {
            System.out.println(name + " занят!");
        } else {
            for (int i = 0; i < inventory.length - 1; i++) {
                if (inventory[i].toString().equals("Краски")) {
                    if (pictureType == PictureType.PORTRAITS) {

                        setActivity(ActionStatuses.DRAWING);
                        setActionCheck(true);
                        System.out.println(name + " начал рисовать");
                        System.out.println("Введите количество коротышек, которых " + name + " хочет нарисовать");
                        picture = new Picture(pictureType) {
                        };
                        inputShortyAmount();
                        picture.setDrawnShorties(picture.getShortyAmount());

                    } else {
                        picture = blankPicture;
                    }
                } else {
                    System.out.println(name + " нечем рисовать");
                }
            }
        }
    }

    public void continiueDrawing(Shorty shorty) {
        checkEndNeeding();
        if (getActivity() != ActionStatuses.DRAWING && getActivity() != ActionStatuses.DONEDRAWING) {
            System.out.println(name + " занят!");
        } else if (getActivity() == ActionStatuses.DONEDRAWING) {
            System.out.println(name + " ещё не начал рисовать снова");
        } else {
            if (getActivity() == ActionStatuses.DRAWING) {
                String shortyName = shorty.getName();
                System.out.println(name + " нарисовал " + shortyName);
                picture.addDrawnShorty(shorty);
                DrawnShortiesCounter.addDrawnShorty(1);
            } else {
                System.out.println(name + " ещё не начал рисовать!");
            }
        }
    }

    public void continiueDrawing(Shorty shorty, Properies property, Flags flag) {
        checkEndNeeding();
        if (getActivity() != ActionStatuses.DRAWING && getActivity() != ActionStatuses.DONEDRAWING) {
            System.out.println(name + " занят!");
        } else if (getActivity() == ActionStatuses.DONEDRAWING) {
            System.out.println(name + " ещё не начал рисовать снова");
        } else {
            if (getActivity() == ActionStatuses.DRAWING) {
                shorty.giveProperty(property, flag);
                String shortyName = shorty.getName();
                System.out.println(name + " нарисовал " + shortyName);
                picture.addDrawnShorty(shorty);
                DrawnShortiesCounter.addDrawnShorty(1);
            } else {
                System.out.println(name + " ещё не начал рисовать!");
            }
        }
    }

    public void continiueDrawing(Shorty shorty1, Shorty shorty2, Properies property1, Properies property2, Flags flag) {
        checkEndNeeding();
        if (getActivity() != ActionStatuses.DRAWING && getActivity() != ActionStatuses.DONEDRAWING) {
            System.out.println(name + " занят!");
        } else if (getActivity() == ActionStatuses.DONEDRAWING) {
            System.out.println(name + " ещё не начал рисовать снова");
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
            } else {
                System.out.println(name + " ещё не начал рисовать!");
            }
        }
    }

    public void addToPicture(Shorty shorty, String detail) {
        if (getActivity() != ActionStatuses.DRAWING && getActivity() != ActionStatuses.DONEDRAWING) {
            System.out.println(name + " занят!");
        } else if (getActivity() == ActionStatuses.DONEDRAWING) {
            System.out.println(name + " ещё не начал рисовать снова");
        } else {
            if (getActivity() == ActionStatuses.DRAWING) {
                System.out.println(name + " пририсовал " + shorty.getName() + " " + detail);
                checkEndNeeding();
            } else {
                System.out.println(name + " ещё не начал рисовать!");
            }
        }
    }



    public void endDrawing() {
        if (getActivity() != ActionStatuses.DRAWING && getActivity() != ActionStatuses.DONEDRAWING) {
            System.out.println(name + " занят!");
        } else if (getActivity() == ActionStatuses.DONEDRAWING) {
            System.out.println(name + " ещё не начал рисовать снова");
        } else {
            if (getActivity() == ActionStatuses.DRAWING) {
                if (picture.getDrawnShorties()[picture.getDrawnShorties().length - 1] != null) {
                    System.out.println(name + " нарисовал всех в смешном и нелепом виде");
                    setActionCheck(false);
                    setActivity(ActionStatuses.DONEDRAWING);
                    for (int i = 0; i < donePictures.length; i++) {
                        if (donePictures[i] == blankPicture) {
                            donePictures[i] = picture;
                            break;
                        }
                        if (donePictures[9] != blankPicture) {
                            System.out.println("Нет свободных мест, чтобы сохранить рисунок");
                            setActivity(ActionStatuses.DRAWING);
                            break;
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

    private void checkEndNeeding(){
        if (DrawnShortiesCounter.calcDrawnShorties() >= picture.getShortyAmount()) {
            endDrawing();
        }
    }

    /**
     * Метод, который позволяет получить любую из нарисованных картин художника, по тому какой по счёту она была нарисована
     * НЕПРОВЕРЯЕМОЕ ИСКЛЮЧЕНИЕ + try catch
     *
     * @param picIndex Порядковый номер картины
     */
    public Picture showPicture(int picIndex) {
        try {
            if (donePictures[picIndex - 1] != null) {
                return donePictures[picIndex - 1];
            } else {
                System.out.println(name + " не увидел рисунка под таким номером");
                return blankPicture;
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println(name + " не увидел рисунка под таким номером");
            return blankPicture;

        }
    }

    /**
     * Метод обрабатывающий ввод количества коротышек на рисунке
     * НЕПРОВЕРЯЕМОЕ ИСКЛЮЧЕНИЕ + try catch
     * вижу тут некоторую проблему, не знаю почему так происходит
     */
    public void inputShortyAmount() {
        while (true) {
            try {
                int tempInt = scanner.nextInt();
                picture.setShortyAmount(tempInt);
                if (tempInt >= 1) {
                    break;
                }
                else {
                    System.out.println("Введите число не меньше 1 больше и не больше 2^31-1");
                    inputShortyAmount();
                }
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("InputMismatchException, введите число не меньше 1 больше и не больше 2^31-1");
            }
        }
    }


}


