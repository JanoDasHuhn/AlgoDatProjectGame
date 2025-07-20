package inventar.items;

/**
 * Die Klasse {@code BoostItem} repräsentiert ein Item, das dem Spieler einen Bonus auf Lebenspunkte
 * oder Geschwindigkeit gewährt.
 */
public class BoostItem extends Item {
  /** Der Gesundheits-Boost, den das Item gewährt */
  private float healthBoost;

  /** Der Geschwindigkeits-Boost, den das Item gewährt */
  private float speedBoost;

  /**
   * Erstellt ein neues {@code BoostItem} mit den angegebenen Attributen.
   *
   * @param name Name des Items
   * @param weight Gewicht des Items
   * @param rarity Seltenheit des Items
   * @param desc Beschreibung des Items
   * @param healthBoost Der Gesundheits-Boost-Wert
   * @param speedBoost Der Geschwindigkeits-Boost-Wert
   */
  public BoostItem(String name, float weight, Rarity rarity, String desc, float healthBoost,
      float speedBoost) {
    super(name, weight, rarity, desc);
    this.speedBoost = speedBoost;
    this.healthBoost = healthBoost;
  }

  /**
   * Gibt den Gesundheits-Boost dieses Items zurück.
   *
   * @return Der Wert, um den die Gesundheit erhöht wird
   */
  public float getHealthBoost() {
    return healthBoost;
  }

  /**
   * Gibt den Geschwindigkeits-Boost dieses Items zurück.
   *
   * @return Der Wert, um den die Geschwindigkeit erhöht wird
   */
  public float getSpeedBoost() {
    return speedBoost;
  }
}
