package rooms;

import java.util.ArrayList;
import java.util.Random;

public class RoomManager {
    private ArrayList<Room> rooms;


    public RoomManager(){
        rooms = new ArrayList<>();
        generateRooms();
    }
    private void generateRooms(){
        rooms.add(new Room("Mensa","Du endeckst eine alte Mensa! vielleicht wirst du hier was essbares finden!",RoomType.GOOD));
        rooms.add(new Room("Zellenblock","Du findest einen alten Zellenblock! Hier steckt schon lange keiner mehr fest.",RoomType.NEUTRAL));
        rooms.add(new Room("Wartungsstation","Eine Alte Roboter Wartestation erscheint! Sei auf der Hut....",RoomType.BAD));


    }
    public Room getRandomRoom(){
        Random random = new Random();
        int roomID = random.nextInt(0, rooms.size());
        return rooms.get(roomID);

    }
}
