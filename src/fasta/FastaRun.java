package fasta;

import fasta.model.FastaParser;

import java.io.IOException;
import java.util.Scanner;

public class FastaRun {


    /**
     * method for running fasta parser
     * @param sc
     * @throws IOException
     */
    public void run(Scanner sc) throws IOException {
        //File loading
        FastaParser fastaParser = new FastaParser("textak.txt");
        fastaParser.printMolecules();
        /* OUTPUT */
        System.out.println("--------------");
        System.out.println("Find subsequence in file - 1");
        System.out.println("Get length of a sequence - 2");
        System.out.println("Get info about selected molecule - 3");
        System.out.print("YOUR CHOICE - ");
        int input = sc.nextInt();
        //Switch for above select options
        switch (input){
            case 1:
                System.out.print("Enter subsequence - ");
                sc.nextLine();
                String subsequence = sc.nextLine();
                fastaParser.findSubsequence(subsequence.toUpperCase());
                break;
            case 2:
                System.out.print("Select serial number of molecule - ");
                int i = sc.nextInt();
                System.out.println("Sequence length of this molecule is " + fastaParser.getLenghtOfSequence(i));
                break;
            case 3:
                System.out.print("Select serial number of molecule - \n");
                int j = sc.nextInt();
                fastaParser.printMolekula(j);
                break;
            default:
                System.out.println("Wrong choice");
        }
    }
}
