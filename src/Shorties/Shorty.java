package Shorties;

import Enums.*;
import Interfaces.PropertyChanging;

import java.util.Objects;

import InanimateObjects.InanimateObject;
import Shorties.Artist.Picture;


/**
 * Абстрактный класс предоставляющий базовый функционал для классов-наследников — коротышек
 */
public abstract class Shorty implements PropertyChanging {
    /**
     * Имя коротышки
     */
    protected String name;
    /**
     * Активность которой занят коротышка
     */
    private ActionStatuses shortyAction;
    /**
     * Инвентарь коротышки
     */
    protected InanimateObject[] inventory = new InanimateObject[2];
    /**
     * Свойства, которыми может обладать коротышка
     */
    private String property;
    /**
     * Лимит кол-ва свойств у коротышки
     */
    private int propertiesLimit = 3;
    /**
     * Массив enum Properties хранящий свойства коротышек
     *
     * @see Properies
     */
    protected Properies[] props = new Properies[propertiesLimit];
    /**
     * Значение поля увеличивается в случае если коротышка уже спит, или лег спать
     */
    protected static int sleepingShorties = 0;
    /**
     * Используется для проверки занятости коротышки
     */
    private boolean actionCheck;
    /**
     * Отвечает за смену статуса сна у коротышки
     */
    protected boolean isSleeping;

    /**
     * Конструктор для создания объекта типа Shorty внутри происходит присваивание значений параметров
     * переменным созданным ранее в классе
     *
     * @param name       Имя коротышки
     * @param isSleeping указывает спит ли коротышка в момент создания объекта
     */
    public Shorty(String name, boolean isSleeping) {
        shortyAction = ActionStatuses.NONE;
        this.name = name;
        this.isSleeping = isSleeping;
        if (isSleeping) {
            ++sleepingShorties;
        }
    }

    /**
     * Используется для провеки наличия предметов у коротышки
     *
     * @return Инвентарь которышки
     */
    protected InanimateObject[] getInventory() {
        return inventory;
    }


    /**
     * Используется в методах, где указывается с каким коротышкой идёт взаимодействие
     *
     * @return Имя коротышки
     */
    public String getName() {
        return name;
    }

    /**
     * Используется для проверок последовательности действий и запрета на выполнение нескольких действий одновременно
     *
     * @return Статус занятости коротышки
     */
    protected boolean getActionCheck() {
        return actionCheck;
    }

    /**
     * Геттер статуса активности коротышки, используется для проверки чем занят коротыщка
     *
     * @return Чем занят коротышка
     */
    protected ActionStatuses getActivity() {
        return shortyAction;
    }

    /**
     * Сеттер активности коротышки
     *
     * @param shortyAction Активность, которой будет занят коротышка
     */
    protected void setActivity(ActionStatuses shortyAction) {
        this.shortyAction = shortyAction;
    }

    /**
     * Меяет лимит кол-ва свойств у коротышки
     *
     * @param propertiesLimit новый лимит
     */
    protected void setPropertiesLimit(int propertiesLimit) {
        this.propertiesLimit = propertiesLimit;
    }

    /**
     * Сеттер статуса коротышки, меняет значение на true/false = "занят"/"свободен"
     *
     * @param actionCheck Действие которое нужно дать коротышке
     */
    protected void setActionCheck(boolean actionCheck) {
        this.actionCheck = actionCheck;
    }

    /**
     * Проверяет есть ли у коротышки сейчас что-то чем он занят
     */
    protected boolean checkActivity() {
        boolean abaddonAction;
        abaddonAction = getActionCheck();
        return abaddonAction;
    }


    /**
     * Меняет состояние коротышки на спящее,
     * в случае если все коротышки спят, а коротышка, относящийся к методу,
     * не ложится спать, выводит сообщение об этом
     *
     * @param isSleeping влияет на то, будет ли ложиться спать коротышка, или нет
     */
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

    /**
     * Меняет состояние коротышки на бодрствующее
     * если коротышка не спал, выводит об этом
     */
    public void wakeUp() {
        if (isSleeping) {
            setActionCheck(false);
            isSleeping = false;
            sleepingShorties--;
            System.out.println(name + " проснулся");
        } else {
            System.out.println(name + " и не ложился спать");
        }
    }

    /**
     * Выводит имя объекта и предмет который он взял, добавляет этот предмет в инвентарь коротышки
     *
     * @param object Предмет, который берёт коротышка
     */
    public void grab(InanimateObject object) {
        setActionCheck(true);
        System.out.println(name + " взял" + " " + object.toString().toLowerCase());
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                System.out.println(object + " добавлен в инвентарь " + name);
                inventory[i] = object;
                break;
            } else {
                System.out.println("В инвентаре " + name + " нет места");
            }
        }
        setActionCheck(false);
    }




    @Override
    public void giveProperty(Properies property, Flags flag) {
        for (int i = 0; i < props.length; i++) {
            if (props[i] != null) {
                props[i] = property;
                break;
            } else if (i == 3 && props[i] == null) {
                props[i] = property;
            }
        }
        this.property = property.toString();

        if (flag == Flags.BEFORE) {
            this.name = this.property + " " + this.name;
        } else {
            this.name = this.name + " " + this.property;
        }
    }

    @Override
    public void clearProperty() {
        for (int i = 0; i < props.length; i++) {
            props[i] = null;
        }
    }

    @Override
    public void setProperties(Flags flag, Properies... property) {
        if (property.length > propertiesLimit) {
            throw new IllegalArgumentException("Слишком много аргументов");
        } else {
            for (Properies prop : props) {
                giveProperty(prop, flag);

            }
        }
    }

    /**
     * Переопределение toString() для корректного вывода имени коротышки
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Переопределение equals() для корректного сравнения имени с типами String
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shorty shorty = (Shorty) o;
        return Objects.equals(name.toLowerCase(), shorty.name.toLowerCase());
    }

    /**
     * Переопределение hashcode() объектов для корректного сравнения, чтобы хеш-коды объектов были равны так же как и
     * с точки зрения equals
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}



