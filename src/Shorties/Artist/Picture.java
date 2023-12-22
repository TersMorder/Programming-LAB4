package Shorties.Artist;
import Shorties.Shorty;

import java.util.Scanner;

/**Абстрактный класс рисунка, который будут создавать коротышки-художники*/
public abstract class Picture {
    /**Кол-во коротышек, которые будут нарисованы*/
    private int shortyAmount;
    /** Массив с нарисованными коротышками, используется на протяжении всего рисования*/
    private String[] drawnShorties;
    /**
     * Конструктор класса рисунка, при создании рисунка, пользователь задаёт значение shortyAmount
     */
    public Picture() {
        Scanner scanner = new Scanner(System.in);
        shortyAmount = scanner.nextInt();
        drawnShorties = new String[shortyAmount];

    }


    /**
     * Геттер кол-ва коротышек которых нужно нарисовать, используется для вывода в endDrawing
     */
    public int getShortyAmount() {
        return shortyAmount;
    }
    /**Устанавливает то, сколько коротышек будет нарисовано*/
    public void setShortyAmount(int shortyAmount){
        this.shortyAmount = shortyAmount;
    }

    /**Геттер массива с нарисованными коротышками*/
    public String[] getDrawnShorties() {
        return drawnShorties;
    }
    /**
     * Записывает нарисованного коротышку в массив с такими же
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

}
