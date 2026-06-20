/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantmanagmentsystemm;

/**
 *
 * @author awais
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class RestaurantFileHandler {
    private String customerFile;
    private String reservationFile;
    private String orderFile;
    public RestaurantFileHandler() {
        customerFile = "customers.txt";
        reservationFile = "reservations.txt";
        orderFile = "orders.txt";
    }
    public void saveCustomer(Customer customer) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(customerFile, true));
            bw.write(customer.getCustomerDataForFile());
            bw.newLine();
            bw.close();
            System.out.println("Customer saved in file successfully");
        } catch (IOException e) {
            System.out.println("Error while saving customer data");
        }
    }
    
    public void saveReservation(Reservation reservation) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(reservationFile, true));
            bw.write(reservation.getReservationDataForFile());
            bw.newLine();
            bw.close();
            System.out.println("Reservation saved in file successfully");
        } catch (IOException e) {
            System.out.println("Error while saving reservation data");
        }
    }
    public void saveOrder(Order order) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(orderFile, true));
            bw.write(order.getOrderDataForFile());
            bw.newLine();
            bw.close();
            System.out.println("Order saved in file successfully");
        } catch (IOException e) {
            System.out.println("Error while saving order data");
        }
    }
    public ArrayList<Customer> readCustomersFromFile() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(customerFile));
            String line;
            while ((line = br.readLine()) != null) {
                String data[] = line.split(",");
                if (data.length == 3) {
                    String name = data[0];
                    String phone = data[1];
                    String email = data[2];
                    Customer customer = new Customer(email, name, phone);
                    customers.add(customer);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("No old customer file found yet");
        } catch (Exception e) {
            System.out.println("Error while reading customer data");
        }
        return customers;
    }
    public void displayCustomersFromFile() {
        System.out.println("----- Customers From File -----");
        try {
            BufferedReader br = new BufferedReader(new FileReader(customerFile));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("No customer data found");
        }
    }
    public void displayReservationsFromFile() {
        System.out.println("----- Reservations From File -----");
        try {
            BufferedReader br = new BufferedReader(new FileReader(reservationFile));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("No reservation data found");
        }
    }
    public void displayOrdersFromFile() {
        System.out.println("----- Orders From File -----");
        try {
            BufferedReader br = new BufferedReader(new FileReader(orderFile));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("No order data found");
        }
    }
    public String getCustomersTextFromFile() {
    String text = "";
    try {
        BufferedReader br = new BufferedReader(new FileReader(customerFile));
        String line;
        while ((line = br.readLine()) != null) {
            text = text + line + "\n";
        }
        br.close();
    } catch (IOException e) {
        text = "No customer data found";
    }
    return text;
}
public String getReservationsTextFromFile() {
    String text = "";
    try {
        BufferedReader br = new BufferedReader(new FileReader(reservationFile));
        String line;
        while ((line = br.readLine()) != null) {
            text = text + line + "\n";
        }
        br.close();
    } catch (IOException e) {
        text = "No reservation data found";
    }
    return text;
}
public String getOrdersTextFromFile() {
    String text = "";
    try {
        BufferedReader br = new BufferedReader(new FileReader(orderFile));
        String line;
        while ((line = br.readLine()) != null) {
            text = text + line + "\n";
        }
        br.close();
    } catch (IOException e) {
        text = "No order data found";
    }
    return text;
}
}