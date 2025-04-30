import java.sql.*;
import java.util.Scanner;

public class Sms {




// Function for Personal Details
public static void personalDetails() {
Scanner sc = new Scanner(System.in);
int i;
do {
System.out.println("-------------------------------------------------------------------------------------------");
System.out.println("                           Personal Details                         ");
System.out.println("1 . Add");
System.out.println("2 . Edit");
System.out.println("3 . Delete");
System.out.println("4 . Show");
System.out.println("5 . Exit");

System.out.println("Enter Your Choice :");
i = sc.nextInt();

switch (i) {
case 1:
add();
break;
case 2:
edit();
break;
case 3:
delete();
break;
case 4:
show();
break;
case 5:
return;
default:
System.out.println("Invalid choice. Please try again.");
}
} while (i >= 1 && i <= 4);
}





// Function for Mark Details
public static void markDetails() {
Scanner sc = new Scanner(System.in);
int i;

do {
System.out.println("------------------------------------------------------------------------------------------");
System.out.println("                           Mark Details                          ");
System.out.println("1 . Add");
System.out.println("2 . Edit");
System.out.println("3 . Delete");
System.out.println("4 . Show");
System.out.println("5 . Exit");

System.out.println("Enter Your Choice :");
i = sc.nextInt();

switch (i) {
case 1:
markadd();
break;
case 2:
markedit();
break;
case 3:
markdelete();
break;
case 4:
markshow();
break;
case 5:
return;
default:
System.out.println("Invalid choice. Please try again.");
}
} while (i >= 1 && i <= 4);
}

// Add function
public static void add() {
Scanner sc = new Scanner(System.in);

try {
System.out.print("Enter Name : ");
String sname = sc.nextLine();

System.out.print("Enter DOB : ");
String dob = sc.nextLine();

System.out.print("Enter Ph-no : ");
long ph = sc.nextLong();
sc.nextLine(); // Consume newline

System.out.print("Enter Address : ");
String address = sc.nextLine();

System.out.print("Enter Yr Gender : ");
String gender = sc.nextLine();

try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root")) {
String sql = "INSERT INTO student(sname, dob, ph, address, gender) VALUES (?, ?, ?, ?, ?)";
try (PreparedStatement statement = con.prepareStatement(sql)) {
statement.setString(1, sname);
statement.setString(2, dob);
statement.setLong(3, ph);
statement.setString(4, address);
statement.setString(5, gender);

int rowInserted = statement.executeUpdate();
if (rowInserted > 0) {
System.out.println("Inserted Successfully...");
}
}
}
} catch (Exception e) {
System.out.println(e);
}
}



// Edit function
public static void edit() {
Scanner sc = new Scanner(System.in);

try {
System.out.print("Enter Name : ");
String sname = sc.nextLine();

System.out.print("Enter DOB : ");
int dob = sc.nextInt();

System.out.print("Enter Ph-no : ");
long ph = sc.nextLong();
sc.nextLine(); // Consume newline

System.out.print("Enter Address : ");
String address = sc.nextLine();

System.out.print("Enter Yr Gender : ");
String gender = sc.nextLine();

try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root")) {
String sql = "UPDATE student SET dob = ?, ph = ?, address = ?, gender = ? WHERE sname = ?";
try (PreparedStatement statement = con.prepareStatement(sql)) {
statement.setInt(1, dob);
statement.setLong(2, ph);
statement.setString(3, address);
statement.setString(4, gender);
statement.setString(5, sname);

int rowUpdated = statement.executeUpdate();
if (rowUpdated > 0) {
System.out.println("Updated Successfully...");
} else {
System.out.println("No Record Found...");
}
}
}
} catch (Exception e) {
System.out.println(e);
}
}

// Delete function
public static void delete() {
Scanner sc = new Scanner(System.in);

try {
System.out.print("Enter Name : ");
String sname = sc.nextLine();

try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root")) {
String sql = "DELETE FROM student WHERE sname = ?";
try (PreparedStatement statement = con.prepareStatement(sql)) {
statement.setString(1, sname);

int rowDeleted = statement.executeUpdate();
if (rowDeleted > 0) {
System.out.println("Deleted Successfully...");
} else {
System.out.println("No Record Found...");
}
}
}
} catch (Exception e) {
System.out.println(e);
}
}

