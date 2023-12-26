package Shorties.Artist;

import Enums.PictureType;
import Shorties.Shorty;

/**
 * Абстрактный класс рисунка, который будут создавать коротышки-художники
 */
public abstract class Picture {
    /**
     * То что находится на картине
     */
    private String whatsInPicture = "";
    /**
     * Кол-во коротышек, которые будут нарисованы
     */
    private int shortyAmount;
    /**
     * Массив с нарисованными коротышками, используется на протяжении всего рисования
     */
    private String[] drawnShorties;
    /**
     * Тип рисунка
     */
    final private PictureType pictureType;
    /**
     * Подпись автора на картине
     */
    protected String signature;

    /**
     * Конструктор класса рисунка, при создании рисунка, пользователь задаёт значение shortyAmount
     * ПРИМЕЧАНИЕ: тут костыль, надеюсь простите, вижу его, знаю как исправить, но думаю это излишки
     * @param pictureType Тип рисунка
     */
    public Picture(PictureType pictureType) {
        this.pictureType = pictureType;
        drawnShorties = new String[shortyAmount];
    }
    /**Конструктор по умолчанию, используется для реализации рисования граффити*/
    public Picture(){
    pictureType = PictureType.GRAFFITI;
    }

    /**
     * Геттер типа картины, используется в выводе нарисованных картин
     */
    public PictureType getPictureType() {
        return pictureType;
    }

    /**
     * Сеттер кол-ва коротышек которые будут на картине
     */
    public void setDrawnShorties(int shortyAmount) {
        this.drawnShorties = new String[shortyAmount];
    }

    /**
     * Сеттер описания того что изображено на картине
     */
    public void setWhatsInPicture(String whatsInPicture) {
        this.whatsInPicture += whatsInPicture;
    }

    /**
     * Геттер того что изображено на картине
     */
    public String getWhatsInPicture() {
        return whatsInPicture;
    }

    /**
     * Геттер кол-ва коротышек которых нужно нарисовать, используется для вывода в endDrawing
     */
    public int getShortyAmount() {
        return shortyAmount;
    }

    /**
     * Устанавливает то, сколько коротышек будет нарисовано
     */
    public void setShortyAmount(int shortyAmount) {
        this.shortyAmount = shortyAmount;
    }

    /**
     * Геттер массива с нарисованными коротышками
     */
    public String[] getDrawnShorties() {
        return drawnShorties;
    }

    /**
     * Записывает нарисованного коротышку в массив с такими же
     *
     * @param drawnShorty нарисованный коротышка
     */
    public void addDrawnShorty(Shorty drawnShorty) {
        for (int i = 0; i < drawnShorties.length; i++) {
            if (drawnShorties[i] == null) {
                drawnShorties[i] = drawnShorty.getName();
                break;
            }
        }
    }
    /**Устанавливает подпись автора, нужен для более правильной реализации анонимного класса
     * @param signature подпись*/
    public abstract void addAuthorSignature(String signature);

    @Override
    public String toString() {
        return whatsInPicture;
    }
}
