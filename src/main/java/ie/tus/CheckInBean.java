package ie.tus;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class CheckInBean implements Serializable {

    private String customerName;
    private String roomNumber;
    private String checkInDate;

    // Getter and Setter methods for customerName, roomNumber, and checkInDate

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    // Method to handle the Check In button action
    public String checkIn() {
        // Add your logic here to process the form data
        // For demonstration purposes, we'll just print the data to the console
        System.out.println("Customer Name: " + customerName);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Check-In Date: " + checkInDate);

        // You can also perform any database operations or other business logic here

        // After processing the data, you can navigate to another page or stay on the same page
        // For this example, we'll stay on the same page
        return "checkIn-success";
    }
}
