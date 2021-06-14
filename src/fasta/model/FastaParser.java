package fasta.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FastaParser {

    private List<Molekula> molecules;

    /**
     * constructor of class
     * @param textFile
     * @throws IOException
     */
    public FastaParser(String textFile) throws IOException {
        this.molecules = new ArrayList<>();
        this.fillList(textFile);
    }

    /**
     * fill list of molecules from txt file
     * @param textFile
     * @throws IOException
     */
    private void fillList(String textFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(textFile));

        String st = null;
        String info = null;
        String amino = null;

        //new molecule name starts with >, then it is added to the list
        while((st = br.readLine()) != null) {
            if(st.startsWith(">")) {
                if(info != null){
                    molecules.add(new Molekula(info,amino));
                }
                info = st.substring(1);
                amino = "";
            } else {
                amino = amino + st;
            }
        }

        //last molecule
        molecules.add(new Molekula(info,amino));
    }

    /**
     * get sequence of molecule
     * @param molekula
     * @return
     */
    public String getSequence(String molekula){
        Molekula m = this.molecules
                .stream()
                .filter(molekula1 -> molekula1.getInfo().equals(molekula))
                .findAny()
                .orElse(null);

        assert m != null;
        return m.getInfo();
    }

    /**
     * @param i
     * @return lenght of sequence according to parameter
     */
    public int getLenghtOfSequence(int i) {
        return this.molecules.get(i).getLenghtOfAmino();
    }

    /**
     * find and print subsequence of sequence in a list of molecules
     * @param subsequence
     */
    public void findSubsequence(String subsequence) {
        List<Molekula> finded = this.molecules
                .stream()
                .filter(molekula -> molekula.getAminoAcids().contains(subsequence))
                .collect(Collectors.toList());

        System.out.println("Required subsequence is in " + finded.size() + " molecules. ");
        finded.forEach(molekula -> System.out.println(molekula.getInfo()));
        System.out.println("---------------");
    }

    /**
     * print molecules
     */
    public void printMolecules(){
        int count = 1;

        for(int i = 0; i < this.molecules.size(); i++){
            System.out.println(i + ". " + molecules.get(i).getInfo());
        }
    }

    /**
     * print molecule with index j
     * @param j
     */
    public void printMolekula(int j){
        for(int i = 0; i < this.molecules.size(); i++) {
            if (j == i) {
                System.out.println(i + ". " + molecules.get(i).getInfo());
                System.out.println(molecules.get(i).getAminoAcids());
                System.out.println("Length of amino sequence : " + molecules.get(i).getLenghtOfAmino());
            }
        }
    }

    /**
     * @param index
     * @return molecule from list according to index
     */
    public Molekula getMolekula(int index) {
        return index < this.molecules.size() && index >= 0 ? this.molecules.get(index) : null;
    }
}
