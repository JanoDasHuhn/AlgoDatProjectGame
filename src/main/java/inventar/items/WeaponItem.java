package inventar.items;

/**
 * Die Klasse {@code WeaponItem} repräsentiert ein Item vom Typ Waffe. Waffen haben Schadenswert,
 * Geschwindigkeit und Genauigkeit als zusätzliche Attribute.
 */
public class WeaponItem extends Item {
  /** Der Schadenswert der Waffe */
  private float damage;

  /** Die Geschwindigkeit der Waffe */
  private float speed;

  /** Die Genauigkeit der Waffe */
  private float accuracy;

  /**
   * Erstellt ein neues {@code WeaponItem} mit den angegebenen Attributen.
   *
   * @param name Name der Waffe
   * @param weight Gewicht der Waffe
   * @param rarity Seltenheit der Waffe
   * @param desc Beschreibung der Waffe
   * @param damage Schadenswert der Waffe
   * @param speed Geschwindigkeit der Waffe
   * @param accuracy Genauigkeit der Waffe
   */
  public WeaponItem(String name, float weight, Rarity rarity, String desc, float damage,
      float speed, float accuracy) {
    super(name, weight, rarity, desc);
    this.damage = damage;
    this.accuracy = accuracy;
    this.speed = speed;
  }

  /**
   * Gibt die Genauigkeit der Waffe zurück.
   *
   * @return Die Genauigkeit der Waffe
   */
  public float getAccuracy() {
    return accuracy;
  }

  /**
   * Gibt den Schadenswert der Waffe zurück.
   *
   * @return Der Schaden der Waffe
   */
  public float getDamage() {
    return damage;
  }

  /**
   * Gibt die Geschwindigkeit der Waffe zurück.
   *
   * @return Die Geschwindigkeit der Waffe
   */
  public float getSpeed() {
    return speed;
  }
}
