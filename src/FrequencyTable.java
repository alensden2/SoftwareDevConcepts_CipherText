import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.Comparator;

public class FrequencyTable {

    HashMap<Character, Double> frequencyTable(String fileName) throws IOException {
        /*
        Method 1 (frequencyTable) -  outputs frequency table for given file directory
        Input (1) - String fileName
        Returns - hashmap<Character, Double>
        */
        // still convert to percentage

        // Local variables
        HashMap<Character, Double> charFrequencyTable = new HashMap<Character, Double>();

        double newValue = 0;
        double totalFrequencyText = 0;
        double newValueFreq = 0;

        // Reading File
        File filePath = new File(fileName);

        // Checks if the file path is valid ref - https://stackoverflow.com/questions/468789/is-there-a-way-in-java-to-determine-if-a-path-is-valid-without-attempting-to-cre
        if (filePath.exists()) {
            // File Reading operations
            // File Reader (Line by line)
            FileReader fileReader = new FileReader(fileName);
            // Line Reader (Char by Char)


            // if file is empty ref - https://stackoverflow.com/questions/7190618/most-efficient-way-to-check-if-a-file-is-empty-in-java-on-windows
            //if (fileReader.read() != -1) {
            int c;
            // loop for reading the document line-by-line & total frequency of char in the document

            //First line

            // for reading all lines except first line
            while ((c = fileReader.read()) != -1) {

                char lineByLine = (char) c;

                lineByLine = (char) Character.toLowerCase(c);

                if (Character.isLetter(lineByLine)) {
                    if (charFrequencyTable.containsKey(lineByLine)) {
                        newValue = charFrequencyTable.get(lineByLine);
                        newValue += 1;
                        charFrequencyTable.put(lineByLine, newValue);
                    } else {
                        charFrequencyTable.put(lineByLine, 1D);
                    }
                } else {
                    /* char other than alphabets */
                }


            }

            for (Map.Entry<Character, Double> setFreqTable : charFrequencyTable.entrySet()) {
                Double frequencyValue = setFreqTable.getValue();
                totalFrequencyText += frequencyValue;
            }


        }
        //}

            /*TO BE REMOVED
            // Total no of char in the document for frequency (%) calculation
            for (Double value : charFrequencyTable.values()) {
                totalFrequencyPlainText += value;
            }
            //System.out.println(charFrequencyTable);
            // frequency (%) rounded to next int
            for (Character key : charFrequencyTable.keySet()) {
                newValueFreq = (charFrequencyTable.get(key) / totalFrequencyPlainText) * 100;
                charFrequencyTable.put(key, (double) Math.round((charFrequencyTable.get(key) / totalFrequencyPlainText) * 100));
            }
*/

        else {
            System.out.println("File Path invalid, please avoid space and include '//' in path ex- //home//cynos//IdeaProjects//Assignment1-cipherToPlainText//src//cipher.txt");
            System.out.println(filePath.exists());
        }
        return charFrequencyTable;

    }

    ArrayList<Character> getKeyFromFrequencies(HashMap<Character, Double> frequencyTable) {

        /*
        Method 2 (getKeyFromFrequencies) -  outputs arraylist of characters in decs order occurrence
        Input (1) - hashmap<Character, Double> frequencyTable
        Returns - ArrayList<Character>
        */

        // still got to fix the special cases if plain text char < cipher text char

        LinkedHashMap<Character, Double> currentFrequencyTable = new LinkedHashMap<Character, Double>();
        ArrayList<Character> frequencyDescOrder = new ArrayList<Character>();
        // ref - https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap


        for (Map.Entry<Character, Double> entry : frequencyTable.entrySet()) {
            Character key = entry.getKey();
            Double value = entry.getValue();

            currentFrequencyTable.put(key, value);
        }
        // sorting the linked hash map by
        // ref - https://www.benchresources.net/java-how-to-sort-linkedhashmap-by-its-values/

        // get entry-set from linkedhashmap
        Set<Map.Entry<Character, Double>> currentFrequencyTableSet = currentFrequencyTable.entrySet();

        // linked hashmap to list of Map.entry
        List<Map.Entry<Character, Double>> currentFrequencyTableList = new ArrayList<Map.Entry<Character, Double>>(currentFrequencyTableSet);

        // sorting
        Collections.sort(currentFrequencyTableList, new Comparator<Map.Entry<Character, Double>>() {
            @Override
            public int compare(Entry<Character, Double> val1, Entry<Character, Double> val2) {
                return val1.getValue().compareTo(val2.getValue());
            }
        });

        // clearing the map
        currentFrequencyTable.clear();

        // storing in map
        for (Map.Entry<Character, Double> map : currentFrequencyTableList) {
            currentFrequencyTable.put(map.getKey(), map.getValue());
        }

        // Map set
        for (Map.Entry<Character, Double> iterable : currentFrequencyTable.entrySet()) {
            frequencyDescOrder.add(iterable.getKey());
        }

        return frequencyDescOrder;
    }

    // method to return a decoded string -
    String decodedString(ArrayList<Character> plainKey, ArrayList<Character> cipherKey, String cipherTextLocation) throws IOException {

        /*
        Method 3 (decodeString) -  outputs string of decoded message
        Input (3) - ArrayList<Character> plainKey, ArrayList<Character> cipherKey, String cipherTextLocation
        Returns - String
        */

        int c;
        int indexOfElement;
        String decodedMessage = "";
        FileReader fileReader = new FileReader(cipherTextLocation);
        while ((c = fileReader.read()) != -1) {

            char lineByLine = (char) c;

            lineByLine = (char) Character.toLowerCase(c);

            if (cipherKey.contains(lineByLine)) {
                indexOfElement = cipherKey.indexOf(lineByLine);
                decodedMessage += plainKey.get(indexOfElement);
            } else {
                decodedMessage += lineByLine;
            }


        }


        return decodedMessage;
    }
}