package Objects;

/** Абстрактный класс неживых объектов реализующий их базовый функционал */
public abstract class InanimateObject {
    /** Имя объекта */
    protected String name;
    /** Используется для записи изначального имени, чтобы при надобности вернуться к нему*/
    final protected String oldName;

    /** Базовый конструктор
     * @param name имя объекта*/
    public InanimateObject(String name){
        this.name = name;
        oldName = name;
    }
    /** Переопределение toString() для корректного вывода имени объекта */
    @Override
    public String toString() {
        return name;
    }
}

