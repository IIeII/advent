package logika;

/**
 *  Rozhraní které musí implementovat Class Entity - abstraktní reprezentací interaktivní objekt ve hře
 *
 *@author     Valeria Nekhimchuk
 *@version    pro školní rok 2016/2017
 */

public interface IInteraktiv {
    /**
     * Metoda vrací popis objektu
     *
     *@return  vrací popis objektu
     */
    public String getDescription();

    /**
     * Metoda vrací název objektu
     *
     *@return  vrací název objektu
     */
    public String getName();

    /**
     * Metoda Metoda vrací textovou příkaz, který očekává, že objekt
     *
     *@return  vrací textovou příkaz
     */
    public String getExpectedCommand();

    /**
     * Metoda vrací popis zadávání, která poskytuje objekt
     *
     *@return  vrací textovou popis
     */
    public String getRewardDescription();

    /**
     * metoda vrací award
     *
     *@return  vrací InventoryItem award
     */
    public InventoryItem getReward();

    /**
     * Podle tohoto způsobu se vrátí očekávané podle typu interakce
     *
     *@return  vrací typ
     */
    public int getExpectedType();

    /**
     * metoda vrací hodnotu, pro kterou můžete zvětšit armádu
     *
     *@return  vrací hodnotu
     */
    public int getArmyReward();
}
