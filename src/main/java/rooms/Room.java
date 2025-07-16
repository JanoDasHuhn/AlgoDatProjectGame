package rooms;

/**
 * Die Klasse {@code Room} repräsentiert einen Raum im Spiel.
 * Ein Raum hat einen Namen, eine Beschreibung und einen Raumtyp.
 */
public class Room {
    /** Der Name des Raums */
    private String name;

    /** Die Beschreibung des Raums */
    private String description;

    /** Der Typ des Raums (z.B. GOOD, NEUTRAL, BAD) */
    private RoomType roomType;

    /**
     * Erstellt einen neuen Raum mit Namen, Beschreibung und Raumtyp.
     *
     * @param name        Der Name des Raums
     * @param description Die Beschreibung des Raums
     * @param roomType    Der Typ des Raums
     */
    public Room(String name, String description, RoomType roomType){
        this.name = name;
        this.description = description;
        this.roomType = roomType;
    }

    /**
     * Gibt den Namen des Raums zurück.
     *
     * @return Der Name des Raums
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt den Typ des Raums zurück.
     *
     * @return Der Typ des Raums
     */
    public RoomType getRoomType() {
        return roomType;
    }

    /**
     * Gibt die Beschreibung des Raums zurück.
     *
     * @return Die Beschreibung des Raums
     */
    public String getDescription() {
        return description;
    }
}
