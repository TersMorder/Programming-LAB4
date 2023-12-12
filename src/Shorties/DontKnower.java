package Shorties;

import Enums.Flags;
import Enums.Genders;
import Enums.Properies;
import Interfaces.Drawing;
import Objects.Paints;

/** Незнайка */
public class DontKnower extends Shorty implements Drawing {
    /** Используется для проверки начал ли коротышка рисовать */
    private boolean startCheck = false;
    /** Используется для подсчёта нарисованных коротышек */
    private int drawnShorties = 0;
    /**Базовый конструктор*/
    public DontKnower(String name, Genders gender, boolean isSleeping) {
        super(name, gender, isSleeping);
        this.name = name;
        this.gender = gender;
        this.isSleeping = isSleeping;
    }
 public void startDrawing(){
        for(int i = 0; i<inventory.length-1; i++){
            if(inventory[i].equals("Краски")){
                startCheck = true;
                switch(gender) {
                    case M:
                        System.out.println(this.name + " начал рисовать");
                        break;
                    case W:
                        System.out.println(this.name + " начала рисовать");
                        break;
                }
            }
            else {
                changeNameEnding();
                System.out.println(name + " нечем рисовать");
                clearNameChanges();
            }
        }
 }
 public void continiueDrawing(Shorty shorty){
     if (startCheck) {
         shorty.changeNameEnding();
         String shortyName = shorty.getName();
         shorty.clearNameChanges();
         System.out.println(name + " нарисовал " + shortyName);
         drawnShorties++;
     }
     else {
         System.out.println(name + " ещё не начал рисовать!");
     }
 }

    public void continiueDrawing(Shorty shorty, Properies property, Flags flag){
        if (startCheck) {
            shorty.changeNameEnding();
            shorty.giveProperty(property, flag);
            String shortyName = shorty.getName();
            System.out.println(name + " нарисовал " + shortyName);
            drawnShorties++;
        }
        else {
            System.out.println(name + " ещё не начал рисовать!");
        }
    }
    public void continiueDrawing(Shorty shorty1, Shorty shorty2, Properies property1, Properies property2, Flags flag){
        if (startCheck) {
            if(property1 == Properies.HORSEBACK) {
                shorty1.changeNameEnding();
                shorty1.giveProperty(property1, flag);
                String shortyName1 = shorty1.getName();
                char[] shorty2CharArray = shorty2.getName().toCharArray();
                shorty2CharArray[shorty2CharArray.length-1] = 'е';
                String shortyName2 = new String(shorty2CharArray);
                System.out.println(name + " нарисовал " + shortyName1 + " на " + shortyName2);
                shorty2.giveProperty(property2, Flags.BEFORE);
            }
            else{
                shorty1.changeNameEnding();
                shorty2.changeNameEnding();
                shorty1.giveProperty(property1, flag);
                shorty2.giveProperty(property2, flag);
                String shortyName1 = shorty1.getName();
                String shortyName2 = shorty2.getName();
                System.out.println(name + " нарисовал " + shortyName1 + " и " + shortyName2);

            }
            drawnShorties+= 2;
        }
        else {
            System.out.println(name + " ещё не начал рисовать!");
        }
    }
    public void addToPicture(Shorty shorty, String detail){
        if (startCheck) {
            final String shortyname;
            shorty.clearNameChanges();
            char[] shortyCharArray = shorty.toString().toCharArray();
            if(shortyCharArray[shortyCharArray.length-1] == 'а'){
                shortyCharArray[shortyCharArray.length-1] = 'е';
                shortyname = new String(shortyCharArray);
            }
            else if(shortyCharArray[shortyCharArray.length-1] == 'н'){
                char[] newShortyCharArray = new char[shortyCharArray.length+1];
                System.arraycopy(shortyCharArray, 0, newShortyCharArray, 0, shortyCharArray.length);
                newShortyCharArray[shortyCharArray.length] = 'у';
                shortyname = new String(newShortyCharArray);
            }
            else {
                shortyname = shorty.toString();
            }

            System.out.println(name + " пририсовал " + shortyname + " " + detail);
        }
        else {
            System.out.println(name + " ещё не начал рисовать!");
        }

    }

    public void endDrawing(){
        if (startCheck) {
            if (drawnShorties == 6) { System.out.println(name + " нарисовал всех в смешном и нелепом виде");}
            else { System.out.println(name + "ещё не нарисовал всех коротышек");}
        }
        else {
            System.out.println(name + " и не начинал рисовать!");
        }
    }

}


