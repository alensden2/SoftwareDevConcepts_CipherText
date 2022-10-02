import java.io.IOException;
import java.util.Scanner;

public class A1 {
    public static void main(String[] args) throws IOException {

        // Scanner declared
        Scanner sc = new Scanner(System.in);

        // path for the file location
        // assuming 2 original file
        String plainTextPath1 = "";
        String cipherTextPath = "";
        String plainTextPath2 = "";

        // Creation of object of type SubstitutionCipher()
        SubstitutionCipher substitutionCipher = new SubstitutionCipher();

        // taking inputs for file paths
        // Paths to be passed using '//' ex-""
        //
        //home//cynos//IdeaProjects//Assignment1-cipherToPlainText//src//plan.txt
        //home//cynos//IdeaProjects//Assignment1-cipherToPlainText//src//langB.txt
        //home//cynos//IdeaProjects//Assignment1-cipherToPlainText//src//cipher.txt

        plainTextPath1 = sc.nextLine();
        plainTextPath2 = sc.nextLine();
        cipherTextPath = sc.nextLine();

        //testing rig ---- remove

        // Calling originalLanguage function for both language
        substitutionCipher.originalLanguage("lang A", plainTextPath1);
        substitutionCipher.originalLanguage("lang B", plainTextPath2);

        // Calling ciphertext method for the cipher file
        substitutionCipher.ciphertext(cipherTextPath);
        System.out.println(substitutionCipher.decodeText());
    }
}
