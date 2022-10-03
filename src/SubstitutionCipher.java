import java.io.IOException;
import java.util.*;

public class SubstitutionCipher {
    // Helper class initialized
    FrequencyTable frequencyTable = new FrequencyTable();
    HashMap<Character, Double> plainTextFrequencyTable = new HashMap<Character, Double>();
    HashMap<Character, Double> currentPlainFrequencyTable = new HashMap<Character, Double>();
    String languageName = null;
    HashMap<Character, Double> cipherTextFrequencyTable = new HashMap<Character, Double>();
    ArrayList<Character> plainTextKey = new ArrayList<Character>();
    ArrayList<Character> cipherTextKey = new ArrayList<Character>();
    String cipherTextLocation = null;
    String decodedString = null;

    HashMap<Character, Character> knownKeyMap = new HashMap<Character, Character>();

    // map to store original language
    HashMap<String, HashMap<Character, Double>> originalLanguagesFrequency = new HashMap<String, HashMap<Character, Double>>();
    String nameKnownString = "";

    // empty constructor
    SubstitutionCipher() {

    }

    // params constructor
    SubstitutionCipher(String nameParams, Map<Character, Character> keyParams) {
        // iskeyValid called
        knownKeyMap = (HashMap<Character, Character>) keyParams;
        nameKnownString = nameParams;
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
                currentPlainFrequencyTable = frequencyTable.frequencyTable(fileName, name, 0);  // 0 for original language

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

                // linking the current obj to be decrypted
                cipherTextFrequencyTable = frequencyTable.frequencyTable(fileName, "", 1);

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

        // we have to generate the code from the 2 files
        Scanner sc = new Scanner(System.in);
        String languageName = "";

        // exception to be handled

        // if the key already present i.e sent by user using the constructor
        if ((!knownKeyMap.isEmpty() && !nameKnownString.isEmpty()) && (currentPlainFrequencyTable.isEmpty())) {
            System.out.println("Key already present, provided by constructor");

            decodedString = frequencyTable.alreadyKnownKey(nameKnownString, knownKeyMap, cipherTextLocation);
        }


        // if user is generating key using frequency table and no key was passed using the constructor
        if ((!currentPlainFrequencyTable.isEmpty() && !cipherTextFrequencyTable.isEmpty()) && (knownKeyMap.isEmpty() && nameKnownString.isEmpty())) {
            System.out.println("please enter the language file you wish to use for guessing the key (i.e String name - given with originalLanguage method)");

            // taking the key for the original languages map for getting the value hashMap
            languageName = sc.nextLine();
            guessKeyFromFrequencies(languageName);


            decodedString = frequencyTable.decodedString(plainTextKey, cipherTextKey, cipherTextLocation);
        }

        // If a key was passed through the constructor and a key can be generated
        if ((!currentPlainFrequencyTable.isEmpty() && !cipherTextFrequencyTable.isEmpty()) && (!knownKeyMap.isEmpty() && !nameKnownString.isEmpty())) {
            System.out.println("Two keys found user defined key is active now");
            decodedString = frequencyTable.alreadyKnownKey(nameKnownString, knownKeyMap, cipherTextLocation);
            return decodedString;
        }

        // If no key was passed and no data exists to build a key
        if ((currentPlainFrequencyTable.isEmpty() && cipherTextFrequencyTable.isEmpty()) && (knownKeyMap.isEmpty() && nameKnownString.isEmpty())) {
            return null;
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

        // all entries are converted to lowercase
        Character plainTextValue = plaintextChar;
        Character cipherTextValue = ciphertextChar;
        plainTextValue = Character.toLowerCase(plainTextValue);
        cipherTextValue = Character.toLowerCase((cipherTextValue));

        // For a mapping to be valid the new map character must be in the plain text frequency
        if (!plainTextKey.contains(plainTextValue) && !cipherTextKey.contains(cipherTextValue)) {
            plainTextKey.add(plainTextValue);
            cipherTextKey.add(cipherTextValue);
            // For a valid mapping that has already been mapped setDecode will update the current mapping
        } else if (plainTextKey.contains(plainTextValue) && cipherTextKey.contains(cipherTextValue)) {
            int indexPlainChar = plainTextKey.indexOf(plainTextKey);
            int indexCipherChar = cipherTextKey.indexOf(ciphertextChar);
            // updating the values
            plainTextKey.set(indexPlainChar, plainTextValue);
            cipherTextKey.set(indexCipherChar, cipherTextValue);
        }


        // If ciphertext char is not already there, this method add a new entry to the key

        // If ciphertext is already present the add method will replace the existing entry


        // all exceptions to handled

//        if () {
//        } else if () {
//
//        }

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

        Set<Character> plainTextSet = plainTextFrequencyTable.keySet();
        Set<Character> cipherTextSet = cipherTextFrequencyTable.keySet();

        if ((cipherTextSet.size() <= plainTextSet.size())) {
            return true;
        } else {
            return false;
        }

        // all exceptions to handled

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

            // returns the required frequency table
            plainTextFrequencyTable = originalLanguagesFrequency.get(language);
            // key mapped according to indexes
            plainTextKey = frequencyTable.getKeyFromFrequencies(plainTextFrequencyTable);
            cipherTextKey = frequencyTable.getKeyFromFrequencies(cipherTextFrequencyTable);

            return true;

        }
        /*
        System.out.println("plain text key" +  plainTextKey);
        System.out.println("cipher text key" + cipherTextKey);
        System.out.println("\n");
        System.out.println("plain freq Table"+plainTextFrequencyTable);
        System.out.println("cipher freq table"+cipherTextFrequencyTable);
        */
        else {
            return false;
        }
    }

    String matchLanguage() {

        /*
        Method 8 (matchLanguage) -  uses the frequencies of all the language to match the language that the ciphertext is
        Returns - Boolean
        */

        String matchedLanguage = frequencyTable.matchLanguagePercentage();


        // all exceptions to handled

        return matchedLanguage;
    }

}