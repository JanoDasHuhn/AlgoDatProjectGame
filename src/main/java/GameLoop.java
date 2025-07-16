
import Seedstuff.Seedreader;
import encounters.Encounter;
import encounters.EncounterManager;
import encounters.Entity;
import encounters.EntityType;
import inventar.InventarManager;
import inventar.items.*;

import rooms.Room;
import rooms.RoomManager;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
/**
 * Main Klasse des Spieles
 * @author Janis
 */
public class GameLoop {

    /** Verwalter für alle Räume im Spiel */
    static RoomManager roomManager;

    /** Verwalter für die Seed-basierten Zufallszahlen */
    static Seedreader seedreader;

    /** Verwalter für das Inventar des Spielers */
    static InventarManager inventarManager;

    /** Verwalter für alle Items im Spiel */
    static ItemManager itemManager;

    /** Verwalter für alle Encounters im Spiel */
    static EncounterManager encounterManager;

    /** Die aktuellen Lebenspunkte des Spielers */
    static int health = 100;

    /** Die aktuelle Raum-Nummer */
    static int room = 0;

    /** Gibt an, ob das Spiel noch läuft */
    static boolean isRunning = true;

    /**Main Methode die das Programm startet**/
    public static void main(String[] args) {


        setup();




    }
    /**
     * setup methode, bei spiel neustart wird sie ausgerufen**/
    private static void setup(){
        roomManager = new RoomManager();
        inventarManager = new InventarManager();
        itemManager = new ItemManager();
        encounterManager = new EncounterManager();
        seedreader = new Seedreader();
        addItems();

        addEncounters();
        inventarManager.weaponEquiped = new WeaponItem("Hände", 0.0f, Rarity.COMMON, "Deine bloßen Hände", 5.0f, 0.0f, 0.9f);
        health = 100;
        room = 0;
        System.out.println("Seed(-) generieren oder (1)eingeben?");
        Scanner scanner = new Scanner(System.in);
        String eingabe = scanner.nextLine();
        if(!eingabe.isEmpty()){
            switch (Integer.parseInt(eingabe)) {
                case 1:
                    System.out.println("Bitte Seed (eine Zahl unter 30000) eingeben");
                    int seed = scanner.nextInt();
                    seedreader.setPosition(seed);
                    break;

                default:
                    System.out.println("Seed wird generiert");
                    Random rand = new Random();
                    int randomNumber = rand.nextInt(30000) + 1; // 1 bis 30000 (inklusive)
                    System.out.println("Seed: " + randomNumber);
                    seedreader.setPosition(randomNumber);
                    break;
            }}
        else {
            System.out.println("Seed wird generiert");
            Random rand = new Random();
            int randomNumber = rand.nextInt(30000) + 1; // 1 bis 30000 (inklusive)
            System.out.println("Seed: " + randomNumber);
            seedreader.setPosition(randomNumber);

        }
        while (isRunning) {

            Room roomOffer1 = roomManager.getRandomRoom(seedreader.zeroninereader());
            Room roomOffer2 = roomManager.getRandomRoom(seedreader.zeroninereader());
            Room chosenRoom = roomOffer1;

            System.out.println("Raum: " + room);
            System.out.println("Raum Links: " + roomOffer1.getName() + " Klassifikation: " + roomOffer1.getRoomType().toString());
            System.out.println("Raum Rechts: " + roomOffer2.getName() + " Klassifikation: " + roomOffer2.getRoomType().toString());
            System.out.println("(-) " +roomOffer1.getName() + " (1) " + roomOffer2.getName());
            Scanner scanner1 = new Scanner(System.in);
            String eingabe1 = scanner1.nextLine();
            if (!Objects.equals(eingabe1, "1")){
                chosenRoom = roomOffer1;
            }
            System.out.println(chosenRoom.getDescription());
            handleEncounter(chosenRoom);
            room++;
            encounterManager.updateEnemies(room);

        }


    }

        /**
        füllt den encounterManager mit Encounters
        * */

