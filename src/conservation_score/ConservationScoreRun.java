package conservation_score;

import msa.model.MsaParser;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ConservationScoreRun {

    public void run(Scanner sc) throws IOException {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.print("Index of column: ");
        int index = sc.nextInt();
        System.out.println("Conservation score for " + index + ". column = " + df.format(new MsaParser("msa.txt").conservationScore(index)));
    }
}
