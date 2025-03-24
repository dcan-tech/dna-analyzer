// Programmer: Dylan Canfield
// Class: CS &141
// Date 6*/2022
// Assignment: Lab 6 : DNA File Check
// read from file
// find string patterns and display results
// Use provided data for mass percentages
// Check results for possible protein value
import java.io.*;
import java.util.*;


public class DNALab {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        intro();
        processFile();

    } // end of main method

    public static void intro() { // program information
        System.out.println("This program reports information about DNA");
        System.out.println("nucleotide sequences that may encode proteins");
        System.out.println();
    } // end of intro

    private static void processFile() throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        File inFile = whatFile(console); // call whatFile method
        Scanner read = new Scanner(inFile);
        String nLine = read.nextLine();

        PrintStream output = new PrintStream(output(console));
        while (read.hasNextLine()) {
            String nName = nLine;
            String nucRow = read.nextLine().toUpperCase();
            // assign count to numberOfNucs array
            int[] numberOfNucs = howManyNucs(nucRow);
            // assign mass percentage to massP array
            double[] massP = massPercentage(numberOfNucs);
            String [] codon = codon(nucRow.replace("-", "")); // check for junk
            boolean protein = proteinCheck(codon, massP); // protein check
            // call output method
            outputToFile(nName, nucRow, numberOfNucs, massP, codon,
                    output, protein);
            if (read.hasNextLine()) {
                nLine = read.nextLine();
            }
        }  // end of while / read file
    } // end of processFile

    public static File whatFile(Scanner console) { // ask for file
        System.out.print("Input file name: ");
        File answer = new File(console.nextLine());

        while(!answer.exists()) {
            System.out.println("File not found. Try again: ");
            answer = new File(console.nextLine());	} // end of filename check
        return  answer;
    }  // end of whatFile method

    public static File output(Scanner console) { // where to send output
        System.out.print("Output file name: ");
        File fileName = new File (console.nextLine());
        return fileName;
    } // end of output method

    public static int[] howManyNucs(String lineNucs)  { // nucleotides counter
        int[] nucCount = new int[4];
        for (int i = 0; i < lineNucs.length(); i++)  {
            int index = "ACGT".indexOf(lineNucs.charAt(i)); // ACGT check
            if (index >= 0)   {
                nucCount[index]++; // add to nucCount array
            }
        } // end of ACGT check
        return nucCount; // totals
    } // end of howManyNucs method

    public static double[] massPercentage (int[] nucCount) { // mass percentage
        double[] mass = {135.128, 111.103, 151.128, 125.107};
        double[] massOfEach = new double[4];
        double[] massPercent = new double[4];
        double massSum = 0;
        for (int m = 0; m < 4; m++) {
            massOfEach[m] = ((nucCount[m]) * (mass[m]));
            massSum = massOfEach[m]+ massSum;
        }
        for (int p = 0; p < 4; p++) {
            massPercent[p] = Math.round((massOfEach[p] / massSum) * 1000.0)/10.0;
        }
        return massPercent;
    } // end of massPercentage method
    // put codons in groups of 3
    public static String[] codon(String lineOfNucs) {
        String[] codon = new String [(lineOfNucs.length() / 3)];
        int indexStart = 0;
        for (int c = 0; c < codon.length; c++) {
            codon[c] = lineOfNucs.substring(indexStart, (indexStart + 3));
            indexStart = indexStart + 3;
        }
        return codon;
    } // end of codon method

    public static boolean proteinCheck(String[] codon, double[] massPercent)  {
        if (!codon[0].equals("ATG")) { // start with ATG
            return false; }

        if ((!codon[codon.length-1].equals("TAA")) && (!codon[codon.length-1].equals("TAG")) &&
                (!codon[codon.length-1].equals("TGA"))) {
            return false; } // check ending

        if (codon.length < 5) { // check length
            return false; }

        if ((massPercent[1] + massPercent[2]) < 30) {
            return false; } // check percentage mass

        return true; // is a protein
    }  // end of proteinCheck method
    // output to file
    public static void outputToFile (String nName, String nNucs, int[] nucCounts,
                                     double[] massPercent, String[] codons, PrintStream output, boolean protein) {
        output.println("Region Name: " + nName);
        output.println("Nucleotides: " + nNucs);
        output.println("Nucleotide counts: " + Arrays.toString(nucCounts));
        output.println("Mass percentages: " + Arrays.toString(massPercent));
        output.println("Codons: " + Arrays.toString(codons));
        output.print("Encodes a protein: ");
        if (protein == true) {
            output.println("yes");
        } else {
            output.println("no"); }
        output.println();
    } // end of outputToFile method

} // end of dnaLbDylanCanfield class
