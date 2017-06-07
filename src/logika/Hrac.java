package logika;

import java.util.HashSet;

/**
 *  Class Hrac - Obsahuje informace o armádou hráče a jeho inventáře
 *
 *@author     Valeria Nekhimchuk
 *@version    pro školní rok 2016/2017
 */

public class Hrac {

    private int maxVelikostInvent = 3;

    private HashSet<InventoryItem> inventar;
    private int armySize;

    /**
     * Konstruktor který inicializuje počáteční hodnotu
     */
    public Hrac() {
        armySize = 0;
        inventar = new HashSet<>();
    }

    /**
     *  Metoda, která umožňuje zvětšit velikost armády
     *
     *@param  count  int, číslo, které ke zvýšení armádu
     */
    public void addToArmy(int count){
        armySize += count;
    }

    /**
     *  Metoda, který snižuje armáda 1 jednotku
     */
    public void decreaseArmy(){
        armySize--;
    }

    /**
     *  Metoda, která vrátí aktuální velikost armády
     *
     *  @return        vrátí počet armády
     */
    public int getArmySize(){
        return armySize;
    }

    /**
     *  Metoda, která vám umožní přidat položky do vašeho inventáře
     *
     *@param  itemName  které chcete přidat do svého inventáře
     */
    public void addItemToInventory(InventoryItem itemName){
        if (itemName != null){
            inventar.add(itemName);
        }
    }

    /**
     * Metoda, která umožňuje odstranit předměty z inventáře
     *
     *@param  itemName  co chcete odstranit z inventáře
     */
    public void removeItemFromInventory(String itemName){
        for (InventoryItem item : inventar){
            if (item.getName().equals(itemName)){
                inventar.remove(item);
                break;
            }
        }

    }

    /**
     * Metoda, která vám umožní zjistit, zda existuje něco ve vašem inventáři
     *
     *@param  itemName  co chcete odstranit z inventáře
     *@return          Vrací hodnotu true, pokud jde o to, v inventáře
     */
    public Boolean hasItemInInventory(String itemName){

        for (InventoryItem item : inventar){
            if (item.getName().equals(itemName)){
                return true;
            }
        }

        return false;
    }

    /**
     *  Metoda, vytváří text, ve kterém názvy všech položek, které jsou ve vašem inventáři
     *
     *@return      vrátí jména všech položek, které máte ve vašem inventáři
     */
    public String getInventoryItemsNames (){

        String result = "";
        for (InventoryItem item : inventar){
            result += item.getName() + " ";
        }

        return inventar.isEmpty() ? null : result;
    }

    /**
     *  Kontroluje, zda je volné místo v inventáři
     *
     *@return      Vrací hodnotu true, do prostor je k dispozici ve vašem inventáři
     */
    public Boolean isEnouthSpaceInInventory (){
        return inventar.size() < maxVelikostInvent;
    }

}
