/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantmanagmentsystemm;

/**
 *
 * @author awais
 */
public class Customer extends User {
    private String email;
    public Customer(String email, String name, String phonenumber) {
        super(name, phonenumber);
        if (email == null || email.equals("")) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        this.email = email;
    }
    public void setemail(String newEmail) {
        if (newEmail == null || newEmail.equals("")) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        this.email = newEmail;
    }
    public String getEmail() {
        return email;
    }
    public String getCustomerDataForFile() {
        return getName() + "," + getPhoneNumber() + "," + email;
    }
    @Override
    public void DisplayUserDetails() {
        super.DisplayUserDetails();
        System.out.println("Email: " + email);
    }
}
