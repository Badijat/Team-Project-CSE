package ie.tus;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CheckoutBean {
    private String guestName;
    private String roomNumber;
    private String checkOutDate;

    // Getter and Setter methods for guestName, roomNumber, and checkOutDate

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    // Method to handle the Check Out button action
    public String checkOut() {
        // Add your logic here to process the form data
        // For demonstration purposes, we'll just print the data to the console
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Check-Out Date: " + checkOutDate);

        // You can also perform any database operations or other business logic here

        // After processing the data, you can navigate to another page or stay on the same page
        // For this example, we'll stay on the same page
        return "checkout-success";
    }
}
