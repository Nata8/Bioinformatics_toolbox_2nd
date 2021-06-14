package msa.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BlosumMatrix {

    private List<List<Integer>> matrix;

    /**
     * load data from txt file and save them to list
     * @throws IOException
     */
    public void loadMatrix() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("matrix.txt"));

        this.matrix = new ArrayList<>();
        String st = null;

        int row = 0;
        while((st = br.readLine()) != null) {
            String[] numbers = st.split(" ");

            this.matrix.add(new ArrayList<>());
            for (int i = 0; i < numbers.length; i++) {
                if (!numbers[i].equals(""))
                    this.matrix.get(row).add(Integer.parseInt(numbers[i]));
            }
            row++;
        }
        int b = 0;
    }

    /**
     * @param a
     * @return index of amino acid
     */
    private Integer getIndex(char a) {
        switch ((String.valueOf(a)).toUpperCase().charAt(0)) {
            case 'A': return 0;
            case 'R': return 1;
            case 'N': return 2;
            case 'D': return 3;
            case 'C': return 4;
            case 'Q': return 5;
            case 'E': return 6;
            case 'G': return 7;
            case 'H': return 8;
            case 'I': return 9;
            case 'L': return 10;
            case 'K': return 11;
            case 'M': return 12;
            case 'F': return 13;
            case 'P': return 14;
            case 'S': return 15;
            case 'T': return 16;
            case 'W': return 17;
            case 'Y': return 18;
            case 'V': return 19;
            default: return null;
        }
    }

    public List<List<Integer>> getMatrix() {
        return matrix;
    }

    /**
     * @param i
     * @param j
     * @return matrix score for two amino acids
     */
    private Integer getDistance(int i, int j) {
        return (i >= 0 && i < matrix.size()) && (j >= 0 && j < matrix.size()) ? matrix.get(i).get(j) : null;
    }

    /**
     * @param a1
     * @param a2
     * @return matrix score for two amino acids
     */
    public Integer getDistance(char a1, char a2) {
        return getIndex(a1) != null && getIndex(a2) != null ? getDistance(getIndex(a1),getIndex(a2)) : null;
    }
}
