
import Seedstuff.Seedreader;
import encounters.Encounter;
import encounters.EncounterManager;
import encounters.Entity;
import encounters.EntityType;
import inventar.InventarManager;
import inventar.items.*;

import rooms.Room;
import rooms.RoomManager;

import java.util.Random;
import java.util.Scanner;

public class GameLoop {
   static RoomManager roomManager;

   static Seedreader seedreader;



   
       

   static InventarManager inventarManager;
   static ItemManager itemManager;
   static EncounterManager encounterManager;
   static int health = 100;
    public static void main(String[] args) {
        roomManager = new RoomManager();
        inventarManager = new InventarManager();
        itemManager = new ItemManager();
        encounterManager = new EncounterManager();
        addItems();

        addEncounters();
        inventarManager.weaponEquiped = new WeaponItem("Hände",0.0f,Rarity.COMMON,"Deine bloßen Hände",5.0f,0.0f,0.9f);
        while (true){
            Room chosenRoom = roomManager.getRandomRoom();

            System.out.println("Das Spiel beginnt!");
            System.out.println(chosenRoom.getDescription());
            handleEncounter();

        }
    }

    private static void addEncounters() {
        encounterManager.addEncounter(new Entity("Villager","Du findest einen Dorfbewohner",Rarity.COMMON,20, EntityType.GOOD,0, itemManager.getItem(2)));
        encounterManager.addEncounter(new Entity("Böser Roboter","Ein Roboter erscheint und greift dich an",Rarity.RARE,20, EntityType.EVIL,2, itemManager.getItem(3)));
        encounterManager.addEncounter(new Entity("Ratte","Eine Ratte erscheint, sie scheint dich nicht anzugreifen",Rarity.COMMON,100, EntityType.NEUTRAL,2, itemManager.getItem(10)));

    }

    private static void handleEncounter() {
        Encounter encounter = encounterManager.getRandomEncounter();
        System.out.println("\n");
        System.out.println(encounter.getName() + "\n");
        System.out.println(encounter.getDesc() + ".\n");

        System.out.println("Was willst du machen?");
        if(encounter instanceof Entity){
            Entity entity = (Entity) encounter;
            switch (entity.getEntityType()){
                case GOOD:  handleGood(entity); break;
                case NEUTRAL:  handleNeutral(entity); break;
                case EVIL:  handleEvil(entity); break;
            }
        }



    }

    private static void handleEvil(Entity entity) {
        fight(entity,entity.getHealth());
    }

    private static void gameOver() {
        System.out.println("Du hast verloren");
    }

    private static void handleNeutral(Entity entity) {
        System.out.println("(1) Ein Boost-Item anbieten (3) Kämpfen (2) Inventar anschauen");
        Scanner scanner = new Scanner(System.in);
        String eingabe = scanner.nextLine();
        if(eingabe.isEmpty()){
            return;

        }
        if(Integer.parseInt(eingabe) == 0){
            return;
        }
        switch (Integer.parseInt(eingabe)){
            case 1:
                boolean foundBoost = false;
                for (Item item : inventarManager.getInventar().keySet()){
                    if(item instanceof BoostItem){
                        System.out.println("Du gibt " + entity.getName() + " das Item " + item+ ".");
                        inventarManager.subtractItem(item);
                        System.out.println("Du darfst weiter gehen!");
                        foundBoost = true;
                        break;
                    }
                }
                if(foundBoost == false){
                    System.out.println("Du hast leider keine Boost Items.");
                    fight(entity,entity.getHealth());
                }

                return;

            case 2:
                System.out.println(inventarManager.listItems());
                handleGood(entity);
                break;
            default:
                System.out.println("Falsche Eingabe");
                handleGood(entity);
        }
    }

