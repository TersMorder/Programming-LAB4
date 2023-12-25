package Enums;

/**
 * Используется для определения того чем занят коротышка
 */
public enum ActionStatuses {
    DRAWING("рисует"),
    DONEDRAWING("закончил рисовать"),
    DOINGSOMETHING("занят чем-то"),
    LAUGHING("смеётся"),
    TAKINGLOOK("внимательно рассматривает"),
    PUTTINGON("надевает"),
    NONE("ничего не делает");


    private String actionName;
    ActionStatuses(String actionName){
    this.actionName = actionName;
    }

    @Override
    public String toString() {
        return actionName;
    }
}
