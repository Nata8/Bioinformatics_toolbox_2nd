package msa;

import msa.model.MsaParser;

import java.io.IOException;
import java.util.Scanner;


public class MsaRun {
    /**
     * run this task
     * @param sc
     * @throws IOException
     */
    public void run(Scanner sc) throws IOException {
        MsaParser msaParser = new MsaParser("msa.txt");
        System.out.println("Retrieve sequence by ID - 1");
        System.out.println("Retrieve given column from the MSA - 2");
        System.out.println("Retrieve sum of pairs score of a column - 3");
        System.out.println("Retrieve sum of pairs score of whole MSA - 4");
        System.out.print("YOUR CHOICE - ");
        int input = sc.nextInt();
        switch(input){
            case 1:
                System.out.print("Write id: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.println(msaParser.getSequence(name));
                break;
            case 2:
                System.out.print("Index of column: ");
                msaParser.getColumn(sc.nextInt()).forEach(System.out::println);
                break;
            case 3:
                System.out.print("Index of column: ");
                System.out.println(msaParser.sumOfPairsScoreOfColumn(sc.nextInt()));
                break;
            case 4:
                System.out.println(msaParser.sumOfPairsScoreWholeMSA());
                break;
            default:
                System.out.println("Wrong choice.");
        }
    }
}
