package inventar.items;

public class WeaponItem extends Item{
    private float damage;
    private float speed;
    private float accuracy;
    public WeaponItem(String name, float weight, Rarity rarity, String desc,float damage,float speed,float accuracy) {

        super(name, weight, rarity, desc);
        this.damage = damage;
        this.accuracy = accuracy;
        this.speed = speed;
    }



    public float getAccuracy() {
        return accuracy;
    }

    public float getDamage() {
        return damage;
    }

    public float getSpeed() {
        return speed;
    }
}
