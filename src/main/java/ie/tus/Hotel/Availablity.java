package ie.tus.Hotel;

import ie.tus.User;

public class Availablity {
    public static final int AVAILABLE = 0;     
    public static final int BOOKED    = 1; 

    public int status = 0;

    // Guest who booked the room
    public User guest;

    @Override   
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass()!= o.getClass()) {
            return false;
        }

        Availablity that = (Availablity) o;

        return that.status == this.status &&  
            ((this.guest == null && that.guest == null) ||
            (this.guest != null && that.guest != null && that.guest.equals(this.guest)));
    }
}
