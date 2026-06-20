/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantmanagmentsystemm;

/**
 *
 * @author awais
 */
public class Restauranttable {
    private int tableNumber;
    private int capacity;
    private boolean isReserved;
    public Restauranttable(int tableNumber, int capacity) {
        if (tableNumber <= 0) {
            throw new IllegalArgumentException("Table number must be greater than 0");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = capacity;
        this.isReserved = false;
        this.tableNumber = tableNumber;
    }
    public int gettableNumber() {
        return tableNumber;
    }
    public void setCapacity(int newcapacity) {
        if (newcapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = newcapacity;
    }
    public int getcapacity() {
        return capacity;
    }
    public boolean getisReserved() {
        return isReserved;
    }
    public void reserveTable() {
        if (isReserved == true) {
            throw new IllegalArgumentException("Table is already reserved");
        }
        isReserved = true;
    }
    public void FreeTable() {
        isReserved = false;
    }
    public boolean isAvailable() {
        return !isReserved;
    }
    public String getTableDataForFile() {
        return tableNumber + "," + capacity + "," + isReserved;
    }
    public void DisplayTableDetails() {
        System.out.println("-----Table Details-----");
        System.out.println("Table Number: " + tableNumber);
        System.out.println("Reserved: " + isReserved);
        System.out.println("Capacity: " + capacity);
        System.out.println("----------");
    }
}
