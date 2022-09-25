import java.util.HashMap;
import java.util.Map;

public class SubstitutionCipher {
    // empty constructor
    SubstitutionCipher(){

    }

    // params constructor
    SubstitutionCipher(String name, Map<Character,Character> key){

    }

    // gives freq map for plainText
    // name and filepath
    boolean originalLanguage(String name, String fileName){
        return true;
    }

    // gives freq map for cipherText
    // filepath
    boolean ciphertext(String filename){
        return true;
    }

    //decodes with the associated key
    String decodeText(){
        String decodedText = "";
        return decodedText;
    }

    // update internal encryption, put to the map/replace
    boolean setDecodeLetter(char plaintextChar, char ciphertextChar){
        return true;
    }

    //get the current associated key
    Map<Character,Character> getKey(){
        Map<Character,Character> currentKey = new HashMap<Character,Character>();
        return currentKey;
    }

    // if each freq matches with the plain text return true
    boolean KeyIsValid(){
        return true;
    }

    // makes custom key from matching the freq tables
    // name of the language
    boolean guessKeyFromFrequencies(String language){
        return true;
    }

    String matchLanguage(){
        String langNameCoded = "";
        return langNameCoded;
    }

    String testWorks(String a, String b){
        return "paths are as follows" + a + " " + b;
    }

}
