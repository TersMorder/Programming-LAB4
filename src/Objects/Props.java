//package Objects;
//
//import Enums.Flag;
//import Enums.Genders;
//import Interfaces.PropertyChanging;
//
//public class Props extends LiveObject implements PropertyChanging {
//    char[] property;  // Измените на массив char
//    private String startProperty;
//    private final String oldName;
//    private String name;
//
//    public Props(String name, Genders gender){
//        super(name, gender);
//        this.name = name;
//        this.gender = gender;
//        oldName = name;
//    }
//    public void giveStartProperty(String property){
//        startProperty = property;
//        this.name = property + " " + this.name + " ";
//    }
//
//
//    @Override
//    public void giveProperty(String property, Flag flag) {
//        this.property = property.toCharArray();
//        int propertyLength = this.property.length;
//
//        //  System.out.println("Количество символов в property: " + propertyLength);
//
//        char[] nameArray = this.name.toCharArray();
//        char[] newNameArray = new char[nameArray.length + propertyLength + 1];
//
//        System.arraycopy(nameArray, 0, newNameArray,0, nameArray.length);
//        int spaceIndex = this.name.indexOf(" ");
//        newNameArray[spaceIndex] = ' ';
//        for (int i = nameArray.length - 1; i >= spaceIndex; i--) {
//            newNameArray[i + propertyLength + 1] = newNameArray[i];
//        }
//
//        for (int i = 0; i < propertyLength; i++) {
//            newNameArray[spaceIndex + 1 + i] = this.property[i];
//        }
//
//        this.name = new String(newNameArray);
//        char [] charArray = this.name.toCharArray();
//        if (charArray[charArray.length-2] == 'а'){
//            charArray[charArray.length-2] ='у';
//            this.name = new String(charArray);
//        }
//
//
//    }
//
//
//
//    @Override
//    public void changePropertyEnding(){
//        clearProperty();
//        char [] charPropArray = this.startProperty.toCharArray();
//
//        if (charPropArray[charPropArray.length-1] == 'й') {
//            char[] charNewPropArray = new char[charPropArray.length + 1];
//            System.arraycopy(charPropArray, 0, charNewPropArray, 0, charPropArray.length);
//            charNewPropArray[charNewPropArray.length - 1] = 'о';
//            charNewPropArray[charNewPropArray.length - 2] = 'г';
//            charNewPropArray[charNewPropArray.length - 3] = 'о';
//            startProperty = new String(charNewPropArray);
//        }
//        else if (charPropArray[charPropArray.length-1] == 'к') {
//            char[] charNewPropArray = new char[charPropArray.length + 1];
//            System.arraycopy(charPropArray, 0, charNewPropArray, 0, charPropArray.length);
//            charNewPropArray[charPropArray.length] = 'а';
//            startProperty = new String(charNewPropArray);
//        }
//        giveStartProperty(startProperty);
//    }
//
//    @Override
//    public String toString() {
//        char [] charArray = name.toCharArray();
//        if (charArray[charArray.length-1] == 'а'){
//            charArray[charArray.length-1] ='у';
//            name = new String(charArray);
//        }
//        return name;
//    }
//
//@Override
//    public void clearProperty() {
//        this.name = oldName;
//    }
//}
