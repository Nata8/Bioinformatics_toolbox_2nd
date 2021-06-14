package h_distance.model;

import fasta.model.Molekula;
import h_distance.exceptions.DifferentDistancesException;

/**
 * class representing computation of Hamming distance
 */
public class HammingDistance {
    /**
     * @param first
     * @param second
     * @return Hamming distance of two molecules
     */
    public int hd(Molekula first, Molekula second){
        int counter = 0;
        if(first.getLenghtOfAmino() == second.getLenghtOfAmino()){
            for(int i = 0; i < first.getAminoAcids().length(); i++){
                if(first.getAminoAcids().charAt(i) != second.getAminoAcids().charAt(i)) {
                    counter++;
                }
            }
        } else {
            throw new DifferentDistancesException("lengths are different");
        }

        return counter;
    }
}