// Show function

public static void show() {
try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root")) {
String sql = "SELECT * FROM student";
try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

System.out.println(             "Name"+ "           "+"DOB"+"             "+" PH-NO"+"                    "+"ADDRESS"+"               "+"GENDER");

while (rs.next()) {
System.out.println(rs.getString("sname") + "\t" + rs.getInt("dob") + "\t" + rs.getLong("ph") + "\t" + rs.getString("address") + "\t" + rs.getString("gender"));
}
}
} catch (Exception e) {
System.out.println(e);
}
}



// mark list functions


// markAdd function
public static void markadd() {
Scanner sc = new Scanner(System.in);

try {
System.out.print("Enter Name : ");
String sname = sc.nextLine();

System.out.print("Enter tamil mark : ");
int tam = sc.nextInt();

System.out.print("Enter english mark : ");
int eng = sc.nextInt();
sc.nextLine(); 

System.out.print("Enter maths mark : ");
int mat = sc.nextInt();


try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root")) {
String sql = "INSERT INTO marklist(sname, tam,eng,mat) VALUES (?, ?, ?, ?)";
try (PreparedStatement statement = con.prepareStatement(sql)) {
statement.setString(1, sname);
statement.setInt(2, tam);
statement.setInt(3, eng);
statement.setInt(4, mat);


int rowInserted = statement.executeUpdate();
if (rowInserted > 0) {
System.out.println("Inserted Successfully...");
}
}
}
} catch (Exception e) {
System.out.println(e);
}
}


// markEdit function
public static void markedit() {
Scanner sc = new Scanner(System.in);

try {
System.out.print("Enter Name : ");
String sname = sc.nextLine();

System.out.print("Enter tamil mark : ");
int tam = sc.nextInt();

System.out.print("Enter english mark : ");
int eng = sc.nextInt();
sc.nextLine(); // Consume newline

System.out.print("Enter maths mark : ");
int mat = sc.nextInt();


try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root")) {
String sql = "UPDATE marklist SET tam = ?, eng = ?, mat = ? WHERE sname = ?";
try (PreparedStatement statement = con.prepareStatement(sql)) {
statement.setInt(1, tam);
statement.setInt(2, eng);
statement.setInt(3, mat);
statement.setString(4, sname);

int rowUpdated = statement.executeUpdate();
if (rowUpdated > 0) {
System.out.println("Updated Successfully...");
} else {
System.out.println("No Record Found...");
}
}
}
} catch (Exception e) {
System.out.println(e);
}
}


// markDelete function
public static void markdelete() {
Scanner sc = new Scanner(System.in);

try {
System.out.print("Enter Name : ");
String sname = sc.nextLine();

try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root")) {
String sql = "DELETE FROM marklist WHERE sname = ?";
try (PreparedStatement statement = con.prepareStatement(sql)) {
statement.setString(1, sname);

int rowDeleted = statement.executeUpdate();
if (rowDeleted > 0) {
System.out.println("Deleted Successfully...");
} else {
System.out.println("No Record Found...");
}
}
}
} catch (Exception e) {
System.out.println(e);
}
}


// markShow function
public static void markshow() {
try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root")) {
String sql = "SELECT * FROM marklist";
try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

System.out.println(             "Name" +"          "+"Tamil" +"  "+"English" +"   "+"Maths");
while (rs.next()) {
System.out.println(rs.getString("sname") + "\t" + rs.getInt("tam") + "\t" + rs.getInt("eng") + "\t" + rs.getInt("mat"));
}
}
} catch (Exception e) {
System.out.println(e);
}
}




// Main Function
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int i;

do {
System.out.println("  Menu  ");
System.out.println("1. Personal Details");
System.out.println("2. Mark Details");
System.out.println("3. Exit");

System.out.print("Enter your Choice : ");
i = sc.nextInt();

switch (i) {
case 1:
personalDetails();
break;
case 2:
markDetails();
break;
case 3:
System.out.println("Exiting...");
break;
default:
System.out.println("Invalid choice. Please try again.");
}
} while (i != 3);

sc.close();
}
}