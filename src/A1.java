import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class A1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String plainTextPath1 = "";
        String cipherTextPath = "";
        String plainTextPath2 = "";

        // Creation of object of type SubstitutionCipher()
        SubstitutionCipher substitutionCipher = new SubstitutionCipher();

        // taking inputs for file paths
        // Paths to be passed using '//' ex-""
        //
        //home//cynos//IdeaProjects//Assignment1-cipherToPlainText//src//plan.txt
        //home//cynos//IdeaProjects//Assignment1-cipherToPlainText//src//plan.txt
        //home//cynos//IdeaProjects//Assignment1-cipherToPlainText//src//cipher.txt

        plainTextPath1 = sc.nextLine();
        plainTextPath2 = sc.nextLine();
        cipherTextPath = sc.nextLine();

        //testing rig ---- remove

        substitutionCipher.originalLanguage("lang A", plainTextPath1);
        substitutionCipher.originalLanguage("lang B", plainTextPath2);
        substitutionCipher.ciphertext(cipherTextPath);
        System.out.println(substitutionCipher.decodeText());
    }


}
