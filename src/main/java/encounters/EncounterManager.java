package encounters;

import rooms.RoomType;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse {@code EncounterManager} verwaltet eine Liste von Encountern.
 * Sie ermöglicht das Hinzufügen, Abrufen und Filtern von Encountern nach Typ.
 * Zudem können die Stats der Enemies entsprechend angepasst werden.
 *
 * @author janis
 */
public class EncounterManager {
    /** Die Liste aller Encounter-Objekte */
    private final List<Encounter> encounters;

    /**
     * Konstruktor für {@code EncounterManager}.
     * Erstellt eine leere Liste von Encountern.
     */
    public EncounterManager(){
        encounters = new ArrayList<>();
    }

    /**
     * Gibt die Liste aller Encounter zurück.
     *
     * @return Liste der Encounter
     */
    public List<Encounter> getEncounters() {
        return encounters;
    }

    /**
     * Fügt einen neuen Encounter zur Liste hinzu.
     *
     * @param encounter Das Encounter-Objekt, das hinzugefügt werden soll
     */
    public void addEncounter(Encounter encounter){
        encounters.add(encounter);
    }

    /**
     * Gibt das Encounter an der angegebenen Position zurück.
     * Wenn kein Encounter vorhanden ist, wird das erste Encounter zurückgegeben.
     *
     * @param i Index des Encounters
     * @return Das entsprechende Encounter-Objekt
     */
    public Encounter getEncounter(int i){
        if(encounters.get(i) == null){
            return encounters.getFirst();
        }
        return encounters.get(i);
    }

    /**
     * Gibt ein zufälliges Encounter eines bestimmten Raum-Typs zurück.
     * Interne Hilfsmethode, wird von {@link #getRandomEncounter(RoomType, int)} verwendet.
     *
     * @param roomType Der Raum-Typ, nach dem gefiltert werden soll
     * @param index Der Index des Encounters innerhalb des Typs
     * @return Ein zufälliges Encounter des gewünschten Typs
     */
    private Encounter getRandomEncounterByType(RoomType roomType, int index){
        switch (roomType){
            default:
            case NEUTRAL:
                return encounterUtilByType(EntityType.NEUTRAL, index);
            case BAD:
                return encounterUtilByType(EntityType.EVIL, index);
            case GOOD:
                return encounterUtilByType(EntityType.GOOD, index);
        }
    }

    /**
     * Gibt ein zufälliges Encounter eines bestimmten Raum-Typs zurück.
     *
     * @param roomType Der Typ des Raums (z.B. GOOD, BAD, NEUTRAL)
     * @param index Index des gewünschten Encounters innerhalb des Typs
     * @return Das passende Encounter-Objekt
     */
    public Encounter getRandomEncounter(RoomType roomType, int index){
        return getRandomEncounterByType(roomType, index);
    }

    /**
     * Aktualisiert die Stats aller {@link Entity}-Encounters abhängig vom Raum.
     *
     * @param room Die aktuelle Raumzahl zur Berechnung der Stat-Verbesserung
     */
    public void updateEnemies(int room) {
        for (Encounter encounter : getEncounters()){
            if(encounter instanceof Entity entity){
                entity.boostStats(room);
            }
        }
    }

    /**
     * Filtert und gibt ein Encounter eines bestimmten Entity-Typs und Index zurück.
     *
     * @param entityType Der Typ der Entität (z.B. GOOD, EVIL, NEUTRAL)
     * @param index Der Index innerhalb der gefilterten Liste
     * @return Das entsprechende Encounter-Objekt
     */
    private Encounter encounterUtilByType(EntityType entityType, int index){
        List<Encounter> encounterList1 = new ArrayList<>();
        for (Encounter encounter : encounters){
            if(encounter instanceof Entity entity){
                if(entity.getEntityType() == entityType){
                    encounterList1.add(entity);
                }
            }
        }
        return encounterList1.get(index);
    }
}
