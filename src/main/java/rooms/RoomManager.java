package rooms;

import java.util.ArrayList;
import java.util.Random;

/**
 * Die Klasse {@code RoomManager} verwaltet eine Liste aller Räume im Spiel. Sie kann neue Räume
 * generieren und einzelne Räume abrufen.
 */
public class RoomManager {
  /** Die Liste aller Räume */
  private ArrayList<Room> rooms;

  /**
   * Konstruktor für {@code RoomManager}. Initialisiert die Raumliste und füllt sie mit vorgegebenen
   * Räumen.
   */
  public RoomManager() {
    rooms = new ArrayList<>();
    generateRooms();
  }

  /**
   * Erstellt und fügt vordefinierte Räume zur Liste hinzu.
   */
  private void generateRooms() {
    rooms.add(new Room("Mensa",
        "Du endeckst eine alte Mensa! vielleicht wirst du hier was Essbares finden!",
        RoomType.GOOD));
    rooms.add(new Room("Zellenblock",
        "Du findest einen alten Zellenblock! Hier steckt schon lange keiner mehr fest.",
        RoomType.NEUTRAL));
    rooms.add(new Room("Wartungsstation",
        "Eine alte Roboter-Wartestation erscheint! Sei auf der Hut...", RoomType.BAD));
    rooms.add(new Room("Gefängnis",
        "Du siehst vor dir ein paar alte Zellen, das muss ein altes Gefängnis sein.",
        RoomType.BAD));
    rooms.add(new Room("Labor",
        "Ein altes Labor voller verstaubter Geräte. Vielleicht findest du nützliche Ausrüstung.",
        RoomType.GOOD));
    rooms.add(new Room("Lagerraum",
        "Du betrittst einen dunklen Lagerraum. Kisten sind überall verstreut.", RoomType.NEUTRAL));
    rooms.add(new Room("Kommandozentrale",
        "Du stehst in einer ehemaligen Kommandozentrale. Alles wirkt verlassen, aber funktionsfähig.",
        RoomType.GOOD));
    rooms.add(new Room("Belüftungsschacht",
        "Ein enger Belüftungsschacht. Es ist stickig und du hörst seltsame Geräusche.",
        RoomType.BAD));
    rooms.add(new Room("Waschraum",
        "Ein alter Waschraum, modrig und leer. Aber nichts Gefährliches scheint hier zu sein.",
        RoomType.NEUTRAL));
    rooms.add(new Room("Reaktorkammer",
        "Du findest den Reaktorraum – die Luft flimmert und es riecht nach Gefahr.", RoomType.BAD));
  }

  /**
   * Gibt den Raum am angegebenen Index zurück.
   *
   * @param i Der Index des Raums
   * @return Das entsprechende {@link Room}-Objekt
   */
  public Room getRandomRoom(int i) {
    return rooms.get(i);
  }
}
