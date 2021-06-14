package msa.model;

public class BiologicalSequence {
    private String name;
    private String sequence;

    /**
     * constructor
     * @param name
     * @param sequence
     */
    public BiologicalSequence(String name, String sequence) {
        this.name = name;
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public String getSequence() {
        return sequence;
    }

    /**
     * @return number of amino acids
     */
    public int getNumberOfAminos(){
        int count = 0;
        for(int i = 0; i < this.sequence.length(); i++){
            if(this.sequence.charAt(i) != '-'){
                count++;
            }
        }
        return count;
    }

    /**
     * increment attribute sequence by param
     * @param sequence
     */
    public void setSequence(String sequence) {
        this.sequence += sequence;
    }

    @Override
    public String toString() {
        return "BiologicalSequence{" +
                "name='" + name + '\'' +
                ", sequence='" + sequence + '\'' +
                '}';
    }
}
