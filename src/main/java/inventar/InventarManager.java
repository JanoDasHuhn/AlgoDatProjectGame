package inventar;

import inventar.items.BoostItem;
import inventar.items.InteractiveItem;
import inventar.items.Item;
import inventar.items.WeaponItem;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * Die Klasse {@code InventarManager} verwaltet das Inventar des Spielers. Sie ermöglicht das
 * Hinzufügen, Entfernen und Auflisten von Items, sowie das Ausrüsten von Waffen.
 */
public class InventarManager {
  /** Das Inventar als HashMap: Item und Anzahl */
  private HashMap<Item, Integer> inventar;

  /** Die aktuell ausgerüstete Waffe */
  public WeaponItem weaponEquiped;

  /**
   * Konstruktor für {@code InventarManager}. Erstellt ein leeres Inventar.
   */
  public InventarManager() {
    inventar = new HashMap<>();
  }

  /**
   * Fügt ein Item dem Inventar hinzu. Wird eine Waffe gefunden, kann der Spieler entscheiden, sie
   * auszurüsten.
   *
   * @param item Das hinzuzufügende Item
   */
  public void addItem(Item item) {
    if (item instanceof WeaponItem) {
      System.out.println("Du findest die Waffe " + item.getName() + ".");
      System.out.println("Damage: " + ((WeaponItem) item).getDamage() + " Speed: "
          + ((WeaponItem) item).getSpeed() + " Accuracy: " + ((WeaponItem) item).getAccuracy());
      System.out.println("Deine jetzige Waffe: " + weaponEquiped.getName());
      System.out.println("Damage: " + weaponEquiped.getDamage() + " Speed: "
          + weaponEquiped.getSpeed() + " Accuracy: " + weaponEquiped.getAccuracy());
      System.out.println("(0) " + weaponEquiped.getName() + " (1) " + item.getName());
      Scanner scanner = new Scanner(System.in);
      String eingabe = scanner.nextLine();
      if (!Objects.equals(eingabe, "1")) {
        System.out.println("Du hast die Waffe nicht gewechselt!");
        return;
      }
      weaponEquiped = (WeaponItem) item;
      System.out.println("Du hast die Waffe " + item.getName() + " ausgerüstet.");
    }
    if (inventar.containsKey(item)) {
      inventar.put(item, inventar.get(item) + 1);
      return;
    }
    inventar.put(item, 1);
  }

  /**
   * Entfernt ein Item aus dem Inventar. Verringert die Anzahl, löscht das Item, wenn kein Exemplar
   * mehr vorhanden ist.
   *
   * @param item Das zu entfernende Item
   * @return {@code true}, wenn das Item entfernt werden konnte, sonst {@code false}
   */
  public boolean subtractItem(Item item) {
    if (!inventar.containsKey(item)) {
      return false;
    }
    inventar.put(item, inventar.get(item) - 1);
    if (inventar.get(item) == 0) {
      inventar.remove(item);
    }
    return true;
  }

  /**
   * Gibt das Inventar als String zurück, sortiert nach Waffen, Boosts und interaktiven Items.
   *
   * @return Das Inventar als formatierten String
   */
  public String listItems() {
    HashMap<WeaponItem, Integer> weaponItems = new HashMap<>();
    HashMap<BoostItem, Integer> boostItems = new HashMap<>();
    HashMap<InteractiveItem, Integer> interactiveItems = new HashMap<>();
    System.out.println(inventar.keySet());
    for (Item item : inventar.keySet()) {
      if (item instanceof WeaponItem) {
        weaponItems.put((WeaponItem) item, inventar.get(item));
        continue;
      }
      if (item instanceof BoostItem) {
        boostItems.put((BoostItem) item, inventar.get(item));
        continue;
      }
      interactiveItems.put((InteractiveItem) item, inventar.get(item));
    }
    StringBuilder string = new StringBuilder("Inventory\n");
    string.append("Weapons: \n");
    for (WeaponItem weaponItem : weaponItems.keySet()) {
      string.append(weaponItem.getRarity().name()).append(" ").append(weaponItem.getName())
          .append(" ").append(weaponItems.get(weaponItem)).append("\n");
    }
    string.append("Boosts: \n");
    for (BoostItem boostItem : boostItems.keySet()) {
      string.append(boostItem.getRarity()).append(" ").append(boostItem.getName()).append(" ")
          .append(boostItems.get(boostItem)).append("\n");
    }
    string.append("Interactive: \n");
    for (InteractiveItem interactiveItem : interactiveItems.keySet()) {
      string.append(interactiveItem.getRarity()).append(" ").append(interactiveItem.getName())
          .append(" ").append(interactiveItems.get(interactiveItem)).append("\n");
    }
    return string.toString();
  }

  /**
   * Gibt das Inventar als HashMap zurück.
   *
   * @return Das Inventar
   */
  public HashMap<Item, Integer> getInventar() {
    return inventar;
  }
}
