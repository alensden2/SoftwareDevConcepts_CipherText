import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Helper {
    // Special characters

    ArrayList<Character> decodeCharList = new ArrayList<Character>(
            List.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
    );


    HashMap<Character, Double> frequencyTable(String fileName) throws IOException {
        // Local variables
        HashMap<Character, Double> charFrequencyTable = new HashMap<Character, Double>();
        long c = 0;
        double newValue = 0;
        long totalFrequencyPlainText = 0;
        double newValueFreq = 0;

        // Reading File
        File filePath = new File(fileName);

        // Checks if the file path is valid ref - https://stackoverflow.com/questions/468789/is-there-a-way-in-java-to-determine-if-a-path-is-valid-without-attempting-to-cre
        if (filePath.exists()) {
            // File Reading operations
            // File Reader (Line by line)
            FileReader fileReader = new FileReader(filePath);
            // Line Reader (Char by Char)
            BufferedReader fileReaderLine = new BufferedReader(fileReader);

            // if file is empty ref - https://stackoverflow.com/questions/7190618/most-efficient-way-to-check-if-a-file-is-empty-in-java-on-windows
            if (fileReaderLine.readLine() != null) {
                // loop for reading the document line-by-line & total frequency of char in the document
                while ((c = fileReaderLine.read()) != -1) {

                    char lineByLine = (char) c;
                    lineByLine = Character.toLowerCase(lineByLine);

                    // if the map already has the char then the value is increased by one
                    if (charFrequencyTable.containsKey(lineByLine) && decodeCharList.contains(lineByLine)) {
                        newValue = charFrequencyTable.get(lineByLine) + 1;
                        charFrequencyTable.put(lineByLine, newValue);
                    }
                    // if the char is not there in the map
                    else if (decodeCharList.contains(lineByLine)) {
                        double initialFreq = 1;
                        charFrequencyTable.put(lineByLine, 1D);
                    } else {
                        // if special char; exclude
                    }
                }
            }

            // Total no of char in the document for frequency (%) calculation
            for (Double value : charFrequencyTable.values()) {
                totalFrequencyPlainText += value;
            }

            // frequency (%) rounded to next int
            for (Character key : charFrequencyTable.keySet()) {
                newValueFreq = (charFrequencyTable.get(key) / totalFrequencyPlainText) * 100;
                charFrequencyTable.put(key, (double) Math.round((charFrequencyTable.get(key) / totalFrequencyPlainText) * 100));
            }



        } else {
            System.out.println("File Path invalid, please avoid space and include '//' in path ex- //home//cynos//IdeaProjects//Assignment1-cipherToPlainText//src//cipherA.txt");
            System.out.println(filePath.exists());
        }
        return charFrequencyTable;

    }
}
