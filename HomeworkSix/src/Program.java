import java.io.IOException;

public class Program {
    public static void main (String[] args) throws IOException {

        String path = "C:\\ALL\\PROGRAMMING\\JavaProgramming\\HomeworkSix\\Text.txt";
        String pathEncryption = "C:\\ALL\\PROGRAMMING\\JavaProgramming\\HomeworkSix\\FileWriter.txt";

        Encryption encryption = new Encryption(path);
        //encryption.createFile();
        encryption.readFile();
        encryption.changeText(pathEncryption);
    }
}