package inventar.items;

public abstract class Item {
    private float weight;
    private String name;
    private String desc;
    private Rarity rarity;

    public Item(String name, float weight,Rarity rarity,String desc){
        this.weight = weight;
        this.name = name;
        this.desc = desc;
        this.rarity = rarity;

    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public String getDesc() {
        return desc;
    }
}
