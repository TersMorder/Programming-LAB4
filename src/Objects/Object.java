package Objects;

import Enums.Flag;
import Enums.Genders;

public abstract class Object {
    protected String name;
    protected Genders gender;
    protected Flag flag;
    protected String objName;

    public Object (String name, Genders gender, Flag flag){
        this.name=name;
        this.gender = gender;
        this.flag = flag;

    }
    public Object (String name, Genders gender){
        this.name=name;
        this.gender = gender;
        this.objName = this.name;
    }
    public Object(String name){
        this.name=name;
    }
    public String getName(){
        return objName;
    }
}
