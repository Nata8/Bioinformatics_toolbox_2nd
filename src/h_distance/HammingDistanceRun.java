package h_distance;

import fasta.model.FastaParser;
import h_distance.model.HammingDistance;

import java.io.IOException;
import java.util.Scanner;

public class HammingDistanceRun {

    /**
     * method for task launching
     * @param sc
     * @throws IOException
     */
    public void run(Scanner sc) throws IOException {
        FastaParser parser = new FastaParser("textak.txt");

        parser.printMolecules();
        System.out.println("Select two molecules to calculate their Hamming distance...");
        System.out.print("First molecule - ");
        int firstChoice = sc.nextInt();
        System.out.print("Second molecule - ");
        int secondChoice = sc.nextInt();

        System.out.println("Hamming distance between given molecules is - "
                + new HammingDistance().hd(parser.getMolekula(firstChoice),parser.getMolekula(secondChoice)));

    }
}
