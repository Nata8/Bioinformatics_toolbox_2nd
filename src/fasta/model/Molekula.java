package fasta.model;

public class Molekula {
    private String info;
    private String aminoAcids;

    /**
     * constructor for molecule
     * @param info
     * @param aminoAcids
     */
    public Molekula(String info, String aminoAcids) {
        this.info = info;
        this.aminoAcids = aminoAcids;
    }


    public String getInfo() {
        return info;
    }

    public String getAminoAcids() {
        return aminoAcids;
    }

    public int getLenghtOfAmino() {
        return this.aminoAcids.length();
    }
}
