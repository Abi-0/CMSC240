import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
    private static MorseCodeTree tre = new MorseCodeTree();

    public MorseCodeConverter() {

    }
    /**
     * converts a file of morse code into english each letter is delimited by a space
     * @param codeFile
     * @return
     */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException {
        // variables
        String result = "";
        ArrayList<String> sent = new ArrayList<String>();
        Scanner inputFile = new Scanner(codeFile);
        String[] words;
        String[] characters;

        // loop through the input file and read into arraylist
        while(inputFile.hasNext())
            sent.add(inputFile.nextLine());
        inputFile.close();
        // loop through the lines in array list
        for(int i = 0; i < sent.size(); i++) {
            words = sent.get(i).split(" / ");
            for(int k = 0; k < words.length; k++) {
                characters = words[k].split(" ");
                for(int j = 0; j < characters.length; j++)
                    result += tre.fetch(characters[j]);

                // add space after each letter
                result += " ";
            }
        }
        result = result.trim();
        return result;
    }

    /**
     * converts Morse code into english
     * @param code
     * @return
     */
    public static String convertToEnglish(String code) {
        String result = "";
        String[] words;
        String[] characters;

        words = code.split(" / ");

        for(int i = 0; i < words.length; i++) {
            characters = words[i].split(" ");

            for(int k = 0; k < characters.length; k++)
                result += tre.fetch(characters[k]);
            result+=" ";

        }
        result = result.trim();
        return result;
    }

    /**
     * returns a string with all the data in the treee in LNR order with an space
     * @return tree in LNR order
     */
    public static String printTree() {
        ArrayList<String> data = new ArrayList<>();
        data = tre.toArrayList();
        String str = "";
        for(int i = 0; i < data.size(); i++)
            str += data.get(i) + " ";

        return str;
    }

}
