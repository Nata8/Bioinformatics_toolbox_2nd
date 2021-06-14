package e_distance;

import e_distance.model.EditDistance;

import java.util.Scanner;

public class EditDistanceRun {

    /**
     * run the task
     * @param sc
     */
    public void run(Scanner sc) {
        sc.nextLine();
        System.out.println("Write sequences to find edit distance");
        System.out.print("First sequence - ");
        String firstSequence = sc.nextLine();
        System.out.print("Second sequence - ");
        String secondSequence = sc.nextLine();

        EditDistance editDistance = new EditDistance(firstSequence.length(),secondSequence.length());
        System.out.println("Edit distance - " + editDistance.ed(firstSequence.toUpperCase(),secondSequence.toUpperCase()));
    }
}
