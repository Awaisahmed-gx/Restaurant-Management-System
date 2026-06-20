/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantmanagmentsystemm;

/**
 *
 * @author awais
 */
import java.time.LocalDate;
import java.time.LocalTime;
public class Reservation {
     private int reservationid;
    private static int nextreservationid = 1;
    private int noofguests;
    private LocalDate reservationdate;
    private LocalTime reservationTime;
    private Customer customer;
    private Restauranttable table;
    public Reservation(int noofguests, Customer customer, Restauranttable table) {
        if (noofguests <= 0) {
            throw new IllegalArgumentException("Number of guests must be greater than 0");
        }
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        if (table == null) {
            throw new IllegalArgumentException("Table cannot be null");
        }
        if (noofguests > table.getcapacity()) {
            throw new IllegalArgumentException("Guests are more than table capacity");
        }
        if (table.isAvailable() == false) {
            throw new IllegalArgumentException("Table is already reserved");
        }
        this.reservationid = nextreservationid;
        nextreservationid++;
        this.noofguests = noofguests;
        this.reservationdate = LocalDate.now();
        this.reservationTime = LocalTime.now();
        this.customer = customer;
        this.table = table;
        this.table.reserveTable();
    }
    public int getreservationid() {
        return reservationid;
    }
    public LocalDate getreservationdate() {
        return reservationdate;
    }
    public LocalTime getreservationTime() {
        return reservationTime;
    }
    public Customer getcustomer() {
        return customer;
    }
    public Restauranttable gettable() {
        return table;
    }
    public void setnoofguests(int newnoofGuests) {
        if (newnoofGuests <= 0) {
            throw new IllegalArgumentException("Number of guests must be greater than 0");
        }
        this.noofguests = newnoofGuests;
    }
    public int getnoofguests() {
        return noofguests;
    }
    public String getReservationDataForFile() {
        return reservationid + "," + customer.getName() + "," + table.gettableNumber() + "," + noofguests + "," + reservationdate + "," + reservationTime;
    }
    public void DisplayReservationDetails() {
        System.out.println("-----Reservation Details-----");
        System.out.println("Reservation Id: " + reservationid);
        System.out.println("Guests: " + noofguests);
        System.out.println("Reservation Date: " + reservationdate);
        System.out.println("Reservation Time: " + reservationTime);
        customer.DisplayUserDetails();
        table.DisplayTableDetails();
    }
}
