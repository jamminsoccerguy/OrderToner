/**
 * Created by Mike Plucker
 * Date: 3/8/2016
 */

import java.util.ArrayList;
import java.io.ObjectOutputStream; //output stream for Object
import java.io.FileOutputStream; //generic output stream
import java.io.ObjectInputStream; //input stream for Objects
import java.io.FileInputStream; //generic input stream
import java.io.*; //provide easy access to all IO Exceptions

/**
 * This class creates an ArrayList of the printers
 */
public class PrinterCollection {

    //create arrayList of printers
    private ArrayList<Printer> printerList = new ArrayList<>();


    //adds printer to end of printerList
    public boolean addPrinter(Printer printer){

        if(printer != null) { //if a valid object
            printerList.add(printer); //add printer to end of printerList
            return true;
        }
        System.out.println("\nError: Cannot add null printer.");
        return false; //printer isn't added
    }


    //removes and returns the printer at the index
    public Printer removePrinter(int index){

        if (printerList.isEmpty()){ //no printers in printerList
            System.out.println("\nError: No printers are currently on file.");
            return null;
        }
        else{
            Printer printer = printerList.remove(index);
            return printer;
        }
    }


    //returns the printer at the index
    public Printer getPrinter(int index){

        if(printerList.isEmpty()){ //no printers in printerList
            System.out.println("\nError: No printers are currently on file.");
            return null;
        }
        else{
            return printerList.get(index); //returns printer at that index
        }
    }


    //returns the size of printerList
    public int size(){
        return printerList.size();
    }


    //toString method for printerList
    public String toString(){
        return printerList.toString();
    }


    //writes the printerList information to a text file using Serialization
    public boolean writeToFile(File dataFile){

        ObjectOutputStream output;

        try{
            output = new ObjectOutputStream(new FileOutputStream(dataFile));

            //enhanced for loop that iterates over arrayList and writes to a file
            for(Printer write : printerList){ //iterates over printerList
                output.writeObject(write); //writes the printer objects to the file
            }
            output.close();
        }
        catch(IOException e){
            System.out.println("\nFile write problem to fix.");
        }
        return true;
    }


    //reads the printerList information from a text file using Serialization
    public boolean readFromFile(File dataFile){

        ObjectInputStream input;

        printerList.clear(); //clears the printerList

        try {
            input = new ObjectInputStream(new FileInputStream(dataFile));

            //reads the file until an EOFException is thrown
            while(true){
                Printer p = (Printer) input.readObject(); //reads a printer object
                printerList.add(p); //adds the printer object to the printerList
            }
            //input.close();
        } catch (EOFException e) {
            //System.out.println("\nEnd of File read.");
        } catch (IOException e) {
            System.out.println("\nIO problem to fix.");
        } catch (ClassNotFoundException e) {
            System.out.println("\nClass does not exist.");
        }
        return true;
    }


    //prints the printerList information to the console
    public void printToConsole(){

        //enhanced for loop to print out printer object information
        for(Printer print : printerList){ //iterates over printerList
            System.out.println(print); //prints the printer objects to the console
        }
    }
}
