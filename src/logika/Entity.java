package logika;

/**
 *  Class Entity - abstraktní reprezentací interaktivní objekt ve hře
 *  Tato třída uchovává data a vrací ji na žádost
 *
 *@author     Valeria Nekhimchuk
 *@version    pro školní rok 2016/2017
 */
public class Entity implements IInteraktiv {

    private String name;
    private String description;
    private String rewardDescription;
    private InventoryItem reward;
    private String expectedCommand;
    private int expectedType;
    private int armyReward;

    /**
     * Konstruktér, který ukládá data v lokálních proměnných
     */

    public Entity(String name, String description, String rewardDescription, InventoryItem reward, String expectedCommand, int expectedType, int armyReward) {
        this.name = name;
        this.description = description;
        this.rewardDescription = rewardDescription;
        this.reward = reward;
        this.expectedCommand = expectedCommand;
        this.expectedType = expectedType;
        this.armyReward = armyReward;
    }

    /**
     * Metoda vrací popis objektu
     *
     *@return  vrací popis objektu
     */
    public String getDescription() {
        return description;
    }

    /**
     * Metoda vrací název objektu
     *
     *@return  vrací název objektu
     */
    public String getName() {
        return name;
    }

    /**
     * Metoda Metoda vrací textovou příkaz, který očekává, že objekt
     *
     *@return  vrací textovou příkaz
     */
    public String getExpectedCommand() {
        return expectedCommand;
    }

    /**
     * Metoda vrací popis zadávání, která poskytuje objekt
     *
     *@return  vrací textovou popis
     */
    public String getRewardDescription() {
        return rewardDescription;
    }

    /**
     * metoda vrací award
     *
     *@return  vrací InventoryItem award
     */
    public InventoryItem getReward() {
        return reward;
    }

    /**
     * Podle tohoto způsobu se vrátí očekávané podle typu interakce
     *
     *@return  vrací typ
     */
    public int getExpectedType() {
        return expectedType;
    }

    /**
     * metoda vrací hodnotu, pro kterou můžete zvětšit armádu
     *
     *@return  vrací hodnotu
     */
    public int getArmyReward() {
        return armyReward;
    }
}
