package inventar.items;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    private List<Item> allItems;
    public ItemManager(){
        allItems = new ArrayList<>();
    }
    public void addItemToPool(String name,float weight,String desc,Rarity rarity){
        InteractiveItem interactiveItem = new InteractiveItem(name,weight,rarity,desc);
        allItems.add(interactiveItem);

    }
    public void addItemToPool(String name,float weight,String desc,Rarity rarity,float damage, float speed, float accuracy){
        WeaponItem weaponItem = new WeaponItem(name,weight,rarity,desc,damage,speed,accuracy);
        allItems.add(weaponItem);


    }
    public void addItemToPool(String name,float weight,String desc,Rarity rarity,float healthBoost, float speedBoost){
        BoostItem weaponItem = new BoostItem(name,weight,rarity,desc,healthBoost,speedBoost);
        allItems.add(weaponItem);


    }
    public Item getItem(int i){
        return allItems.get(i);
    }
    public List<Item> getAllItems() {
        return allItems;
    }
}
