public class InvalidSequenceException extends Exception {

    InvalidSequenceException(String error) {
        super(error);
    }

    /**
     * No-arg constructor
     */
    InvalidSequenceException(){};
}
