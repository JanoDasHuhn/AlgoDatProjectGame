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
    private Encounter getRandomEncounterByType(RoomType roomType,int index){
        switch (roomType){
            default:
            case NEUTRAL:
                return encounterUtilByType(EntityType.NEUTRAL,index);
            case BAD:
               return encounterUtilByType(EntityType.EVIL,index);
            case GOOD:
                return encounterUtilByType(EntityType.GOOD,index);
        }

    }
    public Encounter getRandomEncounter(RoomType roomType,int index){
        return getRandomEncounterByType(roomType,index);
    }

    public void updateEnemies(int room) {
        for (Encounter encounter : getEncounters()){
            if(encounter instanceof Entity entity){
                entity.boostStats(room);
            }
        }
    }
    private Encounter encounterUtilByType(EntityType entityType,int index){
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
