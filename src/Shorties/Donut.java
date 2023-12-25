package Shorties;

import Enums.Properies;

/**
 * Пончик
 */
public class Donut extends Shorty {
    /**
     * Базовый конструктор
     */
    public Donut(String name,boolean isSleeping) {
        super(name, isSleeping);
    }

    /**
     * Проверка помещается ли пончик на картине и вывод этого
     */
    public void dontFit() {
        for (int i = 0; i < props.length - 1; i++) {
            if (props[i] == Properies.FAT) {
                System.out.println(name + " не поместился на картине");
                break;
            } else {
                System.out.println(name + " поместился на картине");
                break;
            }
        }

    }

}