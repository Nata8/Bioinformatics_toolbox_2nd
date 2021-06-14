import conservation_score.ConservationScoreRun;
import e_distance.EditDistanceRun;
import fasta.FastaRun;
import h_distance.HammingDistanceRun;
import msa.MsaRun;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

    /**
     * main method for starting of app
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int choice = -1;

        System.out.println("\033[0;1mBASIC METHODS FROM THE BIOINFORMATICS FIELD\n");
        while (choice != 6) {
            System.out.println("__________________________________________________________________");
            System.out.println("Fasta parser - 1");
            System.out.println("Hamming distance - 2");
            System.out.println("Edit distance - 3");
            System.out.println("Msa parser - 4");
            System.out.println("Conservation score of column - 5");
            System.out.println("Exit - 6");
            System.out.println("-----------------------------------------------------------------");
            System.out.print("YOUR CHOICE - \n");
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Wrong input");
                return;
            }

            switch(choice){
                case 1:
                    new FastaRun().run(sc);
                    break;
                case 2:
                    new HammingDistanceRun().run(sc);
                    break;
                case 3:
                    new EditDistanceRun().run(sc);
                    break;
                case 4:
                    new MsaRun().run(sc);
                    break;
                case 5:
                    new ConservationScoreRun().run(sc);
                    break;
            }
        }
    }
}
