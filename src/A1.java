import java.util.Scanner;

public class A1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String plainTextPath = "";
        String cipherTextPath = "";
        // Creation of object of type SubstitutionCipher()
        SubstitutionCipher substitutionCipher = new SubstitutionCipher();

        //taking inputs for file paths
        // /home/cynos/IdeaProjects/Assignment1-cipherToPlainText/src/cipherA.txt /home/cynos/IdeaProjects/Assignment1-cipherToPlainText/src/lang1_plain.txt

        plainTextPath = sc.nextLine();
        cipherTextPath = sc.nextLine();

        System.out.println(substitutionCipher.testWorks(plainTextPath,cipherTextPath));

    }


}
