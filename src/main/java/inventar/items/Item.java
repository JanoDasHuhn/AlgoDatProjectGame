package inventar.items;

/**
 * Die abstrakte Klasse {@code Item} repräsentiert ein generisches Item im Inventar.
 * Sie enthält grundlegende Eigenschaften wie Name, Gewicht, Seltenheit und Beschreibung.
 */
public abstract class Item {
    /** Das Gewicht des Items */
    private float weight;

    /** Der Name des Items */
    private String name;

    /** Die Beschreibung des Items */
    private String desc;

    /** Die Seltenheit des Items */
    private Rarity rarity;

    /**
     * Konstruktor für {@code Item}.
     *
     * @param name   Der Name des Items
     * @param weight Das Gewicht des Items
     * @param rarity Die Seltenheit des Items
     * @param desc   Die Beschreibung des Items
     */
    public Item(String name, float weight, Rarity rarity, String desc){
        this.weight = weight;
        this.name = name;
        this.desc = desc;
        this.rarity = rarity;
    }

    /**
     * Gibt den Namen des Items zurück.
     *
     * @return Der Name des Items
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt das Gewicht des Items zurück.
     *
     * @return Das Gewicht des Items
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Gibt die Seltenheit des Items zurück.
     *
     * @return Die Rarity des Items
     */
    public Rarity getRarity() {
        return rarity;
    }

    /**
     * Gibt die Beschreibung des Items zurück.
     *
     * @return Die Beschreibung des Items
     */
    public String getDesc() {
        return desc;
    }
}
