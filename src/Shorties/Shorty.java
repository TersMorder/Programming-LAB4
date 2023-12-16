package Shorties;

import Enums.*;
import Interfaces.PropertyChanging;
import java.util.Objects;
import InanimateObjects.InanimateObject;
import Interfaces.ShortyActions;


/** Абстрактный класс предоставляющий базовый функционал для классов-наследников — коротышек*/
public abstract class Shorty implements PropertyChanging, ShortyActions {
    /** Имя коротышки */
    protected String name;
    /** Пол коротышки */
    protected Genders gender;
    /** Используется для сохранения начального имени коротышки */
    final String oldName;
    /**Активность которой занят коротышка*/
    private ActionStatuses shortyAction;
    /** Инвентарь коротышки */
    protected InanimateObject[] inventory = new InanimateObject[2];
    /** Свойства, которыми может обладать коротышка */
    private String property;
    /** Массив enum Properties хранящий свойства коротышек
     * @see Properies */
    protected final Properies[] props = Properies.values();
    /** Значение поля увеличивается в случае если коротышка уже спит, или лег спать */
    protected static int sleepingShorties = 0;
    /** Используется для проверки занятости коротышки */
    private boolean actionCheck;
    /** Отвечает за смену статуса сна у коротышки */
    protected boolean isSleeping;

    /** Конструктор для создания объекта типа Shorty внутри происходит присваивание значений параметров
     * переменным созданным ранее в классе
     * @param name Имя коротышки
     * @param gender Пол коротышки
     * @param isSleeping указывает спит ли коротышка в момент создания объекта
     */
    public Shorty (String name, Genders gender, boolean isSleeping) {
        shortyAction = ActionStatuses.NONE;
        this.name=name;
        this.gender = gender;
        this.oldName = name;
        this.isSleeping = isSleeping;
        if (isSleeping){
            ++sleepingShorties;
        }
    }

    /** Используется для провеки наличия предметов у коротышки
     * @return Инвентарь которышки*/
    public InanimateObject[] getInventory() {
        return inventory;
    }
    /**Используется для вывода сообщений с правильными окончаниями
     * @return Пол коротышки*/
    public Genders getGender(){
        return gender;
    }
    /**Используется в методах, где указывается с каким коротышкой идёт взаимодействие
     * @return Имя коротышки*/
    public String getName(){
        return name;
    }
    /** Используется для проверок последовательности действий и запрета на выполнение нескольких действий одновременно
     * @return Статус занятости коротышки*/
    public boolean getActionCheck(){
        return actionCheck;
    }
    /** Геттер статуса активности коротышки, используется для проверки чем занят коротыщка
     * @return Чем занят коротышка*/
    public ActionStatuses getShortyActivity(){
        return shortyAction;
    }
    /**Сеттер активности коротышки
     * @param shortyAction Активность, которой будет занят коротышка*/
    public void setShortyAction(ActionStatuses shortyAction) {
        this.shortyAction = shortyAction;
    }

    /** Сеттер статуса коротышки, меняет значение на true/false = "занят"/"свободен"
     * @param actionCheck Действие которое нужно дать коротышке*/
    public void setActionCheck(boolean actionCheck){
        this.actionCheck = actionCheck;
    }


    /** Меняет состояние коротышки на спящее,
     *  в случае если все коротышки спят, а коротышка, относящийся к методу,
     *  не ложится спать, выводит сообщение об этом
     * @param isSleeping влияет на то, будет ли ложиться спать коротышка, или нет*/
    public void goToSleep(boolean isSleeping) {
        if (isSleeping) {
            setActionCheck(true);
            sleepingShorties++;
            this.isSleeping = isSleeping;
        }
        if (sleepingShorties == 7 && !isSleeping) {
            System.out.println("Все кроме " + name + " уснули");
        }
    }


    /** Выводит имя объекта и предмет который он взял, добавляет этот предмет в инвентарь коротышки
     * @param object Предмет, который берёт коротышка*/
    public void grab(InanimateObject object) {
        setActionCheck(true);
        System.out.println(name + " взял" + " " + object.toString().toLowerCase());
        for (int i=0; i< inventory.length; i++){
            if(inventory[i] == null){
                System.out.println(object + " добавлен в инвентарь " + name);
                inventory[i] = object;
                break;
            }
            else {
                System.out.println("В инвентаре " + name + " нет места");
            }
        }
        setActionCheck(false);
    }



    @Override
    public void giveProperty(Properies property, Flags flag){
        for(int i=0; i<props.length-1; i++){
            if(props[i] != null){
                props[i] = property;
                break;
            }
        }
        this.property = property.toString();

        if (flag == Flags.BEFORE) {
            this.name = this.property + " " + this.name;
        }
        else{
            this.name = this.name + " " +  this.property ;
        }
    }
    @Override
    public void clearProperty(){
        for(int i = 0; i<props.length-1; i++){
            props[i] = null;
        }
        this.name = oldName;
    }

    /** Переопределение toString() для корректного вывода имени коротышки */
    @Override
    public String toString() {
        return name;
    }
    /** Переопределение equals() для корректного сравнения имени с типами String */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shorty shorty = (Shorty) o;
        return Objects.equals(name.toLowerCase(), shorty.name.toLowerCase());
    }
    /** Переопределение hashcode() объектов для корректного сравнения, чтобы хеш-коды объектов были равны так же как и
     * с точки зрения equals */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}



