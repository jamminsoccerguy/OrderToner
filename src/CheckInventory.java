/**
 * Created by Mike Plucker
 * Date: 3/8/2016
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.*; //provide easy access to all IO Exceptions

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class contains the user interface
 */
public class CheckInventory {

    //instance variables
    private final File PRINTERDATA = new File("printerData.txt");
    //private final File PRINTERINVENTORY = new File("printerInventory.txt");
    private String textFileName;

    //create objects
    private Scanner scan = new Scanner(System.in);
    private PrintWriter write = null;
    private PrinterCollection printers = new PrinterCollection();



    //it all starts here!
    public void start(){

        printers.readFromFile(PRINTERDATA); //read in printer objects from file


        displayMenu(); //display the initial menu options


        printers.writeToFile(PRINTERDATA); //write current printer objects to file
    }


    //displays the initial menu
    public void displayMenu(){

        //local variables
        int displayMenu;

        System.out.println("Welcome!");
        System.out.println("1. List Printers ");
        System.out.println("2. Add Printer ");
        System.out.println("3. Update Printer ");
        System.out.println("4. Remove Printer ");
        System.out.println("5. Calculate Order ");
        System.out.println("6. Exit ");

        System.out.print("What action do you want to take? (enter #) ");
        displayMenu = scan.nextInt();

        while(displayMenu != 6) { //will loop until 6 is selected to exit program
            switch (displayMenu) {
                case 1:
                    listPrinters(); //displays any printers
                    break;
                case 2:
                    addPrinter(); //add printer
                    break;
                case 3:
                    updatePrinter(); //update printer
                    break;
                case 4:
                    removePrinter(); //remove printer
                    break;
                case 5:
                    calculateOrder(); //calculate order
                    break;
            }

            System.out.println("\n1. List Printers ");
            System.out.println("2. Add Printer ");
            System.out.println("3. Update Printer ");
            System.out.println("4. Remove Printer ");
            System.out.println("5. Calculate Order ");
            System.out.println("6. Exit ");

            System.out.print("What action do you want to take? (enter #) ");
            displayMenu = scan.nextInt();
        }

        System.out.println("\nThanks! Have a great day!");
    }


    //displays printers
    public void listPrinters(){

        //local variable
        String displayPrinter;

        System.out.print("\nDo you want to display any printers? (yes or no) ");
        displayPrinter = scan.next();

        while(!displayPrinter.equalsIgnoreCase("no")) { //loops until input is "no"
            if(displayPrinter.equalsIgnoreCase("yes")) { //validates if input is "yes"

                for(int i = 0; i < printers.size(); i++){ //iterates over printerList
                    System.out.println((i + 1) + ". " + printers.getPrinter(i).getName()); //prints out each printer's name in a list
                }

                System.out.print("\nDo you want to display any printers? (yes or no) ");
                displayPrinter = scan.next();
            }
            else{ //if input is neither "yes" or "no"
                System.out.print("Error: Invalid Input. Enter Yes or No. ");
                displayPrinter = scan.next();
            }
        }
    }


    //reads in printer names
    public String nameInput () {

        //local variables
        String name = "";
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); //creates buffered reader

