package msa.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MsaParser {
    private List<BiologicalSequence> list;
    private String lastRow;
    private BlosumMatrix blosumMatrix;

    /**
     * constructor
     * @param textFile
     * @throws IOException
     */
    public MsaParser(String textFile) throws IOException {
        this.list = new ArrayList<>();
        this.lastRow = "";
        this.blosumMatrix = new BlosumMatrix();
        this.blosumMatrix.loadMatrix();
        this.fillList(textFile);
    }

    /**
     * fill list from txt file
     * @param textFile
     * @throws IOException
     */
    private void fillList(String textFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(textFile));

        String st;
        String last = "";
        while((st = br.readLine()) != null) {
            if(st.matches("^\\S+[\\s]+\\S+")){
                String[] array = st.split("[\\s]+");

                if(this.list.stream().noneMatch(biologicalSequence -> biologicalSequence.getName().equals(array[0]))){
                    this.list.add(new BiologicalSequence(array[0],array[1]));
                } else {
                    this.list
                            .stream()
                            .filter(biologicalSequence1 -> biologicalSequence1.getName().contains(array[0]))
                            .findFirst().ifPresent(biologicalSequence -> biologicalSequence.setSequence(array[1]));
                }
            }
            if(last.matches("^\\S+[\\s]+\\S+") && st.contains(" ")){
                this.lastRow += st;
            }
            last = st;
        }
    }

    /**
     * @param column
     * @return column according to index
     */
    public List<Character> getColumn(int column) {
        return this.list
                .stream()
                .map(biologicalSequence -> biologicalSequence.getSequence().charAt(column))
                .collect(Collectors.toList());
    }

    /**
     * @param column
     * @return sum of pairs score for column using minimal entropy
     */
    public int sumOfPairsScoreOfColumn(int column){
        int sum = 0;
        List<Character> chars = this.getColumn(column);
        for(int i = 0; i < chars.size(); i++){
            for(int j = i + 1; j < chars.size(); j++){
                if(chars.get(i) == '-' || chars.get(j) == '-'){
                    sum = sum + (-4);
                } else {
                    sum = sum + this.blosumMatrix.getDistance(chars.get(i),chars.get(j));
                }
            }
        }
        return sum;
    }

    /**
     * @return sum of pairs score for whole MSA using minimal entropy
     */
    public int sumOfPairsScoreWholeMSA(){
        int sum = 0;
        int columns = this.list.get(0).getSequence().length(); //every sequence should have same length

        for(int i = 0; i < columns; i++){
            sum = sum + this.sumOfPairsScoreOfColumn(i);
        }
        return sum;
    }

    /**
     * @param column
     * @return conservation score for column
     */
    public double conservationScore(int column){
        double score = 1;
        HashMap<Character, Double> hashMap = new HashMap<>();
        List<Character> chars = this.getColumn(column);

        for(Character ch : chars) {
            if(ch == '-')
                continue;

            if(hashMap.containsKey(ch)){
                hashMap.replace(ch,hashMap.get(ch),hashMap.get(ch) + 1);
            } else {
                hashMap.put(ch,1d);
            }
        }

        for(Map.Entry me : hashMap.entrySet()){
            score = (score * Math.pow((Double) me.getValue()/chars.size(),(Double) me.getValue()));
        }
        return score;
    }

    /**
     * @param name
     * @return sequence according to its name
     */
    public String getSequence(String name){
        return Objects.requireNonNull(this.list.stream().filter(biologicalSequence -> biologicalSequence.getName().equals(name)).findFirst().orElse(null)).getSequence();
    }


    public List<BiologicalSequence> getList() {
        return list;
    }
}