    static void handleGood(Entity entity){
        System.out.println("(1) Interagieren (2) Inventar anschauen");
        Scanner scanner = new Scanner(System.in);
        String eingabe = scanner.nextLine();
        if(eingabe.isEmpty()){
            return;

        }
        if(Integer.parseInt(eingabe) == 0){
            return;
        }
        switch (Integer.parseInt(eingabe)){
            case 1: System.out.println("Du bekommst ein " + entity.getItem().getName() +".");
                inventarManager.addItem(entity.getItem());
                return;

            case 2:
                System.out.println(inventarManager.listItems());
                handleGood(entity);
                break;
            default:
                System.out.println("Falsche Eingabe");
                handleGood(entity);
        }

    }

    static void addItems(){

        itemManager.addItemToPool("Plasma Cutter", 3.2f, "Ein Hochpräzisionswerkzeug, das zu einer tödlichen Waffe umfunktioniert wurde.", Rarity.RARE, 45.0f, 1.2f, 0.95f);
        itemManager.addItemToPool("Brute Hammer", 7.8f, "Ein massiver Hammer, der langsam aber verheerend ist.", Rarity.UNCOMMON, 80.0f, 0.6f, 0.65f);
        itemManager.addItemToPool("Neon Blade", 2.5f, "Eine blitzschnelle Energieklinge mit mittlerem Schaden.", Rarity.EPIC, 55.0f, 1.8f, 0.88f);
        itemManager.addItemToPool("Pulse Rifle", 4.6f, "Ein taktisches Gewehr mit hoher Genauigkeit und Feuerrate.", Rarity.LEGENDARY, 50.0f, 1.6f, 0.98f);
        itemManager.addItemToPool("Rusty Shiv", 1.1f, "Ein einfaches, aber tödliches Messer aus Altmetall.", Rarity.COMMON, 20.0f, 2.1f, 0.75f);
        itemManager.addItemToPool("EMP Launcher", 5.4f, "Schaltet elektronische Gegner mit einer Hochfrequenzladung aus.", Rarity.MYTHIC, 70.0f, 0.9f, 0.85f);
        itemManager.addItemToPool("Silent Dagger", 1.8f, "Perfekt für lautlose Attentate.", Rarity.RARE, 35.0f, 2.3f, 0.9f);
        itemManager.addItemToPool("Thermal Cannon", 6.9f, "Verschießt konzentrierte Hitzestrahlen, um Gegner zu schmelzen.", Rarity.EPIC, 90.0f, 0.7f, 0.82f);


        // Beispielhafte Interactive Items hinzufügen
        itemManager.addItemToPool("Keycard: Sector 7", 0.1f, "Eine magnetische Schlüsselkarte für Hochsicherheitsbereiche im Sektor 7.", Rarity.UNCOMMON);
        itemManager.addItemToPool("Altes Tagebuch", 1.2f, "Ein ledergebundenes Buch mit verblasstem Schriftzug.", Rarity.RARE);
        itemManager.addItemToPool("Datachip Fragment", 0.05f, "Ein beschädigter Chip mit teilweise lesbaren Informationen.", Rarity.COMMON);
        itemManager.addItemToPool("Mysteriöse Kassette", 0.3f, "Eine alte Tonkassette mit kryptischer Beschriftung.", Rarity.EPIC);
        itemManager.addItemToPool("Antike Schriftrolle", 0.7f, "Mit Symbolen verziert, die niemand mehr entziffern kann.", Rarity.MYTHIC);
        itemManager.addItemToPool("Zugangskarte: Labor Delta", 0.2f, "Erforderlich, um das geheime Forschungslabor zu betreten.", Rarity.LEGENDARY);
        itemManager.addItemToPool("Notizzettel eines Wissenschaftlers", 0.1f, "Zerknitterter Zettel mit Formeln und Warnungen.", Rarity.COMMON);
        itemManager.addItemToPool("Bedienungsanleitung: Energiezelle", 0.4f, "Ein Handbuch zur sicheren Nutzung einer instabilen Energiequelle.", Rarity.UNCOMMON);



        // Beispielhafte Boost Items hinzufügen
        itemManager.addItemToPool("MediGel", 0.5f, "Ein biologisch aktives Gel zur schnellen Wundheilung.", Rarity.COMMON, 25.0f, 0.0f);
        itemManager.addItemToPool("Stimulant: RedRush", 0.3f, "Ein Hochleistungs-Stimulans für schnelle Reaktionen.", Rarity.UNCOMMON, 0.0f, 15.0f);
        itemManager.addItemToPool("NanoBooster X", 0.4f, "Ein fortschrittlicher Injektor, der Zellen blitzschnell regeneriert.", Rarity.RARE, 50.0f, 5.0f);
        itemManager.addItemToPool("Adrenalin Shot", 0.2f, "Sofortiger Energieschub mit leichtem Heilungseffekt.", Rarity.UNCOMMON, 10.0f, 20.0f);
        itemManager.addItemToPool("Cyber-Enhancer: MK-I", 1.0f, "Verbessert temporär Reflexe und Körperfunktionen.", Rarity.EPIC, 30.0f, 25.0f);
        itemManager.addItemToPool("Reboot Serum", 0.6f, "Setzt Vitalfunktionen zurück – nur für Notfälle!", Rarity.LEGENDARY, 75.0f, 10.0f);
        itemManager.addItemToPool("Tactical Snack", 0.1f, "Schmeckt furchtbar, wirkt fantastisch.", Rarity.COMMON, 5.0f, 8.0f);
        itemManager.addItemToPool("Ghost Extract", 0.2f, "Ein geheimnisvoller Extrakt, der dich blitzschnell macht.", Rarity.MYTHIC, 0.0f, 50.0f);
        itemManager.addItemToPool("Regenerationsmodul", 0.7f, "Implantat-Add-on zur automatischen Heilung über Zeit.", Rarity.RARE, 40.0f, 0.0f);



    }
    private static int calculateDamage(WeaponItem weaponItem){
        int damage = 0;
        damage += weaponItem.getDamage();
        int extraDamage = (int) (damage * (weaponItem.getAccuracy() +1));
        damage += new Random().nextInt(damage,extraDamage);
        return damage;


    }
    private static void fight(Entity entity, int enemyHealthLeft){
        System.out.println("(1) Kämpfen (2) Inventar anschauen");
        Scanner scanner = new Scanner(System.in);
        String eingabe = scanner.nextLine();
        if(eingabe.isEmpty()){
            fight(entity,enemyHealthLeft);
            return;

        }
        if(Integer.parseInt(eingabe) == 0){
            fight(entity,enemyHealthLeft);
            return;
        }
        switch (Integer.parseInt(eingabe)){
            case 1:
                int damage = calculateDamage(inventarManager.weaponEquiped);
                System.out.println("Du nutzt die Waffe " + inventarManager.weaponEquiped.getName() + ". ");
                System.out.println("Du machst " + damage + " Schaden!");
                enemyHealthLeft -= damage;
                if (enemyHealthLeft <= 0){
                    System.out.println("Du hast den Gegner " + entity.getName() + " vernichtet.");
                    System.out.println("Du bekommst das Item " + entity.getItem().getName() + ".");
                    inventarManager.addItem(entity.getItem());
                    return;
                }else {
                    System.out.println("Der Gegner macht " + entity.getDamage() + " Schaden.");
                    health-= entity.getDamage();
                    System.out.println("Du hast noch " + health + " Leben übrig.");
                    if(health <= 0){
                        gameOver();
                    }


                    fight(entity,enemyHealthLeft);



                }


                return;

            case 2:
                System.out.println(inventarManager.listItems());
                fight(entity,enemyHealthLeft);
                break;
            default:
                System.out.println("Falsche Eingabe");
                fight(entity,enemyHealthLeft);
        }

    }

}
