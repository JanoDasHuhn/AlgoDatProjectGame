package inventar;

import inventar.items.BoostItem;
import inventar.items.InteractiveItem;
import inventar.items.Item;
import inventar.items.WeaponItem;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class InventarManager {
    private HashMap<Item,Integer> inventar;
    public InventarManager(){
        inventar = new HashMap<>();
    }
    public WeaponItem weaponEquiped;
    public void addItem(Item item){
        if(item instanceof WeaponItem){


            System.out.println("Du findest die Waffe" + item.getName()+".");
            System.out.println("Damage: " + ((WeaponItem) item).getDamage() + " Speed: " + ((WeaponItem) item).getSpeed() + " Accuracy: " + ((WeaponItem) item).getAccuracy());
            System.out.println("Deine jetzige Waffe: " + weaponEquiped.getName() );
            System.out.println("Damage: " + weaponEquiped.getDamage() + " Speed: " + weaponEquiped.getSpeed() + " Accuracy: " + weaponEquiped.getAccuracy ());
            System.out.println("(0) " +weaponEquiped.getName() + " (1) " + item.getName());
            Scanner scanner = new Scanner(System.in);
            String eingabe = scanner.nextLine();
            if(!Objects.equals(eingabe, "1")){
                System.out.println("Du hast die Waffe nicht gewechselt!");
                return;
            }




            weaponEquiped = (WeaponItem) item;
            System.out.println("Du hast die Waffe " + item.getName() + " ausgerüstet.");
        }
        if(inventar.containsKey(item)){
            inventar.put(item,inventar.get(item) +1);
            return;
        }

        inventar.put(item,1);

    }
    public boolean subtractItem(Item item){
        if(!inventar.containsKey(item)){
            return false;
        }
        inventar.put(item,inventar.get(item) -1);
        if (inventar.get(item) == 0){
            inventar.remove(item);
        }
        return true;

    }
    public String listItems(){
         HashMap<WeaponItem,Integer> weaponItems = new HashMap<>();
        HashMap<BoostItem,Integer> boostItems = new HashMap<>();
        HashMap<InteractiveItem,Integer> interactiveItems = new HashMap<>();
        System.out.println(inventar.keySet());
        for (Item item : inventar.keySet()){
            if(item instanceof WeaponItem){
                weaponItems.put((WeaponItem) item,inventar.get(item));
                continue;
            }
            if(item instanceof BoostItem){
                boostItems.put((BoostItem) item,inventar.get(item));
                continue;
            }
            interactiveItems.put((InteractiveItem) item,inventar.get(item));
        }
        StringBuilder string = new StringBuilder("Inventory\n");
        string.append("Weapons: \n");
        for (WeaponItem weaponItem : weaponItems.keySet()){
            string.append(weaponItem.getRarity().name()).append(" ").append(weaponItem.getName()).append(" ").append(weaponItems.get(weaponItem)).append("\n");
        }
        string.append("Boosts: \n");
        for (BoostItem boostItem : boostItems.keySet()){
            string.append(boostItem.getRarity()).append(" ").append(boostItem.getName()).append(" ").append(boostItems.get(boostItem)).append("\n");
        }
        string.append("Interactive: \n");
        for (InteractiveItem interactiveItem : interactiveItems.keySet()){
            string.append(interactiveItem.getRarity()).append(" ").append(interactiveItem.getName()).append(" ").append(interactiveItems.get(interactiveItem)).append("\n");
        }
        return string.toString();
    }

    public HashMap<Item, Integer> getInventar() {
        return inventar;
    }
}
