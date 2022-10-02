import java.io.IOException;
import java.util.HashMap;
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


        // initialising a knownKey -
        HashMap<Character,Character> key = new HashMap<Character,Character>();
        key.put('a','z');
        key.put('b','y');
        key.put('c','x');
        key.put('d','w');
        key.put('e','v');
        key.put('f','u');
        key.put('g','t');
        key.put('h','s');
        key.put('i','r');
        key.put('j','q');
        key.put('k','p');
        key.put('l','o');
        key.put('m','n');
        key.put('n','m');
        key.put('o','l');
        key.put('p','k');
        key.put('q','j');
        key.put('r','i');
        key.put('s','h');
        key.put('t','g');
        key.put('u','f');
        key.put('v','e');
        key.put('w','d');
        key.put('x','c');
        key.put('y','b');
        key.put('z','a');

        // Creation of object of type SubstitutionCipher()
        //SubstitutionCipher substitutionCipher = new SubstitutionCipher("english", key);
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
