package Interfaces;
import Enums.Flags;
import Enums.Properies;
/** Используется для изменения свойств и отчистки всех свойств у коротышек */
public interface PropertyChanging {
   /** Даёт свойство коротышке путём изменения его имени на имя + свойство, или свойство + имя
    * @param property свойство которое нужно дать коротышке
    * @param flag флаг отвечающий за позицию свойства относительно имени до/после
    */
   void giveProperty(Properies property, Flags flag);
   /** Убирает все свойства данные объекту или коротышке */
   void clearProperty();
   /** Даёт список свойств коротышке путём изменения его имени на имя + свойство, или свойство + имя
    * @param property свойства которые нужно дать коротышке
    * @param flag флаг отвечающий за позицию свойства относительно имени до/после
    */
   void setProperties(Flags flag, Properies ... property);

}