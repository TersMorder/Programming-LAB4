package Constructions;

import Shorties.Artist.Picture;
/**Класс построек, нужен для правильной реализации граффити*/
public abstract class Construction {
    /**Массив с рисунками которые есть на структуре (имеется ввиду, что может быть метод для того, чтобы повесить рисунок
     * на стену и тогда он тоже будет занимать место на площади структуры)*/
    private Picture[] pictures;
    private final String name;
    private final int size;
    public Construction(String name, int size){
        this.size = size;
        this.name = name;
        pictures = new Picture[size*2];
    }
/**Геттер имени структуры*/
    public String getName() {
        return name;
    }
/**Добавляет в массив рисунков и граффити новый объект, если места на структуре нет то выдаёт ошибку*/
    public void setPictures(Picture picture) {
        int pictureCounter = 0;
        for(int i = 0; i<pictures.length; i++) {
            if(this.pictures[i] == null) {
                pictures[i] = picture;
                break;
            }
            else{
                ++pictureCounter;
            }
            if(pictureCounter == pictures.length && pictures[pictures.length-1] != null){
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }
    /**Геттер граффити изображённого на структуре по его порядковому номеру
     * @param i Номер*/
    public Picture getPictures(int i) {
        return pictures[i-1];
    }
    /**Вывод того что висит или нарисовано на конструкции
     * @param i порядковый номер того что нужно вывести*/
    public void showWhatsAtConstruction(int i){
        System.out.println("На " + name + " был нарисован " + "\"" + getPictures(i) + "\"");
    }
}