        try {
            name = buffer.readLine(); //reads in user's input
        }catch(IOException e){
            System.out.println("IO Error");
        }
        return name;
    }


    //checks whether to add any printers
    public void addPrinter(){

        //local variables
        String addPrinter, inputName = "";
        int inputWaste, inputBlack, inputYellow, inputMagenta, inputCyan, inputReorder;


        System.out.print("\nDo you want to add a printer? (yes or no) ");
        addPrinter = scan.next();

        while(!addPrinter.equalsIgnoreCase("no")){ //loops until input is "no"
            if(addPrinter.equalsIgnoreCase("yes")) { //validates if input is "yes"
                System.out.print("What is the printer name? ");
                inputName = nameInput(); //reads input for printer name

                System.out.print("How many waste toner bottles are there? ");
                inputWaste = scan.nextInt();

                System.out.print("How many black toner cartridges are there? ");
                inputBlack = scan.nextInt();

                System.out.print("How many yellow toner cartridges are there? ");
                inputYellow = scan.nextInt();

                System.out.print("How many magenta toner cartridges are there? ");
                inputMagenta = scan.nextInt();

                System.out.print("How many cyan toner cartridges are there? ");
                inputCyan = scan.nextInt();

                System.out.print("What is this printer's reorder number? ");
                inputReorder = scan.nextInt();


                Printer newPrinter = new Printer(inputName, inputWaste, inputBlack, inputYellow, inputMagenta, inputCyan, inputReorder); //creates new printer object
                printers.addPrinter(newPrinter); //add new printer to printerList


                System.out.print("\nDo you want to add any more printers? (yes or no) "); //check if there are more printers to add
                addPrinter = scan.next();
            }
            else{ //if input is neither "yes" or "no"
                System.out.print("Error: Invalid Input. Enter Yes or No. ");
                addPrinter = scan.next();
            }
        }
    }


    //check whether to update any printer info
    public void updatePrinter(){

        //local variables
        String updatePrinter;
        int printerNum, inputWaste, inputBlack, inputYellow, inputMagenta, inputCyan, inputReorder;
        Printer printer;


        System.out.print("\nDo you want to update a printer? (yes or no) ");
        updatePrinter = scan.next();

        while(!updatePrinter.equalsIgnoreCase("no")){ //loops until input is "no"
            if(updatePrinter.equalsIgnoreCase("yes")) { //validates if input is "yes"
                for(int i = 0; i < printers.size(); i++){ //iterates over printerList
                    System.out.println((i + 1) + ". " + printers.getPrinter(i).getName()); //prints out each printer's name in a list
                }

                System.out.print("\nWhat printer do you want to update? (enter #) ");
                printerNum = (scan.nextInt() - 1);
                printer = printers.getPrinter(printerNum); //gets selected printer


                System.out.println("\nPrinter Name: " + printer.getName());

                System.out.print("How many waste toner bottles are there? ");
                inputWaste = scan.nextInt();
                printer.setWasteBottle(inputWaste);

                System.out.print("How many black toner cartridges are there? ");
                inputBlack = scan.nextInt();
                printer.setBlackToner(inputBlack);

                System.out.print("How many yellow toner cartridges are there? ");
                inputYellow = scan.nextInt();
                printer.setYellowToner(inputYellow);

                System.out.print("How many magenta toner cartridges are there? ");
                inputMagenta = scan.nextInt();
                printer.setMagentaToner(inputMagenta);

                System.out.print("How many cyan toner cartridges are there? ");
                inputCyan = scan.nextInt();
                printer.setCyanToner(inputCyan);

                System.out.print("What is this printer's reorder number? ");
                inputReorder = scan.nextInt();
                printer.setReorderNum(inputReorder);

                System.out.println("Done updating printer: " + printer.getName());


                System.out.print("\n\nDo you want to update any more printers? (yes or no) "); //check if there are more printers to update
                updatePrinter = scan.next();
            }
            else{ //if input is neither "yes" or "no"
                System.out.print("Error: Invalid Input. Enter Yes or No. ");
                updatePrinter = scan.next();
            }
        }
    }


    //check whether to remove any printers
    public void removePrinter(){

        //local variables
        String removePrinter;
        int printerNum;
        Printer printer;


        System.out.print("\nDo you want to remove a printer? (yes or no) ");
        removePrinter = scan.next();

        while(!removePrinter.equalsIgnoreCase("no")) { //loops until input is "no"
            if(removePrinter.equalsIgnoreCase("yes")) { //validates if input is "yes"
                for(int i = 0; i < printers.size(); i++){ //iterates over printerList
                    System.out.println((i + 1) + ". " + printers.getPrinter(i).getName()); //prints out each printer's name in a list
                }

                System.out.print("\nWhat printer do you want to remove? (enter #) ");
                printerNum = (scan.nextInt() - 1);
                printer = printers.removePrinter(printerNum); //removes selected printer

                System.out.println("\nYou removed printer: " + printer.getName());


                System.out.print("\n\nDo you want to remove any more printers? (yes or no) "); //check if there are more printers to remove
                removePrinter = scan.next();
            }
            else{ //if input is neither "yes" or "no"
                System.out.print("Error: Invalid Input. Enter Yes or No. ");
                removePrinter = scan.next();
            }
        }
    }


    //calculate what supplies to order
    public void calculateOrder(){

        //local variables
        String calculateOrder;


        System.out.print("\nDo you want to calculate a toner order? (yes or no) ");
        calculateOrder = scan.next();

        while(!calculateOrder.equalsIgnoreCase("no")) { //loops until input is "no"
            if(calculateOrder.equalsIgnoreCase("yes")) { //validates if input is "yes"

                for(int i = 0; i < printers.size(); i++){ //iterates over printerList
                    System.out.println("\nPrinter: " + printers.getPrinter(i).getName() + " needs to order: "); //print out printer's name

                    //check waste bottle count
                    if(printers.getPrinter(i).getWasteBottle() <= printers.getPrinter(i).getReorderNum()){
                        printers.getPrinter(i).setNeedWasteBottle(printers.getPrinter(i).getReorderNum() - printers.getPrinter(i).getWasteBottle());
                        System.out.println("Waste Bottle(s): " + printers.getPrinter(i).getNeedWasteBottle());
                    }

                    //check black toner count
                    if(printers.getPrinter(i).getBlackToner() <= printers.getPrinter(i).getReorderNum()){
                        printers.getPrinter(i).setNeedBlackToner(printers.getPrinter(i).getReorderNum() - printers.getPrinter(i).getBlackToner());
                        System.out.println("Black Toner Cartridge(s): " + printers.getPrinter(i).getNeedBlackToner());
                    }

                    //check yellow toner count
                    if(printers.getPrinter(i).getYellowToner() <= printers.getPrinter(i).getReorderNum()){
                        printers.getPrinter(i).setNeedYellowToner(printers.getPrinter(i).getReorderNum() - printers.getPrinter(i).getYellowToner());
                        System.out.println("Yellow Toner Cartridge(s): " + printers.getPrinter(i).getNeedYellowToner());
                    }

                    //check magenta toner count
                    if(printers.getPrinter(i).getMagentaToner() <= printers.getPrinter(i).getReorderNum()){
                        printers.getPrinter(i).setNeedMagentaToner(printers.getPrinter(i).getReorderNum() - printers.getPrinter(i).getMagentaToner());
                        System.out.println("Magenta Toner Cartridge(s): " + printers.getPrinter(i).getNeedMagentaToner());
                    }

                    //check cyan toner count
                    if(printers.getPrinter(i).getCyanToner() <= printers.getPrinter(i).getReorderNum()){
                        printers.getPrinter(i).setNeedCyanToner(printers.getPrinter(i).getReorderNum() - printers.getPrinter(i).getCyanToner());
                        System.out.println("Cyan Toner Cartridge(s): " + printers.getPrinter(i).getNeedCyanToner());
                    }
                }

                //writes the reorder data to a text file
                writeTextToFile();

                return;
            }
            else{ //if input is neither "yes" or "no"
                System.out.print("Error: Invalid Input. Enter Yes or No. ");
                calculateOrder = scan.next();
            }
        }
    }


    //writes the reorder information to a text file
    public boolean writeTextToFile(){

        //local variables
        int ticket;
        String date;
        File textFile;

        System.out.print("\nWhat is the ticket number? ");
        ticket = scan.nextInt();

        date = getDate(); //get current date and time

        //name the new text file
        textFileName = "PrinterInventory_" + date + ".txt";
        textFile = new File(textFileName);


        System.out.println("\nTicket Number: " + ticket);
        System.out.println("Date: " + date);
        System.out.println("FileName: " + textFile);


        try{
            write = new PrintWriter(new BufferedWriter(new FileWriter(textFile))); //creates new printWriter

            write.println("\nTicket Number: " + ticket); //prints ticket number
            write.println("Date: " + date); //prints current date or reorder

            for(int i = 0; i < printers.size(); i++){ //iterates over printerList
                write.println();
                write.println("Printer: " + printers.getPrinter(i).getName() + " needs to order: ");
                write.println("Waste Bottle(s): " + printers.getPrinter(i).getNeedWasteBottle());
                write.println("Black Toner Cartridge(s): " + printers.getPrinter(i).getNeedBlackToner());
                write.println("Yellow Toner Cartridge(s): " + printers.getPrinter(i).getNeedYellowToner());
                write.println("Magenta Toner Cartridge(s): " + printers.getPrinter(i).getNeedMagentaToner());
                write.println("Cyan Toner Cartridge(s): " + printers.getPrinter(i).getNeedCyanToner());
            }
        }catch(IOException e){
            System.out.println("IO Error!");
        }finally{
            if(write != null){
                write.close(); //closes printWriter
            }
        }
        return true;
    }


    //returns current date and time
    public String getDate(){

        DateFormat dateFormat = new SimpleDateFormat("EEE-MM-dd-yyyy"); //creates date formatter

        Date date = new Date(); //gets current date and time

        return dateFormat.format(date); //returns formatted date and time
    }


    //prints the printerList information to the console
    public void printToConsole(){
        printers.printToConsole();
    }
}
