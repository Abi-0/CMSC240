public class NoLowerAlphaException extends Exception {

    NoLowerAlphaException(String error) {
        super(error);
    }

    /**
     * No-arg constructor
     */
    NoLowerAlphaException(){};
}
