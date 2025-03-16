import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

class InventoryItem {
    int ID;
    String name;
    int price;
    int quantity;
    int totalprice;

    public InventoryItem(int ID, String name, int price, int quantity, int totalprice) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.totalprice = price * quantity;
    }
    public String toString() {
        return ID + " " + name + " " + price + " " + quantity + " " + totalprice;
    }
    public String toFileString() {
        return ID + "," + name + "," + price + "," + quantity + "," + totalprice;
    }

}

    public class InventoryFileReader {
        public static void main(String[] args) {
            ArrayList<InventoryItem> Items = new ArrayList<>();
            String choice;

            try {
                File Inventory = new File("src/Inventory.txt");
                Scanner Reader = new Scanner(Inventory);

                while (Reader.hasNextLine()) {
                    String line = Reader.nextLine();
                    String[] DataUnit = line.split(",");

                    int ID = Integer.parseInt(DataUnit[0]);
                    String name = DataUnit[1];
                    int price = Integer.parseInt(DataUnit[2]);
                    int quantity = Integer.parseInt(DataUnit[3]);
                    int totalprice = Integer.parseInt(DataUnit[4]);

                    Items.add(new InventoryItem(ID, name, price, quantity, totalprice));
                }
                Reader.close();

            } catch (Exception e) {
                System.out.println("There was an error reading the file");
                e.printStackTrace();
                }

                Scanner scanner = new Scanner(System.in);
                System.out.println("Do you want to add a new item?"); {
                choice = scanner.next();

                if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
                    try {
                        System.out.println("Enter ID: ");
                        int newID = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter item name: ");
                        String newName = scanner.nextLine();

                        System.out.println("Enter item price: ");
                        int newPrice = scanner.nextInt();

                        System.out.println("Enter item quantity: ");
                        int newQuantity = scanner.nextInt();

                        InventoryItem newItem = new InventoryItem(newID, newName, newPrice, newQuantity, newQuantity);
                        Items.add(newItem);

                    FileWriter fw = new FileWriter("src/Inventory.txt", true);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.println(newItem.toFileString());
                    pw.close();


                    } catch (Exception e) {
                        System.out.println("There was an error adding the new item");
                        e.printStackTrace();
                    }
                }
            }
        }
    }
