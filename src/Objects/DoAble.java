package Objects;

import Enums.Action;
import Enums.Flag;
import Enums.Genders;
import Interfaces.Properties;

import java.util.Objects;


public class DoAble extends Object implements Properties {

    private String name;
    final private Genders gender;
    final private String oldName;
    private String property;
    private Boolean flagpoint = true;




    public DoAble(String name, Genders gender){
        super(name, gender);
        this.name = name;
        this.gender = gender;
        oldName = name;
    }
    public DoAble(){
        gender = Genders.NONE;
        oldName = "null";
    }




    public void doSomething(Action act) {
        switch (act) {

            case goCryAboutIt:
                switch (gender) {
                    case M:
                        System.out.println(this.name + " обиделся и ушёл домой");
                        break;

                    case W:
                        System.out.println(this.name + " обиделась и ушла домой");
                        break;
                }
                break;
            case dontGoToSleep:
                switch (gender) {
                    case M:
                        System.out.println(this.name + " не пошёл спать");
                        break;
                    case W:
                        System.out.println(this.name + " не пошла спать");
                        break;
                }
            case everyoneIsSleeping:
                System.out.println("Все уснули");
                break;
            case grab:
                switch (gender) {
                    case M:
                        System.out.print(this.name + " взял");
                        break;
                    case W:
                        System.out.print(this.name + " взяла");
                        break;
                }
                break;
            case drawStart:
                switch(gender) {
                    case M:
                        System.out.println();
                        System.out.println(this.name + " начал рисовать");
                        break;
                    case W:
                        System.out.println();
                        System.out.println(this.name + " начала рисовать");
                        break;
                }
                break;
            case drawContiniue:
                flagpoint = true;
                        switch (gender) {
                            case M:
                                System.out.print(this.name + " нарисовал");
                                break;
                            case W:
                                System.out.print(this.name + " нарисовала");
                                break;
                        }
                break;
            case addToPicture:
                char[] oldCharArray = super.objName.toCharArray();
                if (oldCharArray[oldCharArray.length-1] == 'а' ){
                    oldCharArray[oldCharArray.length-1] = 'е';
                }
                super.objName = new String(oldCharArray);

                switch (gender){
                    case M:
                        System.out.print(this.name + " пририсовал к " + super.objName);
                        break;
                    case W:
                        System.out.print(this.name + " пририсовала к последнему персонажу");
                        break;

                }
                break;
            case dontFit:
                switch(gender) {
                    case M:
                        System.out.print("не поместился на картине");
                        break;
                    case W:
                        System.out.print("не поместилась на картине");
                        break;
                }
                break;
            case drawEnd:
                switch (gender){
                    case M:
                        System.out.println(this.name + " нарисовал всех в смешном и нелепом виде" );
                        break;
                    case W:
                        System.out.println(this.name + " нарисовала всех в смешном и нелепом виде" );
                        break;
                }
                break;








        }
    }


    public void doSomething(Action act, Object obj, Flag flag) {

        if(flag == Flag.AFTER) {
            doSomething(act);
            objName = obj.getName();
            System.out.print(" " + obj);
        } else if (flag == Flag.BEFORE) {
            System.out.print(obj + " ");
            objName = obj.getName();
            doSomething(act);
        }
    }
    public void doSomething(Action act, Things thing){
        doSomething(act);
        System.out.print(" " + thing);
    }

    public void doSomething(Action act, String newDetail){
        doSomething(act);
        System.out.print(" " + newDetail);
    }
    public void doSomething(Action act, Object obj, Flag flag, String newProperty){
        doSomething(act, obj, flag);
        System.out.print(" " + newProperty);
    }


    @Override
    public void giveProperty(String property){
        this.property = property;
        this.name = property + " " + this.name;
    }
    public void clearProperty(){
        this.name = oldName;
    }


    public void changeProperty(){
        clearProperty();
        char [] charPropArray = this.property.toCharArray();

        if (charPropArray[charPropArray.length-1] == 'й') {
            char[] charNewPropArray = new char[charPropArray.length + 1];
            System.arraycopy(charPropArray, 0, charNewPropArray, 0, charPropArray.length);
            charNewPropArray[charNewPropArray.length - 1] = 'о';
            charNewPropArray[charNewPropArray.length - 2] = 'г';
            charNewPropArray[charNewPropArray.length - 3] = 'о';
            property = new String(charNewPropArray);
        }
        else if (charPropArray[charPropArray.length-1] == 'к' || charPropArray[charPropArray.length-1] == 'р') {
            char[] charNewPropArray = new char[charPropArray.length + 1];
            System.arraycopy(charPropArray, 0, charNewPropArray, 0, charPropArray.length);
            charNewPropArray[charPropArray.length] = 'а';
            property = new String(charNewPropArray);
        }
        this.name = property + " " + this.name;
    }

    @Override
    public String toString() {
        char [] charArray = name.toCharArray();
        if (charArray[charArray.length-1] == 'а' && flagpoint){
            charArray[charArray.length-1] ='у';
            name = new String(charArray);
            flagpoint = false;
        }
        else if (charArray[charArray.length-1] == 'к' && flagpoint) {
            char[] charNewArray = new char[charArray.length+1];
            System.arraycopy(charArray, 0, charNewArray,0, charArray.length);
            charNewArray[charArray.length] ='а';
            name = new String(charNewArray);
            flagpoint = false;
        }

        else {
            name = oldName;
        }

        for (int i = 0; i<charArray.length; i++){
            if (charArray[i] == ' ' && flagpoint){
                charArray[i-1] = 'а';
                name = new String(charArray);
                flagpoint = false;
            }
        }

        return name;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DoAble doable = (DoAble) o;
        return Objects.equals(name, doable.name);
    }





    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
