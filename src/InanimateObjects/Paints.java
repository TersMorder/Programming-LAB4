package InanimateObjects;

import InanimateObjects.InanimateObject;

/** Класс неживого объекта - красок, используемый для проверки их наличия в инвентаре */
public class Paints extends InanimateObject {
    protected String name;
    final protected String oldName;
    public Paints(String name){
        super(name);
        this.name = name;
        oldName = name;
    }
    /** Переопределение toString() для корректного вывода имени объекта */
    @Override
    public String toString() {
        return name;
    }
}
