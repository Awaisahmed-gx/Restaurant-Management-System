package restaurantmanagmentsystemm;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RestaurantManagmentSystemm extends Application {
private Scene Mainscene;
Restaurant restaurant = new Restaurant();
Customer currentCustomer;
Order currentOrder;
String customerName = "";
String customerPhone = "";
String customerEmail = "";
int selectedTable = 0;
double totalBill = 0;
String orderText = "";

@Override
public void start(Stage stage) {
try{
restaurant.addTable(new Restauranttable(1, 2));
restaurant.addTable(new Restauranttable(2, 4));
restaurant.addTable(new Restauranttable(3, 6));
restaurant.addTable(new Restauranttable(4, 8));
restaurant.addTable(new Restauranttable(5, 10));
}catch(Exception e){
System.out.println(e.getMessage());
}

Label heading = new Label("======RESTAURANT RESERVATION SYSTEM=======");
heading.setFont(Font.font("Arial", FontWeight.BOLD, 30));
Label msg = new Label("Welcome to Cheezious! We are open 24/7");

Button ReserveTable = new Button("Reserve Table");
ReserveTable.setPrefSize(180, 50);
Button FoodOrder = new Button("Order Food");
FoodOrder.setPrefSize(180, 50);

HBox r1 = new HBox(30, ReserveTable, FoodOrder);

Button Bill = new Button("Bill And Payment");
Bill.setPrefSize(180, 50);
Button Reservations = new Button("View Reservations");
Reservations.setPrefSize(180, 50);

HBox r2 = new HBox(30, Bill, Reservations);

Button records = new Button("View Records");
records.setPrefSize(180, 50);
Button Exit = new Button("Exit");
Exit.setPrefSize(180, 50);

HBox r3 = new HBox(30, records, Exit);

r1.setAlignment(Pos.CENTER);
r2.setAlignment(Pos.CENTER);
r3.setAlignment(Pos.CENTER);

VBox v = new VBox(30);
v.getChildren().addAll(heading, msg, r1, r2, r3);
v.setAlignment(Pos.CENTER);

Mainscene = new Scene(v, 800, 550);

ReserveTable.setOnAction(e -> showReserveScene(stage));
FoodOrder.setOnAction(e -> showOrderScene(stage));
Bill.setOnAction(e -> showBillScene(stage));
Reservations.setOnAction(e -> showReservationScene(stage));
records.setOnAction(e -> showRecordsScene(stage));

Exit.setOnAction(e -> {
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setHeaderText("Thank You for ordering here!\nWe hope to serve you again soon!");
alert.showAndWait();
stage.close();
});

stage.setTitle("Cheezious Restaurant");
stage.setScene(Mainscene);
stage.show();
}

private void showReserveScene(Stage stage) {
Label heading2 = new Label("TABLE RESERVATION");
heading2.setFont(Font.font("Arial", FontWeight.BOLD, 25));

Label name = new Label("Enter Name");
TextField t1 = new TextField();
HBox h1 = new HBox(30);
h1.getChildren().addAll(name, t1);

Label phone = new Label("Phone Number");
TextField t2 = new TextField();
HBox h2 = new HBox(30);
h2.getChildren().addAll(phone, t2);

Label email = new Label("Enter Email");
TextField t3 = new TextField();
HBox h3 = new HBox(30);
h3.getChildren().addAll(email, t3);

Label tablee = new Label("Select Table");
ComboBox<String> c1 = new ComboBox<>();

c1.getItems().addAll(
"Table 1 (2 Seats)",
"Table 2 (4 Seats)",
"Table 3 (6 Seats)",
"Table 4 (8 Seats)",
"Table 5 (10 Seats)"
);

HBox h4 = new HBox(30);
h4.getChildren().addAll(tablee, c1);

Label date = new Label("Date");
TextField t4 = new TextField();

HBox h5 = new HBox(30);
h5.getChildren().addAll(date, t4);

Label time = new Label("Time");
TextField t5 = new TextField();

HBox h6 = new HBox(30);
h6.getChildren().addAll(time, t5);

h1.setAlignment(Pos.CENTER);
h2.setAlignment(Pos.CENTER);
h3.setAlignment(Pos.CENTER);
h4.setAlignment(Pos.CENTER);
h5.setAlignment(Pos.CENTER);
h6.setAlignment(Pos.CENTER);

Button reserve = new Button("Reserve");
Button back = new Button("Back");

reserve.setOnAction(e -> {

try {
if (t1.getText().equals("") || t2.getText().equals("") ||
t3.getText().equals("") || t4.getText().equals("") ||
t5.getText().equals("") || c1.getValue() == null) {
throw new IllegalArgumentException("Please fill all fields");
}

customerName = t1.getText();
customerPhone = t2.getText();
customerEmail = t3.getText();

String table = c1.getValue();

if (table.contains("Table 1")) {
selectedTable = 1;
} else if (table.contains("Table 2")) {
selectedTable = 2;
} else if (table.contains("Table 3")) {
selectedTable = 3;
} else if (table.contains("Table 4")) {
selectedTable = 4;
} else if (table.contains("Table 5")) {
selectedTable = 5;
}

int guests = 0;

if (selectedTable == 1) {
guests = 2;
} else if (selectedTable == 2) {
guests = 4;
} else if (selectedTable == 3) {
guests = 6;
} else if (selectedTable == 4) {
guests = 8;
} else if (selectedTable == 5) {
guests = 10;
}

currentCustomer = new Customer(customerEmail, customerName, customerPhone);
restaurant.addCustomer(currentCustomer);
restaurant.reserveTable(currentCustomer, selectedTable, guests);

currentOrder = null;
totalBill = 0;
orderText = "";

Alert a = new Alert(Alert.AlertType.INFORMATION);
a.setContentText("Reservation successful and saved in file");
a.show();

Label success = new Label("Reservation Successful!");
Label n = new Label("Customer Name: " + customerName);
Label p = new Label("Phone Number: " + customerPhone);
Label em = new Label("Email: " + customerEmail);
Label tb = new Label("Table Number: " + selectedTable);
Label dt = new Label("Date: " + t4.getText());
Label tm = new Label("Time: " + t5.getText());

Button order = new Button("Order Food");
Button bck = new Button("Back ");

HBox btns = new HBox(20, order, bck);
btns.setAlignment(Pos.CENTER);

order.setOnAction(x -> showOrderScene(stage));
bck.setOnAction(x -> stage.setScene(Mainscene));

VBox box = new VBox(20, success, n, p, em, tb, dt, tm, btns);
box.setAlignment(Pos.CENTER);

stage.setScene(new Scene(box, 800, 550));

} catch (Exception ex) {
Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setContentText(ex.getMessage());
alert.show();
}
});

back.setOnAction(e -> stage.setScene(Mainscene));

HBox buttons = new HBox(20, reserve, back);
buttons.setAlignment(Pos.CENTER);

VBox v2 = new VBox(18, heading2, h1, h2, h3, h4, h5, h6, buttons);
v2.setAlignment(Pos.CENTER);
v2.setPadding(new Insets(20));

stage.setScene(new Scene(v2, 800, 550));
}

private void showOrderScene(Stage stage) {
if (currentCustomer == null) {
Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setContentText("Please reserve a table first.");
alert.show();
return;
}

if (currentOrder == null) {
currentOrder = restaurant.createOrder(currentCustomer, selectedTable);
}

Label heading3 = new Label("ORDER FOOD");
heading3.setFont(Font.font("Arial", FontWeight.BOLD, 25));

Label cname = new Label("Customer: " + customerName);
Label f = new Label("Select Food");
Label q = new Label("Quantity");

ComboBox<String> foodBox = new ComboBox<>();
foodBox.getItems().addAll("Burger", "Pizza", "Biryani", "Fries", "Cold Drink");

TextField quantityField = new TextField();

Button addItem = new Button("Add Item");
Button confirmOrder = new Button("Confirm Order");
Button back = new Button("Back");

HBox btns = new HBox(20, addItem, confirmOrder, back);
btns.setAlignment(Pos.CENTER);

Label orderDetails = new Label("Your Order will appear here");
Label billLabel = new Label("Total Bill: Rs. " + totalBill);

addItem.setOnAction(e -> {

try {
if (foodBox.getValue() == null || quantityField.getText().equals("")) {
throw new IllegalArgumentException("Select food and enter quantity");
}

int quantity = Integer.parseInt(quantityField.getText());

if (quantity <= 0) {
throw new IllegalArgumentException("Quantity must be greater than 0");
}

String foodName = foodBox.getValue();

for (int i = 1; i <= quantity; i++) {
restaurant.addFoodToOrder(currentOrder, foodName);
}

totalBill = currentOrder.calculateTotal();

orderText = orderText + foodName + " x " + quantity + "\n";

orderDetails.setText(orderText);
billLabel.setText("Total Bill: Rs. " + totalBill);

quantityField.clear();

} catch (NumberFormatException ex) {
Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setContentText("Quantity must be a number");
alert.show();

} catch (Exception ex) {
Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setContentText(ex.getMessage());
alert.show();
}
});

confirmOrder.setOnAction(e -> {
try {
if (currentOrder == null || currentOrder.isOrderEmpty()) {
throw new IllegalArgumentException("Order is empty");
}

restaurant.saveOrder(currentOrder);

Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setContentText("Order Confirmed and saved!\nTotal Bill: Rs. " + totalBill);
alert.show();

} catch (Exception ex) {
Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setContentText(ex.getMessage());
alert.show();
}
});

back.setOnAction(e -> stage.setScene(Mainscene));

VBox v3 = new VBox(18, heading3, cname, f, foodBox,
q, quantityField, btns, orderDetails, billLabel);

v3.setAlignment(Pos.CENTER);
v3.setPadding(new Insets(20));

stage.setScene(new Scene(v3, 800, 550));
}

private void showBillScene(Stage stage) {
Label heading = new Label("BILL AND PAYMENT");
heading.setFont(Font.font("Arial", FontWeight.BOLD, 25));

Label customer = new Label("Customer: " + customerName);
Label table = new Label("Table: " + selectedTable);
Label orders = new Label("Orders:\n" + orderText);
Label total = new Label("Total Bill: Rs. " + totalBill);

ComboBox<String> paymentMethod = new ComboBox<>();
paymentMethod.getItems().addAll("Cash", "Card", "EasyPaisa", "JazzCash");

TextField paidField = new TextField();
paidField.setPromptText("Enter amount paid");

Label result = new Label();

Button pay = new Button("Pay");
Button back = new Button("Back");

HBox btns = new HBox(20, pay, back);
btns.setAlignment(Pos.CENTER);

pay.setOnAction(e -> {
try {
if (currentCustomer == null) {
throw new IllegalArgumentException("No customer found");
}
if (totalBill <= 0) {
throw new IllegalArgumentException("No order found");
}
if (paymentMethod.getValue() == null || paidField.getText().equals("")) {
throw new IllegalArgumentException("Select payment method and enter amount");
}

double paid = Double.parseDouble(paidField.getText());

if (paid <= 0) {
throw new IllegalArgumentException("Invalid amount");
}

if (paid < totalBill) {
result.setText("Insufficient amount paid.\nRemaining: Rs. " + (totalBill - paid));
} else {
result.setText("Payment Successful by " + paymentMethod.getValue()
+ "\nChange: Rs. " + (paid - totalBill));
}

} catch (NumberFormatException ex) {
result.setText("Amount must be a number");

} catch (Exception ex) {
result.setText(ex.getMessage());
}
});

back.setOnAction(e -> stage.setScene(Mainscene));

VBox v4 = new VBox(18, heading, customer, table, orders, total,
new Label("Payment Method"), paymentMethod, paidField, btns, result);

v4.setAlignment(Pos.CENTER);
v4.setPadding(new Insets(20));

stage.setScene(new Scene(v4, 800, 550));
}

private void showReservationScene(Stage stage) {
Label heading = new Label("VIEW RESERVATION");
heading.setFont(Font.font("Arial", FontWeight.BOLD, 25));

String data = restaurant.getReservationsTextFromFile();

TextArea details = new TextArea(data);
details.setPrefSize(600, 300);
details.setEditable(false);

Button back = new Button("Back");
back.setOnAction(e -> stage.setScene(Mainscene));

VBox v4 = new VBox(20, heading, details, back);
v4.setAlignment(Pos.CENTER);
v4.setPadding(new Insets(20));

stage.setScene(new Scene(v4, 800, 550));
}

private void showRecordsScene(Stage stage) {
Label heading = new Label("VIEW RECORDS");
heading.setFont(Font.font("Arial", FontWeight.BOLD, 25));

String allData = "";

allData = allData + "----- CUSTOMERS -----\n";
allData = allData + restaurant.getCustomersTextFromFile();

allData = allData + "\n----- RESERVATIONS -----\n";
allData = allData + restaurant.getReservationsTextFromFile();

allData = allData + "\n----- ORDERS -----\n";
allData = allData + restaurant.getOrdersTextFromFile();

TextArea details = new TextArea(allData);
details.setPrefSize(650, 350);
details.setEditable(false);

Button back = new Button("Back");
back.setOnAction(e -> stage.setScene(Mainscene));

VBox layout = new VBox(20, heading, details, back);
layout.setAlignment(Pos.CENTER);
layout.setPadding(new Insets(20));

stage.setScene(new Scene(layout, 800, 550));
}

public static void main(String[] args) {
launch(args);
}
}