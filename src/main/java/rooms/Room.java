package rooms;

public class Room {
    private String name;
    private String description;
    private RoomType roomType;

    public Room(String name, String description, RoomType roomType){
        this.name = name;
        this.description = description;
        this.roomType = roomType;
    }
    public String getName() {
        return name;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public String getDescription() {
        return description;
    }

}
