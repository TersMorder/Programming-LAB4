package Shorties.Artist;
/** Занимается подсчётом нарисованных коротышек, пример реализации Single responsibility*/
public class DrawnShortiesCounter {
    private static int drawnShorties = 0;
    /**Добавляет значение к нарисованным коротышкам
     * @param i Колличество нарисованных коротышек*/
    public static void addDrawnShorty(int i){
        drawnShorties+= i;
    }
    /**@return Возвращает кол-во нарисованных коротышек*/
    public static int calcDrawnShorties(){
        return  drawnShorties;
    }
}
