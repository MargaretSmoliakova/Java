import java.io.IOException;

public class Program {
    public static void main (String[] args) throws IOException {

        String path = "Text.txt";
        String pathEncryption = "ChangedText.txt";
        String pathEncryptionBack = "ChangedTextBack.txt";

        Encryption encryption = new Encryption(path);
        //encryption.createFile();
        encryption.readFile();
        encryption.changeText(pathEncryption);
        encryption.changeTextBack(pathEncryptionBack, pathEncryption);
    }
}