        private static void addEncounters () {
            encounterManager.addEncounter(new Entity("Dorfbewohner", "Du findest einen Dorfbewohner", Rarity.COMMON, 20, EntityType.GOOD, 0, itemManager.getItem(2)));
            encounterManager.addEncounter(new Entity("Sanfte MedBot", "Ein MedBot bietet dir eine kostenlose Behandlung an", Rarity.UNCOMMON, 50, EntityType.GOOD, 0, itemManager.getItem(4)));
            encounterManager.addEncounter(new Entity("Wandernder Mönch", "Ein Mönch reicht dir still einen Energiebooster", Rarity.RARE, 30, EntityType.GOOD, 0, itemManager.getItem(5)));
            encounterManager.addEncounter(new Entity("Straßenkünstler", "Ein Künstler schenkt dir ein Bild, das Mut macht", Rarity.COMMON, 15, EntityType.GOOD, 0, itemManager.getItem(6)));
            encounterManager.addEncounter(new Entity("Veteran der Rebellion", "Ein älterer Soldat teilt mit dir wertvolle Ausrüstung", Rarity.UNCOMMON, 60, EntityType.GOOD, 0, itemManager.getItem(7)));
            encounterManager.addEncounter(new Entity("Mechanikerin", "Sie bietet an, deine Ausrüstung kostenlos zu reparieren", Rarity.RARE, 40, EntityType.GOOD, 0, itemManager.getItem(8)));
            encounterManager.addEncounter(new Entity("Kinderbande", "Eine Gruppe neugieriger Kinder teilt mit dir Infos über die Gegend", Rarity.COMMON, 10, EntityType.GOOD, 0, itemManager.getItem(9)));
            encounterManager.addEncounter(new Entity("Cyber-Mönch", "Er segnet deine Implantate, was deine Werte kurzzeitig erhöht", Rarity.EPIC, 20, EntityType.GOOD, 0, itemManager.getItem(11)));
            encounterManager.addEncounter(new Entity("Verletzter Helfer", "Trotz seiner Wunden reicht er dir ein wertvolles MedKit", Rarity.UNCOMMON, 30, EntityType.GOOD, 0, itemManager.getItem(19)));
            encounterManager.addEncounter(new Entity("Wächter der Untergrundbahn", "Ein geheimnisvoller Wächter lässt dich ungehindert durch", Rarity.LEGENDARY, 100, EntityType.GOOD, 0, itemManager.getItem(20)));

            encounterManager.addEncounter(new Entity("Böser Roboter", "Ein Roboter erscheint und greift dich an", Rarity.RARE, 200, EntityType.EVIL, 200, itemManager.getItem(3)));
            encounterManager.addEncounter(new Entity("Straßengang-Mitglied", "Ein bewaffneter Typ mit Neonmaske stellt sich dir in den Weg", Rarity.UNCOMMON, 35, EntityType.EVIL, 2, itemManager.getItem(12)));
            encounterManager.addEncounter(new Entity("Cyber-Ninja", "Aus dem Schatten springt ein Cyber-Ninja mit Klingenarmen", Rarity.EPIC, 60, EntityType.EVIL, 4, itemManager.getItem(15)));
            encounterManager.addEncounter(new Entity("CorpSec-Drohne", "Eine bewaffnete Überwachungsdrohne scannt dein Gesicht", Rarity.COMMON, 15, EntityType.EVIL, 2, itemManager.getItem(17)));
            encounterManager.addEncounter(new Entity("Elite-Killer", "Ein Auftragsmörder versucht, dich lautlos auszuschalten", Rarity.EPIC, 90, EntityType.EVIL, 10, itemManager.getItem(21)));
            encounterManager.addEncounter(new Entity("Mutierter Hund", "Ein entstelltes Biest knurrt dich an – es hat Hunger", Rarity.UNCOMMON, 45, EntityType.EVIL, 5, itemManager.getItem(22)));
            encounterManager.addEncounter(new Entity("Corp-Agent", "Ein Agent der Megacorp will deine Daten um jeden Preis", Rarity.RARE, 50, EntityType.EVIL, 6, itemManager.getItem(23)));
            encounterManager.addEncounter(new Entity("Schwarzer Netzhai", "Ein Hacker-Killer aus dem Darknet greift dein Implantat an", Rarity.EPIC, 40, EntityType.EVIL, 7, itemManager.getItem(24)));
            encounterManager.addEncounter(new Entity("Widerstandsloser Berserker", "Er schreit und stürzt sich blind auf alles, was sich bewegt", Rarity.UNCOMMON, 70, EntityType.EVIL, 8, itemManager.getItem(25)));
            encounterManager.addEncounter(new Entity("Kultanhänger", "Ein fanatischer Anhänger einer dunklen Tech-Religion greift dich an", Rarity.RARE, 60, EntityType.EVIL, 9, itemManager.getItem(26)));

            encounterManager.addEncounter(new Entity("Ratte", "Eine Ratte erscheint, sie scheint dich nicht anzugreifen", Rarity.COMMON, 100, EntityType.NEUTRAL, 2, itemManager.getItem(10)));
            encounterManager.addEncounter(new Entity("Defekter Servitor", "Ein defekter Servitor taumelt auf dich zu, seine Systeme glühen rot", Rarity.COMMON, 25, EntityType.NEUTRAL, 1, itemManager.getItem(13)));
            encounterManager.addEncounter(new Entity("Datenbroker", "Ein zwielichtiger Broker bietet dir gegen Bezahlung Informationen an", Rarity.RARE, 10, EntityType.NEUTRAL, 0, itemManager.getItem(14)));
            encounterManager.addEncounter(new Entity("Implantat-Schmuggler", "Ein Typ mit überladenem Cyberarm bietet dir ein Upgrade – gegen deinen Arm", Rarity.UNCOMMON, 20, EntityType.NEUTRAL, 1, itemManager.getItem(16)));
            encounterManager.addEncounter(new Entity("Verirrter Hacker", "Ein Hacker erscheint plötzlich – sein Mind scheint halb im Netz gefangen zu sein", Rarity.RARE, 20, EntityType.NEUTRAL, 3, itemManager.getItem(18)));
            encounterManager.addEncounter(new Entity("Schattenbeobachter", "Du wirst beobachtet, aber der Beobachter verschwindet wieder", Rarity.UNCOMMON, 10, EntityType.NEUTRAL, 0, itemManager.getItem(27)));
            encounterManager.addEncounter(new Entity("Straßenprediger", "Er hält eine feurige Rede, die dich zum Nachdenken bringt", Rarity.COMMON, 5, EntityType.NEUTRAL, 0, itemManager.getItem(28)));
            encounterManager.addEncounter(new Entity("Mutierte Katze", "Eine verstörende Katze kreuzt deinen Weg, sie wirkt intelligent", Rarity.COMMON, 10, EntityType.NEUTRAL, 1, itemManager.getItem(29)));
            encounterManager.addEncounter(new Entity("Neutraler KI-Kern", "Eine KI möchte eine Diskussion führen, ohne Absicht zu handeln", Rarity.RARE, 20, EntityType.NEUTRAL, 0, itemManager.getItem(30)));
            encounterManager.addEncounter(new Entity("Unbekannter Wanderer", "Er ignoriert dich komplett und geht weiter", Rarity.UNCOMMON, 30, EntityType.NEUTRAL, 0, itemManager.getItem(31)));


        }
        /**
        Dialog des encounters
        @param chosenRoom Der Ausgewählte Room wo der Gegner bestimmt wird welcher "spawnen" soll
        * */
        private static void handleEncounter (Room chosenRoom) {
            Encounter encounter = encounterManager.getRandomEncounter(chosenRoom.getRoomType(),seedreader.zeroninereader());
            System.out.println("\n");
            System.out.println(encounter.getName() + "\n");
            System.out.println(encounter.getDesc() + ".\n");

            System.out.println("Was willst du machen?");
            if (encounter instanceof Entity) {
                Entity entity = (Entity) encounter;
                switch (entity.getEntityType()) {
                    case GOOD:
                        handleGood(entity);
                        break;
                    case NEUTRAL:
                        handleNeutral(entity);
                        break;
                    case EVIL:
                        handleEvil(entity);
                        break;
                }
            }


        }

