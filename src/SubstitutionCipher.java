import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SubstitutionCipher {
    // variable declaration

    HashMap<Character, Double> plainTextFrequencyTable = new HashMap<Character, Double>();

    // empty constructor
    SubstitutionCipher() {

    }

    // params constructor
    SubstitutionCipher(String name, Map<Character, Character> key) {

    }

    // gives freq map for plainText
    // name and filepath
    boolean originalLanguage(String name, String fileName) throws IOException {
        if(name != null && fileName !=null){
            if(name != "" && fileName !="" ){
                Helper helper = new Helper();
                plainTextFrequencyTable = helper.frequencyTable(fileName);
                System.out.println(plainTextFrequencyTable);
            }
            else {
                // if name or fileName is empty string
                return false;
            }
        } else {
            // if name or File path has null then throw false
            return false;
        }
        return true;
    }

    // gives freq map for cipherText
    // filepath
    boolean ciphertext(String filename) {
        return true;
    }

    //decodes with the associated key
    String decodeText() {
        String decodedText = "";
        return decodedText;
    }

    // update internal encryption, put to the map/replace
    boolean setDecodeLetter(char plaintextChar, char ciphertextChar) {
        return true;
    }

    //get the current associated key
    Map<Character, Character> getKey() {
        Map<Character, Character> currentKey = new HashMap<Character, Character>();
        return currentKey;
    }

    // if each freq matches with the plain text return true
    boolean KeyIsValid() {
        return true;
    }

    // makes custom key from matching the freq tables
    // name of the language
    boolean guessKeyFromFrequencies(String language) {
        return true;
    }

    String matchLanguage() {
        String langNameCoded = "";
        return langNameCoded;
    }

    String testWorks(String a, String b) throws IOException {

        return "plainTextFrequencyTable works";
    }

}
