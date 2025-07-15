package encounters;

import rooms.RoomType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EncounterManager {
    private final List<Encounter> encounters;

    public EncounterManager(){
        encounters = new ArrayList<>();
    }
    public List<Encounter> getEncounters() {
        return encounters;
    }
    public void addEncounter(Encounter encounter){
        encounters.add(encounter);

    }
    public Encounter getEncounter(int i){
        if(encounters.get(i) == null){
            return  encounters.getFirst();
        }
        return encounters.get(i);

    }
    private Encounter getRandomEncounterByType(RoomType roomType){
        switch (roomType){
            default:
            case NEUTRAL:
                return encounterUtilByType(EntityType.NEUTRAL);
            case BAD:
               return encounterUtilByType(EntityType.EVIL);
            case GOOD:
                return encounterUtilByType(EntityType.GOOD);
        }

    }
    public Encounter getRandomEncounter(RoomType roomType){
        return getRandomEncounterByType(roomType);
    }

    public void updateEnemies(int room) {
        for (Encounter encounter : getEncounters()){
            if(encounter instanceof Entity entity){
                entity.boostStats(room);
            }
        }
    }
    private Encounter encounterUtilByType(EntityType entityType){
        List<Encounter> encounterList1 = new ArrayList<>();
        for (Encounter encounter : encounters){
            if(encounter instanceof Entity entity){
                if(entity.getEntityType() == entityType){
                    encounterList1.add(entity);

                }
            }
        }
        return encounterList1.get(new Random().nextInt(0,encounterList1.size()));

    }
}
