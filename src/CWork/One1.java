
package CWork;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

public class One1 {

    public static void main(String args[]) {
        //create a static array size is 12
        String[] cabins = new String[12];

        Scanner input = new Scanner(System.in);
        // String[] cabins = new String[12];
        //in for loop display options
        for (int i=0;i<100;i++){

            System.out.println("A:- Adds customer to cabin:-");
            System.out.println("v:- Views All cabins:-");
            System.out.println("E:- Display Empty cabins:-");
            System.out.println("D:- Delete customer from cabin:-");
            System.out.println("F:- Find cabin from customer name:-");
            System.out.println("S:- Store Program data into file:-");
            System.out.println("L:- Load Program data from file:-");
            System.out.println("O:- View passengers Ordered alphabetically by name:-");
            System.out.println();

            System.out.print("what is your Choice:-");
            String selector = input.next();

            //check user input letter using if statement

            if (selector.equals("A")) {
                //call add method
                cabins=add(cabins);

            }

            if (selector.equals("V")) {
                //call view method
                cabins=view(cabins);

            }

            if (selector.equals("E")){
                //call empty method
                cabins=  empty(cabins);

            }

            if (selector.equals("D")){
                //call delete method
                cabins= delete(cabins);

            }

            if (selector.equals("F")){
                //call find method
                find(cabins);

            }

            if (selector.equals("O")){
                //call sortcabin method
                cabins=  sortcabin(cabins);
            }


            if (selector.equals("S")){
                //call save method
                cabins=  save(cabins);
            }



            if (selector.equals("L")){
                //call load method
                cabins=  load(cabins);
            }
        }
    }

    //implement load method
    private static String[] load(String[] cabin) {
        //get File object
        File myObj = new File("D:\\cabin.txt");
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());

        } else {
            System.out.println("The file does not exist.");
        }
        return cabin;
    }

    //implement save method
    private static String[] save(String[] cabin) {
        //to create try catch
        try {
            //create save file
            FileWriter saveArray = new FileWriter("D:\\cabin.txt");
            for (int i = 0; i < cabin.length; i++)
            {
                saveArray.write("cabin"+i+":"+cabin[i]+"\n");
            }
            //close file
            saveArray.close();
            System.out.println("Sucess......");
        }catch (IOException saveArray) {
            System.out.println("Something went wrong.....");
            saveArray.printStackTrace();
        }
        //return statement
        return cabin;
    }




    //implement sortcabin method
    private static String[] sortcabin(String[] cabins) {
        System.out.println("Start Sort");
        //check null index
        for (int i = 0; i < cabins.length ; i++) {
            for (int j = i + 1; j < cabins.length; j++) {
                if (cabins[i]==null | cabins[j]==null){
                    System.out.print("");
                    //check not null index
                }else if (cabins[i]!=null | cabins[j]!=null){
                    if (cabins[i].compareTo(cabins[j]) > 0) {
                        String temp;
                        temp = cabins[i];
                        cabins[i] = cabins[j];
                        cabins[j] = temp;
                    }
                }
            }
        }
        //display cabins array
        for (int i = 0; i < cabins.length; i++) {
            System.out.println(cabins[i]);
        }
        System.out.println("End sort");
        return cabins;
    }

    private static String[] ordered(String[] cabins1) {
        System.out.println("Sort");
        try {
            cabins1 = Stream.of(cabins1).sorted().toArray(String[]::new);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }

        //Sort the array in alphabetical order

        System.out.println("Sorted : " + Arrays.toString(cabins1));


        return cabins1;
    }


    //implement find method
    private static void find(String[] cabins) {
        try {
            //import Scanner
            Scanner input=new Scanner(System.in);
            System.out.print("What do you want Customer Cabin Number:-");
            String cstCbnName=input.next();
            for (int i=0;i<cabins.length;i++) {
                if (cabins[i] == null){
                    System.out.print("");
                }else{
                    //check name is equal or not
                    if(cabins[i].equals(cstCbnName)) {
                        System.out.println(cstCbnName + " :room number is " + i);
                    }else{
                        System.out.println("");
                    }
                }
            }

        }catch (Exception e){
            System.out.println("Something went wrong..");

        }


    }

    //implement delete method
    private static String[] delete(String[] cabins) {
        try {

            //import scanner
            Scanner input=new Scanner(System.in);
            //get delete cabin number
            System.out.print("What do you want delete cabin Number:-");
            int dltCbnNumber= input.nextInt();
            //check cabin number is null
            if (cabins[dltCbnNumber] == null){
                System.out.println("Sorry There are no Customer");
            }else {
                cabins[dltCbnNumber]=null;
                System.out.println("cabin "+dltCbnNumber+"is now clear");
            }
        }catch (Exception e){
            System.out.println("Something went wrong..");

        }
        return cabins;
    }

    //implement empty method
    private static String[] empty(String[] cabins) {
        for (int i=0;i< cabins.length;i++){
            //check cabins are null and display it
            if (cabins[i]==null){
                System.out.println("cabin "+i);
            }
        }
        return cabins;
    }


    //implement view method
    private static String[] view(String[] cabins) {
        System.out.println("View");
        //for loop run to cabins.length
        for (int i=0;i<cabins.length;i++){
            System.out.println("Cabin "+i+" :-"+cabins[i]);
        }
        return cabins;
    }

    //implement add method
    private static String[] add(String[] cabins) {
        try {
            System.out.println("Add a Customer to a Cabin..");
            System.out.println();
            //import scanner
            Scanner input=new Scanner(System.in);
            //get room number
            System.out.print("What do you want Room Number:-");
            int cabinNumber = input.nextInt();
            //check cabin is null or not
            if (cabins[cabinNumber]==null){
                System.out.print("What is customer Name:-");
                String name = input.next();
                cabins[cabinNumber]=name;

                System.out.println("Customer Added..");
                System.out.println();
            }else{
                System.out.println("Sorry this cabin is already exit..");
                System.out.println();
            }

        }catch (Exception e){
            System.out.println("Something went wrong..");

        }

        return cabins;
    }

}



