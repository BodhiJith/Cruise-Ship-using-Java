
package CWork;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] cabin = new String[20];

        for (int x = 0; x < 50; x++)
        {
            System.out.println("Choose from here");
            System.out.println(" ");
            System.out.println("A - Add a customer to a cabin ");
            System.out.println("V - View all cabins ");
            System.out.println("D - Delete customer from cabin ");
            System.out.println("E - Display empty cabins ");
            System.out.println("F - Find cabin from customer name ");
            System.out.println("S - Store program data into file ");
            System.out.println("L - Load program data from file ");
            System.out.println("O - View passengers Ordered alphabetically by name ");
            System.out.println(" ");
            System.out.print("Choose what you want -> ");
            String selectoption = input.next();
            System.out.println(" ");


            switch (selectoption) {
                case "A" -> addcabin(cabin);
                case "V" -> viewcabin(cabin);
                case "D" -> dltcabin(cabin);
                case "E" -> emptycabin(cabin);
                case "F" -> findcabin(cabin);
                case "S" -> storefile(cabin);
                case "L" -> loadfile();
                case "O" -> sortcabin(cabin);
                default -> System.out.println("Invalid Input");
            }
        }
    }


    private static void addcabin(String[] cabin) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the cabin number - ");
            int cabinnum = input.nextInt();
            if (cabin[cabinnum] == null) {
                System.out.print("Enter the customer name - ");
                String cust = input.next();
                cabin[cabinnum] = cust;

                System.out.println("Customer added to the cabin");
                System.out.println();
            }
            else {
                System.out.println("Cabin is already booked");
                System.out.println();
            }
        }
        catch (Exception e) {
            System.out.println("Invalid Input");

        }
    }


    private static void viewcabin(String[] cabin) {
        for (int x = 0; x < 12; x++) {
            System.out.println(  x + "Cabin - " + cabin[x]);
        }
    }


    private static void dltcabin(String[] cabin) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("What customer do you want to delete?  ");
            int deletecustomer = input.nextInt();
            if (cabin[deletecustomer] == null) {
                System.out.println("There is no customer");
            }
            else {
                cabin[deletecustomer] = null;
                System.out.println( deletecustomer + " deleted from the cabin");
            }
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }
    }


    private static void emptycabin(String[] cabin) {
        System.out.println("Empty cabins");
        System.out.println();
        for (int x = 0; x < 12; x++) {
            if (cabin[x] == null) {
                System.out.println(x + " Cabin ");
            }
        }
    }


    private static void findcabin(String[] cabin) {
        try {
            System.out.print("Enter the customer you want to find - ");
            Scanner input = new Scanner(System.in);
            String findcust = input.next();
            for (int x = 0; x < 12; x++) {
                if (cabin[x] == null) {
                    System.out.print("");
                }
                else {
                    if (cabin[x].equals(findcust)) {
                        System.out.println(findcust + "'s room number is " + x);
                    } else {
                        System.out.println();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }
    }

    // store
    // reference - https://tedblob.com/write-arraylist-to-file-java/
    private static void storefile(String[] cabins) {
        try {
            FileWriter writer = new FileWriter("D:\\Task1_cabin.txt");
            for (int x = 0; x < 12; x++) {
                writer.write(  x + " Cabin - " + cabins[x]);
                writer.write("\n");
            }
            writer.close();
            System.out.println("Stored the program into a file");
        }
        catch (IOException writer) {
            System.out.println("Failed to store the program");
            writer.printStackTrace();
        }
    }

    // load file
    // references - https://www.w3schools.com/java/java_files_read.asp
    private static void loadfile() {
        //get File object
        File loadfile = new File("D:\\Task1_cabin.txt");
        if (loadfile.exists()) {
            System.out.println("Saved to " + loadfile.getName() + "Save file path is " + loadfile.getAbsolutePath());
        }
        else {
            System.out.println("File cannot be found");
        }
    }


    //sortcabin method
    //reference - https://www.geeksforgeeks.org/java-program-to-sort-names-in-an-alphabetical-order/
    private static void sortcabin(String[] cabin) {
        int n = 12;
        String temp;

        for (int x = 0; x < n; x++) {
            for (int y = x + 1; y < n; y++) {
                if (cabin[x] == null || cabin[y] == null) {
                    System.out.print("");

                }
                else {
                    if (cabin[x].compareTo(cabin[y]) > 0) {
                        temp = cabin[x];
                        cabin[x] = cabin[y];
                        cabin[y] = temp;
                    }
                }
            }
        }
        System.out.println();
        for (int x = 0; x < 12; x++) {
            if (cabin[x] == null)
                System.out.print("");
            else {
                System.out.println(cabin[x]);
            }
        }
    }
}


