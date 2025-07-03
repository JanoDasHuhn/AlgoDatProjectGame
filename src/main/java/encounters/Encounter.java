package encounters;

import inventar.items.Rarity;

public abstract class Encounter {
    private Rarity rarity;
    private String name, desc;

    public Encounter(String name, String desc, Rarity rarity){
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
