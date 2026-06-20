/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantmanagmentsystemm;

/**
 *
 * @author awais
 */
public class FoodItems {
    private int itemId;
    private static int nextitemId = 1;
    private String itemName;
    private double price;
    private String category;
    public FoodItems(String itemName, double price, String category) {
        if (itemName == null || itemName.equals("")) {
            throw new IllegalArgumentException("Item name cannot be empty");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        if (category == null || category.equals("")) {
            throw new IllegalArgumentException("Category cannot be empty");
        }
        this.itemId = nextitemId;
        nextitemId++;
        this.itemName = itemName;
        this.price = price;
        this.category = category;
    }
    public void setitemName(String newName) {
        if (newName == null || newName.equals("")) {
            throw new IllegalArgumentException("Item name cannot be empty");
        }
        this.itemName = newName;
    }
    public String getitemName() {
        return itemName;
    }
    public void setPrice(double newPrice) {
        if (newPrice <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        this.price = newPrice;
    }
    public double getPrice() {
        return price;
    }
    public void setCategory(String newCategory) {
        if (newCategory == null || newCategory.equals("")) {
            throw new IllegalArgumentException("Category cannot be empty");
        }
        this.category = newCategory;
    }
    public String getCategory() {
        return category;
    }
    public int getitemId() {
        return itemId;
    }
    public void DisplayFoodItemsDetails() {
        System.out.println("-----Food Items-----");
        System.out.println("Item Id: " + itemId);
        System.out.println("Item Name: " + itemName);
        System.out.println("Item Price: " + price);
        System.out.println("Item Category: " + category);
        System.out.println("----------");
    }
}
