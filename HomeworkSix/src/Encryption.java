import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Encryption {

    private String path;

    public Encryption() {

    }

    public Encryption (String path) {
        this.path = path;
    }

    public void createFile () throws IOException {

        File file = new File(path);
        String tempString = "";
        Scanner scanner = new Scanner(System.in);

        OutputStream outputStream = new FileOutputStream(file);
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, "cp1251");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        tempString = scanner.nextLine();

        bufferedWriter.write(tempString);

        bufferedWriter.close();
        outputStreamWriter.close();
        outputStream.close();
    }

    public void readFile () throws FileNotFoundException {

        File file = new File(path);
        Scanner sc =  new Scanner(file, "cp1251");

        System.out.println("\nOriginal text: \n");

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

        sc.close();
    }

    public void changeText (String pathEncryption) throws IOException {

        File file = new File(path);
        File fileForEncryption = new File(pathEncryption);
        Scanner sc =  new Scanner(file, "cp1251");
        String tempString;
        char[] tempCharArray;
        int i = 0, j = 0, lengthTempCharArrayFinal = 0;
        char[] tempCharArrayFinal;

        OutputStream outputStream = new FileOutputStream(fileForEncryption);
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, "cp1251");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        System.out.println("\nChanged text: \n");

        while (sc.hasNextLine()) {
            tempString = sc.nextLine();
            StringTokenizer st = new StringTokenizer(tempString, ".,-:; ");
            while (st.hasMoreTokens()) {
                tempCharArray = st.nextToken().toCharArray();
                lengthTempCharArrayFinal = tempCharArray.length + 1;
                tempCharArrayFinal = new char[lengthTempCharArrayFinal];
                j = 0;
                for (i = 0; i < tempCharArray.length; j++) {
                    tempCharArrayFinal[i] = tempCharArray[j];
                    System.out.print(tempCharArrayFinal[i]);
                    i++;
                    if (i < tempCharArray.length) {
                        tempCharArrayFinal[i] = tempCharArray[tempCharArray.length - 1 - j];
                        System.out.print(tempCharArrayFinal[i]);
                        i++;
                    }
                }
                tempCharArrayFinal [lengthTempCharArrayFinal - 1] = '#';
                bufferedWriter.write(tempCharArrayFinal);
                bufferedWriter.write("\n");
                System.out.print("\n");
            }
        }

        bufferedWriter.close();
        outputStreamWriter.close();
        outputStream.close();
    }
}
