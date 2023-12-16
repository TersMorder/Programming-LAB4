package Interfaces;

import Enums.ActionStatuses;
import Shorties.Shorty;
/**Реализует выдачу и передачу действий коротышек между интерфейсами*/
public interface ShortyActions {
    /**@see Shorty#setShortyAction(ActionStatuses)  */
    default void setActivity(Shorty shorty, ActionStatuses actionStatus){
      shorty.setShortyAction(actionStatus);
    }
    /**@see Shorty#getActivity(Shorty)  */
    default ActionStatuses getActivity(Shorty shorty){
        return shorty.getShortyActivity();
    }
    /**Проверяет есть ли у коротышки сейчас что-то чем он занят*/
    default boolean checkActivity(Shorty shorty){
        boolean abaddonAction;
        if(shorty.getActionCheck()){
            abaddonAction = true;
        }
        else {
            abaddonAction = false;
        }
        return abaddonAction;
    }
}