        /**
        Mini Methode für Entities des Evil typs
        @param entity Die Evil Entity
        * */
        private static void handleEvil (Entity entity){
            fight(entity, entity.getHealth());
        }
        /**
        Beendet das Spiel und startet es neu
        * */
        private static void gameOver () {
            System.out.println("Du hast verloren");
            isRunning = false;
            setup();
        }
             /**
            Methode für Entities des Neutral typs kpmmert sich um dialog Optionen
            @param entity Die Neutral Entity
            * */
        private static void handleNeutral (Entity entity){
            System.out.println("(1) Ein Boost-Item anbieten (2) Kämpfen (3) Inventar anschauen");

            Scanner scanner = new Scanner(System.in);
            String eingabe = scanner.nextLine();

            if (eingabe.isEmpty()) {
                return;

            }
            if (Integer.parseInt(eingabe) == 0) {
                return;
            }

            switch (Integer.parseInt(eingabe)) {
                case 1:
                    boolean foundBoost = false;
                    for (Item item : inventarManager.getInventar().keySet()) {
                        if (item instanceof BoostItem) {
                            System.out.println("Du gibt " + entity.getName() + " das Item " + item.getName() + ".");
                            inventarManager.subtractItem(item);
                            System.out.println("Du darfst weiter gehen!");
                            foundBoost = true;
                            break;
                        }
                    }
                    if (foundBoost == false) {
                        System.out.println("Du hast leider keine Boost Items.");
                        fight(entity, entity.getHealth());
                    }

                    return;
                case 2:
                    fight(entity,entity.getHealth());
                case 3:
                    System.out.println(inventarManager.listItems());
                    handleNeutral(entity);
                    break;
                default:
                    System.out.println("Falsche Eingabe");
                    handleNeutral(entity);
            }
        }
     /**
    Methode für Entities des Good typs kpmmert sich um dialog Optionen
    @param entity Die Good Entity
    * */

