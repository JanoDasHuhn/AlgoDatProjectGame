package inventar.items;

public class BoostItem extends Item{
    private float healthBoost,speedBoost;
    public BoostItem(String name, float weight, Rarity rarity, String desc,float healthBoost,float speedBoost) {
        super(name, weight, rarity, desc);
        this.speedBoost = speedBoost;
        this.healthBoost = healthBoost;

    }



    public float getHealthBoost() {
        return healthBoost;
    }

    public float getSpeedBoost() {
        return speedBoost;
    }
}
