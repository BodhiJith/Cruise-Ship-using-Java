package CWork;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Cabin {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Passenger[][] PassengerNew = new Passenger[12][3];
        for (int x = 0; x < 50; x++) {
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
            System.out.println("T - Total expenses of passengers ");
            System.out.println(" ");
            System.out.print("Choose what you want -> ");
            String selectoption1 = input.next();
            System.out.println(" ");



            switch (selectoption1) {
                case "A" -> addcabin(PassengerNew);
                case "V" -> viewcabin(PassengerNew);
                case "D" -> dltcabin(PassengerNew);
                case "E" -> emptycabin(PassengerNew);
                case "F" -> findcabin(PassengerNew);
                case "S" -> storefile(PassengerNew);
                case "L" -> loadfile();
                case "O" -> sortcabin(PassengerNew);
                case "T" -> expenses(PassengerNew);
                default -> System.out.println("Invalid Input");
            }
        }
    }

    private static void addcabin(Passenger[][] PassengerNew) {

        try {
            Passenger passenger = new Passenger();
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the cabin number - ");
            int roomnum = input.nextInt();

            System.out.print("Enter the cabin slot - ");
            int cabin = input.nextInt();

            if (PassengerNew[roomnum][cabin] == null) {
                System.out.print("First Name - ");
                String firstname = input.next();
                passenger.setfname(firstname);

                System.out.print("SurName - ");
                String surname = input.next();
                passenger.setsname(surname);



                System.out.print("Expenses - ");
                int expense = input.nextInt();
                passenger.setexpense(expense);

                String firstname1 = passenger.getfname();
                String surname1 = passenger.getsname();
                int expense1 = passenger.getexpense();


                Passenger pass1 = new Passenger(expense1, firstname1, surname1);
                PassengerNew[roomnum][cabin] = pass1;
            } else {
                System.out.println("Cabin slot is already booked");
            }

        }
        catch (Exception e) {
            System.out.println("Invalid Input");
            System.out.println();
        }
    }

    private static void viewcabin(Passenger[][] PassengerNew) {

        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 3; y++) {
                if (PassengerNew[x][y] != null) {

                    System.out.println("Room " + x + "" + "'s Slot " + y );
                    System.out.println(" First Name:- " + PassengerNew[x][y].getfname() + ", Sur Name:- " + PassengerNew[x][y].getsname() + ", Expenses:- " + PassengerNew[x][y].getexpense() );
                    System.out.println();
                }

                else {
                    System.out.println("No customer in Room " + x + "" + "'s Slot " + y);

                }
            }
            System.out.println();
            System.out.println();
        }
    }


    private static void dltcabin(Passenger[][] PassengerNew) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("What is the cabin that customer in?  ");
            int roomnum = input.nextInt();

            System.out.print("What customer's slot do you want to delete?  ");
            int cabin = input.nextInt();

            if (PassengerNew[roomnum][cabin] == null) {
                System.out.println("There is no Customer");
                System.out.println();
            } else {
                PassengerNew[roomnum][cabin] = null;
                System.out.println("Customer in cabin " + roomnum + "'s Slot " + cabin + " deleted from the cabin");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }
        System.out.println();
        System.out.println();
    }


    private static void emptycabin(Passenger[][] PassengerNew) {
        System.out.println("Empty cabins");
        System.out.println();
        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 3; y++) {
                if (PassengerNew[x][y] == null) {
                    System.out.println("Cabin No" + x + "'s slot " + y );
                }
            }
        }
        System.out.println();
        System.out.println();
    }


    private static void findcabin(Passenger[][] PassengerNew) {
        try {
            System.out.print("Enter the customer you want to find - ");
            Scanner input = new Scanner(System.in);
            String findcust = input.next();
            for (int x = 0; x < 12; x++) {
                for (int y = 0; y < 3; y++) {

                    if (PassengerNew[x][y] == null) {
                        System.out.print("");
                    } else {
                        if (PassengerNew[x][y].getfname().equals(findcust)) {
                            System.out.println(findcust + "'s Room is " + x + "and cabin slot is " + y);
                            System.out.println();
                        } else {
                            System.out.println("There are no customer in this name");
                            System.out.println();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }
        System.out.println();
        System.out.println();
    }

    private static void storefile(Passenger[][] PassengerNew) {
        try {
            FileWriter writer = new FileWriter("D:\\Task2_cabin.txt");
            for (int x = 0; x < 12; x++) {
                for (int y = 0; y < 3; y++) {
                    if (PassengerNew[x][y] == null) {
                        System.out.print("");
                    }
                    else {
                        writer.write("Cabin number -  " + x + ", Cabin Slot " + y + ", First Name - " + PassengerNew[x][y].getfname() );
                        writer.write("\n");
                        writer.write("Cabin number -  " + x + ", Cabin Slot " + y + ", SurName - " + PassengerNew[x][y].getsname() );
                        writer.write("\n");
                        writer.write("Cabin number -  " + x + ", Cabin Slot " + y + ", Expenses - " + PassengerNew[x][y].getexpense() );
                        writer.write("\n");
                    }

                }
            }

            writer.close();
            System.out.println("Stored the program into a file");
        }
        catch (IOException writer) {
            System.out.println("Failed to store the program");
            writer.printStackTrace();


        }
        System.out.println();
        System.out.println();
    }

    private static void loadfile() {
        File loadfile = new File("D:\\Task2_cabin.txt");
        if (loadfile.exists()) {
            System.out.println("Saved to " + loadfile.getName() + "Save file path is " + loadfile.getAbsolutePath());

        }
        else {
            System.out.println("File cannot be found");
        }
        System.out.println();
        System.out.println();

    }

    private static void sortcabin(Passenger[][] PassengerNew) {

        int z = 0;
        String[] cabin = new String[36];

        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 3; y++) {
                if (PassengerNew[x][y] == null) {
                    System.out.print("");
                }
                else if (z < 36) {
                    cabin[z] = PassengerNew[x][y].getfname();
                    ++z;
                }

            }
        }

        String temp;
        for (int x = 0; x < 12; x++) {
            for (int y = x + 1; y < 12; y++) {
                if (cabin[x] == null || cabin[y] == null) {
                    System.out.print("");
                }
                else  {
                    if (cabin[x].compareTo(cabin[y]) > 0) {
                        temp = cabin[x];
                        cabin[x] = cabin[y];
                        cabin[y] = temp;
                    }
                }
            }
        }

        System.out.println();
        for (int x = 0; x < 36; x++) {
            if (cabin[x] == null)
                System.out.print("");
            else {
                System.out.println(cabin[x]);
            }
        }
        System.out.println();
        System.out.println();
    }

    private static void expenses(Passenger[][] PassengerNew) {
        int[] expen = new int[36];

        int z = 0;
        for (int x = 0; x < 12; x++) {


            for (int y = 0; y < 3; y++) {
                if (PassengerNew[x][y] == null) {
                    System.out.print("");
                }
                else if (z < 36) {
                    expen[z] = PassengerNew[x][y].getexpense();
                    ++z;
                }
            }
        }

        int total = 0;
        for (int x = 0; x < 36; x++) {
            total += expen[x];
        }

        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 3; y++) {
                if (PassengerNew[x][y] != null) {
                    System.out.println("Cabin" + x + "'s slot " + y + " - " + PassengerNew[x][y].getexpense() );
                } else {
                    System.out.print("");
                }
            }
        }
        System.out.println("Total expenses of all passengers - " + total);
        System.out.println();


    }
}