    static void handleGood(Entity entity) {
        System.out.println("(1) Interagieren (2) Inventar anschauen");
        Scanner scanner = new Scanner(System.in);
        String eingabe = scanner.nextLine();
        if (eingabe.isEmpty()) {
            return;

        }
        if (Integer.parseInt(eingabe) == 0) {
            return;
        }
        switch (Integer.parseInt(eingabe)) {
            case 1:
                System.out.println("Du bekommst ein " + entity.getItem().getName() + ".");
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




    /**
   füllt den itemManager mit Items
   * */
        static void addItems () {

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


            itemManager.addItemToPool("Shock Gauntlet", 2.2f, "Ein Handschuh, der bei Kontakt elektrische Schocks auslöst.", Rarity.UNCOMMON, 30.0f, 1.4f, 0.92f);
            itemManager.addItemToPool("Kinetic Fist", 4.0f, "Ein Cyber-Faust-Modul mit explosiver Wucht.", Rarity.RARE, 65.0f, 1.0f, 0.8f);
            itemManager.addItemToPool("Toxic Injector", 1.3f, "Verabreicht ein gefährliches Toxin beim Angriff.", Rarity.RARE, 25.0f, 2.0f, 0.85f);
            itemManager.addItemToPool("Railgun", 8.0f, "Hochgeschwindigkeits-Geschosse durch Magnetfelder beschleunigt.", Rarity.LEGENDARY, 100.0f, 0.8f, 0.99f);
            itemManager.addItemToPool("Laser Scalpel", 0.9f, "Ein chirurgisches Gerät – tödlich, wenn falsch eingesetzt.", Rarity.COMMON, 15.0f, 2.5f, 0.7f);
            itemManager.addItemToPool("Stun Baton", 2.7f, "Betäubt Ziele kurzzeitig bei einem Treffer.", Rarity.UNCOMMON, 25.0f, 1.5f, 0.86f);
            itemManager.addItemToPool("Gravity Axe", 6.5f, "Verbiegt die Schwerkraft beim Zuschlagen.", Rarity.EPIC, 75.0f, 0.8f, 0.89f);
            itemManager.addItemToPool("Photon Saber", 3.3f, "Kompakte Lichtklinge für Nahkämpfer.", Rarity.MYTHIC, 60.0f, 1.9f, 0.94f);
            itemManager.addItemToPool("Nano-Dart Gun", 2.1f, "Feuert Mikrodarts mit Gift, Tracking oder EMP.", Rarity.RARE, 30.0f, 2.2f, 0.91f);
            itemManager.addItemToPool("Buzz Saw Arm", 5.0f, "Eine Kreissäge statt eines Arms – rustikal aber effektiv.", Rarity.UNCOMMON, 55.0f, 1.0f, 0.7f);
            itemManager.addItemToPool("Holo Decoy", 1.0f, "Ablenker, kein Schaden – erzeugt eine Projektion.", Rarity.RARE, 0.0f, 0.0f, 1.0f);
            itemManager.addItemToPool("Drone Controller", 3.7f, "Erlaubt dir, eine Mini-Drohne zur Unterstützung zu rufen.", Rarity.EPIC, 40.0f, 1.4f, 0.93f);
            itemManager.addItemToPool("Neural Disruptor", 2.8f, "Stört temporär die Nerven des Ziels.", Rarity.RARE, 28.0f, 1.5f, 0.84f);
            itemManager.addItemToPool("Implant Spike", 0.6f, "Ein Werkzeug zur Sabotage von Cyberware.", Rarity.COMMON, 10.0f, 2.4f, 0.65f);
            itemManager.addItemToPool("Cryo Grenade", 1.5f, "Friert Gegner im Umkreis für kurze Zeit ein.", Rarity.UNCOMMON, 40.0f, 0.5f, 0.75f);
            itemManager.addItemToPool("Mag-Claw", 2.0f, "Mechanische Greifklaue mit hoher Zugkraft.", Rarity.UNCOMMON, 35.0f, 1.3f, 0.77f);
            itemManager.addItemToPool("Firewall Wand", 3.9f, "Erzeugt ein digitales Schutzfeld gegen Angriffe.", Rarity.EPIC, 0.0f, 0.0f, 1.0f);
            itemManager.addItemToPool("Street Mod Kit", 2.6f, "Upgrade für improvisierte Waffen oder Implantate.", Rarity.RARE, 0.0f, 0.0f, 1.0f);
            itemManager.addItemToPool("Molotov Cluster", 1.9f, "Selbstgebaute Brandladung mit Splitterwirkung.", Rarity.UNCOMMON, 45.0f, 0.7f, 0.72f);
            itemManager.addItemToPool("Grapple Hook", 3.0f, "Taktisches Werkzeug zur schnellen Fortbewegung.", Rarity.COMMON, 0.0f, 0.0f, 1.0f);
            itemManager.addItemToPool("Mind Leech", 2.3f, "Zieht Daten und Energie vom Ziel ab.", Rarity.EPIC, 35.0f, 1.2f, 0.88f);
            itemManager.addItemToPool("Antimaterie-Bolzen", 4.2f, "Zerstörerisches Projektil mit minimaler Streuung.", Rarity.MYTHIC, 120.0f, 0.5f, 0.99f);
            itemManager.addItemToPool("Echo Blaster", 3.6f, "Feuert Schallwellen mit starker Rückstoßkraft.", Rarity.RARE, 42.0f, 1.1f, 0.8f);


        }
    /**
       berechnet Schaden anhand von Waffe
       @param weaponItem die Waffe
       @return den Schaden der Waffe
       * */
    private static int calculateDamage(WeaponItem weaponItem){
        int damage = 0;
        damage += weaponItem.getDamage();
        int extraDamage = (int) (damage * (weaponItem.getAccuracy() +1));
        damage += new Random().nextInt(damage,extraDamage);
        return damage;


    }
    /**
     * Kampf dialog Methode
     * @param entity Die Entity die beämpft wird
     * @param enemyHealthLeft Wie viel Leben die Entity übrig hat
     *
    **/
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

