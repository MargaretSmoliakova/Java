import java.io.IOException;

public class RunProgram {
    public static void main (String[] args) throws IOException {

        String path = "C:\\ALL\\PROGRAMMING\\JavaProgramming\\HomeworkSix1\\Text.txt";
        String pathEncryption = "C:\\ALL\\PROGRAMMING\\JavaProgramming\\HomeworkSix1\\FileWriter.txt";

        Encryption encryption = new Encryption(path);
        //encryption.createFile();
        encryption.readFile();
        encryption.changeText(pathEncryption);
    }
}
