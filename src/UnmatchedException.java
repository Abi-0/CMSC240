public class UnmatchedException extends Exception{

    UnmatchedException(String error) {
        super(error);
    }

    /**
     * No-arg constructor
     */
    UnmatchedException(){};
}
