package logika;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashSet;

public class Hrac {

    private int maxVelikostInvent = 3;

    private HashSet<String> inventar;
    private int armySize;

    public Hrac() {

        inventar = new HashSet<>();
    }

    public void addItemToInventory(String itemName){
        inventar.add(itemName);
    }

    public void removeItemFromInventory(String itemName){
        inventar.remove(itemName);
    }

    public Boolean hasItemInInventory(String itemName){
        return inventar.contains(itemName);
    }

    public String getInventoryItemsNames (){

        String result = "";
        for (String item : inventar){
            result += item + " ";
        }

        return inventar.isEmpty() ? null : result;
    }



}
