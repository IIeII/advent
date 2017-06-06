package logika;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashSet;

public class Hrac {

    private int maxVelikostInvent = 3;

    private HashSet<InventoryItem> inventar;
    private int armySize;

    public Hrac() {
        armySize = 0;
        inventar = new HashSet<>();
    }

    public void addToArmy(int count){
        armySize += count;
    }

    public int getArmySize(){
        return armySize;
    }

    public void addItemToInventory(InventoryItem itemName){
        if (itemName != null){
            inventar.add(itemName);
        }
    }

    public void removeItemFromInventory(String itemName){
        inventar.remove(itemName);
    }

    public Boolean hasItemInInventory(String itemName){
        return inventar.contains(itemName);
    }

    public String getInventoryItemsNames (){

        String result = "";
        for (InventoryItem item : inventar){
            result += item.getName() + " ";
        }

        return inventar.isEmpty() ? null : result;
    }

    public Boolean isEnouthSpaceInInventory (){
        return inventar.size() < maxVelikostInvent;
    }

}
