package Interfaces;

import Enums.Flags;
import Enums.PictureType;
import Enums.Properies;
import Shorties.Shorty;

/**
 * Интерфейс реализующий рисование, используется у коротышек-художников, использует equals, чтобы избежать нарушения S принципа
 */
public interface Drawing {
    /**
     * Проверяет есть ли в инвентаре коротышки краски и даёт добро на их использование для начала рисования первой части рисунка
     * @param pictureType Тип рисунка
     */
    void startDrawing(PictureType pictureType);

    /**
     * Рисование следующего фрагмента рисунка без свойств у нарисованного коротышки
     *
     * @param shorty коротышка, которого нужно нарисовать
     */
    void continiueDrawing(Shorty shorty);

    /**
     * Рисование следующего фрагмента рисунка
     *
     * @param shorty   коротышка которого нужно нарисовать
     * @param property то каким он должен быть нарисован
     * @param flag     с какой стороны относительно имени должно находиться свойство
     */
    void continiueDrawing(Shorty shorty, Properies property, Flags flag);

    /**
     * Рисование следующего фрагмента рисунка, с двумя коротышками
     *
     * @param shorty1   коротышка которого нужно нарисовать
     * @param shorty2   коротышка с которым происходит взаимодействие в рисунке
     * @param property1 свойство с которым будет shorty1
     * @param property2 свойство с которым будет shorty2
     * @param flag      с какой стороны относительно имени должно находиться свойство
     */
    void continiueDrawing(Shorty shorty1, Shorty shorty2, Properies property1, Properies property2, Flags flag);

    /**
     * Добавляет к фрагменту рисунка какую-то деталь
     *
     * @param detail деталь которую нужно добавить к рисунку
     * @param shorty коротышка к которому нужно пририсовать деталь
     */
    void addToPicture(Shorty shorty, String detail);

    /**
     * Завершает рисование, в случае если были нарисованы все коротышки то выводит соответсвующее сообщение
     */
    void endDrawing();
}