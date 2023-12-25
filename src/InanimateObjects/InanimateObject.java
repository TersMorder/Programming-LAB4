package InanimateObjects;

/**
 * Абстрактный класс неживых объектов реализующий их базовый функционал
 */
public abstract class InanimateObject {
    /**
     * Имя объекта
     */
    protected String name;

    /**
     * Базовый конструктор
     *
     * @param name имя объекта
     */
    public InanimateObject(String name) {
        this.name = name;
    }

    /**
     * Переопределение toString() для корректного вывода имени объекта
     */
    @Override
    public String toString() {
        return name;
    }
}

