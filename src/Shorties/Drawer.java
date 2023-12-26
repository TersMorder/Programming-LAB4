package Shorties;

import Enums.*;
import InanimateObjects.InanimateObject;
import Interfaces.Drawing;
import Shorties.Artist.*;
import Constructions.Construction;
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
    private static Picture picture;
    /**
     * Идея для новой картины
     */
    private String pictureIdea;
    /**
     * Массив с нарисованными картинами, по умолчанию все слоты забиты пустыми холстами
     * 10 потому что места принадлежащего коротышке не хватит на больше :)
     */
    private static final Picture[] donePictures = new Picture[10];
    /**
     * Пустой холст, который есть по умолчанию у художников
     * РЕАЛИЗАЦИЯ АНОНИМНОГО КЛАССА
     */
    private static final Picture blankPicture = new Picture(PictureType.BLANK) {
        @Override
        public void addAuthorSignature(String signature) {
            this.signature = null;
        }
    };

    /**
     * Базовый конструктор
     */
    public Drawer(String name, boolean isSleeping) {
        super(name, isSleeping);
        Arrays.fill(donePictures, blankPicture);
    }

    /**
     * Рисует идею, которая дала муза
     *
     * @param pictureType жанр рисунка(портрет, натюрморт и т.п.)
     */
    public void drawIdea(PictureType pictureType) {
        for (InanimateObject item :
                inventory) {
            if (item.toString().equalsIgnoreCase("краски")) {
                setActivity(ActionStatuses.DRAWING);
                setActionCheck(true);
                picture = new Picture(pictureType) {
                    @Override
                    public void addAuthorSignature(String signature) {
                        this.signature = signature;
                    }
                };
                picture.setWhatsInPicture(pictureIdea);
                endPicture();
                setActivity(ActionStatuses.DONEDRAWING);
                setActionCheck(false);

                break;
            } else {
                System.out.println("У " + name + " нет красок в инвентаре");
                break;
            }

        }
    }
    /**РЕАЛИЗАЦИЯ ЛОКАЛЬНОГО КЛАССА
     * @param graffitiDescription то что будет нарисовано на граффити*/
    public void drawGraffiti(Construction construction, String graffitiDescription){
        class Graffiti extends Picture{
            @Override
            public void addAuthorSignature(String signature) {
                this.signature = signature;
            }
        }
            for (InanimateObject item:
            inventory) {
                if (item.toString().equalsIgnoreCase("краски")) {
                    setActivity(ActionStatuses.DRAWING);
                    setActionCheck(true);
                    picture = new Graffiti();
                    picture.setWhatsInPicture(graffitiDescription);
                    construction.setPictures(picture);
                    setActivity(ActionStatuses.DONEDRAWING);
                    setActionCheck(false);
                    break;
                } else {
                    System.out.println("У " + name + " нет красок в инвентаре");
                    break;
                }
            }

    }

    /**
     * Завершает рисование картины и добавляет её к остальным
     */
    protected void endPicture() {
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
    }
/**Выводит то что изображено на рисунке под указанным номером
 * @param picIndex номер рисунка*/
    public void showPicture(int picIndex) {
        try {
            System.out.println(name + " показывает что изображено на рисунке под номером " + picIndex + ": " +
                    donePictures[picIndex - 1].getWhatsInPicture());

        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println(name + " не увидел рисунка под таким номером");

        }
    }
/**Геттер описание картины под номером
 * @param picIndex номер картины*/
    public String getPictureDescription(int picIndex) {
        try {
            if (donePictures[picIndex - 1] != null) {
                return donePictures[picIndex - 1].getWhatsInPicture();
            } else {
                System.out.println(name + " не увидел рисунка под таким номером");
                return blankPicture.getWhatsInPicture();
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println(name + " не увидел рисунка под таким номером");
            return blankPicture.getWhatsInPicture();

        }
    }

    /**
     * Метод, который позволяет получить любую из нарисованных картин художника, по тому какой по счёту она была нарисована
     * НЕПРОВЕРЯЕМОЕ ИСКЛЮЧЕНИЕ + try catch
     *
     * @param picIndex Порядковый номер картины
     */
    public Picture getPictureType(int picIndex) {
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
     * РЕАЛИЗАЦИЯ ВЛОЖЕННОГО non-static КЛАССА
     */
    public class Muse {
        private final String name;

        /**
         * Простенький конструктор
         */
        public Muse(String name) {
            this.name = name;
        }

        /**
         * Даёт идею художнику
         *
         * @param idea Идея
         */
        public void GiveIdea(String idea) {
            pictureIdea = idea;
        }
    }

    /**
     * Статический вложенный клас для художников которые рисуют коротышек
     * РЕАЛИЗАЦИЯ ВЛОЖЕННОГО static КЛАССА
     */
    public static class ShortyDrawer extends Drawer {
        /**
         * Базовый конструктор
         */
        public ShortyDrawer(String name, boolean isSleeping) {
            super(name, isSleeping);
        }

        /**
         * Используется несколько раз для корректной реализации рисования
         */
        private final Scanner scanner = new Scanner(System.in);

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
                                @Override
                                public void addAuthorSignature(String signature) {
                                    this.signature = signature;
                                }
                            };
                            inputShortyAmount();
                            picture.setDrawnShorties(picture.getShortyAmount());

                        } else {
                            picture = blankPicture;
                        }
                        break;
                    } else {
                        System.out.println(name + " нечем рисовать");
                        break;
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
                    picture.setWhatsInPicture(shortyName + ", ");
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
                    picture.setWhatsInPicture(shortyName + ", ");
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
                        picture.setWhatsInPicture(shortyName1 + " на " + shortyName2 + ", ");
                        shorty2.giveProperty(property2, Flags.BEFORE);
                    } else {
                        shorty1.giveProperty(property1, flag);
                        shorty2.giveProperty(property2, flag);
                        String shortyName1 = shorty1.getName();
                        String shortyName2 = shorty2.getName();
                        System.out.println(name + " нарисовал " + shortyName1 + " и " + shortyName2);
                        picture.setWhatsInPicture(shortyName1 + " и " + shortyName2 + ", ");
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
                    picture.setWhatsInPicture("с " + detail + ", ");
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
                        super.endPicture();
                    } else {
                        System.out.println(name + " ещё не нарисовал всех коротышек");
                    }
                } else {
                    System.out.println(name + " и не начинал рисовать!");
                }
            }
        }

        /**
         * Метод обрабатывающий ввод количества коротышек на рисунке
         * содержит проверяемое и непроверяемое исключения + try catch
         */
        public void inputShortyAmount() throws IllegalArgumentException {
            while (true) {
                try {
                    int tempInt = scanner.nextInt();
                    picture.setShortyAmount(tempInt);
                    if (tempInt >= 1) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Число меньше 1 или больше 2^31-1");

                    }
                } catch (InputMismatchException e) {
                    scanner.next();
                    System.out.println("InputMismatchException, введите число не меньше 1 больше и не больше 2^31-1");
                }
            }
        }


        /**
         * Проверяет необходимость в завершении рисования
         */
        private void checkEndNeeding() {
            if (DrawnShortiesCounter.calcDrawnShorties() >= picture.getShortyAmount()) {
                endDrawing();
            }
        }

    }


}


