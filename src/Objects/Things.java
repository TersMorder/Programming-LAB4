package Objects;

public class Things extends Object {
    protected String name;
    public Things(String name){
        super(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


}
