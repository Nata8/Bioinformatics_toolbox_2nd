package h_distance.exceptions;

/**
 * exception for different lengths of sequences
 */
public class DifferentDistancesException extends RuntimeException {
    public DifferentDistancesException(String message) {
        super(message);
    }
}
