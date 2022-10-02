import java.io.IOException;
import java.util.*;

public class SubstitutionCipher {
    HashMap<Character, Double> plainTextFrequencyTable = new HashMap<Character, Double>();
    HashMap<Character, Double> currentPlainFrequencyTable = new HashMap<Character, Double>();
    String languageName = null;
    HashMap<Character, Double> cipherTextFrequencyTable = new HashMap<Character, Double>();
    ArrayList<Character> plainTextKey = new ArrayList<Character>();
    ArrayList<Character> cipherTextKey = new ArrayList<Character>();
    String cipherTextLocation = null;
    String decodedString = null;

    // map to store original lang
    HashMap<String, HashMap<Character, Double>> originalLanguagesFrequency = new HashMap<String, HashMap<Character, Double>>();


    // empty constructor
    SubstitutionCipher() {

    }

    // params constructor
    SubstitutionCipher(String name, Map<Character, Character> key) {

    }

    // gives freq map for plainText
    // name and filepath
    boolean originalLanguage(String name, String fileName) throws IOException {

        /*
        Method 1 (originalLanguage) -  outputs if language can be transformed to a frequency table
        Input (2) - String name, String fileName
        Returns - Boolean
        */

        // all exceptions to be handled

        if (name != null && fileName != null) {
            if (name != "" && fileName != "") {
                FrequencyTable FrequencyTable = new FrequencyTable();
                currentPlainFrequencyTable = FrequencyTable.frequencyTable(fileName, name, 0);  // 0 for original language

                // stored the current frequency table in the original languages map
                originalLanguagesFrequency.put(name, currentPlainFrequencyTable);
                // If returned hash map is empty return false
                if (currentPlainFrequencyTable.isEmpty()) {
                    return false;
                }
//                System.out.println(currentPlainFrequencyTable);
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

        /*
        Method 2 (ciphertext) -  outputs if language can be transformed to a frequency table
        Input (1) - String fileName
        Returns - Boolean
        */

        // all exceptions to be handled

        if (fileName != null) {
            if (fileName != "") {
                // Stroring the cipher text file location
                cipherTextLocation = fileName;

                // creation of FrequencyTable object, to create a frequency table
                FrequencyTable FrequencyTable = new FrequencyTable();

                // linking the current obj to be decrypted
                cipherTextFrequencyTable = FrequencyTable.frequencyTable(fileName,"",1);

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

        /*
        Method 3 (ciphertext) -  outputs the decoded string
        Returns - String
        */

        // exception to be handled

        // if the key already present i.e sent by user using the constructor
        /* INSERT CODE */

        // if the user wish to modify the current key
        /* INSERT CODE */

        // we have to generate the code from the 2 files
        Scanner sc = new Scanner(System.in);
        String languageName = "";

        if (!currentPlainFrequencyTable.isEmpty() && !cipherTextFrequencyTable.isEmpty()) {
            System.out.println("please enter the language file you wish to use for guessing the key");

            // taking the key for the original languages map for getting the value hashMap
            languageName = sc.nextLine();
            guessKeyFromFrequencies(languageName);
            FrequencyTable FrequencyTable = new FrequencyTable();

            decodedString = FrequencyTable.decodedString(plainTextKey, cipherTextKey, cipherTextLocation);
        }
        return decodedString;
    }

    // update internal encryption, put to the map/replace
    boolean setDecodeLetter(char plaintextChar, char ciphertextChar) {

        /*
        Method 4 (setDecodeLetter) -  lets the user modify the existing key
        Input (2) - char plaintextChar, char ciphertextChar
        Returns - Boolean
        */

        // all exceptions to handled

        return true;
    }

    //get the current associated key
    Map<Character, Character> getKey() {

        /*
        Method 5 (getKey) -  returns the current used key
        Returns - Map<Character, Character>
        */

        // all exceptions to handled

        Map<Character, Character> currentKey = new HashMap<Character, Character>();
        return currentKey;
    }

    // if each freq matches with the plain text return true
    boolean KeyIsValid() {

        /*
        Method 6 (setDecodeLetter) -  returns if the current key is valid
        Returns - Boolean
        */

        // all exceptions to handled

        return true;
    }

    // makes custom key from matching the freq tables
    // name of the language
    boolean guessKeyFromFrequencies(String language) {

        /*
        Method 7 (guessKeyFromFrequencies) -  uses the frequency table to make a key
        Input (1) - String language
        Returns - Boolean
        */

        // all exceptions to handled

        if (!currentPlainFrequencyTable.isEmpty() && !cipherTextFrequencyTable.isEmpty()) {
            FrequencyTable frequencyTable = new FrequencyTable();

            // returns the required frequency table
            plainTextFrequencyTable = originalLanguagesFrequency.get(language);
            // key mapped according to indexes
            plainTextKey = frequencyTable.getKeyFromFrequencies(plainTextFrequencyTable);
            cipherTextKey = frequencyTable.getKeyFromFrequencies(cipherTextFrequencyTable);

        }
        return false;
    }

    String matchLanguage() {

        /*
        Method 8 (matchLanguage) -  uses the frequencies of all the language to match the language that the ciphertext is
        Returns - Boolean
        */

        FrequencyTable frequencyTable = new FrequencyTable();
        String matchedLanguage = frequencyTable.matchLanguagePercentage();


        // all exceptions to handled

        return matchedLanguage;
    }

}
