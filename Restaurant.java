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
public class Restaurant {
    private ArrayList<Customer> customers;
    private ArrayList<Restauranttable> tables;
    private ArrayList<Reservation> reservations;
    private ArrayList<Order> orders;
    private Menu menu;
    private RestaurantFileHandler fileHandler;
    public Restaurant() {
        customers = new ArrayList<>();
        tables = new ArrayList<>();
        reservations = new ArrayList<>();
        orders = new ArrayList<>();
        menu = new Menu();
        fileHandler = new RestaurantFileHandler();
        customers = fileHandler.readCustomersFromFile();
    }
    public void addCustomer(Customer customer) {
        try {
            if (customer == null) {
                throw new IllegalArgumentException("Customer cannot be null");
            }
            customers.add(customer);
            fileHandler.saveCustomer(customer);
            System.out.println("Customer added successfully");
        } catch (Exception e) {
            System.out.println("Customer not added: " + e.getMessage());
        }
    }
    public void addTable(Restauranttable table) {
        try {
            if (table == null) {
                throw new IllegalArgumentException("Table cannot be null");
            }
            tables.add(table);
            System.out.println("Table added successfully");
        } catch (Exception e) {
            System.out.println("Table not added: " + e.getMessage());
        }
    }
    public void displayCustomers() {
        System.out.println("----- Customers -----");

        if (customers.isEmpty()) {
            System.out.println("No customers available");
        } else {
            for (Customer customer : customers) {
                customer.DisplayUserDetails();
            }
        }
    }
    public String getCustomersTextFromFile() {
    return fileHandler.getCustomersTextFromFile();
}

public String getReservationsTextFromFile() {
    return fileHandler.getReservationsTextFromFile();
}

public String getOrdersTextFromFile() {
    return fileHandler.getOrdersTextFromFile();
}
    public void displayTables() {
        System.out.println("----- Tables -----");
        if (tables.isEmpty()) {
            System.out.println("No tables available");
        } else {
            for (Restauranttable table : tables) {
                table.DisplayTableDetails();
            }
        }
    }
    public void showMenu() {
        menu.displayMenu();
    }
    public Menu getMenu() {
        return menu;
    }
    public void reserveTable(Customer customer, int tableNumber, int numberOfGuests) {
        try {
            if (customer == null) {
                throw new IllegalArgumentException("Customer cannot be null");
            }
            if (tableNumber <= 0) {
                throw new IllegalArgumentException("Invalid table number");
            }
            if (numberOfGuests <= 0) {
                throw new IllegalArgumentException("Invalid number of guests");
            }
            for (Restauranttable table : tables) {
                if (table.gettableNumber() == tableNumber) {
                    Reservation reservation = new Reservation(numberOfGuests, customer, table);
                    reservations.add(reservation);
                    fileHandler.saveReservation(reservation);
                    System.out.println("Table reserved successfully");
                    return;
                }
            }
            throw new IllegalArgumentException("Table not found");
        } catch (Exception e) {
            System.out.println("Reservation failed: " + e.getMessage());
        }
    }
    public Order createOrder(Customer customer, int tableNumber) {
        try {
            if (customer == null) {
                throw new IllegalArgumentException("Customer cannot be null");
            }
            for (Restauranttable table : tables) {
                if (table.gettableNumber() == tableNumber) {
                    Order order = new Order(customer, table);
                    orders.add(order);

                    System.out.println("Order created successfully");
                    return order;
                }
            }
            throw new IllegalArgumentException("Table not found");
        } catch (Exception e) {
            System.out.println("Order not created: " + e.getMessage());
            return null;
        }
    }
    public void addFoodToOrder(Order order, String itemName) {
        try {
            if (order == null) {
                throw new IllegalArgumentException("Order does not exist");
            }
            FoodItems item = menu.searchFoodItemByName(itemName);
            order.addItem(item);
        } catch (Exception e) {
            System.out.println("Food not added: " + e.getMessage());
        }
    }
    public void saveOrder(Order order) {
        try {
            if (order == null) {
                throw new IllegalArgumentException("Order does not exist");
            }
            if (order.isOrderEmpty()) {
                throw new IllegalArgumentException("Order is empty");
            }
            fileHandler.saveOrder(order);
            System.out.println("Order saved successfully");
        } catch (Exception e) {
            System.out.println("Order not saved: " + e.getMessage());
        }
    }
    public void displayReservations() {
        System.out.println("----- Reservations -----");

        if (reservations.isEmpty()) {
            System.out.println("No reservations available");
        } else {
            for (Reservation reservation : reservations) {
                reservation.DisplayReservationDetails();
            }
        }
    }
    public void displayOrders() {
        System.out.println("----- Orders -----");

        if (orders.isEmpty()) {
            System.out.println("No orders available");
        } else {
            for (Order order : orders) {
                order.displayOrderDetails();
            }
        }
    }
    public void displayOldCustomersFromFile() {
        fileHandler.displayCustomersFromFile();
    }
    public void displayOldReservationsFromFile() {
        fileHandler.displayReservationsFromFile();
    }
    public void displayOldOrdersFromFile() {
        fileHandler.displayOrdersFromFile();
    }
}
