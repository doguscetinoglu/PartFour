import java.util.*;

/*

--> WELCOME PATIKA STORE <--
## Usage

1. When you run the program, a main menu will appear.
2. In the main menu, numbered options are displayed for different operations.
3. Enter the relevant number for the desired operation.
4. Choose the appropriate options to add, list, or delete notebooks or cell phones.
5. After completing the operations, you can exit by selecting option "0" from the main menu.

## Features

--> here are separate operations for adding notebooks and cell phones.
--> The specifications of the added products (ID, type, brand, color, price, discount rate, stock, memory, screen size, battery, RAM) are obtained from the user.
--> The added products are automatically added to the respective brand lists.
--> The added products and brands can be listed by the user.
--> The user has the authority to delete the desired product and brand.

 */


public class Main {

    public static void main(String[] args) {

        // Sadece marka listelemeleri için ana değişkenler
        String brandName = "";
        String pcBrandName = "";

        Scanner scanner = new Scanner(System.in);

        // Telefon marka listesi
        Map<Integer, String> phoneBrand = new TreeMap<>();

        // Notebook marka listesi
        Map<Integer, String> bookBrand = new TreeMap<>();

        // Telefon Listesi
        TreeMap<Integer, Phone> phone = new TreeMap<>();

        // Notebook listesi
        TreeMap<Integer, Notebook> notebook = new TreeMap<>();

        int choice;

        System.out.println("PATIKA STORE PRODUCT MANAGEMENT PANEL");

        // İşlem menüsü döngüsü
        while (true) {
            System.out.println(
                    "1 - Notebook Operations\n" +
                            "2 - Mobile Phone Operations\n" +
                            "3 - Phone Brand List\n" +
                            "4 - Notebook Brand List\n" +
                            "5 - Deletion Operations\n" +
                            "0 - Exit");

            // --> Menu selection query
            try {
                choice = scanner.nextInt();

                // --> Menu selection conditions
                if (choice <= 5 && choice >= 0) {

                    // --> Notebook Add Block
                    if (choice == 1) {
                        System.out.print("ID : ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Tür : ");
                        String name = scanner.nextLine().toUpperCase();
                        System.out.print("Marka : ");
                        pcBrandName = scanner.nextLine().toUpperCase();
                        System.out.print("Renk : ");
                        String color = scanner.nextLine().toUpperCase();
                        System.out.print("Fiyat : ");
                        int price = scanner.nextInt();
                        System.out.print("İndirim Oranı : ");
                        int sales = scanner.nextInt();
                        System.out.print("Adet : ");
                        int stock = scanner.nextInt();
                        System.out.print("Hafıza : ");
                        int memory = scanner.nextInt();
                        System.out.print("Ekran Boyutu : ");
                        int screen = scanner.nextInt();
                        System.out.print("Ram : ");
                        int ram = scanner.nextInt();

                        notebook.put(id, new Notebook(name, pcBrandName, color, price, sales, stock, memory, screen, ram));
                        bookBrand.put(id, pcBrandName);

                        System.out.println("The product has been successfully added. Please select the 'List Notebook Brands' option from the menu to view the listings of the product and the added brands.");
                        continue;
                    }
                    // --> Phone Add Block
                    if (choice == 2) {

                        System.out.print("ID : ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Type : ");
                        String name = scanner.nextLine().toUpperCase();
                        System.out.print("Brand : ");
                        brandName = scanner.nextLine().toUpperCase();
                        System.out.print("Color : ");
                        String color = scanner.nextLine().toUpperCase();
                        System.out.print("Price : ");
                        int price = scanner.nextInt();
                        System.out.print("Discount Rate : ");
                        int sales = scanner.nextInt();
                        System.out.print("Quantity : ");
                        int stock = scanner.nextInt();
                        System.out.print("Memory : ");
                        int memory = scanner.nextInt();
                        System.out.print("Screen Size : ");
                        int screen = scanner.nextInt();
                        System.out.print("Battery : ");
                        int battery = scanner.nextInt();
                        System.out.print("Ram : ");
                        int ram = scanner.nextInt();

                        phone.put(id, new Phone(name, brandName, color, price, sales, stock, memory, screen, battery, ram));
                        phoneBrand.put(id, brandName);

                        System.out.println("The product has been successfully added. Please select the 'List Notebook Brands' option from the menu to view the listings of the product and the added brands.");
                        continue;
                    }

                    // --> Brand listing block - Phone
                    if (choice == 3) {
                        System.out.println("PHONE BRANDS\n--------------");
                        for (Map.Entry<Integer, String> entry : phoneBrand.entrySet()) {
                            System.out.println("- " + entry.getValue());
                        }

                        System.out.println();
                        // --> Table Display - Phone
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("| CATAGORY       | BRAND      | COLOR   | PRICE      | DISCOUNT   | STOCK | MEMORY | SCREEN | BATTERY | RAM |");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                        // Phone List toString
                        for (Map.Entry<Integer, Phone> entry : phone.entrySet()) {
                            System.out.println(entry.getKey() + " " + entry.getValue());

                        }
                        System.out.println();
                        System.out.println("REDIRECTING TO MENU...\n");
                        continue;
                    }

                    // --> Brand listing block - Notebook
                    if (choice == 4) {
                        System.out.println("NOTEBOOK BRANDS\n--------------");
                        for (Map.Entry<Integer, String> entry : bookBrand.entrySet()) {
                            System.out.println("- " + entry.getValue());
                        }
                        System.out.println();

                        // --> Table Display - Notebook
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("| CATAGORY       | BRAND      | COLOR   | PRICE      | DISCOUNT   | STOCK | MEMORY | SCREEN | BATTERY | RAM |");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                        // Notebook List toString
                        for (Map.Entry<Integer, Notebook> entry : notebook.entrySet()) {
                            System.out.println(entry.getKey() + " " + entry.getValue());
                        }
                        System.out.println();
                        System.out.println("REDIRECTING TO MENU...\n");
                        continue;
                    }
                    // --> Deletion operations block
                    if (choice == 5) {
                        System.out.println("SELECT THE CATEGORY YOU WANT TO DELETE\n1 - PHONE\n2 - NOTEBOOK");
                        choice = scanner.nextInt();
                        if (choice == 1) {
                            System.out.println("SELECT THE ID YOU WANT TO DELETE");
                            System.out.println("ID LIST :" + phone.keySet());
                            int deletedId = scanner.nextInt();
                            phone.remove(deletedId);
                            phoneBrand.remove(deletedId);
                            continue;
                        }
                        if (choice == 2) {
                            System.out.println("SELECT THE ID YOU WANT TO DELETE");
                            System.out.println("ID LIST :" + notebook.keySet());
                            int deletedId = scanner.nextInt();
                            notebook.remove(deletedId);
                            bookBrand.remove(deletedId);
                            continue;
                        }
                    }

                    if (choice == 0) {
                        System.out.println("EXITING.. THANK YOU FOR CHOOSING US");
                        System.exit(0);
                    }
                    break;
                    // --> Out-of-condition value query block
                } else {
                    System.out.println("MENU SHOULD BE BETWEEN 0 AND 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("ENTER A NUMERICAL VALUE");
                scanner.next();
            }
        }
    }
}