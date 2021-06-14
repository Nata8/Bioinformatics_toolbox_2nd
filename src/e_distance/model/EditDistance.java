package e_distance.model;

import java.util.ArrayList;
import java.util.List;

public class EditDistance {

    private int D[][];

    /**
     * constructor
     * @param firstSequenceLenght
     * @param secondSequenceLenght
     */
    public EditDistance(int firstSequenceLenght, int secondSequenceLenght) {
        this.D = new int[firstSequenceLenght + 1][secondSequenceLenght + 1];
    }

    /**
     * @param x
     * @param y
     * @param z
     * @return minimum of two numbers
     */
    private int min(int x, int y, int z) {
        return Math.min(x, Math.min(y,z));
    }

    /**
     * @param firstSequence
     * @param secondSequence
     * @return edit distance of two sequences
     */
    public int ed(String firstSequence, String secondSequence){
        for(int i = 0; i <= firstSequence.length(); i++){
            for(int j = 0; j <= secondSequence.length(); j++){
                if(i == 0){
                    this.D[0][j] = j;
                } else if(j == 0) {
                    this.D[i][0] = i;
                } else if(firstSequence.charAt(i - 1) == secondSequence.charAt(j - 1)){
                    this.D[i][j] = this.D[i - 1][j - 1];
                } else {
                    this.D[i][j] = 1 + min(this.D[i][j - 1], this.D[i - 1][j], this.D[i - 1][j - 1]);
                }
            }
        }
        this.backtracking(" " + firstSequence, " " + secondSequence);
        return this.D[firstSequence.length()][secondSequence.length()];
    }

    /**
     * backtracking for alignment of two sequences
     * @param firstSequence
     * @param secondSequence
     */
    private void backtracking(String firstSequence, String secondSequence) {
        int j = secondSequence.length() - 1;
        int i = firstSequence.length() - 1;

        List<int[]> list = new ArrayList<>();
        int[] arr = {i ,j, 0};
        list.add(arr);

        while(i != 0 && j != 0) {
            int[] positions = this.positionsOfMin(i,j);
            list.add(positions);
            i = positions[0];
            j = positions[1];
        }
        list.add(new int[3]);

        String first = "";
        String second = "";

        for(int k = 0; k < list.size() - 1; k++){
            if(list.get(k)[0] == list.get(k + 1)[0] && list.get(k)[1] > list.get(k + 1)[1]) {
                first = "-" + first;
                second = secondSequence.charAt(list.get(k)[1]) + second;
            } else if(list.get(k)[0] > list.get(k + 1)[0] && list.get(k)[1] == list.get(k+1)[1]) {
                first = firstSequence.charAt(list.get(k)[0]) + first;
                second = "-" + second;
            } else if(list.get(k)[0] > list.get(k + 1)[0] && list.get(k)[1] > list.get(k+1)[1]) {
                first = firstSequence.charAt(list.get(k)[0]) + first;
                second = secondSequence.charAt(list.get(k)[1]) + second;
            }
        }
        System.out.println(first);
        System.out.println(second);
    }

    /**
     * @param i
     * @param j
     * @return array of minimum positions
     */
    private int[] positionsOfMin(int i, int j){
        int[] positions = new int[2];
        int data = this.min(this.D[i][j - 1], this.D[i - 1][j], this.D[i - 1][j - 1]);

        if(this.D[i - 1][j - 1] == data){
            positions[0] = i - 1;
            positions[1] = j - 1;
        } else if(this.D[i][j - 1] == data) {
            positions[0] = i;
            positions[1] = j - 1;
        } else if(this.D[i - 1][j] == data) {
            positions[0] = i - 1;
            positions[1] = j;
        }
        return positions;
    }
}
