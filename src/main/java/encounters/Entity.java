package encounters;

import inventar.items.Item;
import inventar.items.Rarity;

/**
 * Die Klasse {@code Entity} repräsentiert eine besondere Art von Encounter mit zusätzlichen
 * Attributen wie Lebenspunkten, Schadenswert, Entitätstyp und einem Item.
 */
public class Entity extends Encounter {
  /** Die Lebenspunkte der Entität */
  private int health;

  /** Der Typ der Entität (z.B. GOOD, EVIL, NEUTRAL) */
  private EntityType entityType;

  /** Der Schadenswert der Entität */
  private int damage;

  /** Das Item, das die Entität eventuell trägt */
  private Item item;

  /**
   * Erstellt eine neue Instanz der Klasse {@code Entity}.
   *
   * @param name Der Name der Entität
   * @param desc Die Beschreibung der Entität
   * @param rarity Die Seltenheit der Entität
   * @param health Die Lebenspunkte der Entität
   * @param entityType Der Typ der Entität (GOOD, EVIL, NEUTRAL)
   * @param damage Der Schadenswert der Entität
   * @param item Das Item, das die Entität besitzt
   */
  public Entity(String name, String desc, Rarity rarity, int health, EntityType entityType,
      int damage, Item item) {
    super(name, desc, rarity);
    this.health = health;
    this.entityType = entityType;
    this.damage = damage;
    this.item = item;
  }

  /**
   * Gibt den Schadenswert der Entität zurück.
   *
   * @return Der Schaden, den die Entität verursacht
   */
  public int getDamage() {
    return damage;
  }

  /**
   * Gibt das Item zurück, das die Entität besitzt.
   *
   * @return Das Item-Objekt der Entität
   */
  public Item getItem() {
    return item;
  }

  /**
   * Gibt den Typ der Entität zurück.
   *
   * @return Der EntityType der Entität
   */
  public EntityType getEntityType() {
    return entityType;
  }

  /**
   * Gibt die aktuellen Lebenspunkte der Entität zurück.
   *
   * @return Die Lebenspunkte der Entität
   */
  public int getHealth() {
    return health;
  }

  /**
   * Verstärkt die Werte (Stats) der Entität abhängig vom übergebenen Boost-Wert. Diese Methode ist
   * aktuell noch in Arbeit und hat keine Implementierung.
   *
   * @param boost Der Wert, um den die Stats verstärkt werden sollen
   */
  public void boostStats(int boost) {
    // in Arbeit
  }
}
