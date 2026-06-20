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

public class Menu {
    private ArrayList<FoodItems> foodItems;
    public Menu() {
        foodItems = new ArrayList<>();
        addDefaultItems();
    }
    public void addFoodItem(FoodItems item) {
        if (item == null) {
            throw new IllegalArgumentException("Food item cannot be null");
        }
        foodItems.add(item);
    }
    public void addDefaultItems() {
        foodItems.add(new FoodItems("Burger", 500, "Fast Food"));
        foodItems.add(new FoodItems("Pizza", 1200, "Fast Food"));
        foodItems.add(new FoodItems("Biryani", 350, "Rice"));
        foodItems.add(new FoodItems("Fries", 250, "Snacks"));
        foodItems.add(new FoodItems("Cold Drink", 150, "Drink"));
    }
    public void displayMenu() {
        System.out.println("-------- Restaurant Menu --------");
        for (FoodItems item : foodItems) {
            item.DisplayFoodItemsDetails();
        }
    }
    public FoodItems searchFoodItemByName(String itemName) {
        if (itemName == null || itemName.equals("")) {
            throw new IllegalArgumentException("Item name cannot be empty");
        }
        for (FoodItems item : foodItems) {
            if (item.getitemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Food item not found");
    }
}
