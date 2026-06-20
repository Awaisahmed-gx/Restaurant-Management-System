/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantmanagmentsystemm;
/**
 *
 * @author awais
 */
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
public class Order {
    private int orderId;
    private static int nextOrderId = 1;
    private Customer customer;
    private Restauranttable table;
    private ArrayList<FoodItems> orderedItems;
    private LocalDate orderDate;
    private LocalTime orderTime;
    public Order(Customer customer, Restauranttable table) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        if (table == null) {
            throw new IllegalArgumentException("Table cannot be null");
        }
        this.orderId = nextOrderId;
        nextOrderId++;
        this.customer = customer;
        this.table = table;
        this.orderDate = LocalDate.now();
        this.orderTime = LocalTime.now();
        this.orderedItems = new ArrayList<>();
    }
    public int getorderId() {
        return orderId;
    }
    public LocalDate getorderDate() {
        return orderDate;
    }
    public LocalTime getorderTime() {
        return orderTime;
    }
    public Customer getcustomer() {
        return customer;
    }
    public Restauranttable gettable() {
        return table;
    }
    public ArrayList<FoodItems> getOrderedItems() {
        return orderedItems;
    }
    public void addItem(FoodItems item) {
        if (item == null) {
            throw new IllegalArgumentException("Food item cannot be null");
        }
        orderedItems.add(item);
        System.out.println(item.getitemName() + " added to order");
    }
    public boolean isOrderEmpty() {
        return orderedItems.isEmpty();
    }
    public double calculateTotal() {
        double total = 0;
        for (FoodItems item : orderedItems) {
            total = total + item.getPrice();
        }
        return total;
    }
    public String getOrderDataForFile() {
        String itemNames = "";
        for (FoodItems item : orderedItems) {
            itemNames = itemNames + item.getitemName() + " ";
        }
        return orderId + "," + customer.getName() + "," + table.gettableNumber() + "," + itemNames + "," + calculateTotal() + "," + orderDate + "," + orderTime;
    }
    public void displayOrderDetails() {
        if (orderedItems.isEmpty()) {
            System.out.println("No items added in this order");
            return;
        }
        System.out.println("----- Order Details -----");
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Order Time: " + orderTime);
        customer.DisplayUserDetails();
        table.DisplayTableDetails();
        System.out.println("----- Ordered Items -----");
        for (FoodItems item : orderedItems) {
            item.DisplayFoodItemsDetails();
        }
        System.out.println("Total Bill: Rs. " + calculateTotal());
    }
}