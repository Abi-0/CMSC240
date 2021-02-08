import java.util.ArrayList;
public interface PasswordCheckerInterface {
    static boolean isValidPassword (String passwordString) throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException{return false;};
    ArrayList<String> validPasswords (ArrayList<String> passwords);
}
