/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantmanagmentsystemm;

/**
 *
 * @author awais
 */
public class User {
    private int id;
    private static int nextID = 1;
    private String name;
    private String phonenumber;

    public User(String name, String phonenumber) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (phonenumber == null || phonenumber.equals("")) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        this.id = nextID;
        nextID++;
        this.name = name;
        this.phonenumber = phonenumber;
    }
    public int getId() {
        return id;
    }
    public void setName(String newName) {
        if (newName == null || newName.equals("")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = newName;
    }
    public String getName() {
        return name;
    }
    public void setPhoneNumber(String newPhoneNumber) {
        if (newPhoneNumber == null || newPhoneNumber.equals("")) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        this.phonenumber = newPhoneNumber;
    }
    public String getPhoneNumber() {
        return phonenumber;
    }
    public void DisplayUserDetails() {
        System.out.println("-----User Details-----");
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phonenumber);
        System.out.println("----------");
    }
}
