package encounters;

import inventar.items.Rarity;

/**
 * @author Janis abstrakte Encounter Klasse
 **/
public abstract class Encounter {
  private Rarity rarity;
  private String name, desc;

  /**
   * @param name Name des Encounters
   * @param desc Beschreibung des Encounters
   * @param rarity Seltenheit des Encounters
   **/
  public Encounter(String name, String desc, Rarity rarity) {
    this.name = name;
    this.desc = desc;
    this.rarity = rarity;
  }

  public Rarity getRarity() {
    return rarity;
  }

  public String getName() {
    return name;
  }

  public String getDesc() {
    return desc;
  }
}
