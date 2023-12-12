package Interfaces;
/** Используется для изменения имени и отчистки его изменений у коротышек и объектов*/
public interface NameChanging {
    /** Меняет окончание у имени на подходящее контексту*/
    void changeNameEnding();
    /** Меняет имя на прежнее */
    void clearNameChanges();
}
