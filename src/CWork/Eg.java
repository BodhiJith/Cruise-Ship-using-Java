package CWork;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Eg {
    private static String[] sortcabin(String[] cabin) {
        for (int i = 0; i <cabin.length ; i++) {
            for (int j = i + 1; j < cabin.length; j++) {

                if (cabin[i].compareTo(cabin[j]) > 0) {
                    String temp;
                    temp = cabin[i];
                    cabin[i] = cabin[j];
                    cabin[j] = temp;
                }
            }
        }
        for (int i = 0; i < cabin.length; i++) {
            System.out.println(cabin[i]);
        }
        return cabin;
    }

    public static void main(String[] args) {

        String chamr;
        String[] cabin = new String[13];
        Scanner input = new Scanner(System.in);
        initialize(cabin);


        for (int i = 0; i < cabin.length; i++) {
            cabin[i] = "Empty";
        }

        while (true) {
            System.out.print("Enter a Input-");
            chamr = input.next();


            if (chamr.equals("A")) {
                cabin = add(cabin);


            } else if (chamr.equals("V")) {
                cabin = veiwe(cabin);

            } else if (chamr.equals("E")) {
                cabin = empty(cabin);

            } else if (chamr.equals("D")) {
                cabin = delete(cabin);


            } else if (chamr.equals("S")) {
                cabin = save(cabin);

            } else if (chamr.equals("L")) {
                cabin = load(cabin);

            } else if (chamr.equals("F")) {
                cabin = find(cabin);

            }
            else {
                System.out.println("Invalid Input");

            }

        }
    }



    private static void initialize(String cabinRef[]) {
        for (int x = 0; x < 12; x++) cabinRef[x] = "e";
        System.out.println("Welcome to Crouse Ship! ");
    }




    private static String[] empty(String cabin[]) {

        for (int x = 0; x < 12; x++) {
            if (cabin[x]=="Empty")
                System.out.println("room " + x + " is empty");
        }





        return cabin;
    }
    private static String[] add(String[] cabin) {
        int number = 0;
        String name;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Cabin Number :");
        number = input.nextInt();
        System.out.println("Enter the Pasenger Name :");
        name = input.next();
        cabin[number] = name;

        return cabin;
    }

    public static String[] veiwe(String[] cabin) {


        for (int x = 0; x < 12; x++) {

            System.out.println("cabin" + x + " occupied by " + cabin[x]);
        }



        return cabin;
    }
    public static String[] delete(String []cabin) {
        Scanner input= new Scanner(System.in);
        System.out.println("Enter the cabin number you want to remove a passenger");
        int i=input.nextInt();
        cabin[i]="Empty";
        return cabin;


    }



    private static String[] find(String[] cabin) {
        System.out.println("Find cabin from customer name");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        for (int i = 0; i < cabin.length; i++) {

            if (cabin[i].equals(name) ) {
                System.out.println("cabin number is :"+i);
            }
        }
        return cabin;
    }

    private static String[] save(String[] cabin) {
        try {
            FileWriter savecabin = new FileWriter("cabin.txt"); //creat a new object type file writer
            for (int i = 0; i < cabin.length; i++)
            {
                savecabin.write("cabin"+i+":"+cabin[i]+"\n");
            }

            savecabin.close();
            System.out.println("The file was successfully written to..");
        }catch (IOException e) {
            System.out.println("There was a mistake.");
            e.printStackTrace();
        }
        return cabin;
    }

    private static String[] load(String[] cabin) {
        File myObj = new File("cabin.txt");
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());

        } else {
            System.out.println("The file does not exist.");
        }
        return cabin;
    }
}
