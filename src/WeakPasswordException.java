public class WeakPasswordException extends Exception{

    WeakPasswordException(String error) {
        super(error);
    }

    /**
     * no-arg constructor
     */
    WeakPasswordException(){};
}
