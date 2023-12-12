//package Objects;
//
//import Enums.Flag;
//import Enums.Genders;
//
//import java.util.Objects;
//
//public abstract class LiveObject {
//    protected String name;
//    protected Genders gender;
//    protected Flag flag;
//    protected String objName;
//
//    public LiveObject(String name, Genders gender, Flag flag){
//        this.name=name;
//        this.gender = gender;
//        this.flag = flag;
//
//    }
//    public LiveObject(String name, Genders gender){
//        this.name=name;
//        this.gender = gender;
//        this.objName = this.name;
//    }
//    public LiveObject(String name){
//        this.name=name;
//    }
//    public LiveObject(){}
//    public String getName(){
//        return objName;
//    }
//
//
//    public boolean equals(LiveObject o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        LiveObject object = o;
//        return Objects.equals(name, object.name) && gender == object.gender && flag == object.flag && Objects.equals(objName, object.objName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, gender, flag, objName);
//    }
//}
