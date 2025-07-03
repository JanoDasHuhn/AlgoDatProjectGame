package encounters;

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
    public Encounter getRandomEncounter(){
        return getEncounter(new Random().nextInt(0,encounters.size()));
    }
}
