public class NoUpperAlphaException extends Exception{

    NoUpperAlphaException(String error) {
        super(error);
    }

    /**
     * No-arg constructor
     */
    NoUpperAlphaException(){};
}
