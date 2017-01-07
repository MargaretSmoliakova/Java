import java.io.IOException;

/**
 * Created by Маргарита on 07.12.2016.
 */
public class Program {
    public static void main (String[] args) throws IOException {

        String path = "C:\\ALL\\PROGRAMMING\\JavaProgramming\\HomeworkSixNew1\\Text.txt";
        String pathEncryption = "C:\\ALL\\PROGRAMMING\\JavaProgramming\\HomeworkSixNew1\\FileWriter.txt";

        Encryption encryption = new Encryption(path, pathEncryption);
        encryption.changeText();
    }
}
