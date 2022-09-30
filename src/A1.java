import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class A1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String plainTextPath = "";
        String cipherTextPath = "";
        String plainTextPath1 = "";

        // Creation of object of type SubstitutionCipher()
        SubstitutionCipher substitutionCipher = new SubstitutionCipher();

        // taking inputs for file paths
        // Paths to be passed using '//' ex-""
        //
        //home//cynos//IdeaProjects//Assignment1-cipherToPlainText//src//plan.txt

        plainTextPath = sc.nextLine();
        cipherTextPath = sc.nextLine();

        //testing rig ---- remove

        substitutionCipher.originalLanguage("lang A", plainTextPath);
        substitutionCipher.ciphertext(cipherTextPath);
        System.out.println(substitutionCipher.decodeText());
    }


}
