package ie.tus;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ie.tus.Hotel.Hotel;
import ie.tus.Hotel.Room;
import ie.tus.Hotel.Staff;

@ManagedBean
@SessionScoped
public class HotelsBean {
    private Hotel BHD_Rose  = new Hotel();
    private Hotel BHD_Mary  = new Hotel();
    private Hotel BHD_Thyme = new Hotel();

    @PostConstruct
    public void init() {
        System.out.println("Hotel init");

        BHD_Rose.setName( "Boutique Hotels of Dublin - Rose");
        BHD_Mary.setName( "Boutique Hotels of Dublin - Mary");
        BHD_Thyme.setName("Boutique Hotels of Dublin - Thyme");
        
        // Assign staff to all the hotels
        
        ArrayList<Staff> hotel_staff = new ArrayList<Staff>();
        hotel_staff.add(new Staff(1, "Esther Carbrey"    , "goodbuffalo63", "esther@gmail.com"       , BHD_Rose));
        hotel_staff.add(new Staff(2, "Christy Erna"      , "scaryskunk37" , "christy@gmail.com"      , BHD_Rose));
        hotel_staff.add(new Staff(3, "Natasja Thorsten"  , "lazydoor40"   , "natasja@gmail.com"      , BHD_Rose));
        hotel_staff.add(new Staff(4, "Ann-Christine Maud", "murkymint90"  , "ann-christine@gmail.com", BHD_Rose));
        hotel_staff.add(new Staff(5, "Inga Liselotte"    , "lumpysneeze63", "inga@gmail.com"         , BHD_Rose));
        BHD_Rose.setStaff(hotel_staff);

        
        hotel_staff = new ArrayList<Staff>();
        hotel_staff.add(new Staff(1, "Jonna Magnus"     , "slowrabbit47", "jonna@gmail.com"   , BHD_Mary));
        hotel_staff.add(new Staff(2, "Damhnait Johannes", "jadebike83"  , "damhnait@gmail.com", BHD_Mary));
        hotel_staff.add(new Staff(3, "Gustav Jörgen"    , "oddangle73"  , "gustav@gmail.com"  , BHD_Mary));
        hotel_staff.add(new Staff(4, "Bernt Asløg"      , "paleyear84"  , "bernt@gmail.com"   , BHD_Mary));
        hotel_staff.add(new Staff(5, "Sture Julius"     , "paleyear84"  , "sture@gmail.com"   , BHD_Mary));
        BHD_Mary.setStaff(hotel_staff);

        
        hotel_staff = new ArrayList<Staff>();
        hotel_staff.add(new Staff(1, "Randi Nicklas"    , "luckysoup35", "randi@gmail.com"   , BHD_Thyme));
        hotel_staff.add(new Staff(2, "Christer Eleonora", "quietjam75" , "christer@gmail.com", BHD_Thyme));
        hotel_staff.add(new Staff(3, "Tom Love"         , "freekey89"  , "tom@gmail.com"     , BHD_Thyme));
        hotel_staff.add(new Staff(4, "Vilma Thomas"     , "amberfish14", "vilma@gmail.com"   , BHD_Thyme));
        hotel_staff.add(new Staff(5, "Embla Loke"       , "tinykite57" , "embla@gmail.com"   , BHD_Thyme));
        BHD_Thyme.setStaff(hotel_staff);


        // Assign rooms to all the hotels
        ArrayList<Room> hotel_rooms = new ArrayList<Room>();
        hotel_rooms.add(new Room(101, "Standard Room", 98, 1, BHD_Rose));
        hotel_rooms.add(new Room(102, "Standard Room", 98, 1, BHD_Rose));
        hotel_rooms.add(new Room(103, "Standard Room", 98, 1, BHD_Rose));
        hotel_rooms.add(new Room(104, "Standard Room", 98, 1, BHD_Rose));
        hotel_rooms.add(new Room(105, "Standard Room", 98, 1, BHD_Rose));

        hotel_rooms.add(new Room(201, "Double Room", 168, 2, BHD_Rose));
        hotel_rooms.add(new Room(202, "Double Room", 168, 2, BHD_Rose));
        hotel_rooms.add(new Room(203, "Double Room", 168, 2, BHD_Rose));
        hotel_rooms.add(new Room(204, "Double Room", 168, 2, BHD_Rose));
        hotel_rooms.add(new Room(205, "Double Room", 168, 2, BHD_Rose));

        hotel_rooms.add(new Room(301, "Executive Room", 398, 1, BHD_Rose));
        hotel_rooms.add(new Room(302, "Executive Room", 398, 1, BHD_Rose));
        hotel_rooms.add(new Room(303, "Executive Room", 398, 1, BHD_Rose));
        hotel_rooms.add(new Room(304, "Executive Room", 398, 1, BHD_Rose));
        hotel_rooms.add(new Room(305, "Executive Room", 398, 1, BHD_Rose));

        hotel_rooms.add(new Room(301, "Suite", 598, 2, BHD_Rose));
        hotel_rooms.add(new Room(302, "Suite", 598, 2, BHD_Rose));
        hotel_rooms.add(new Room(303, "Suite", 598, 2, BHD_Rose));
        hotel_rooms.add(new Room(304, "Suite", 598, 2, BHD_Rose));
        hotel_rooms.add(new Room(305, "Suite", 598, 2, BHD_Rose));
        BHD_Rose.setRooms(hotel_rooms);

        
        hotel_rooms = new ArrayList<Room>();
        hotel_rooms.add(new Room(101, "Standard Room", 98, 1, BHD_Mary));
        hotel_rooms.add(new Room(102, "Standard Room", 98, 1, BHD_Mary));
        hotel_rooms.add(new Room(103, "Standard Room", 98, 1, BHD_Mary));
        hotel_rooms.add(new Room(104, "Standard Room", 98, 1, BHD_Mary));
        hotel_rooms.add(new Room(105, "Standard Room", 98, 1, BHD_Mary));
        
        hotel_rooms.add(new Room(201, "Double Room", 168, 2, BHD_Mary));
        hotel_rooms.add(new Room(202, "Double Room", 168, 2, BHD_Mary));
        hotel_rooms.add(new Room(203, "Double Room", 168, 2, BHD_Mary));
        hotel_rooms.add(new Room(204, "Double Room", 168, 2, BHD_Mary));
        hotel_rooms.add(new Room(205, "Double Room", 168, 2, BHD_Mary));

        hotel_rooms.add(new Room(301, "Executive Room", 398, 1, BHD_Mary));
        hotel_rooms.add(new Room(302, "Executive Room", 398, 1, BHD_Mary));
        hotel_rooms.add(new Room(303, "Executive Room", 398, 1, BHD_Mary));
        hotel_rooms.add(new Room(304, "Executive Room", 398, 1, BHD_Mary));
        hotel_rooms.add(new Room(305, "Executive Room", 398, 1, BHD_Mary));

        hotel_rooms.add(new Room(301, "Suite", 598, 2, BHD_Mary));
        hotel_rooms.add(new Room(302, "Suite", 598, 2, BHD_Mary));
        hotel_rooms.add(new Room(303, "Suite", 598, 2, BHD_Mary));
        hotel_rooms.add(new Room(304, "Suite", 598, 2, BHD_Mary));
        hotel_rooms.add(new Room(305, "Suite", 598, 2, BHD_Mary));
        BHD_Mary.setRooms(hotel_rooms);


        hotel_rooms = new ArrayList<Room>();
        hotel_rooms.add(new Room(101, "Standard Room", 98, 1, BHD_Thyme));
        hotel_rooms.add(new Room(102, "Standard Room", 98, 1, BHD_Thyme));
        hotel_rooms.add(new Room(103, "Standard Room", 98, 1, BHD_Thyme));
        hotel_rooms.add(new Room(104, "Standard Room", 98, 1, BHD_Thyme));
        hotel_rooms.add(new Room(105, "Standard Room", 98, 1, BHD_Thyme));

        hotel_rooms.add(new Room(201, "Double Room", 168, 2, BHD_Thyme));
        hotel_rooms.add(new Room(202, "Double Room", 168, 2, BHD_Thyme));
        hotel_rooms.add(new Room(203, "Double Room", 168, 2, BHD_Thyme));
        hotel_rooms.add(new Room(204, "Double Room", 168, 2, BHD_Thyme));
        hotel_rooms.add(new Room(205, "Double Room", 168, 2, BHD_Thyme));

        hotel_rooms.add(new Room(301, "Executive Room", 398, 1, BHD_Thyme));
        hotel_rooms.add(new Room(302, "Executive Room", 398, 1, BHD_Thyme));
        hotel_rooms.add(new Room(303, "Executive Room", 398, 1, BHD_Thyme));
        hotel_rooms.add(new Room(304, "Executive Room", 398, 1, BHD_Thyme));
        hotel_rooms.add(new Room(305, "Executive Room", 398, 1, BHD_Thyme));

        hotel_rooms.add(new Room(301, "Suite", 598, 2, BHD_Thyme));
        hotel_rooms.add(new Room(302, "Suite", 598, 2, BHD_Thyme));
        hotel_rooms.add(new Room(303, "Suite", 598, 2, BHD_Thyme));
        hotel_rooms.add(new Room(304, "Suite", 598, 2, BHD_Thyme));
        hotel_rooms.add(new Room(305, "Suite", 598, 2, BHD_Thyme));
        BHD_Thyme.setRooms(hotel_rooms);
    }

    public Hotel getBHD_Mary() {
        return BHD_Mary;
    }
    public Hotel getBHD_Rose() {
        return BHD_Rose;
    }
    public Hotel getBHD_Thyme() {
        return BHD_Thyme;
    }
    public ArrayList<Room> getAvailableRooms(String hotel, String date) {
        if (hotel.equals("Rose") || hotel.equals("BHD_Rose") || hotel.equals("BHD Rose")) {
            return BHD_Rose.getAvailableRooms(date);
        } else if (hotel.equals("Thyme") || hotel.equals("BHD_Thyme") || hotel.equals("BHD Thyme")) {
            return BHD_Thyme.getAvailableRooms(date);
        } else if (hotel.equals("Mary") || hotel.equals("BHD_Mary") || hotel.equals("BHD Mary")) {
            return BHD_Mary.getAvailableRooms(date);
        } else {
            return null;
        }        
    }
    public ArrayList<Room> getAvailableRooms(Hotel hotel, String date) {
        return hotel.getAvailableRooms(date);
    }
    public ArrayList<Room> getAvailableRooms(Hotel hotel, LocalDate date) {
        return hotel.getAvailableRooms(date);
    }
}