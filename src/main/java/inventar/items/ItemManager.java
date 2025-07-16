package inventar.items;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse {@code ItemManager} verwaltet einen Pool von Items.
 * Sie ermöglicht das Hinzufügen verschiedener Item-Typen und das Abrufen der Items.
 */
public class ItemManager {
    /** Die Liste aller Items im Pool */
    private List<Item> allItems;

    /**
     * Konstruktor für {@code ItemManager}.
     * Erstellt eine leere Item-Liste.
     */
    public ItemManager(){
        allItems = new ArrayList<>();
    }

    /**
     * Fügt ein {@link InteractiveItem} dem Pool hinzu.
     *
     * @param name   Name des Items
     * @param weight Gewicht des Items
     * @param desc   Beschreibung des Items
     * @param rarity Seltenheit des Items
     */
    public void addItemToPool(String name, float weight, String desc, Rarity rarity){
        InteractiveItem interactiveItem = new InteractiveItem(name, weight, rarity, desc);
        allItems.add(interactiveItem);
    }

    /**
     * Fügt ein {@link WeaponItem} dem Pool hinzu.
     *
     * @param name     Name der Waffe
     * @param weight   Gewicht der Waffe
     * @param desc     Beschreibung der Waffe
     * @param rarity   Seltenheit der Waffe
     * @param damage   Schadenswert
     * @param speed    Geschwindigkeit
     * @param accuracy Genauigkeit
     */
    public void addItemToPool(String name, float weight, String desc, Rarity rarity, float damage, float speed, float accuracy){
        WeaponItem weaponItem = new WeaponItem(name, weight, rarity, desc, damage, speed, accuracy);
        allItems.add(weaponItem);
    }

    /**
     * Fügt ein {@link BoostItem} dem Pool hinzu.
     *
     * @param name        Name des Items
     * @param weight      Gewicht des Items
     * @param desc        Beschreibung des Items
     * @param rarity      Seltenheit des Items
     * @param healthBoost Gesundheits-Boost-Wert
     * @param speedBoost  Geschwindigkeits-Boost-Wert
     */
    public void addItemToPool(String name, float weight, String desc, Rarity rarity, float healthBoost, float speedBoost){
        BoostItem boostItem = new BoostItem(name, weight, rarity, desc, healthBoost, speedBoost);
        allItems.add(boostItem);
    }

    /**
     * Gibt das Item am angegebenen Index zurück.
     *
     * @param i Der Index des gewünschten Items
     * @return Das entsprechende {@link Item}-Objekt
     */
    public Item getItem(int i){
        return allItems.get(i);
    }

    /**
     * Gibt eine Liste aller Items im Pool zurück.
     *
     * @return Die Liste aller {@link Item}-Objekte
     */
    public List<Item> getAllItems() {
        return allItems;
    }
}
