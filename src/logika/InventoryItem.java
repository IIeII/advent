package logika;

/**
 *  Class InventoryItem - Jedná se o objekt, který může být uložen v inventáři
 *
 *@author     Valeria Nekhimchuk
 *@version    pro školní rok 2016/2017
 */

public class InventoryItem {

    private String name;

    /**
     * Konstruktér, který ukládá data v lokálních proměnných
     */
    public InventoryItem(String name) {
        this.name = name;
    }

    /**
     * Metoda vrací název objektu
     *
     *@return   vrací název objektu
     */
    public String getName() {
        return name;
    }
}
