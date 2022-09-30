import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class SubstitutionCipher {
    // variable declaration

    HashMap<Character, Double> plainTextFrequencyTable = new HashMap<Character, Double>();
    String languageName = null;
    HashMap<Character, Double> cipherTextFrequencyTable = new HashMap<Character, Double>();
    ArrayList<Character> plainTextKey = new ArrayList<Character>();
    ArrayList<Character> cipherTextKey = new ArrayList<Character>();
    String cipherTextLocation = null;
    String decodedString = null;

    // map to store original lang
    HashMap<String , HashMap<Character, Double>> originalLanguage = new HashMap<String , HashMap<Character, Double>>();


    // empty constructor
    SubstitutionCipher() {

    }

    // params constructor
    SubstitutionCipher(String name, Map<Character, Character> key) {

    }

    // gives freq map for plainText
    // name and filepath
    boolean originalLanguage(String name, String fileName) throws IOException {
        languageName = name;
        if (name != null && fileName != null) {
            if (name != "" && fileName != "") {
                FrequencyTable FrequencyTable = new FrequencyTable();
                plainTextFrequencyTable = FrequencyTable.frequencyTable(fileName);

                // If returned hash map is empty return false
                if (plainTextFrequencyTable.isEmpty()) {
                    return false;
                }
//                System.out.println(plainTextFrequencyTable);
            } else {
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
    boolean ciphertext(String fileName) throws IOException {
        if (fileName != null) {
            if (fileName != "") {
                // Stroring the cipher text file location
                cipherTextLocation = fileName;

                // creation of FrequencyTable object, to create a frequency table
                FrequencyTable FrequencyTable = new FrequencyTable();

                // linking the current obj to be decrypted
                cipherTextFrequencyTable = FrequencyTable.frequencyTable(fileName);

                // If returned hash map empty return false
                if (cipherTextFrequencyTable.isEmpty()) {
                    return false;
                }
//                System.out.println(cipherTextFrequencyTable);
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    //decodes with the associated key
    String decodeText() throws IOException {
        if (!plainTextFrequencyTable.isEmpty() && !cipherTextFrequencyTable.isEmpty()) {
            guessKeyFromFrequencies(languageName);
            FrequencyTable FrequencyTable = new FrequencyTable();
//            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
//            System.out.println(plainTextKey);
//            System.out.println(cipherTextKey);
            decodedString = FrequencyTable.decodedString(plainTextKey, cipherTextKey, cipherTextLocation);
        }
        return decodedString;
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
        if (!plainTextFrequencyTable.isEmpty() && !cipherTextFrequencyTable.isEmpty()) {
            FrequencyTable frequencyTable = new FrequencyTable();
            // key mapped according to indexes
            plainTextKey = frequencyTable.getKeyFromFrequencies(plainTextFrequencyTable);
            cipherTextKey = frequencyTable.getKeyFromFrequencies(cipherTextFrequencyTable);

        }
        return false;
    }

    String matchLanguage() {
        String langNameCoded = "";
        return langNameCoded;
    }

    String testWorks(String a, String b) throws IOException {

        return a + " " + b;
    }

}
