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
        rooms.add(new Room("Mensa","Du endeckst eine alte Mensa! vielleicht wirst du hier was Essbares finden!",RoomType.GOOD));
        rooms.add(new Room("Zellenblock","Du findest einen alten Zellenblock! Hier steckt schon lange keiner mehr fest.",RoomType.NEUTRAL));
        rooms.add(new Room("Wartungsstation","Eine Alte Roboter Wartestation erscheint! Sei auf der Hut....",RoomType.BAD));
        rooms.add(new Room("Gefängnis","Du siehst vor dir ein paar alte Zellen, das musss ein altes gefängnis sein",RoomType.BAD));
        rooms.add(new Room("Labor","Ein altes Labor voller verstaubter Geräte. Vielleicht findest du nützliche Ausrüstung.", RoomType.GOOD));
        rooms.add(new Room("Lagerraum","Du betrittst einen dunklen Lagerraum. Kisten sind überall verstreut.", RoomType.NEUTRAL));
        rooms.add(new Room("Kommandozentrale","Du stehst in einer ehemaligen Kommandozentrale. Alles wirkt verlassen, aber funktionsfähig.", RoomType.GOOD));
        rooms.add(new Room("Belüftungsschacht","Ein enger Belüftungsschacht. Es ist stickig und du hörst seltsame Geräusche.", RoomType.BAD));
        rooms.add(new Room("Waschraum","Ein alter Waschraum, modrig und leer. Aber nichts Gefährliches scheint hier zu sein.", RoomType.NEUTRAL));
        rooms.add(new Room("Reaktorkammer","Du findest den Reaktorraum – die Luft flimmert und es riecht nach Gefahr.", RoomType.BAD));



    }
    public Room getRandomRoom(int i){
        Random random = new Random();

        return rooms.get(i);

    }
}
