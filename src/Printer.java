/**
 * Created by Mike Plucker
 * Date: 3/8/2016
 */

import java.io.Serializable;

/**
 * A Printer class that will create an object for each printer and keep track of each printer's toner amounts
 */
public class Printer implements Serializable {

    //instance variables
    private String printerName;
    private int wasteBottle, blackToner, yellowToner, magentaToner, cyanToner, reorderNum;
    private int needWasteBottle, needBlackToner, needYellowToner, needMagentaToner, needCyanToner;


    //constructor with name + waste bottle + black + 3 colors + reorder number
    public Printer(String name, int bottle, int black, int yellow, int magenta, int cyan, int reorder){

        //validates data before initializing it
        setName(name);
        setWasteBottle(bottle);
        setBlackToner(black);
        setYellowToner(yellow);
        setMagentaToner(magenta);
        setCyanToner(cyan);
        setReorderNum(reorder);
    }


    //constructor with additional need to order variables
    public Printer(String name, int bottle, int black, int yellow, int magenta, int cyan, int reorder, int needBottle, int needBlack, int needYellow, int needMagenta, int needCyan){

        //validates data before initializing it
        setName(name);
        setWasteBottle(bottle);
        setBlackToner(black);
        setYellowToner(yellow);
        setMagentaToner(magenta);
        setCyanToner(cyan);
        setReorderNum(reorder);

        setNeedWasteBottle(needBottle);
        setNeedBlackToner(needBlack);
        setNeedYellowToner(needYellow);
        setNeedMagentaToner(needMagenta);
        setNeedCyanToner(needCyan);
    }


    //getters and setters for each attribute of the class
    public String getName(){
        return printerName;
    }

    public void setName(String name){
        printerName = name.toUpperCase();
    }

    public int getWasteBottle(){
        return wasteBottle;
    }

    public void setWasteBottle(int bottle){
        if(bottle < 0) { //validate that bottle isn't negative
            System.out.println("\nError: Waste Bottle can't be negative");
        }
        else{
            wasteBottle = bottle;
        }
    }

    public int getBlackToner(){
        return blackToner;
    }

    public void setBlackToner(int black){
        if(black < 0){ //validate that toner isn't negative
            System.out.println("\nError: Black Toner can't be negative");
        }
        else {
            blackToner = black;
        }
    }

    public int getYellowToner(){
        return yellowToner;
    }

    public void setYellowToner(int yellow){
        if(yellow < 0){ //validate that toner isn't negative
            System.out.println("\nError: Yellow Toner can't be negative");
        }
        else {
            yellowToner = yellow;
        }
    }

    public int getMagentaToner(){
        return magentaToner;
    }

    public void setMagentaToner(int magenta){
        if(magenta < 0){ //validate that toner isn't negative
            System.out.println("\nError: Magenta Toner can't be negative");
        }
        else {
            magentaToner = magenta;
        }
    }

    public int getCyanToner(){
        return cyanToner;
    }

    public void setCyanToner(int cyan){
        if(cyan < 0){ //validate that toner isn't negative
            System.out.println("\nError: Cyan Toner can't be negative");
        }
        else {
            cyanToner = cyan;
        }
    }

    public int getReorderNum(){
        return reorderNum;
    }

    public void setReorderNum(int reorder){
        if(reorder < 0){ //validate that reorder number isn't negative
            System.out.println("\nError: Reorder Number can't be negative");
        }
        else {
            reorderNum = reorder;
        }
    }

    public int getNeedWasteBottle(){
        return needWasteBottle;
    }

    public void setNeedWasteBottle(int needBottle){
        if(needBottle < 0){ //validate that needBottle isn't negative
            System.out.println("\nError: Waste bottle needed can't be negative");
        }
        else {
            needWasteBottle = needBottle;
        }
    }

    public int getNeedBlackToner(){
        return needBlackToner;
    }

    public void setNeedBlackToner(int needBlack){
        if(needBlack < 0){ //validate that needBlack isn't negative
            System.out.println("\nError: Black toner needed can't be negative");
        }
        else {
            needBlackToner = needBlack;
        }
    }

    public int getNeedYellowToner(){
        return needYellowToner;
    }

    public void setNeedYellowToner(int needYellow){
        if(needYellow < 0){ //validate that needYellow isn't negative
            System.out.println("\nError: Yellow toner needed can't be negative");
        }
        else {
            needYellowToner = needYellow;
        }
    }

    public int getNeedMagentaToner(){
        return needMagentaToner;
    }

    public void setNeedMagentaToner(int needMagenta){
        if(needMagenta < 0){ //validate that needMagenta isn't negative
            System.out.println("\nError: Magenta toner needed can't be negative");
        }
        else {
            needMagentaToner = needMagenta;
        }
    }

    public int getNeedCyanToner(){
        return needCyanToner;
    }

    public void setNeedCyanToner(int needCyan){
        if(needCyan < 0){ //validate that needCyan isn't negative
            System.out.println("\nError: Cyan toner needed can't be negative");
        }
        else {
            needCyanToner = needCyan;
        }
    }


    //returns a string containing all the attributes of the class with the most significant attributes appearing first.
    @Override
    public String toString(){
        return "\nPrinter Name: " + getName() + "\nWaste Bottle: " + getWasteBottle() + "\nBlack Toner: " + getBlackToner() +
                "\nYellow Toner: " + getYellowToner() + "\nMagenta Toner: " + getMagentaToner() + "\nCyan Toner: " + getCyanToner() +
                "\nReorder Number " + getReorderNum() + "\nWaste Bottle Needed: " + getNeedWasteBottle() + "\nBlack Toner Needed: " +
                getNeedBlackToner() + "\nYellow Toner Needed: " + getNeedYellowToner() + "\nMagenta Toner Needed; " + getNeedMagentaToner() +
                "\nCyan Toner Needed: " + getNeedCyanToner();
    }
}
