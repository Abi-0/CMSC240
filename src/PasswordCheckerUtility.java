import java.util.ArrayList;

public class PasswordCheckerUtility implements PasswordCheckerInterface{


    /**
     * compare equality of two passwords
     * @param password
     * @param passwordConfirm
     */
    public static void comparePasswords (String password, String passwordConfirm) {
        // check if the two passed arguments are equal
        password.equals(passwordConfirm);
    }

    /**
     * compare equality of two passwords
     * @param password
     * @param passwordConfirm
     * @return
     */
    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) throws UnmatchedException{
        // if the passed passwords are not equal throw exception
        if(!(password.equals(passwordConfirm)))
            throw new UnmatchedException();
        // compare and return result of two passed passwords
        return (password.equals(passwordConfirm));

    }

    /**
     * Reads file of passwords and the passwords failed will be added invalid
     * passwords with the reason
     * @param passwords
     * @return
     */
    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) throws NoLowerAlphaException,
            NoUpperAlphaException, InvalidSequenceException, NoDigitException, LengthException, NoSpecialCharacterException{
        ArrayList<String> invalidPasswords = null;
        // check if there are any invalid password and add them to invalid password list
        for(int i = 0; i < passwords.size(); i++) {
            if(!(PasswordCheckerUtility.isValidPassword(passwords.get(i)))) {
                invalidPasswords.add(passwords.get(i));
            }
        }
        return invalidPasswords;
    }

    /**
     * Weak password length check - 6-9 characters weak but valid
     * @param password
     * @return
     */
    public static boolean hasBetweenSixAndNineChars(String password) {
        // checks if it is between 6 to 9 characters to see if it is weak
        return (password.length() > 6 && password.length() < 9);
    }

    /**
     * Checks the password digit requirement
     * @param password
     * @return
     */
    public static boolean hasDigit(String password) throws NoDigitException{

        boolean found = false;
        // iterates to find a digit character in password
        for(char c : password.toCharArray()) {
            if(Character.isDigit(c))
                found = true;
            else if(found)  // if a digit has been found break
                break;
        }
        if(!found)
            throw new NoDigitException("The password doesn't contain digits");
        return found;
    }

    /**
     * checks password lower alphabet requirement
     * @param password
     * @return
     */
    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
        boolean found = false;
        // iterates to find a lower case in password
        for(char c : password.toCharArray()) {
            if(Character.isLowerCase(c))
                found = true;
            else if(found)  // if a lower case has been found break
                break;
        }

        if(!found)
            throw new NoLowerAlphaException("The password must contain at least one lower alphabet");

        return found;
    }

    /**
     * checks the password Sequence requirement - not contain more than 2 of the same character
     * @param password
     * @return
     */
    public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException{
        boolean repeated = false;
        char[] chars = password.toCharArray();
        // compares the one infront with the previous if they are similar there is a sequence
        for(int i = 1; i < password.length(); i++) {
            if(chars[i] == chars[i-1]) {
                repeated = true;
            } else if(repeated)
                break;
        }
        if(repeated)
            throw new InvalidSequenceException("The password must no contain more than 2 of the same character");
        return repeated;
    }


    /**
     * checks the password Special character requirement
     * @param password
     * @return
     */
    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
        boolean specialChar = false;
        for(int i = 0; i < password.length(); i++) {
            if(password.matches("(?=.*[@#$%^&+=])"))
                specialChar = true;
        }
        if(!specialChar)
            throw new NoSpecialCharacterException("Password doesn't contain special character");
        return true;
    }

    /**
     * checks the password alpha character requirement - must contain upper case
     * @param password
     * @return
     */
    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
        boolean found = false;
        for(char c : password.toCharArray()) {
            if(Character.isUpperCase(c))
                found = true;
            else if(found)  // if a digit has been found break
                break;
        }

        if(!found)
            throw new NoUpperAlphaException("The password must contain at least one lower alphabet");

        return found;
    }

    /**
     * checks the password length requirement - The password must be >6
     * @param password
     * @return
     */
    public static boolean isValidLength(String password) throws LengthException{
        if(!(password.length() > 6))
            throw new LengthException("The password needs to be longer than 6 characters");
        return (password.length() > 6);
    }


    /**
     * return true if valid password
     * @param password
     * @return
     */
    public static boolean isValidPassword(String password) throws LengthException, NoDigitException, NoUpperAlphaException,
            NoLowerAlphaException, InvalidSequenceException, NoSpecialCharacterException{
       boolean validation = true;


       if(!(hasDigit(password) && hasLowerAlpha(password) && (!hasSameCharInSequence(password)) && hasSpecialChar(password)
            && hasUpperAlpha(password) && isValidLength(password)))
           validation = false;

       return validation;
    }

    @Override
    public ArrayList<String> validPasswords(ArrayList<String> passwords) {
        return null;
    }


    /**
     * checks if password is valid but between 6-9 characters
     * @param password
     * @return
     */
    public static boolean isWeakPassword(String password) throws WeakPasswordException{
        boolean weak;
        if(hasBetweenSixAndNineChars(password))
            weak = true;
        else
            throw new WeakPasswordException("Password is valid but weak");
        return weak;
    }


}
