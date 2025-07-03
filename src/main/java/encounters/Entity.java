package encounters;

import inventar.items.Item;
import inventar.items.Rarity;

public class Entity extends Encounter{
    private int health;
    private EntityType entityType;
    private int damage;
    private Item item;
    public Entity(String name, String desc, Rarity rarity, int health, EntityType entityType, int damage, Item item) {
        super(name, desc, rarity);
        this.health = health;
        this.entityType = entityType;
        this.damage = damage;
        this.item = item;
    }

    public int getDamage() {
        return damage;
    }

    public Item getItem() {
        return item;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public int getHealth() {
        return health;
    }
}
