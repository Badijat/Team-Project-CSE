package ie.tus.Hotel;

public class RoomType {
    private String roomName;
    private float price;
    private int occupancy;

    public RoomType(String roomName, float price, int occupancy) {
        this.roomName = roomName;
        this.price = price;
        this.occupancy = occupancy;
    }

    public RoomType() {
        this.roomName = "";
        this.price = -1;
        this.occupancy = -1;
    }

    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getOccupancy() {
        return occupancy;
    }
    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    @Override   
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass()!= o.getClass()) {
            return false;
        }

        RoomType that = (RoomType) o;

        return that.price == this.price && 
            that.occupancy == this.occupancy &&
            (   (this.roomName == null && that.roomName == null) ||
                (this.roomName != null && that.roomName != null && this.roomName.equals(that.roomName)));
    }
}
